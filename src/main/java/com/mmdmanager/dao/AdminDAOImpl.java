package com.mmdmanager.dao;

import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO{
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;

    @Override
    public Admin getAdmin(String user_id, String acc_password) {
        Admin admin = new Admin();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT COMPANY_ID, USER_ID, ACC_PASSWORD, IS_ADMIN, FIRST_NAME, LAST_NAME, SEX FROM USERS WHERE USER_ID=? AND ACC_PASSWORD=? AND IS_ADMIN = 'Y'");
            preparedStatement.setString(1, user_id);
            preparedStatement.setString(2, acc_password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                admin.setUser_id(resultSet.getString(2));
                admin.setAcc_password(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return admin;
    }
}
