package com.mmdmanager.servlets;

import com.mmdmanager.dao.MaterialDAO;
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
    private Iterator<Material> iterator;

    String[] excelHeaders = new String[] {"Id",	"Request Number",	"(E)SK Number",	"Request type",	"Creation type",	"Request by",	"Request date",	"Product Number",	"Material Name",	"Remark",	"Material Group",	"Product Hierachy",	"Batch",	"Gross weight (Kg)",	"Net weight (Kg)",	"Length (M)",	"Width (M)",	"Height (M)",	"Volume (M³)",	"Capacity Unit of Measure",	"Inverter",	"Power Supply",	"CE-mark",	"Application",	"Mode",	"Refrigerant",	"Compressor type",	"Refrigerant Weight (Kg)",	"Frequency",	"Packing style",	"Sales OEM product",	"Buy OEM product",	"Indoor / outdoor",	"DG Indicator Profile",	"Business Pilar",	"Source / Country of Origin",	"Sales Brand",	"Destination Market",	"Factory",	"MRP type",	"SNP planner",	"Poscode",	"",	"Batch determination"};

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet;
    XSSFRow row;

    private GeneralData generalData;
    private MaterialData materialData;
    private WeigthsAndDimensions weigthsAndDimensions;
    private TechnicalData technicalData;
    private LogisticData logisticData;

    private String materialProperties = new String();

    private final MaterialDAO materialDAO = new MaterialDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String inputSend = request.getParameter("send");
        HttpSession httpSession = request.getSession();

        try {
            if (inputSend.equals("send")) {
                //materialList = materialDAO.getMaterialList(materialList);
                iterator = materialList.iterator();

                while(iterator.hasNext()) {
                    materialProperties = String.valueOf(iterator.next());
                }
                String[] tokensVal = materialProperties.split(",");

                int counter = 0;
                String[][] array = new String[materialList.size()][37];
                while (iterator.hasNext()) {
                    array[counter] = String.valueOf(iterator.next()).split(",");
                    counter++;
                }

                try {
                    sheet = workbook.createSheet("Request");
                    row = sheet.createRow(0);
                    for(byte i = 0; i<excelHeaders.length; i++) {
                        XSSFCell cell = row.createCell(i);
                        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                        cell.setCellValue(excelHeaders[i]);
                    }
                    for (byte n = 1; n < materialList.size() + 1; n++) {
                        row = sheet.createRow(n);
                        for (byte y = 2; y < array.length+2; y++) {
                            XSSFCell cell = row.createCell(y);
                            cell.setCellValue(array[n-1][y-2]);
                        }
                    }
                    FileOutputStream outputStream = new FileOutputStream("C:\\Users\\admin\\Desktop\\Test1.xlsx");
                    workbook.write(outputStream);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
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

                StringBuilder strArray = new StringBuilder().append(request.getParameter("firstLevelMG"))
                        .append(" - ").append(request.getParameter("secondLevelMG"))
                        .append(" - ").append(request.getParameter("productHierarchy1"))
                        .append(" - ").append(request.getParameter("productHierarchy2"))
                        .append(" - ").append(request.getParameter("productHierarchy3"));

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

                String destMarketTab[] = request.getParameterValues("destMarket");
                StringBuilder destinationMarket = new StringBuilder();
                for (byte i = 0; i < destMarketTab.length; i++) {
                    if (destMarketTab[i] != null || !destMarketTab[i].equals("null")) {
                        destinationMarket.append(destMarketTab[i]).append("-");
                    }
                }
                destinationMarket.deleteCharAt(destinationMarket.length()-1);
                logisticData = new LogisticData(packingStyle, salesOemProduct, buyOemProduct, indoorOutdoor, dgIndicatorProfile, salesBrand, businessPilar, source,String.valueOf(destinationMarket), factory);

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
