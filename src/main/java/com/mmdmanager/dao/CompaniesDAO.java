package com.mmdmanager.dao;

import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.Companies;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompaniesDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public CompaniesDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mmdmanager","NHY67ujm");
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public List<Companies> listAllCompanies() throws SQLException {
        List<Companies> listAllCompanies = new ArrayList<>();

        String sql = "SELECT * FROM CLIENTS";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int company_id = resultSet.getInt(1);
            String company_name = resultSet.getString(2);
            String company_name_short = resultSet.getString(3);
            String company_country = resultSet.getString(4);

            Companies book = new Companies(company_id, company_name, company_name_short, company_country);
            listAllCompanies.add(book);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listAllCompanies;
    }

    public Companies getBook(int id) throws SQLException {
        Companies companies = null;
        String sql = "SELECT * FROM CLIENTS WHERE COMPANY_ID = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int company_id = resultSet.getInt(1);
            String company_name = resultSet.getString(2);
            String company_name_short = resultSet.getString(3);
            String company_country = resultSet.getString(4);

            companies = new Companies(company_id, company_name, company_name_short, company_country);
        }

        resultSet.close();
        statement.close();

        return companies;
    }
}
