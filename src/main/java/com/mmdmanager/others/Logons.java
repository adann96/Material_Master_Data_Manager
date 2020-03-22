package com.mmdmanager.others;

import java.sql.Timestamp;

public class Logons {
    private int logon_id;
    private String user_id, first_name, last_name, company_short_name;
    private Timestamp start_session;
    private Timestamp end_of_session;

    public Logons() {

    }

    public Logons(int logon_id, String user_id, String first_name, String last_name, String company_short_name, Timestamp start_session, Timestamp end_of_session) {
        this.logon_id = logon_id;
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.company_short_name = company_short_name;
        this.start_session = start_session;
        this.end_of_session = end_of_session;
    }

    public int getLogon_id() {
        return logon_id;
    }

    public void setLogon_id(int logon_id) {
        this.logon_id = logon_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCompany_short_name() {
        return company_short_name;
    }

    public void setCompany_short_name(String company_short_name) {
        this.company_short_name = company_short_name;
    }

    public Timestamp getStart_session() {
        return start_session;
    }

    public void setStart_session(Timestamp start_session) {
        this.start_session = start_session;
    }

    public Timestamp getEnd_of_session() {
        return end_of_session;
    }

    public void setEnd_of_session(Timestamp end_of_session) {
        this.end_of_session = end_of_session;
    }
}
