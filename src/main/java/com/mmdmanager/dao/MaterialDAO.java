package com.mmdmanager.dao;

import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class MaterialDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;
    private Iterator<Material> iterator;
    ResultSet resultSet;

    public ArrayList<Material> getMaterialList(ArrayList<Material> materialList, GeneralData generalData, MaterialData materialData, WeigthsAndDimensions weigthsAndDimensions, TechnicalData technicalData, LogisticData logisticData) {

        try {
            connection = ConnectionProvider.getConnection();
            while(!connection.isClosed()) {
                preparedStatement = connection.prepareStatement("insert into materials(material_name,product_number,user_id,request_datetime,esk_number,request_type,request_sub_type,remark,batch_number, product_hierarchy, gross_Weight, net_Weight, material_Length, material_Width, material_Height, material_Volume, Capacity_Unit_Of_Measure, inverter, POWER_SUPPLY, CEMARK, REFR_APPLICATION, REFR_MODE, REFRIGERANT_TYPE, REFRIGERANT_WEIGHT, FREQUENCY, COMPRESSOR_TYPE, PACKAGING_STYLE, SALES_OEM_PRODUCT, BUY_OEM_PRODUCT, INDOOR_OUTDOOR, DG_INDICATOR_PROFILE, SALES_BRAND, BUSINESS_PILAR, MATERIAL_SOURCE, FACTORY_NAME, DESTINATION_MARKET) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                connection.setAutoCommit(false);
                for (iterator = materialList.iterator(); iterator.hasNext();) {
                    Material material = (Material) iterator.next();
                    preparedStatement.setString(1, materialData.getMaterialName());
                    preparedStatement.setString(2, materialData.getProductNumber());
                    preparedStatement.setString(3, generalData.getEmployeeID());
                    preparedStatement.setTimestamp(4, generalData.getRequestDateTime());
                    preparedStatement.setInt(5,generalData.getEskNumber());
                    preparedStatement.setString(6, generalData.getRequestType());
                    preparedStatement.setString(7, generalData.getRequestSubType());
                    preparedStatement.setString(8, materialData.getRemark());
                    preparedStatement.setString(9, String.valueOf(materialData.getBatchNumber()));
                    preparedStatement.setString(10, materialData.getProductHierarchy());
                    preparedStatement.setDouble(11, weigthsAndDimensions.getGrossWeight());
                    preparedStatement.setDouble(12, weigthsAndDimensions.getNetWeight());
                    preparedStatement.setDouble(13, weigthsAndDimensions.getMaterialLength());
                    preparedStatement.setDouble(14, weigthsAndDimensions.getMaterialWidth());
                    preparedStatement.setDouble(15, weigthsAndDimensions.getMaterialHeight());
                    preparedStatement.setDouble(16, weigthsAndDimensions.getMaterialVolume());
                    preparedStatement.setByte(17, technicalData.getCapacityUnitOfMeasure());
                    preparedStatement.setByte(18, technicalData.getInverter());
                    preparedStatement.setByte(19, technicalData.getPowerSupply());
                    preparedStatement.setByte(20, technicalData.getCeMark());
                    preparedStatement.setByte(21, technicalData.getApplication());
                    preparedStatement.setByte(22, technicalData.getMode());
                    preparedStatement.setByte(23, technicalData.getRefrigerant());
                    preparedStatement.setDouble(24, technicalData.getRefrigerantWeight());
                    preparedStatement.setDouble(25, technicalData.getFrequency());
                    preparedStatement.setByte(26, technicalData.getCompressorType());
                    preparedStatement.setByte(27, logisticData.getPackingStyle());
                    preparedStatement.setByte(28, logisticData.getSalesOemProduct());
                    preparedStatement.setByte(29, logisticData.getBuyOemProduct());
                    preparedStatement.setByte(30, logisticData.getIndoorOutdoor());
                    preparedStatement.setByte(31, logisticData.getDgIndicatorProfile());
                    preparedStatement.setString(32, logisticData.getSalesBrand());
                    preparedStatement.setByte(33, logisticData.getBusinessPilar());
                    preparedStatement.setString(34, logisticData.getSource());
                    preparedStatement.setString(35, logisticData.getFactory());
                    preparedStatement.setString(36, logisticData.getDestinationMarket());
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
                connection.commit();
                connection.setAutoCommit(true);
                connection.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materialList;
    }
}
