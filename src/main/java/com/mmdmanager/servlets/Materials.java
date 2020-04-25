package com.mmdmanager.servlets;

import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.Material;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

@WebServlet("/Materials")
public class Materials extends HttpServlet {
    private ArrayList<Material> materialList = new ArrayList<>();

    private String materialName, productNumber, employeeID;
    private String requestedBy;
    private Timestamp requestDateTime;
    private Integer eskNumber;
    private String requestType, requestSubType, remark, batchContainsSth;
    private StringBuilder batch, materialGroup;
    private String materialGroupStr, productHierarchyStr;
    private StringBuilder strArray, materialDescription;
    private String[] materialDescriptionArr;
    private Double grossWeight, netWeight, materialLength, materialWidth, materialHeight, materialVolume;

    private String inputSave, inputSend;
    static Connection connection = null;
    static PreparedStatement preparedStatement;
    static Statement statement = null;
    private ResultSet resultSet;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        inputSend = request.getParameter("send");
        if (inputSend.equals("send")) {
            try {
                connection = ConnectionProvider.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select max(request_number)+1 from materials");

                while(resultSet.next()) {
                    preparedStatement = connection.prepareStatement("insert into materials(material_name,product_number,user_id,request_Number,request_by,request_datetime,esk_number,request_type,request_sub_type,remark,batch_number, material_group, product_hierarchy, material_description, gross_Weight, net_Weight, material_Length, material_Width, material_Height, material_Volume) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                    connection.setAutoCommit(false);
                    for (Iterator<Material> iterator = materialList.iterator(); iterator.hasNext();) {
                        Material material = (Material) iterator.next();
                        preparedStatement.setString(1, material.getMaterialName());
                        preparedStatement.setString(2,material.getProductNumber());
                        preparedStatement.setString(3, material.getEmployeeID());
                        preparedStatement.setInt(4, resultSet.getInt(1));
                        preparedStatement.setString(5, material.getRequestedBy());
                        preparedStatement.setTimestamp(6, material.getRequestDateTime());
                        preparedStatement.setInt(7,material.getEskNumber());
                        preparedStatement.setString(8, material.getRequestType());
                        preparedStatement.setString(9,material.getRequestSubType());
                        preparedStatement.setString(10,material.getRemark());
                        preparedStatement.setString(11,String.valueOf(material.getBatchNumber()));
                        preparedStatement.setString(12,material.getMaterialGroup());
                        preparedStatement.setString(13,material.getProductHierarchy());
                        preparedStatement.setString(14,material.getMaterialDescription());
                        preparedStatement.setDouble(15,material.getGrossWeight());
                        preparedStatement.setDouble(16,material.getNetWeight());
                        preparedStatement.setDouble(17,material.getMaterialLength());
                        preparedStatement.setDouble(18,material.getMaterialWidth());
                        preparedStatement.setDouble(19,material.getMaterialHeight());
                        preparedStatement.setDouble(20,material.getMaterialVolume());
                        preparedStatement.addBatch();
                    }
                    preparedStatement.executeBatch();
                    connection.commit();
                    connection.setAutoCommit(true);
                }
                materialList.clear();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        response.sendRedirect("http://localhost:8090/MMDManager/MaterialDashboard.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        inputSave = request.getParameter("save");

        try {
            if (inputSave.equals("save")) {

                connection = ConnectionProvider.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select USER_ID, first_name || ' ' || last_name, login_id from users natural join logons order by 3 desc fetch first 1 rows only");

                while (resultSet.next()) {
                    materialName = request.getParameter("materialName");
                    productNumber = request.getParameter("productNumber");
                    employeeID = resultSet.getString(1);
                    requestedBy = resultSet.getString(2);
                    requestDateTime = new Timestamp(System.currentTimeMillis());
                    eskNumber = Integer.valueOf(request.getParameter("eskNumber"));
                    requestType = request.getParameter("requestType");
                    requestSubType = request.getParameter("requestSubType");
                    remark = request.getParameter("remark");
                    batchContainsSth = request.getParameter("batchCountry");

                    if (batchContainsSth == null) {
                        batch = new StringBuilder();
                    }
                    else {
                        batch = new StringBuilder().
                                append(request.getParameter("batchCountry")).
                                append("0").
                                append(request.getParameter("batchNumber"));
                    }

                    materialGroup = new StringBuilder().append(request.getParameter("firstLevelMG"));
                    materialGroupStr = String.valueOf(materialGroup.substring(0,3));
                    materialGroupStr.concat(request.getParameter("secondLevelMG").substring(0,6));

                    productHierarchyStr = materialGroupStr
                            .concat(request.getParameter("productHierarchy1").substring(0,3))
                            .concat(request.getParameter("productHierarchy2").substring(0,3))
                            .concat(request.getParameter("productHierarchy3").substring(0,3));

                    strArray = new StringBuilder().append(request.getParameter("firstLevelMG"))
                            .append(" - ").append(request.getParameter("secondLevelMG"))
                            .append(" - ").append(request.getParameter("productHierarchy1"))
                            .append(" - ").append(request.getParameter("productHierarchy2"))
                            .append(" - ").append(request.getParameter("productHierarchy3"));

                    materialDescriptionArr = String.valueOf(strArray).split(" - ");

                    materialDescription = new StringBuilder();
                    for (int i = 0; i<materialDescriptionArr.length; i++) {
                        if ((i%2) !=0) {
                            materialDescription.append(materialDescriptionArr[i]);
                            if (i < materialDescriptionArr.length-1) {
                                materialDescription.append("<");
                            }
                        }
                    }

                    grossWeight = Double.valueOf(request.getParameter("grossWeight"));
                    materialLength = Double.valueOf(request.getParameter("length"));
                    materialWidth = Double.valueOf(request.getParameter("width"));
                    materialHeight = Double.valueOf(request.getParameter("height"));
                    materialVolume = Double.valueOf(request.getParameter("volume"));

                    materialList.add(new Material(materialName,productNumber,employeeID,requestedBy,requestDateTime,eskNumber,requestType,requestSubType,remark, batch, materialGroupStr, productHierarchyStr, String.valueOf(materialDescription), grossWeight, materialLength, materialWidth, materialHeight, materialVolume));
                    httpSession.setAttribute("materialList",materialList);

                    response.sendRedirect("http://localhost:8090/MMDManager/MaterialDashboard.jsp");
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
