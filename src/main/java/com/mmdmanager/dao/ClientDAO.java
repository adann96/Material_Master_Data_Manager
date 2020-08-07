package com.mmdmanager.dao;

import com.mmdmanager.oracle.ClosureProvider;
import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.Client;
import com.mmdmanager.others.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends ClosureProvider {
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;
    boolean isClosed;
    ClosureProvider closureProvider = new ClosureProvider();

    public List<Client> allClients() throws SQLException {
        List<Client> clients = new ArrayList<>();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("select company_id, company_name, company_short_name, company_country from clients order by 1 asc");
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
            preparedStatement = connection.prepareStatement("insert into MMDMANAGER.CLIENTS (company_name, company_short_name, company_country) values ('" + company_name + "','" + company_short_name + "','" + company_country + "')");

            rowAdded = preparedStatement.executeUpdate() > 0;
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
            preparedStatement = connection.prepareStatement("delete clients where company_id=?");
            preparedStatement.setByte(1,client_id);

            rowDeleted = preparedStatement.executeUpdate() > 0;
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
