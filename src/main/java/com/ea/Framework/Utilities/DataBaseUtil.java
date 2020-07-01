package com.ea.Framework.Utilities;
/*
 * Database Utility method for DataBase Testing
 */

import java.sql.*;
import java.util.Enumeration;
import java.util.Hashtable;

public class DataBaseUtil {

    public static Connection Open(String connectionString) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            return DriverManager.getConnection(connectionString);
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
        return null;
    }
    public static void Close()
    {

    }
    public static void ExecuteQuery(String query, Connection connection)
    {
        Statement statement = null;
        try
        {
            statement=connection.createStatement();

            ResultSet resultSet  =statement.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();

            resultSet.next();
            int row=resultSet.getRow();
            int columnsNumber = rsmd.getColumnCount();


        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
    }
    //insert reporting through storedprocedure
    public static void ExecuteStoredProc(String procedureName, Hashtable parameters, Connection connection)
    {
        try {

            int paramterLength = parameters.size();
            String paraAppender = null;
            StringBuilder builder = new StringBuilder();
            // Build the paramters list to be passed in the stored proc
            for (int i = 0; i < parameters.size(); i++) {
                builder.append("?,");
            }

            paraAppender = builder.toString();
            paraAppender = paraAppender.substring(0,
                    paraAppender.length() - 1);

            CallableStatement stmt = connection.prepareCall("{Call "
                    + procedureName + "(" + paraAppender + ")}");

            // Creates Enumeration for getting the keys for the parameters
            Enumeration params = parameters.keys();

            // Iterate in all the Elements till there is no keys
            while (params.hasMoreElements()) {
                // Get the Key from the parameters
                String paramsName = (String) params.nextElement();
                // Set Paramters name and Value
                stmt.setString(paramsName, parameters.get(paramsName)
                        .toString());
            }

            // Execute Query
            stmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
