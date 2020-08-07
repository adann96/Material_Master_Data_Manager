package com.mmdmanager.dao;

import com.mmdmanager.oracle.ClosureProvider;
import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.Session;
import java.sql.CallableStatement;

import java.sql.*;

public class SessionDAO extends ClosureProvider {
    static Connection connection;
    static PreparedStatement preparedStatement;
    static CallableStatement callableStatement;
    boolean isClosed;
    ClosureProvider closureProvider = new ClosureProvider();

    public Session startSession(String user_id) throws SQLException {
        Session session = new Session();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO LOGONS (USER_ID) VALUES (?)");
            preparedStatement.setString(1, user_id);
            preparedStatement.execute();
            session.setUser_id(user_id);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            isClosed = closureProvider.isConnectionClosed(preparedStatement,connection);
        }
        return session;
    }

    public String closeSession() throws SQLException {
        try {
            connection = ConnectionProvider.getConnection();
            callableStatement = connection.prepareCall("{call close_session}");
            callableStatement.execute();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            isClosed = closureProvider.isConnectionClosed(callableStatement,connection);
        }
        return "Session closed successfully!";
    }
}
