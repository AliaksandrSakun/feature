package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    public java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");

            if (connection != null) {
                System.out.println("Connection OK");
            } else {
                System.out.println("Connection FAILED");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
