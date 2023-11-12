package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfig {

    // JDBC database URL for Oracle
    private static final String JDBC_URL = "jdbc:oracle:thin:@your_oracle_host:your_oracle_port:your_oracle_sid";
    private static final String JDBC_USERNAME = "your_oracle_username";
    private static final String JDBC_PASSWORD = "your_oracle_password";

    // JDBC driver name for Oracle
    private static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";

    // Create a database connection
    public static Connection getConnection() {
        try {
            // Register the JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
            throw new RuntimeException("Failed to establish a database connection.");
        }
    }

    // Close the database connection
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
