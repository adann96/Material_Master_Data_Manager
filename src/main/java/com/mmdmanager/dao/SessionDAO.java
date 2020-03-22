package com.mmdmanager.dao;

import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.Session;
import com.mmdmanager.others.User;

import java.sql.*;

public class SessionDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;

    public Session getSession(String user_id, Timestamp start_session) throws SQLException {
        Session session = new Session();

        try {
            connection = ConnectionProvider.getConnection();

            preparedStatement = connection.prepareStatement("INSERT INTO LOGONS (USER_ID, START_SESSION) VALUES (?,?)");
            preparedStatement.setString(1, user_id);
            preparedStatement.setTimestamp(2, start_session);
            preparedStatement.executeUpdate();

            session.setUser_id(user_id);
            session.setStart_session(start_session);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        connection.close();
        return session;
    }

    public Session closeSession(Timestamp end_of_session) throws SQLException {
        Session session = new Session();

        try {
            connection = ConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE LOGONS SET END_OF_SESSION = ? WHERE LOGIN_ID = (select MAX(LOGIN_ID) from LOGONS)");
            preparedStatement.setTimestamp(1, end_of_session);
            preparedStatement.executeUpdate();

            session.setEnd_of_session(end_of_session);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        connection.close();
        return session;
    }
}
