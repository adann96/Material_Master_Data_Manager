package com.mmdmanager.servlets;

import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.Material;
import com.mmdmanager.others.Worksheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

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

    private String materialName, productNumber, employeeID, requestedBy, requestType, requestSubType, remark, batchContainsSth, factory, materialGroupStr, productHierarchyStr, salesBrand, source;
    private Timestamp requestDateTime;
    private Integer eskNumber;
    private StringBuilder strArray, materialDescription, destinationMarket, batch, materialGroup;
    private String[] materialDescriptionArr;
    private Double grossWeight, materialLength, materialWidth, materialHeight, materialVolume, refrigerantWeight, frequency;
    private byte capacityUnitOfMeasure, inverter, powerSupply, ceMark, application, mode, refrigerant, compressorType, packingStyle, salesOemProduct, buyOemProduct, indoorOutdoor, dgIndicatorProfile, businessPilar;

    static Connection connection = null;
    static PreparedStatement preparedStatement;
    static Statement statement = null;
    private ResultSet resultSet;
    private Iterator<Material> iterator;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String inputSend = request.getParameter("send");
        HttpSession httpSession = request.getSession();
        if (inputSend.equals("send")) {
            try {
                connection = ConnectionProvider.getConnection();

                while(!connection.isClosed()) {
                    preparedStatement = connection.prepareStatement("insert into materials(material_name,product_number,user_id,requested_by,request_datetime,esk_number,request_type,request_sub_type,remark,batch_number, product_hierarchy, gross_Weight, net_Weight, material_Length, material_Width, material_Height, material_Volume, Capacity_Unit_Of_Measure, inverter, POWER_SUPPLY, CEMARK, REFR_APPLICATION, REFR_MODE, REFRIGERANT_TYPE, REFRIGERANT_WEIGHT, FREQUENCY, COMPRESSOR_TYPE, PACKAGING_STYLE, SALES_OEM_PRODUCT, BUY_OEM_PRODUCT, INDOOR_OUTDOOR, DG_INDICATOR_PROFILE, SALES_BRAND, BUSINESS_PILAR, MATERIAL_SOURCE, FACTORY_NAME, DESTINATION_MARKET) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                    connection.setAutoCommit(false);
                    for (iterator = materialList.iterator(); iterator.hasNext();) {
                        Material material = (Material) iterator.next();
                        preparedStatement.setString(1, material.getMaterialName());
                        preparedStatement.setString(2,material.getProductNumber());
                        preparedStatement.setString(3, material.getEmployeeID());
                        preparedStatement.setString(4, material.getRequestedBy());
                        preparedStatement.setTimestamp(5, material.getRequestDateTime());
                        preparedStatement.setInt(6,material.getEskNumber());
                        preparedStatement.setString(7, material.getRequestType());
                        preparedStatement.setString(8,material.getRequestSubType());
                        preparedStatement.setString(9,material.getRemark());
                        preparedStatement.setString(10,String.valueOf(material.getBatchNumber()));
                        preparedStatement.setString(11,material.getProductHierarchy());
                        preparedStatement.setDouble(12,material.getGrossWeight());
                        preparedStatement.setDouble(13,material.getNetWeight());
                        preparedStatement.setDouble(14,material.getMaterialLength());
                        preparedStatement.setDouble(15,material.getMaterialWidth());
                        preparedStatement.setDouble(16,material.getMaterialHeight());
                        preparedStatement.setDouble(17,material.getMaterialVolume());
                        preparedStatement.setByte(18,material.getCapacityUnitOfMeasure());
                        preparedStatement.setByte(19,material.getInverter());
                        preparedStatement.setByte(20,material.getPowerSupply());
                        preparedStatement.setByte(21,material.getCeMark());
                        preparedStatement.setByte(22,material.getApplication());
                        preparedStatement.setByte(23,material.getMode());
                        preparedStatement.setByte(24,material.getRefrigerant());
                        preparedStatement.setDouble(25,material.getRefrigerantWeight());
                        preparedStatement.setDouble(26,material.getFrequency());
                        preparedStatement.setByte(27,material.getCompressorType());
                        preparedStatement.setByte(28,material.getPackingStyle());
                        preparedStatement.setByte(29,material.getSalesOemProduct());
                        preparedStatement.setByte(30,material.getBuyOemProduct());
                        preparedStatement.setByte(31,material.getIndoorOutdoor());
                        preparedStatement.setByte(32,material.getDgIndicatorProfile());
                        preparedStatement.setString(33,material.getSalesBrand());
                        preparedStatement.setByte(34,material.getBusinessPilar());
                        preparedStatement.setString(35,material.getSource());
                        preparedStatement.setString(36,material.getFactory());
                        preparedStatement.setString(37,material.getDestMarket());
                        preparedStatement.addBatch();
                    }
                    preparedStatement.executeBatch();
                    connection.commit();
                    connection.setAutoCommit(true);
                    connection.close();

                }
                httpSession.removeAttribute("materialList");
                materialList.clear();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        response.sendRedirect("http://localhost:8090/MMDManager/MaterialDashboard.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession httpSession = request.getSession();
        String inputSave = request.getParameter("save");

        try {
            if (inputSave.equals("save")) {

                connection = ConnectionProvider.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select USER_ID, first_name || ' ' || last_name, logon_id from users natural join logons order by 3 desc fetch first 1 rows only");

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

                    materialGroup = new StringBuilder().
                            append(request.getParameter("firstLevelMG"));
                    materialGroupStr = String.valueOf(materialGroup.substring(0,3));
                    materialGroupStr = materialGroupStr.concat(request.getParameter("secondLevelMG").substring(0,3));

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

                    capacityUnitOfMeasure = Byte.parseByte(request.getParameter("capacityUnitOfMeasure"));
                    inverter = Byte.parseByte(request.getParameter("inverter"));
                    powerSupply = Byte.parseByte(request.getParameter("powerSupply"));
                    ceMark = Byte.parseByte(request.getParameter("ceMark"));
                    application = Byte.parseByte(request.getParameter("application"));
                    mode = Byte.parseByte(request.getParameter("mode"));
                    refrigerant = Byte.parseByte(request.getParameter("refrigerant"));
                    refrigerantWeight = Double.valueOf(request.getParameter("refrigerantWeight"));
                    frequency = Double.valueOf(request.getParameter("frequency"));
                    compressorType = Byte.parseByte(request.getParameter("compressorType"));
                    packingStyle = Byte.parseByte(request.getParameter("packingStyle"));
                    salesOemProduct = Byte.parseByte(request.getParameter("salesOemProduct"));
                    buyOemProduct = Byte.parseByte(request.getParameter("buyOemProduct"));
                    indoorOutdoor = Byte.parseByte(request.getParameter("indoorOutdoor"));
                    dgIndicatorProfile = Byte.parseByte(request.getParameter("dgIndicatorProfile"));
                    salesBrand = String.valueOf(request.getParameter("salesBrand"));
                    businessPilar = Byte.parseByte(request.getParameter("businessPilar"));
                    source = String.valueOf(request.getParameter("sourceCountryOfOrg"));
                    factory = String.valueOf(request.getParameter("factory"));

                    String destMarketTab[] = request.getParameterValues("destMarket");
                    destinationMarket = new StringBuilder();
                    for (byte i = 0; i < destMarketTab.length; i++) {
                        if (destMarketTab[i] != null || !destMarketTab[i].equals("null")) {
                            destinationMarket.append(destMarketTab[i]).append(",");
                        }
                    }

                    materialList.add(new Material(materialName,productNumber,employeeID,requestedBy,requestDateTime,eskNumber,requestType,requestSubType,remark, batch, materialGroupStr, productHierarchyStr, String.valueOf(materialDescription), grossWeight, materialLength, materialWidth, materialHeight, materialVolume, capacityUnitOfMeasure, inverter, powerSupply, ceMark, application, mode, refrigerant, refrigerantWeight, frequency, compressorType, packingStyle, salesOemProduct, buyOemProduct, indoorOutdoor, dgIndicatorProfile, salesBrand, businessPilar, source, factory, String.valueOf(destinationMarket)));
                    httpSession.setAttribute("materialList",materialList);

                    response.sendRedirect("http://localhost:8090/MMDManager/MaterialDashboard.jsp");
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
