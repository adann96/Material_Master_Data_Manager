package com.mmdmanager.dao;

import com.mmdmanager.oracle.ClosureProvider;
import com.mmdmanager.oracle.ConnectionProvider;
import com.mmdmanager.others.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MaterialDAO extends ClosureProvider {
    static Connection connection;
    static CallableStatement callableStatement;
    byte counter = 0;
    boolean isClosed;
    ClosureProvider closureProvider = new ClosureProvider();

    public ArrayList<Material> getMaterialList(ArrayList<Material> materialList) throws SQLException {

        try {
            connection = ConnectionProvider.getConnection();
            while(connection.isClosed()) {
                callableStatement = connection.prepareCall("{call insertMaterialIntoDb(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

                connection.setAutoCommit(false);
                Iterator<Material> iterator = materialList.iterator();

                String[][] array = new String[materialList.size()][37];
                while (iterator.hasNext()) {
                    array[counter] = String.valueOf(iterator.next()).split(",");

                    //Set Strings
                    callableStatement.setString(1, array[counter][6]);
                    callableStatement.setString(2, array[counter][5]);
                    callableStatement.setString(3, array[counter][3]);
                    callableStatement.setString(6, array[counter][1]);
                    callableStatement.setString(7, array[counter][2]);
                    callableStatement.setString(8, array[counter][7]);
                    callableStatement.setString(9, array[counter][10]);
                    callableStatement.setString(10, array[counter][9]);
                    callableStatement.setString(32, array[counter][34]);
                    callableStatement.setString(34, array[counter][33]);
                    callableStatement.setString(35, array[counter][36]);
                    callableStatement.setString(36, array[counter][35]);
                    callableStatement.setString(37, array[counter][37]);
                    callableStatement.setString(38, array[counter][38]);
                    
                    //Set Timestamp
                    callableStatement.setTimestamp(4, Timestamp.valueOf(array[counter][4]));
                    
                    //Set Integer
                    callableStatement.setInt(5,Integer.parseInt(array[counter][0]));

                    //Set Doubles
                    callableStatement.setDouble(11, Double.parseDouble(array[counter][11]));
                    callableStatement.setDouble(12, Double.parseDouble(array[counter][12]));
                    callableStatement.setDouble(13, Double.parseDouble(array[counter][13]));
                    callableStatement.setDouble(14, Double.parseDouble(array[counter][14]));
                    callableStatement.setDouble(15, Double.parseDouble(array[counter][15]));
                    callableStatement.setDouble(16, Double.parseDouble(array[counter][16]));
                    callableStatement.setDouble(24, Double.parseDouble(array[counter][25]));
                    callableStatement.setDouble(25, Double.parseDouble(array[counter][26]));
                    
                    //Set Bytes
                    callableStatement.setByte(17, Byte.parseByte(array[counter][17]));
                    callableStatement.setByte(18, Byte.parseByte(array[counter][18]));
                    callableStatement.setByte(19, Byte.parseByte(array[counter][19]));
                    callableStatement.setByte(20, Byte.parseByte(array[counter][20]));
                    callableStatement.setByte(21, Byte.parseByte(array[counter][21]));
                    callableStatement.setByte(22, Byte.parseByte(array[counter][22]));
                    callableStatement.setByte(23, Byte.parseByte(array[counter][23]));
                    callableStatement.setByte(26, Byte.parseByte(array[counter][24]));
                    callableStatement.setByte(27, Byte.parseByte(array[counter][27]));
                    callableStatement.setByte(28, Byte.parseByte(array[counter][28]));
                    callableStatement.setByte(29, Byte.parseByte(array[counter][29]));
                    callableStatement.setByte(30, Byte.parseByte(array[counter][30]));
                    callableStatement.setByte(31, Byte.parseByte(array[counter][31]));
                    callableStatement.setByte(33, Byte.parseByte(array[counter][32]));

                    callableStatement.addBatch();
                    counter++;
                }

                callableStatement.executeBatch();
                connection.commit();
                connection.setAutoCommit(true);
                connection.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getSQLState());
        }
        finally {
            isClosed = closureProvider.isConnectionClosed(callableStatement,connection);
        }
        return materialList;
    }
}
