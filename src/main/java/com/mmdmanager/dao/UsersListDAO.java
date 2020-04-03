package com.mmdmanager.dao;

import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.Logons;
import com.mmdmanager.others.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersListDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;

    public List<User> userList() {
        List<User> userList = new ArrayList<>();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("select * from users;");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                String user_id = resultSet.getString(1);
                String first_name = resultSet.getString(2);
                String middle_name = resultSet.getString(3);
                String last_name = resultSet.getString(4);
                String sex = resultSet.getString(5);
                String is_admin = resultSet.getString(6);
                String company_id = resultSet.getString(7);
                String acc_password = resultSet.getString(8);

                userList.add(new User(user_id,first_name,middle_name,last_name,sex,is_admin,company_id,acc_password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
}