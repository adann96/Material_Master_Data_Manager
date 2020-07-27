package com.mmdmanager.others;

import com.mmdmanager.others.Material;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Workbook {
    String[] excelHeaders = new String[] {"Id",	"Request Number",	"(E)SK Number",	"Request type",	"Creation type",	"Request by",	"Request date",	"Product Number",	"Material Name",	"Remark",	"Material Group",	"Product Hierachy",	"Batch",	"Gross weight (Kg)",	"Net weight (Kg)",	"Length (M)",	"Width (M)",	"Height (M)",	"Volume (M³)",	"Capacity Unit of Measure",	"Inverter",	"Power Supply",	"CE-mark",	"Application",	"Mode",	"Refrigerant",	"Compressor type",	"Refrigerant Weight (Kg)",	"Frequency",	"Packing style",	"Sales OEM product",	"Buy OEM product",	"Indoor / outdoor",	"DG Indicator Profile",	"Business Pilar",	"Source / Country of Origin",	"Sales Brand",	"Destination Market",	"Factory", "Commodity Code","MRP type",	"SNP planner",	"Poscode",	"",	"Batch determination"};

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet;
    XSSFRow row;

    public XSSFWorkbook getWorkbook(ArrayList<Material> materialList, ResultSet resultSet) throws SQLException {
        Iterator<Material> iterator = materialList.iterator();

        int counter = 0;
        String[][] array = new String[materialList.size()][39];
        while (iterator.hasNext()) {
            array[counter] = String.valueOf(iterator.next()).split(",");
            counter++;
        }

        try {
            if (resultSet.next()) {
                int logon_id = resultSet.getInt(1);
                int request_no = resultSet.getInt(2);

                sheet = workbook.createSheet("Request CREATION");
                row = sheet.createRow(0);
                for(byte i = 0; i<excelHeaders.length; i++) {
                    XSSFCell cell = row.createCell(i);
                    cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                    cell.setCellValue(excelHeaders[i]);
                }

                for (byte n = 1; n < materialList.size() + 1; n++) {
                    row = sheet.createRow(n);
                    XSSFCell cellLogonId = row.createCell(0);
                    cellLogonId.setCellValue(logon_id);
                    XSSFCell cellRequestNo = row.createCell(1);
                    cellRequestNo.setCellValue(request_no);

                    for (byte y = 2; y < array[n-1].length+2; y++) {
                        if (y == 39 && row.getLastCellNum() == 39) {
                            XSSFCell cell = row.createCell(y);
                            cell.setCellValue("");
                            y = (byte) (y - 1);
                        }
                        else if (row.getLastCellNum() > 39) {
                            XSSFCell cell = row.createCell(y+1);
                            cell.setCellValue(array[n-1][y-2]);
                        }
                        else {
                            XSSFCell cell = row.createCell(y);
                            cell.setCellValue(array[n-1][y-2]);
                        }
                    }
                }

                FileOutputStream outputStream = new FileOutputStream("C:\\Users\\admin\\Desktop\\Request " + String.valueOf(request_no) + ".xlsx");
                workbook.write(outputStream);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return workbook;
    };
}
