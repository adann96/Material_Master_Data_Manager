package com.mmdmanager.oracle;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements Provider {
    static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(connectionUrl,databaseRoot,password);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
