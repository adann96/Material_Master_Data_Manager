package com.mmdmanager.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClosureProvider implements Closure {
    @Override
    public boolean isConnectionClosed(PreparedStatement preparedStatement, Connection connection) throws SQLException {

        try {
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean areAllConnectionsClosed(PreparedStatement preparedStatement, ResultSet resultSet, Connection connection) throws SQLException {

        try {
            preparedStatement.close();
            resultSet.close();
            connection.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
