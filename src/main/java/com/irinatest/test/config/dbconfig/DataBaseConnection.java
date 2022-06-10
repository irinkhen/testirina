package com.irinatest.test.config.dbconfig;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseConnection extends Configs {
    Connection dbConnection;

    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String connection = new StringBuilder()
                .append("jdbc:postgresql://")
                .append(dbHost).append(":")
                .append(dbPort).append("/")
                .append(dbName)
                .toString();
        Class.forName("org.postgresql.Driver");

        dbConnection = DriverManager.getConnection(connection, dbUser, dbPassword);
        return dbConnection;
    }

    public String getSingleValueQuery(String query) {
        String result = "";
        try (ResultSet resultSet = getDBConnection().prepareStatement(query).executeQuery()) {
            if (resultSet.next()) {
                result = resultSet.getString(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public void deleteRow(String query) {
        try (Connection resultSet = getDBConnection()) {
            resultSet.createStatement().executeUpdate(query);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
