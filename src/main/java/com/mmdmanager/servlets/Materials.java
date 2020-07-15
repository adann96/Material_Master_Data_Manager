package com.mmdmanager.servlets;

import com.mmdmanager.dao.MaterialDAO;
import com.mmdmanager.dao.WorkbookDAO;
import com.mmdmanager.others.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet("/Materials")
public class Materials extends HttpServlet {
    private ArrayList<Material> materialList = new ArrayList<>();

    private GeneralData generalData;
    private MaterialData materialData;
    private WeigthsAndDimensions weigthsAndDimensions;
    private TechnicalData technicalData;
    private LogisticData logisticData;

    XSSFWorkbook workbook = new XSSFWorkbook();

    private final MaterialDAO materialDAO = new MaterialDAO();
    private final WorkbookDAO workbookDAO = new WorkbookDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String inputSend = request.getParameter("send");
        HttpSession httpSession = request.getSession();

        try {
            if (inputSend.equals("send")) {
                //materialList = materialDAO.getMaterialList(materialList);
                workbook = workbookDAO.getWorkbook(materialList);
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
                String employeeID = String.valueOf(httpSession.getAttribute("user_id"));
                Timestamp requestDateTime = new Timestamp(System.currentTimeMillis());
                Integer eskNumber = Integer.valueOf(request.getParameter("eskNumber"));
                String requestType = request.getParameter("requestType");
                String requestSubType = request.getParameter("requestSubType");

                generalData = new GeneralData(eskNumber, employeeID, requestType, requestSubType, requestDateTime);

                /*Material Data*/
                String productNumber = request.getParameter("productNumber");
                String materialName = request.getParameter("materialName");
                String remark = request.getParameter("remark");

                String batchContainsSth = request.getParameter("batchCountry");
                StringBuilder batch;
                if (batchContainsSth == null) {
                    batch = new StringBuilder();
                }
                else {
                    batch = new StringBuilder().
                            append(request.getParameter("batchCountry")).
                            append("0").
                            append(request.getParameter("batchNumber"));
                }

                StringBuilder materialGroup = new StringBuilder().
                        append(request.getParameter("firstLevelMG"));
                String materialGroupStr = String.valueOf(materialGroup.substring(0, 3));
                materialGroupStr = materialGroupStr.concat(request.getParameter("secondLevelMG").substring(0,3));
                String productHierarchyStr = materialGroupStr
                        .concat(request.getParameter("productHierarchy1").substring(0, 3))
                        .concat(request.getParameter("productHierarchy2").substring(0, 3))
                        .concat(request.getParameter("productHierarchy3").substring(0, 3));

                String strArray = request.getParameter("firstLevelMG") +
                        " - " + request.getParameter("secondLevelMG") +
                        " - " + request.getParameter("productHierarchy1") +
                        " - " + request.getParameter("productHierarchy2") +
                        " - " + request.getParameter("productHierarchy3");
                String[] materialDescriptionArr = String.valueOf(strArray).split(" - ");

                StringBuilder materialDescription = new StringBuilder();
                for (int i = 0; i< materialDescriptionArr.length; i++) {
                    if ((i%2) !=0) {
                        materialDescription.append(materialDescriptionArr[i]);
                        if (i < materialDescriptionArr.length-1) {
                            materialDescription.append("<");
                        }
                    }
                }
                materialData = new MaterialData(productNumber, materialName, remark, batch, materialGroupStr, productHierarchyStr);

                /*W&D*/
                Double grossWeight = Double.valueOf(request.getParameter("grossWeight"));
                Double materialLength = Double.valueOf(request.getParameter("length"));
                Double materialWidth = Double.valueOf(request.getParameter("width"));
                Double materialHeight = Double.valueOf(request.getParameter("height"));
                Double materialVolume = Double.valueOf(request.getParameter("volume"));
                weigthsAndDimensions = new WeigthsAndDimensions(grossWeight, grossWeight, materialLength, materialWidth, materialHeight, materialVolume);

                /*Technical Data*/
                byte capacityUnitOfMeasure = Byte.parseByte(request.getParameter("capacityUnitOfMeasure"));
                byte inverter = Byte.parseByte(request.getParameter("inverter"));
                byte powerSupply = Byte.parseByte(request.getParameter("powerSupply"));
                byte ceMark = Byte.parseByte(request.getParameter("ceMark"));
                byte application = Byte.parseByte(request.getParameter("application"));
                byte mode = Byte.parseByte(request.getParameter("mode"));
                byte refrigerant = Byte.parseByte(request.getParameter("refrigerant"));
                Double refrigerantWeight = Double.valueOf(request.getParameter("refrigerantWeight"));
                Double frequency = Double.valueOf(request.getParameter("frequency"));
                byte compressorType = Byte.parseByte(request.getParameter("compressorType"));
                technicalData = new TechnicalData(capacityUnitOfMeasure, inverter, powerSupply, ceMark, application, mode, refrigerant, compressorType, refrigerantWeight, frequency);

                /*Logistic Data*/
                byte packingStyle = Byte.parseByte(request.getParameter("packingStyle"));
                byte salesOemProduct = Byte.parseByte(request.getParameter("salesOemProduct"));
                byte buyOemProduct = Byte.parseByte(request.getParameter("buyOemProduct"));
                byte indoorOutdoor = Byte.parseByte(request.getParameter("indoorOutdoor"));
                byte dgIndicatorProfile = Byte.parseByte(request.getParameter("dgIndicatorProfile"));
                String salesBrand = String.valueOf(request.getParameter("salesBrand"));
                byte businessPilar = Byte.parseByte(request.getParameter("businessPilar"));
                String source = String.valueOf(request.getParameter("sourceCountryOfOrg"));
                String factory = String.valueOf(request.getParameter("factory"));

                String[] destMarketTab = request.getParameterValues("destMarket");
                StringBuilder destinationMarket = new StringBuilder();
                for (byte i = 0; i < destMarketTab.length; i++) {
                    if (destMarketTab[i] != null || !destMarketTab[i].equals("null")) {
                        destinationMarket.append(destMarketTab[i]).append("-");
                    }
                }
                destinationMarket.deleteCharAt(destinationMarket.length()-1);
                String mrpType = request.getParameter("mrpType");
                String snpPlanner = request.getParameter("snpPlanner");
                logisticData = new LogisticData(packingStyle, salesOemProduct, buyOemProduct, indoorOutdoor, dgIndicatorProfile, salesBrand, businessPilar, source,String.valueOf(destinationMarket), factory, mrpType, snpPlanner);

                Material material = new Material(generalData, materialData, weigthsAndDimensions, technicalData, logisticData);
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
