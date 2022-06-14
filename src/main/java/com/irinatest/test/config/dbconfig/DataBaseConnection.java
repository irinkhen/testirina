package com.irinatest.test.config.dbconfig;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection extends Configs {
    Connection dbConnection;

    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String connection = new StringBuilder()
                .append("jdbc:postgresql://")
                .append(dbHost).append(":")
                .append(dbPort).append("/")
                .append(dbName)
                .toString();

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
            closeConnection();
        }
        return result;
    }

    public void deleteRow(String query) {
        try (Statement resultSet = getDBConnection().createStatement()) {
            resultSet.executeUpdate(query);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    public void closeConnection() {
        try {
            dbConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
