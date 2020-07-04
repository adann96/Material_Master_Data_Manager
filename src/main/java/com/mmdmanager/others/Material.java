package com.mmdmanager.others;

import java.sql.Timestamp;

public class Material {
    private String materialName, productNumber, employeeID, destMarket;
    private String requestedBy;
    private Timestamp requestDateTime;
    private Integer eskNumber;
    private String requestType, requestSubType, factory;
    private String remark;
    private StringBuilder batchNumber;
    private String materialGroup, productHierarchy, materialDescription, salesBrand, source;
    private Double grossWeight, materialLength, materialWidth, materialHeight, materialVolume, refrigerantWeight, frequency;
    private byte capacityUnitOfMeasure, inverter, powerSupply, ceMark, application, mode, refrigerant, compressorType, packingStyle, salesOemProduct, buyOemProduct, indoorOutdoor, dgIndicatorProfile, businessPilar;

    public Material(String materialName, String productNumber, String employeeID, String requestedBy, Timestamp requestDateTime, Integer eskNumber, String requestType, String requestSubType, String remark, StringBuilder batchNumber, String materialGroup, String productHierarchy, String materialDescription, Double grossWeight, Double materialLength, Double materialWidth, Double materialHeight, Double materialVolume, byte capacityUnitOfMeasure, byte inverter, byte powerSupply, byte ceMark, byte application, byte mode, byte refrigerant, Double refrigerantWeight, Double frequency, byte compressorType, byte packingStyle, byte salesOemProduct, byte buyOemProduct, byte indoorOutdoor, byte dgIndicatorProfile, String salesBrand, byte businessPilar, String source, String factory, String destMarket) {
        this.materialName = materialName;
        this.productNumber = productNumber;
        this.employeeID = employeeID;
        this.requestedBy = requestedBy;
        this.requestDateTime = requestDateTime;
        this.eskNumber = eskNumber;
        this.requestType = requestType;
        this.requestSubType = requestSubType;
        this.remark = remark;
        this.batchNumber = batchNumber;
        this.materialGroup = materialGroup;
        this.productHierarchy = productHierarchy;
        this.materialDescription = materialDescription;
        this.grossWeight = grossWeight;
        this.materialLength = materialLength;
        this.materialWidth = materialWidth;
        this.materialHeight = materialHeight;
        this.materialVolume = materialVolume;
        this.capacityUnitOfMeasure = capacityUnitOfMeasure;
        this.inverter = inverter;
        this.powerSupply = powerSupply;
        this.ceMark = ceMark;
        this.application = application;
        this.mode = mode;
        this.refrigerant = refrigerant;
        this.refrigerantWeight = refrigerantWeight;
        this.frequency = frequency;
        this.compressorType = compressorType;
        this.packingStyle = packingStyle;
        this.salesOemProduct = salesOemProduct;
        this.buyOemProduct = buyOemProduct;
        this.indoorOutdoor = indoorOutdoor;
        this.dgIndicatorProfile = dgIndicatorProfile;
        this.salesBrand = salesBrand;
        this.businessPilar = businessPilar;
        this.source = source;
        this.factory = factory;
        this.destMarket = destMarket;
    }

    public String getDestMarket() {
        return destMarket;
    }

    public String getFactory() {
        return factory;
    }

    public String getSource() {
        return source;
    }

    public String getSalesBrand() {
        return salesBrand;
    }

    public byte getBusinessPilar() {
        return businessPilar;
    }

    public byte getDgIndicatorProfile() {
        return dgIndicatorProfile;
    }

    public byte getIndoorOutdoor() {
        return indoorOutdoor;
    }

    public byte getBuyOemProduct() {
        return buyOemProduct;
    }

    public byte getSalesOemProduct() {
        return salesOemProduct;
    }

    public byte getPackingStyle() {
        return packingStyle;
    }

    public byte getCompressorType() {
        return compressorType;
    }

    public Double getFrequency() {
        return frequency;
    }

    public Double getRefrigerantWeight() {
        return refrigerantWeight;
    }

    public byte getRefrigerant() {
        return refrigerant;
    }

    public byte getMode() {
        return mode;
    }

    public byte getCeMark() {
        return ceMark;
    }

    public byte getApplication() {
        return application;
    }

    public byte getPowerSupply() {
        return powerSupply;
    }

    public byte getInverter() {
        return inverter;
    }

    public byte getCapacityUnitOfMeasure() {
        return capacityUnitOfMeasure;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public Double getNetWeight() {
        return this.grossWeight * 0.8;
    }

    public Double getMaterialLength() {
        return materialLength;
    }

    public Double getMaterialWidth() {
        return materialWidth;
    }

    public Double getMaterialHeight() {
        return materialHeight;
    }

    public Double getMaterialVolume() {
        return materialVolume;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public String getProductHierarchy() {
        return productHierarchy;
    }

    public String getMaterialGroup() {
        return materialGroup;
    }

    public StringBuilder getBatchNumber() {
        return batchNumber;
    }

    public String getRemark() {
        return remark;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getMaterialName() {
        return materialName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public Timestamp getRequestDateTime() {
        return requestDateTime;
    }

    public Integer getEskNumber() {
        return eskNumber;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getRequestSubType() {
        return requestSubType;
    }

}

