package com.mmdmanager.dao;

import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.Companies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompaniesDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;

    public  CompaniesDAO() {}

    public List<Companies> allCompanies() {
        List<Companies> companies = new ArrayList<>();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM CLIENTS");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int company_id = resultSet.getInt(1);
                String company_name = resultSet.getString(2);
                String company_short_name = resultSet.getString(3);
                String company_country = resultSet.getString(4);
                companies.add(new Companies(company_id,company_name,company_short_name,company_country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return companies;
    }
}
