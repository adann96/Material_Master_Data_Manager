package com.mmdmanager.others;

import java.sql.Timestamp;

public class Material {
    private String materialName, productNumber, employeeID;
    private String requestedBy;
    private Timestamp requestDateTime;
    private Integer eskNumber;
    private String requestType, requestSubType;
    private String remark;
    private StringBuilder batchNumber;
    private String materialGroup, productHierarchy, materialDescription;
    private Double grossWeight, materialLength, materialWidth, materialHeight, materialVolume;

    public Material(String materialName, String productNumber, String employeeID, String requestedBy, Timestamp requestDateTime, Integer eskNumber, String requestType, String requestSubType, String remark, StringBuilder batchNumber, String materialGroup, String productHierarchy, String materialDescription, Double grossWeight, Double materialLength, Double materialWidth, Double materialHeight, Double materialVolume) {
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

