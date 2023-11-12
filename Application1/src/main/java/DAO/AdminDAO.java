package DAO;


import config.PostgreSQLJDBCConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    // Method to check if the given username and password match the records in the Admin table
    public static boolean login(String username, String password) {
        Connection connection = PostgreSQLJDBCConfig.connect();

        try {
            // SQL query to check if the provided username and password match
            String query = "SELECT * FROM Admin WHERE Username = ? AND Password = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // If there is a matching record, return true; otherwise, return false
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Close the connection in the finally block to ensure it's always closed
            PostgreSQLJDBCConfig.close();
        }
    }
}

