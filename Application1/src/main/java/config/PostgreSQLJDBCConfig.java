package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLJDBCConfig {

    // JDBC URL, username, and password of PostgreSQL server
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/SOACC_APP1";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "mossab2001";

    // JDBC variables for opening, closing, and managing the connection
    private static Connection connection;

    // Method to establish a connection
    public static Connection connect() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.postgresql.Driver"); // Load the PostgreSQL JDBC driver
                connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle errors here
        }
        return connection;
    }

    // Method to close the connection
    public static void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle errors here
        }
    }

   /* public static void main(String[] args) {
        // Example usage:
        Connection conn = PostgreSQLJDBCConfig.connect();
        // Perform database operations here using the 'conn' connection object
        PostgreSQLJDBCConfig.close();
    }
    */
 // Method to test the connection
    public static void testConnection() {
        Connection conn = connect();
        if (conn != null) {
            System.out.println("Connection to the database is successful!");
            close(); // Close the connection
        } else {
            System.out.println("Failed to make a connection!");
        }
    }

    public static void main(String[] args) {
        // Example usage:
        testConnection();
    }
}

