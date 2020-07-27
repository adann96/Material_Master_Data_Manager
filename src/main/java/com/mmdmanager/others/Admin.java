package com.mmdmanager.others;

public class Admin {

    private String user_id;
    private String acc_password;

    public Admin(String user_id, String acc_password) {
        this.user_id = user_id;
        this.acc_password = acc_password;
    }

    public Admin() {}

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAcc_password() {
        return acc_password;
    }

    public void setAcc_password(String acc_password) {
        this.acc_password = acc_password;
    }
}
