package com.mmdmanager.dao;

import com.mmdmanager.oracle.ClosureProvider;
import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.Client;
import com.mmdmanager.others.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends ClosureProvider {
    static Connection connection;
    static PreparedStatement preparedStatement;
    static CallableStatement callableStatement;
    ResultSet resultSet;
    boolean isClosed;
    ClosureProvider closureProvider = new ClosureProvider();

    public List<Client> allClients() throws SQLException {
        List<Client> clients = new ArrayList<>();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("SELECT COMPANY_ID, COMPANY_NAME, COMPANY_SHORT_NAME, COMPANY_COUNTRY FROM CLIENTS WHERE IS_ACTIVE = 'Y' ORDER BY 1 ASC");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                byte company_id = resultSet.getByte(1);
                String company_name = resultSet.getString(2);
                String company_short_name = resultSet.getString(3);
                String company_country = resultSet.getString(4);

                clients.add(new Client(company_id,company_name,company_short_name,company_country));
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            isClosed = closureProvider.areAllConnectionsClosed(preparedStatement,resultSet,connection);
        }
        return clients;
    }

    public boolean addClientToDb(String company_name, String company_short_name, String company_country) throws SQLException {
        boolean rowAdded = false;

        try {
            connection = ConnectionProvider.getConnection();
            callableStatement = connection.prepareCall("{call insertClientIntoDb(?,?,?)}");
            callableStatement.setString(1,company_name);
            callableStatement.setString(2,company_short_name);
            callableStatement.setString(3,company_country);
            rowAdded = callableStatement.executeUpdate() > 0;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            isClosed = closureProvider.isConnectionClosed(preparedStatement,connection);
        }
        return rowAdded;
    }

    public boolean deleteClientFromDb(byte client_id) throws SQLException {
        boolean rowDeleted = false;

        try {
            connection = ConnectionProvider.getConnection();
            callableStatement = connection.prepareCall("{call deleteClientFromDb(?)}");
            callableStatement.setByte(1,client_id);

            rowDeleted = callableStatement.executeUpdate() > 0;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            isClosed = closureProvider.isConnectionClosed(preparedStatement,connection);
        }
        return rowDeleted;
    }
}
