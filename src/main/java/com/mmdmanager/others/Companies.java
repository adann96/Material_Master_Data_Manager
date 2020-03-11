package com.mmdmanager.others;

public class Companies {
    private int company_id;
    private String company_name;
    private String company_short_name;
    private String company_country;

    public Companies(int company_id, String company_name, String company_short_name, String company_country) {
        this.company_id = company_id;
        this.company_name = company_name;
        this.company_short_name = company_short_name;
        this.company_country = company_country;
    }

    public Companies() {

    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_short_name() {
        return company_short_name;
    }

    public void setCompany_short_name(String company_short_name) {
        this.company_short_name = company_short_name;
    }

    public String getCompany_country() {
        return company_country;
    }

    public void setCompany_country(String company_country) {
        this.company_country = company_country;
    }
}
