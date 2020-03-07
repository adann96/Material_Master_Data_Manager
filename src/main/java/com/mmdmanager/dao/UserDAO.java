package com.mmdmanager.dao;

import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;

    public User getUser(String company_id, String user_id, String acc_password) {
        User user = new User();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT COMPANY_ID, USER_ID, ACC_PASSWORD, IS_ADMIN, FIRST_NAME, LAST_NAME, SEX FROM USERS WHERE COMPANY_ID=? AND USER_ID=? AND ACC_PASSWORD=? AND IS_ADMIN = 'N'");
            preparedStatement.setString(1, company_id);
            preparedStatement.setString(2, user_id);
            preparedStatement.setString(3, acc_password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setCompany_id(resultSet.getString(1));
                user.setUser_id(resultSet.getString(2));
                user.setAcc_password(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }
}
