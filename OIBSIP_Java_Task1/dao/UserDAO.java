package OIBSIP_Java_Task1.dao;
import OIBSIP_Java_Task1.database.DBConnection;
import OIBSIP_Java_Task1.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDAO {
    public boolean login(User user) {
        String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            
            ResultSet rs = ps.executeQuery();
            boolean result = rs.next();

            rs.close();
            ps.close();
            con.close();
            
            return result;
        } catch (SQLException e) {
            System.out.println("Login Error: " + e.getMessage());
            return false;
        }
    }
}
