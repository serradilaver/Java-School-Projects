
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Serra
 */
public class ShoppingCartDatabaseManager {
    
    static final String connectionString = "jdbc:mysql://127.0.0.1:3306/"
            + "sales_tracking_db?user=root&password=123987456Asd";
    public static Connection conn;

    private ProductDatabaseManager productDBManager = new ProductDatabaseManager(conn);

    public void updateShoppingCart(ShoppingCart shoppingCart) {
        String sql = "UPDATE shopping_cart SET total = ? WHERE id = ?";

        try ( PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setBigDecimal(1, shoppingCart.getTotal());
            statement.setInt(2, shoppingCart.getUserId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    
        public static List<ShoppingCartItem> getUserShoppingCart(int userId) {
        List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();
        String query = "SELECT productId, name, price, quantity FROM shopping_cart WHERE userId = ?";

        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("productId");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                int quantity = resultSet.getInt("quantity");
                int stock = ProductDatabaseManager.getProductStock(productId);

                Product product = new Product(productId, name, price, stock);
                ShoppingCartItem shoppingCartItem = new ShoppingCartItem(product, quantity);
                shoppingCartItems.add(shoppingCartItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shoppingCartItems;
    }

         public static boolean clearShoppingCart(int userId) {
        boolean isSuccessful = false;
        String sql = "DELETE FROM shopping_cart WHERE userId = ?";

        try { 
            Connection connection = DriverManager.getConnection(connectionString);  
            PreparedStatement statement = connection.prepareStatement(sql);
              

            statement.setInt(1, userId);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                isSuccessful = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccessful;
    }
    

    
}
