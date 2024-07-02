
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Serra
 */
public class OrderDatabaseManager {
    
    static final String connectionString = "jdbc:mysql://127.0.0.1:3306/"
            + "sales_tracking_db?user=root&password=123987456Asd";
     public static Connection conn;

    public static Order getOrderById(int orderId) {
        Order order = null;
        try {
            conn = DriverManager.getConnection(connectionString);
            String sql = "SELECT * FROM orders WHERE idorder = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                order = new Order(rs.getInt("idorder"), rs.getInt("id"), rs.getString("address"));
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public static List<OrderedItem> getOrderItems(int userId) {
        List<OrderedItem> orderedItems = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(connectionString);
            String sql = "SELECT * FROM shopping_cart WHERE userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                double priceDouble = rs.getDouble("price");
                BigDecimal price = BigDecimal.valueOf(priceDouble);
                OrderedItem item = new OrderedItem(rs.getInt("id"), rs.getInt("idorder"), rs.getInt("quantity"), price);
                orderedItems.add(item);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderedItems;
    }

    public static String getProductName(int productId) {
        String productName = "";
        try {
            conn = DriverManager.getConnection(connectionString);
            String sql = "SELECT * FROM product WHERE productId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                productName = rs.getString("productName");
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productName;
    }

   public static BigDecimal getProductPrice(int productId) {
    BigDecimal price = BigDecimal.ZERO;
    try {
        conn = DriverManager.getConnection(connectionString);
        String sql = "SELECT price FROM product WHERE productId = ?"; 
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, productId);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            price = rs.getBigDecimal("price"); 
        }
        rs.close();
        pstmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return price;
}

    public static boolean saveOrderedItem(OrderedItem orderedItem) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean isSuccessful = false;
        try {

            conn = DriverManager.getConnection(connectionString);

            String query = "INSERT INTO ordered_item (id, orderId, produtId, quantity, price) VALUES (?,?, ?, ?, ?)";
            pst = conn.prepareStatement(query);

            pst.setInt(1, orderedItem.getId());
            pst.setInt(2, orderedItem.getOrderId());
            pst.setInt(3, orderedItem.getId());
            pst.setInt(4, orderedItem.getQuantity());
            pst.setBigDecimal(5, orderedItem.getPrice());

            int result = pst.executeUpdate();

            isSuccessful = result > 0;

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
        return isSuccessful;
    }

    public static List<OrderedItem> getOrderedItemsByOrderId(int orderId) {
        List<OrderedItem> orderItems = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(connectionString);

            String sql = "SELECT * FROM ordered_item WHERE orderId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderId);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                int itemId = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                BigDecimal price = rs.getBigDecimal("price");

                OrderedItem item = new OrderedItem(itemId, orderId, quantity, price);
                orderItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderItems;
    }

    public static boolean saveOrderAddress(String Email, String deliveryAddress) {
        boolean isSuccessful = false;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(connectionString);
            String query = "INSERT INTO orders (id, address) VALUES (?, ?)";
            pst = conn.prepareStatement(query);

            int userId = UserDatabaseManager.getUserIdByEmail(Email);
            if (userId == 0) {
                System.out.println("The user with username " + Email + " does not exist.");
                return false;
            }
            pst.setInt(1, userId);
            pst.setString(2, deliveryAddress);

            int result = pst.executeUpdate();

            if (result > 0) {
                System.out.println("Address saved successfully");
                isSuccessful = true;
            } else {
                System.out.println("An error occurred");
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
        return isSuccessful;
    }

    public static ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("idorder");
                int userId = resultSet.getInt("userId");
                String deliveryAddress = resultSet.getString("address");

                Order order = new Order(orderId, userId, deliveryAddress);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
    
   

    public static boolean saveOrder(Order order) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String query = "INSERT INTO orders (userId, address) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setInt(1, order.getUserId());
            statement.setString(2, order.getAddress());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteOrderById(int orderId) {
        String sql = "DELETE FROM orders WHERE idorders = ?";
        boolean isSuccessful = false;

        try ( Connection connection = DriverManager.getConnection(connectionString);  PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, orderId);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                isSuccessful = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccessful;
    }

    public static ArrayList<Order> getOrdersByEmail(String email) {
        ArrayList<Order> orders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(connectionString);

            int userId = UserDatabaseManager.getUserIdByEmail(email);
            if (userId == 0) {
                JOptionPane.showMessageDialog(null, "The user with email " + email + " does not exist.");
                return orders;
            }

            String query = "SELECT * FROM orders WHERE id = ?";
            pst = conn.prepareStatement(query);

            pst.setInt(1, userId);

            rs = pst.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("idorders");
                String deliveryAddress = rs.getString("deliveryadress");

                Order order = new Order(orderId, userId, deliveryAddress);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return orders;
    }

    public static boolean checkOrdersByEmail(String email) {
        boolean hasOrders = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(connectionString);

            int userId = UserDatabaseManager.getUserIdByEmail(email);
            if (userId == 0) {
                JOptionPane.showMessageDialog(null, "The user with email " + email + " does not exist.");
                return hasOrders;
            }

            String query = "SELECT * FROM orders WHERE id = ?";
            pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, userId);

            rs = pstmt.executeQuery();

            hasOrders = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return hasOrders;
    }

    public static void deleteOrdersByEmail(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(connectionString);

            int userId = UserDatabaseManager.getUserIdByEmail(email);
            if (userId == 0) {
                JOptionPane.showMessageDialog(null, "The user with email " + email + " does not exist.");
                return;
            }

            String query = "DELETE FROM orders WHERE id = ?";
            pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, userId);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Orders deleted successfully for the user with email: " + email);
            } else {
                System.out.println("No orders found for the user with email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
}
