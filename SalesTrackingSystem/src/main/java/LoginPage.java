
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Serra
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public LoginPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_email1 = new javax.swing.JLabel();
        lbl_pasword1 = new javax.swing.JLabel();
        txt_email1 = new javax.swing.JTextField();
        txt_pasword1 = new javax.swing.JPasswordField();
        btn_login1 = new javax.swing.JToggleButton();
        tPane_login = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbl_email = new javax.swing.JLabel();
        lbl_pasword = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        btn_goSignUp = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_emailAdmin = new javax.swing.JLabel();
        lbl_paswordAdmin = new javax.swing.JLabel();
        txt_emailAdmin = new javax.swing.JTextField();
        txt_passwordAdmin = new javax.swing.JPasswordField();
        btn_LoginAdmin = new javax.swing.JToggleButton();

        jLabel2.setText("jLabel2");

        lbl_email1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_email1.setText("Email :");

        lbl_pasword1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_pasword1.setText("Pasword :");

        txt_email1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_pasword1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btn_login1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_login1.setText("Login");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbl_email1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_email1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbl_pasword1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_pasword1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(btn_login1)))
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_pasword1)
                            .addComponent(txt_pasword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(btn_login1)
                        .addGap(143, 143, 143))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_email1)
                            .addComponent(txt_email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tPane_login.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tPane_login.setPreferredSize(new java.awt.Dimension(700, 100));

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_email.setText("Email :");
        jPanel1.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 174, 96, -1));

        lbl_pasword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_pasword.setText("Pasword :");
        jPanel1.add(lbl_pasword, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 224, 96, -1));

        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 171, 159, -1));

        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 221, 159, -1));

        btn_login.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel1.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 295, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("If you don't have an account");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 174, -1, -1));

        btn_goSignUp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_goSignUp.setText("Sign Up");
        btn_goSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_goSignUpActionPerformed(evt);
            }
        });
        jPanel1.add(btn_goSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 231, -1, -1));

        tPane_login.addTab("User", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_emailAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_emailAdmin.setText("Email : ");
        jPanel2.add(lbl_emailAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 171, 96, -1));

        lbl_paswordAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_paswordAdmin.setText("Pasword :");
        jPanel2.add(lbl_paswordAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 221, 96, -1));

        txt_emailAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_emailAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailAdminActionPerformed(evt);
            }
        });
        jPanel2.add(txt_emailAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 165, 159, -1));

        txt_passwordAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txt_passwordAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 218, 159, -1));

        btn_LoginAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_LoginAdmin.setText("Login");
        btn_LoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginAdminActionPerformed(evt);
            }
        });
        jPanel2.add(btn_LoginAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 292, -1, -1));

        tPane_login.addTab("Admin", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tPane_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tPane_login, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailAdminActionPerformed
        String email = txt_emailAdmin.getText();
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (email.matches(regex)) {
            JOptionPane.showMessageDialog(null, "valid email format");
        } else {
            JOptionPane.showMessageDialog(null, "invalid email format");
        }
    }//GEN-LAST:event_txt_emailAdminActionPerformed
    
    private void btn_goSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_goSignUpActionPerformed
        // TODO add your handling code here:
        SignUpPage signup = new SignUpPage();
        signup.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_goSignUpActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
       
        String email = txt_email.getText();
        String password = new String (txt_password.getPassword());
        
               User user = new User(email, password);

            User authenticatedUser = UserDatabaseManager.login(user);

            if (authenticatedUser != null) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                ShoppingPage sp = new ShoppingPage(authenticatedUser);
                sp.setVisible(true);
                this.dispose();
                
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed");
            }

            email = "";
            password = "";
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
        String email = txt_email.getText();
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (email.matches(regex)) {
            JOptionPane.showMessageDialog(null, "valid email format");
        } else {
            JOptionPane.showMessageDialog(null, "invalid email format");
        }
    }//GEN-LAST:event_txt_emailActionPerformed

    private void btn_LoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginAdminActionPerformed
        // TODO add your handling code here: bu değişcek UNUTMAAAAAAAAAAAAAA
        String email = txt_emailAdmin.getText();
        String password = new String (txt_passwordAdmin.getPassword());
        User user = new User(email, password);

            User authenticatedUser = UserDatabaseManager.login(user);

            if (authenticatedUser != null) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                AdminPage sp = new AdminPage();
                sp.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed");
            }

            email = "";
            password = "";
    }//GEN-LAST:event_btn_LoginAdminActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_LoginAdmin;
    private javax.swing.JToggleButton btn_goSignUp;
    private javax.swing.JToggleButton btn_login;
    private javax.swing.JToggleButton btn_login1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_email1;
    private javax.swing.JLabel lbl_emailAdmin;
    private javax.swing.JLabel lbl_pasword;
    private javax.swing.JLabel lbl_pasword1;
    private javax.swing.JLabel lbl_paswordAdmin;
    private javax.swing.JTabbedPane tPane_login;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_email1;
    private javax.swing.JTextField txt_emailAdmin;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JPasswordField txt_passwordAdmin;
    private javax.swing.JPasswordField txt_pasword1;
    // End of variables declaration//GEN-END:variables
}
