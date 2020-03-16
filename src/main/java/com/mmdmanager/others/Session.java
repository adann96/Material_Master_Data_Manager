package com.mmdmanager.others;

import java.sql.Timestamp;

public class Session {
    private long logon_id;
    private String user_id;
    private Timestamp start_session;
    private Timestamp end_of_session;

    public long getLogon_id() {
        return logon_id;
    }

    public void setLogon_id(long logon_id) {
        this.logon_id = logon_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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
