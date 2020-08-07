package com.mmdmanager.dao;

import com.mmdmanager.oracle.ClosureProvider;
import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.Logons;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogonsDAO extends ClosureProvider {
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;
    boolean isClosed;
    ClosureProvider closureProvider = new ClosureProvider();

    public List<Logons> allLogons() throws SQLException {
        List<Logons> logons = new ArrayList<>();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("select logon_id, user_id, first_name, last_name, company_short_name, start_session, end_of_session from logons natural join users natural join clients order by 1 desc");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int logon_id = resultSet.getInt(1);
                String user_id = resultSet.getString(2);
                String first_name = resultSet.getString(3);
                String last_name = resultSet.getString(4);
                String company_short_name = resultSet.getString(5);
                Timestamp start_session = resultSet.getTimestamp(6);
                Timestamp end_of_session = resultSet.getTimestamp(7);
                logons.add(new Logons(logon_id,user_id,first_name,last_name,company_short_name,start_session,end_of_session));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            isClosed = closureProvider.areAllConnectionsClosed(preparedStatement,resultSet,connection);
        }
        return logons;
    }
}
