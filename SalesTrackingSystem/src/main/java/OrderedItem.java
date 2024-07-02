
import java.math.BigDecimal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Serra
 */
public class OrderedItem {
 
    private int id;
    private int orderId;
    private int quantity;
    private BigDecimal price;

    public OrderedItem(int id, int orderId, int quantity, BigDecimal price) {
        this.id = id;
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
    }

   

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }


    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    
    


}
