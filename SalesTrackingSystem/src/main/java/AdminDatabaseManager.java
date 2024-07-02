

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Serra
 */
public class AdminDatabaseManager {
    
    static final String connectionString = "jdbc:mysql://127.0.0.1:3306/"
            + "sales_tracking_db?user=root&password=123987456Asd";
    
    public static Admin login( Admin admin) {
        try {
            Connection connection = DriverManager.getConnection(connectionString);
            java.sql.Statement stmt = connection.createStatement();
            String sql = "SELECT * admin WHERE email = '" + admin.email + "' AND password = '" + admin.password + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Admin authenticatedAdmin = new Admin (rs.getString("email"), rs.getString("password"));
                authenticatedAdmin.setId(rs.getInt("id")); // add this line to set the id
                connection.close();
                return authenticatedAdmin;
            }
            connection.close();
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
}
