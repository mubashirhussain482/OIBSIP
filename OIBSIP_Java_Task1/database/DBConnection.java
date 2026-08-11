package OIBSIP_Java_Task1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USERNAME = "YOUR_USERNAME";
    private static final String PASSWORD = "YOUR_PASSWORD";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection con = getConnection();
            System.out.println("Database Connected Successfully!");
            con.close();
        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            System.out.println(e.getMessage());
        }
    }
}
