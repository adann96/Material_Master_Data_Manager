package com.mmdmanager.others;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.ArrayList;
import java.util.Iterator;

public class Worksheet {
    Iterator i;
    HSSFWorkbook hssfWorkbook;
    HSSFSheet hssfSheet;

    public HSSFWorkbook getMaterialSet(ArrayList<Material> materialList) {
        hssfWorkbook = new HSSFWorkbook();

        i = materialList.iterator();
        hssfSheet = hssfWorkbook.createSheet("Request number: " + i.hasNext());
        return hssfWorkbook;
    }
}
