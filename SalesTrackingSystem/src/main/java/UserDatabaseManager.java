
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Serra
 */
public class UserDatabaseManager {
    
    static final String connectionString = "jdbc:mysql://127.0.0.1:3306/"
            + "sales_tracking_db?user=root&password=123987456Asd";

    static Connection conn = null;
    
    public static User login(User user) {
        try {
            conn = DriverManager.getConnection(connectionString);
            java.sql.Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM user WHERE email = '" + user.email + "' AND password = '" + user.password + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                User authenticatedUser = new User(rs.getString("name"), rs.getString("surname"),rs.getString("email"), rs.getString("phoneNumber"), rs.getString("password"), rs.getString("gender"));
                authenticatedUser.setId(rs.getInt("id")); // add this line to set the id
                conn.close();
                return authenticatedUser;
            }
            conn.close();
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static boolean InsertNewUser(User user) {
       
        try {
            conn = DriverManager.getConnection(connectionString);

            Statement stmt = conn.createStatement();
            String query = "INSERT INTO user "
                    + "(name, surname, email, phoneNumber, password, gender)"
                    + "VALUES('" + user.name +"','" + user.surname +"','" + user.email
                    + "','" + user.phoneNumber + "','" + user.password 
                    + "','" + user.gender + "')" ;
            stmt.executeUpdate(query);

            conn.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
    public static void main(String[] args) {
        getUsers();
    }
     public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                String password = resultSet.getString("password");
                String gender = resultSet.getString("gender");
               

                User user = new User(name,surname, email, phoneNumber, password, gender);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
     
    /*public static void main(String[] args) {
        BigDecimal pr = new BigDecimal(12.12);
        addToShoppingCart(1, 1, 1, "e", pr);
    }*/
    
    
     
    public static boolean addToShoppingCart (int userId, int productId, int quantity, String name, BigDecimal price) {
        boolean isSuccessful = false;
        try{
            Connection connection = DriverManager.getConnection(connectionString);
            
            String userCheckQuery = "SELECT * FROM user WHERE id = ?";
            PreparedStatement userCheckStatement = connection.prepareStatement(userCheckQuery);
            userCheckStatement.setInt(1, userId);
            ResultSet userRs = userCheckStatement.executeQuery();
            if (userRs.next()) {
                String checkQuery = "SELECT * FROM shopping_cart WHERE userId = ? AND productId = ?";
                PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
                checkStatement.setInt(1, userId);
                checkStatement.setInt(2, productId);
                ResultSet rs = checkStatement.executeQuery();
                if (rs.next()) {
                    int oldQuantity = rs.getInt("quantity");
                    String updateQuery = "UPDATE shopping_cart SET quantity = ? WHERE userId = ? AND productId = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    updateStatement.setInt(1, oldQuantity - quantity);
                    updateStatement.setInt(2, userId);
                    updateStatement.setInt(3, productId);
                    int affectedRows = updateStatement.executeUpdate();
                    if (affectedRows > 0) {
                        isSuccessful = true;
                    }
                } else {
                    String insertQuery = "INSERT INTO shopping_cart (userId, productId, name, price, quantity) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                    insertStatement.setInt(1, userId);
                    insertStatement.setInt(2, productId);
                    insertStatement.setString(3, name);
                    insertStatement.setBigDecimal(4, price);
                    insertStatement.setInt(5, quantity);
                    
                    int affectedRows = insertStatement.executeUpdate();
                    if (affectedRows > 0) {
                        isSuccessful = true;
                    }
                }
            } else {
                System.out.println("The user with id " + userId + " does not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccessful;
    }
    
    public static boolean removeFromShoppingCart (int userId, int productId, int quantity) {
        boolean isSuccessful = false;
        try ( Connection connection = DriverManager.getConnection(connectionString)) {
            String userCheckQuery = "SELECT * FROM user WHERE id = ?";
            PreparedStatement userCheckStatement = connection.prepareStatement(userCheckQuery);
            userCheckStatement.setInt(1, userId);
            ResultSet userRs = userCheckStatement.executeQuery();

            if (userRs.next()) {
                String checkQuery = "SELECT * FROM shopping_cart WHERE userId = ? AND productId = ?";
                PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
                checkStatement.setInt(1, userId);
                checkStatement.setInt(2, productId);
                ResultSet rs = checkStatement.executeQuery();

                if (rs.next()) {
                    int oldQuantity = rs.getInt("quantity");

                    if (quantity >= oldQuantity) {
                        String deleteQuery = "DELETE FROM shopping_cart WHERE UserId = ? AND productId = ?";
                        PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                        deleteStatement.setInt(1, userId);
                        deleteStatement.setInt(2, productId);
                        int affectedRows = deleteStatement.executeUpdate();
                        if (affectedRows > 0) {
                            isSuccessful = true;
                        }
                    } else {
                        String updateQuery = "UPDATE shopping_cart SET quantity = ? WHERE UserId = ? AND productId = ?";
                        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                        updateStatement.setInt(1, oldQuantity - quantity);
                        updateStatement.setInt(2, userId);
                        updateStatement.setInt(3, productId);
                        int affectedRows = updateStatement.executeUpdate();
                        
                        if (affectedRows > 0) {
                            isSuccessful = true;
                        }
                    }
                } else {
                    System.out.println("The product with id " + productId + " is not in the shopping cart of user with id " + userId);
                }
            } else {
                System.out.println("The user with id " + userId + " does not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccessful;
    }

    public static int getUserIdByEmail(String email) {
        int userId = 0;

        try ( Connection connection = DriverManager.getConnection(connectionString)) {
            String query = "SELECT id FROM user WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                userId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userId;
    }

   

    public static boolean deleteUser(String email) {
        boolean isDeleted = false;
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = DriverManager.getConnection(connectionString);
            String query = "DELETE FROM user WHERE email = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, email);

            int result = pst.executeUpdate();
            if (result > 0) {
                isDeleted = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return isDeleted;
    }

    public static User getUserByEmail(String email) {
        User user = null;
        String sql = "SELECT * FROM user WHERE email = ?";

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
               
                String password = resultSet.getString("password");

                user = new User(email, password);
                user.setId(resultSet.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    public static boolean isProductInShoppingCart(int userId, int productId){
        boolean productInShoppingCart = false;
        
        try {
            conn = DriverManager.getConnection(connectionString);
            java.sql.Statement stmt = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM shopping_cart WHERE userId = ? AND productId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, productId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                productInShoppingCart = count > 0;
            }
            
        } catch (Exception e) {
        }
    
        return productInShoppingCart;
    }

   public static int getProductQuantityInShoppingCart(int userId, int productId) {
        int quantity = 0;

        try {
            Connection conn = DriverManager.getConnection(connectionString);
            String query = "SELECT quantity FROM shopping_cart WHERE userId = ? AND productId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, productId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                quantity = resultSet.getInt("quantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quantity;
    }
    
   public static boolean updateShoppingCartItemQuantity(int userId, int productId, int newQuantity) {
        boolean updateResult = false;

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            String query = "UPDATE shopping_cart SET quantity = ? WHERE userId = ? AND productId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, newQuantity);
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(3, productId);

            int affectedRows = preparedStatement.executeUpdate();
            
            updateResult = affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateResult;
    }
}

   