
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Serra
 */
public class Order {
    
    private int orderId;
    private int userId;
    private String address;

    public List<OrderedItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderedItem> orderItems) {
        this.orderItems = orderItems;
    }
   private List<OrderedItem> orderItems;

    public Order(int orderId, int userId, String address) {
        this.orderId = orderId;
        this.userId = userId;
        this.address = address;

    }

    public Order(String userName, String email, String deliveryAddress) {

    }

    public Order(int userId, String address) {
        this.userId = userId;
        this.address = address;
    }

    // Getter ve setter metodları
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int id) {
        this.orderId = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
