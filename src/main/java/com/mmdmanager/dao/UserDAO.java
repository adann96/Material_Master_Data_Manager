package com.mmdmanager.dao;

import com.mmdmanager.others.User;

public interface UserDAO {
    public User getUser(String company_id, String user_id, String acc_password);
}
