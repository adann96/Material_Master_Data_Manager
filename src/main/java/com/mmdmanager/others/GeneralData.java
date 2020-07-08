package com.mmdmanager.others;

import java.sql.Timestamp;

public class GeneralData {
    private Integer eskNumber;
    private String requestType, requestSubType, employeeID;
    private Timestamp requestDateTime;

    public GeneralData(Integer eskNumber, String employeeID, String requestType, String requestSubType, Timestamp requestDateTime) {
        this.eskNumber = eskNumber;
        this.employeeID = employeeID;
        this.requestType = requestType;
        this.requestSubType = requestSubType;
        this.requestDateTime = requestDateTime;
    }

    public String getEmployeeID() {
        return employeeID;
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
