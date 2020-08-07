package com.mmdmanager.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Closure {
    boolean isConnectionClosed(PreparedStatement preparedStatement,Connection connection) throws SQLException;
    boolean areAllConnectionsClosed(PreparedStatement preparedStatement, ResultSet resultSet,Connection connection) throws SQLException;
}
