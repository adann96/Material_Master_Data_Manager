package com.mmdmanager.others;

import java.sql.Timestamp;

public class Material {
    private String materialName, productNumber, employeeID;
    private String requestedBy;
    private Timestamp requestDateTime;
    private Integer eskNumber;
    private String requestType, requestSubType;
    private String remark;

    public Material(String materialName, String productNumber, String employeeID, String requestedBy, Timestamp requestDateTime, Integer eskNumber, String requestType, String requestSubType, String remark) {
        this.materialName = materialName;
        this.productNumber = productNumber;
        this.employeeID = employeeID;
        this.requestedBy = requestedBy;
        this.requestDateTime = requestDateTime;
        this.eskNumber = eskNumber;
        this.requestType = requestType;
        this.requestSubType = requestSubType;
        this.remark = remark;
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

    public Timestamp getRequestDateTime() { return requestDateTime; }

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

