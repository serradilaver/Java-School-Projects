
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Serra
 */
public class ProductDatabaseManager {
    
    static final String connectionString = "jdbc:mysql://127.0.0.1:3306/"
            + "sales_tracking_db?user=root&password=123987456Asd";
     private static Connection conn;

    public ProductDatabaseManager(Connection conn) {
        this.conn = conn;
    }
    
   
    
     public static boolean createProduct(Product product) {
        String sql = "INSERT INTO product (name, price, stock) VALUES (?, ?, ?)";
        boolean isSuccessful = false;

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, product.getName());
            statement.setBigDecimal(2, product.getPrice());
            statement.setInt(3, product.getStock());
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                isSuccessful = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccessful;
    }
     
    public static ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try {
            Connection connection = DriverManager.getConnection(connectionString); 
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id =resultSet.getInt("productId");
                String name = resultSet.getString("name");
                BigDecimal price =resultSet.getBigDecimal("price");
                int stock = resultSet.getInt("stock");

                Product product = new Product(id, name, price, stock);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    
    public static Product getProduct(int productdId) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE productId = ?";

        try {
            Connection connection = DriverManager.getConnection(connectionString); 
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, productdId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("productId");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                int stock = resultSet.getInt("stock");

                product = new Product(id, name, price, stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
    
     public static boolean updateProductStock(int productId, int newStock) {
        String sql = "UPDATE product SET stock = ? WHERE productId = ?";
        boolean isSuccessful = false;

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, newStock);
            statement.setInt(2, productId);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                isSuccessful = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccessful;
    }

    public static boolean updateProductStockbyName(String productName, int additionalStock) {
        String sql = "UPDATE product SET stock = stock + ? WHERE name = ?";
        boolean isSuccessful = false;

        try { 
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, additionalStock);
            statement.setString(2, productName);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                isSuccessful = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccessful;
    }

    public static boolean deleteproduct(int productId) {
        String sql = "DELETE FROM product WHERE productId = ?";

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, productId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getProductStock(int productId) {
        int stock = 0;
        String sql = "SELECT stock FROM product WHERE productId = ?";

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                stock = resultSet.getInt("stock");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stock;
    }

    public static int getProductIdByName(String productName) {
        int productId = 0;

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            
            String query = "SELECT productId FROM product WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, productName);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
               productId = rs.getInt("productId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productId;
    }

    public static boolean increaseProductStock(int productId, int stockIncrement) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Connection connection = DriverManager.getConnection(connectionString);

            String selectQuery = "SELECT stock FROM product WHERE productId = ?";

            preparedStatement = connection.prepareStatement(selectQuery);

            preparedStatement.setInt(1, productId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int currentStock = resultSet.getInt("stock");
                int newStock = currentStock + stockIncrement;

                return updateProductStock(productId, newStock);
            } else {
                return false;
            }

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean decreaseProductStock(int productId, int stockDecrement) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Connection connection = DriverManager.getConnection(connectionString);

            String selectQuery = "SELECT stock FROM product WHERE productId = ?";

            preparedStatement = connection.prepareStatement(selectQuery);

            preparedStatement.setInt(1, productId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int currentStock = resultSet.getInt("stock");
                int newStock = currentStock - stockDecrement;

                return updateProductStock(productId, newStock);
            } else {
                return false;
            }

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean updateProductPrice(int productId, BigDecimal newPrice) {
        String sql = "UPDATE product SET price = ? WHERE productId = ?";
        boolean isSuccessful = false;

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setBigDecimal(1, newPrice);
            statement.setInt(2, productId);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                isSuccessful = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccessful;
    }
     
     public static int getStock(int productId) {
        int stock = 0;
        String query = "SELECT stock FROM product WHERE productId = ?";

        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                stock = resultSet.getInt("stock");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stock;
    }
     
}
