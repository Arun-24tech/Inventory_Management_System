package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * JDBC connection utility class for MySQL database.
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/inventory_db";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password"; // CHANGE THIS

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
