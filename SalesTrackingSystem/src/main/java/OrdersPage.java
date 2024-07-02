
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Serra
 */
public class OrdersPage extends javax.swing.JFrame {

    /**
     * Creates new form OrdersPage
     */
    DefaultTableModel t = new DefaultTableModel();
    public OrdersPage() {
        initComponents();
         t.addColumn("Order id");
        t.addColumn("user id");
        t.addColumn("delivery address");
        tbl_orders.setModel(t);
        updateTable();
    }
    
    public void updateTable() {

        t.setRowCount(0);

        ArrayList<Order> orders = OrderDatabaseManager.getOrders();

        for (Order order : orders) {
            Object[] rowData = {order.getOrderId(), order.getUserId(), order.getAddress()};
            t.addRow(rowData);

        }
    }

    public void findOrdersByEmail(String email) {

        t.setRowCount(0);

        ArrayList<Order> orders = OrderDatabaseManager.getOrdersByEmail(email);

        for (Order order : orders) {
            Object[] rowData = {order.getOrderId(), order.getUserId(), order.getAddress()};
            t.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_orders = new javax.swing.JTable();
        btn_back = new javax.swing.JToggleButton();
        btn_orderDetails = new javax.swing.JToggleButton();
        btn_delete = new javax.swing.JToggleButton();
        btn_refresh = new javax.swing.JToggleButton();
        txt_email = new javax.swing.JTextField();
        btn_customersOrder = new javax.swing.JToggleButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_orders.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_orders);

        btn_back.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_orderDetails.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_orderDetails.setText("Order Details");
        btn_orderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orderDetailsActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_delete.setText("Delete");

        btn_refresh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btn_customersOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_customersOrder.setText("Customor's Order");
        btn_customersOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customersOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_back)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_orderDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_email)
                            .addComponent(btn_customersOrder))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_back)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_orderDetails)
                        .addGap(43, 43, 43)
                        .addComponent(btn_delete)
                        .addGap(27, 27, 27)
                        .addComponent(btn_refresh)
                        .addGap(43, 43, 43)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_customersOrder)))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        AdminPage a = new AdminPage();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_orderDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orderDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_orders.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to see details.");
            return;
        }

        int orderId = (int) tbl_orders.getValueAt(selectedRow, 0);

        Order order = OrderDatabaseManager.getOrderById(orderId);
        List<OrderedItem> orderItems = OrderDatabaseManager.getOrderedItemsByOrderId(order.getOrderId());

        if (orderItems.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No items found for this order.");
            return;
        }

        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Order Details:\n");
        orderDetails.append("Order Id: ").append(order.getOrderId()).append("\n");
        orderDetails.append("User Id: ").append(order.getUserId()).append("\n");
        orderDetails.append("Address: ").append(order.getAddress()).append("\n");
        orderDetails.append("Products:\n");

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderedItem item : orderItems) {
        BigDecimal itemTotal = BigDecimal.valueOf(item.getQuantity())
                            .multiply(item.getPrice());
        orderDetails.append(", Quantity: ").append(item.getQuantity())
                .append(", Total price: ").append(itemTotal)
                .append("\n");
            totalPrice = totalPrice.add(itemTotal);
        }
        orderDetails.append("Total price: ").append(totalPrice);

        JOptionPane.showMessageDialog(this, orderDetails.toString());
    }//GEN-LAST:event_btn_orderDetailsActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        updateTable();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_customersOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customersOrderActionPerformed
        // TODO add your handling code here:
        String email = txt_email.getText();
        findOrdersByEmail(email);
    }//GEN-LAST:event_btn_customersOrderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrdersPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdersPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdersPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdersPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdersPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_back;
    private javax.swing.JToggleButton btn_customersOrder;
    private javax.swing.JToggleButton btn_delete;
    private javax.swing.JToggleButton btn_orderDetails;
    private javax.swing.JToggleButton btn_refresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tbl_orders;
    private javax.swing.JTextField txt_email;
    // End of variables declaration//GEN-END:variables
}
