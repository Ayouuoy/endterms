package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import exceptions.DatabaseOperationException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/Fresh";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Sezimkas2008";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new DatabaseOperationException("DB connection failed", e);
        }
    }
}
