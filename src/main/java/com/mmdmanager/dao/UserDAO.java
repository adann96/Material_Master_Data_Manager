package com.mmdmanager.dao;

import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;

    public User getUser(String company_id, String user_id, String acc_password) throws SQLException {
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
        } finally {
            preparedStatement.close();
            resultSet.close();
            connection.close();
        }
        return user;
    }

    public boolean addUserToDb(String user_id, String first_name, String middle_name, String last_name, String sex, String company_id, String is_admin) throws SQLException {
        boolean rowAdded = false;
        String acc_password = "VFR45678";

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("Insert into MMDMANAGER.USERS (USER_ID,FIRST_NAME,MIDDLE_NAME,LAST_NAME,SEX,COMPANY_ID,IS_ADMIN,ACC_PASSWORD) values (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,user_id);
            preparedStatement.setString(2,first_name);
            preparedStatement.setString(3,middle_name);
            preparedStatement.setString(4,last_name);
            preparedStatement.setString(5,sex);
            preparedStatement.setString(6,company_id);
            preparedStatement.setString(7,is_admin);
            preparedStatement.setString(8,acc_password);

            rowAdded = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return rowAdded;
    }

    public boolean deleteUserfromDb(String user_id) throws SQLException {
        boolean rowDeleted = false;

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("delete users where user_id=?");
            preparedStatement.setString(1,user_id);

            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return rowDeleted;
    };

    public List<User> allUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("select user_id,first_name, NVL2(middle_name,middle_name,'---'),last_name,sex,company_id,is_admin,acc_password from users");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                String user_id = resultSet.getString(1);
                String first_name = resultSet.getString(2);
                String middle_name = resultSet.getString(3);
                String last_name = resultSet.getString(4);
                String sex = resultSet.getString(5);
                String company_id = resultSet.getString(6);
                String is_admin = resultSet.getString(7);
                String acc_password = resultSet.getString(8);
                users.add(new User(user_id,first_name,middle_name,last_name,sex,company_id,is_admin,acc_password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            resultSet.close();
            connection.close();
        }
        return users;
    }
}
