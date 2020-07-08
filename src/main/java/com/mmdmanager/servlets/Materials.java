package com.mmdmanager.servlets;

import com.mmdmanager.dao.MaterialDAO;
import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.*;
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

    private GeneralData generalData;
    private MaterialData materialData;
    private WeigthsAndDimensions weigthsAndDimensions;
    private TechnicalData technicalData;
    private LogisticData logisticData;
    private Material material;

    private MaterialDAO materialDAO = new MaterialDAO();

    private String materialName, productNumber, employeeID, requestType, requestSubType, remark, batchContainsSth, factory, materialGroupStr, productHierarchyStr, salesBrand, source;
    private Timestamp requestDateTime;
    private Integer eskNumber;
    private StringBuilder strArray, materialDescription, destinationMarket, batch, materialGroup;
    private String[] materialDescriptionArr;
    private Double grossWeight, materialLength, materialWidth, materialHeight, materialVolume, refrigerantWeight, frequency;
    private byte capacityUnitOfMeasure, inverter, powerSupply, ceMark, application, mode, refrigerant, compressorType, packingStyle, salesOemProduct, buyOemProduct, indoorOutdoor, dgIndicatorProfile, businessPilar;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String inputSend = request.getParameter("send");
        HttpSession httpSession = request.getSession();

        try {
            if (inputSend.equals("send")) {
                materialList = materialDAO.getMaterialList(materialList, generalData, materialData, weigthsAndDimensions, technicalData, logisticData);
            }
            httpSession.removeAttribute("materialList");
            materialList.clear();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        response.sendRedirect("http://localhost:8090/MMDManager/MaterialDashboard.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession httpSession = request.getSession();
        String inputSave = request.getParameter("save");
        try {
            if (inputSave.equals("save")) {

                /*General Data*/
                employeeID = String.valueOf(httpSession.getAttribute("user_id"));
                requestDateTime = new Timestamp(System.currentTimeMillis());
                eskNumber = Integer.valueOf(request.getParameter("eskNumber"));
                requestType = request.getParameter("requestType");
                requestSubType = request.getParameter("requestSubType");

                generalData = new GeneralData(eskNumber,employeeID,requestType,requestSubType,requestDateTime);

                /*Material Data*/
                productNumber = request.getParameter("productNumber");
                materialName = request.getParameter("materialName");
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
                materialData = new MaterialData(productNumber,materialName,remark,batch,materialGroupStr,productHierarchyStr);

                /*W&D*/
                grossWeight = Double.valueOf(request.getParameter("grossWeight"));
                materialLength = Double.valueOf(request.getParameter("length"));
                materialWidth = Double.valueOf(request.getParameter("width"));
                materialHeight = Double.valueOf(request.getParameter("height"));
                materialVolume = Double.valueOf(request.getParameter("volume"));
                weigthsAndDimensions = new WeigthsAndDimensions(grossWeight,grossWeight,materialLength,materialWidth,materialHeight,materialVolume);

                /*Technical Data*/
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
                technicalData = new TechnicalData(capacityUnitOfMeasure,inverter,powerSupply,ceMark,application,mode,refrigerant,compressorType,refrigerantWeight,frequency);

                /*Logistic Data*/
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
                logisticData = new LogisticData(packingStyle,salesOemProduct,buyOemProduct,indoorOutdoor,dgIndicatorProfile,salesBrand,businessPilar,source,String.valueOf(destinationMarket),factory);

                material = new Material(generalData,materialData,weigthsAndDimensions,technicalData,logisticData);
                materialList.add(material);

                httpSession.setAttribute("materialList",materialList);
                response.sendRedirect("http://localhost:8090/MMDManager/MaterialDashboard.jsp");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
