package com.mmdmanager.dao;

import com.mmdmanager.others.Admin;

public interface AdminDAO {
    public Admin getAdmin(String user_id, String acc_password);
}
