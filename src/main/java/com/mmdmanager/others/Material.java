package com.mmdmanager.others;

import java.sql.Date;
import java.sql.Timestamp;

public class Material {
    private String employeeID, requestNumber, requestedBy;
    private Date requestDate;
    private Timestamp requestTime;
    private String eskNumber;
    private String requestType, requestSubType, productNumber, materialName, remark, batch_part_c, batch_part_n, materialGroupFirstL, materialGroupSecL;
    private String productHierarchyFirstL, productHierarchySecL, productHierarchyThirdL;
    private Double grossWeight, netWeight, materialLength, materialWidth, materialHeight, materialVolume;
    private String unitOfMeasure, inverterType, powerSupply, ceMark, applicationNumber, modeNumber, refrigerantNumber, compressorType;
    private Double refrigerantWeight, materialFrequency;
    private String packagingStyle, salesOemProduct, buyOemProduct;
    private boolean inOut;
    private String dgIndicatorProfile, salesBrand, businessPillar, source, factoryName, destinationMarket;

    public Material(String employeeID, String requestNumber, String requestedBy, Date requestDate, Timestamp requestTime, String eskNumber, String requestType, String requestSubType, String productNumber, String materialName, String remark, String batch_part_c, String batch_part_n, String materialGroupFirstL, String materialGroupSecL, String productHierarchyFirstL, String productHierarchySecL, String productHierarchyThirdL, Double grossWeight, Double netWeight, Double materialLength, Double materialWidth, Double materialHeight, Double materialVolume, String unitOfMeasure, String inverterType, String powerSupply, String ceMark, String applicationNumber, String modeNumber, String refrigerantNumber, String compressorType, Double refrigerantWeight, Double materialFrequency, String packagingStyle, String salesOemProduct, String buyOemProduct, boolean inOut, String dgIndicatorProfile, String salesBrand, String businessPillar, String source, String factoryName, String destinationMarket) {
        this.employeeID = employeeID;
        this.requestNumber = requestNumber;
        this.requestedBy = requestedBy;
        this.requestDate = requestDate;
        this.requestTime = requestTime;
        this.eskNumber = eskNumber;
        this.requestType = requestType;
        this.requestSubType = requestSubType;
        this.productNumber = productNumber;
        this.materialName = materialName;
        this.remark = remark;
        this.batch_part_c = batch_part_c;
        this.batch_part_n = batch_part_n;
        this.materialGroupFirstL = materialGroupFirstL;
        this.materialGroupSecL = materialGroupSecL;
        this.productHierarchyFirstL = productHierarchyFirstL;
        this.productHierarchySecL = productHierarchySecL;
        this.productHierarchyThirdL = productHierarchyThirdL;
        this.grossWeight = grossWeight;
        this.netWeight = netWeight;
        this.materialLength = materialLength;
        this.materialWidth = materialWidth;
        this.materialHeight = materialHeight;
        this.materialVolume = materialVolume;
        this.unitOfMeasure = unitOfMeasure;
        this.inverterType = inverterType;
        this.powerSupply = powerSupply;
        this.ceMark = ceMark;
        this.applicationNumber = applicationNumber;
        this.modeNumber = modeNumber;
        this.refrigerantNumber = refrigerantNumber;
        this.compressorType = compressorType;
        this.refrigerantWeight = refrigerantWeight;
        this.materialFrequency = materialFrequency;
        this.packagingStyle = packagingStyle;
        this.salesOemProduct = salesOemProduct;
        this.buyOemProduct = buyOemProduct;
        this.inOut = inOut;
        this.dgIndicatorProfile = dgIndicatorProfile;
        this.salesBrand = salesBrand;
        this.businessPillar = businessPillar;
        this.source = source;
        this.factoryName = factoryName;
        this.destinationMarket = destinationMarket;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Timestamp requestTime) {
        this.requestTime = requestTime;
    }

    public String getEskNumber() {
        return eskNumber;
    }

    public void setEskNumber(String eskNumber) {
        this.eskNumber = eskNumber;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestSubType() {
        return requestSubType;
    }

    public void setRequestSubType(String requestSubType) {
        this.requestSubType = requestSubType;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBatch_part_c() {
        return batch_part_c;
    }

    public void setBatch_part_c(String batch_part_c) {
        this.batch_part_c = batch_part_c;
    }

    public String getBatch_part_n() {
        return batch_part_n;
    }

    public void setBatch_part_n(String batch_part_n) {
        this.batch_part_n = batch_part_n;
    }

    public String getMaterialGroupFirstL() {
        return materialGroupFirstL;
    }

    public void setMaterialGroupFirstL(String materialGroupFirstL) {
        this.materialGroupFirstL = materialGroupFirstL;
    }

    public String getMaterialGroupSecL() {
        return materialGroupSecL;
    }

    public void setMaterialGroupSecL(String materialGroupSecL) {
        this.materialGroupSecL = materialGroupSecL;
    }

    public String getProductHierarchyFirstL() {
        return productHierarchyFirstL;
    }

    public void setProductHierarchyFirstL(String productHierarchyFirstL) {
        this.productHierarchyFirstL = productHierarchyFirstL;
    }

    public String getProductHierarchySecL() {
        return productHierarchySecL;
    }

    public void setProductHierarchySecL(String productHierarchySecL) {
        this.productHierarchySecL = productHierarchySecL;
    }

    public String getProductHierarchyThirdL() {
        return productHierarchyThirdL;
    }

    public void setProductHierarchyThirdL(String productHierarchyThirdL) {
        this.productHierarchyThirdL = productHierarchyThirdL;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public Double getMaterialLength() {
        return materialLength;
    }

    public void setMaterialLength(Double materialLength) {
        this.materialLength = materialLength;
    }

    public Double getMaterialWidth() {
        return materialWidth;
    }

    public void setMaterialWidth(Double materialWidth) {
        this.materialWidth = materialWidth;
    }

    public Double getMaterialHeight() {
        return materialHeight;
    }

    public void setMaterialHeight(Double materialHeight) {
        this.materialHeight = materialHeight;
    }

    public Double getMaterialVolume() {
        return materialVolume;
    }

    public void setMaterialVolume(Double materialVolume) {
        this.materialVolume = materialVolume;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getInverterType() {
        return inverterType;
    }

    public void setInverterType(String inverterType) {
        this.inverterType = inverterType;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public String getCeMark() {
        return ceMark;
    }

    public void setCeMark(String ceMark) {
        this.ceMark = ceMark;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getModeNumber() {
        return modeNumber;
    }

    public void setModeNumber(String modeNumber) {
        this.modeNumber = modeNumber;
    }

    public String getRefrigerantNumber() {
        return refrigerantNumber;
    }

    public void setRefrigerantNumber(String refrigerantNumber) {
        this.refrigerantNumber = refrigerantNumber;
    }

    public String getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(String compressorType) {
        this.compressorType = compressorType;
    }

    public Double getRefrigerantWeight() {
        return refrigerantWeight;
    }

    public void setRefrigerantWeight(Double refrigerantWeight) {
        this.refrigerantWeight = refrigerantWeight;
    }

    public Double getMaterialFrequency() {
        return materialFrequency;
    }

    public void setMaterialFrequency(Double materialFrequency) {
        this.materialFrequency = materialFrequency;
    }

    public String getPackagingStyle() {
        return packagingStyle;
    }

    public void setPackagingStyle(String packagingStyle) {
        this.packagingStyle = packagingStyle;
    }

    public String getSalesOemProduct() {
        return salesOemProduct;
    }

    public void setSalesOemProduct(String salesOemProduct) {
        this.salesOemProduct = salesOemProduct;
    }

    public String getBuyOemProduct() {
        return buyOemProduct;
    }

    public void setBuyOemProduct(String buyOemProduct) {
        this.buyOemProduct = buyOemProduct;
    }

    public boolean isInOut() {
        return inOut;
    }

    public void setInOut(boolean inOut) {
        this.inOut = inOut;
    }

    public String getDgIndicatorProfile() {
        return dgIndicatorProfile;
    }

    public void setDgIndicatorProfile(String dgIndicatorProfile) {
        this.dgIndicatorProfile = dgIndicatorProfile;
    }

    public String getSalesBrand() {
        return salesBrand;
    }

    public void setSalesBrand(String salesBrand) {
        this.salesBrand = salesBrand;
    }

    public String getBusinessPillar() {
        return businessPillar;
    }

    public void setBusinessPillar(String businessPillar) {
        this.businessPillar = businessPillar;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getDestinationMarket() {
        return destinationMarket;
    }

    public void setDestinationMarket(String destinationMarket) {
        this.destinationMarket = destinationMarket;
    }
}
