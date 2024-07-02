/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Dilaver_Kilic_DesktopSearchEngine;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author merye
 */
public class Dilaver_Kilic_MainFrame extends javax.swing.JFrame {

    Dilaver_Kilic_MainPanel mainPanel;
    static CardLayout cardLayout;
    static JPanel panelCont;

    public Dilaver_Kilic_MainFrame() {
        initComponents();
        cardLayout = new CardLayout();
        panelCont = new JPanel(cardLayout);
        panelCont.setSize(745, 470);
        this.setSize(745, 470);
        getContentPane().add(panelCont);


        mainPanel = new Dilaver_Kilic_MainPanel();
        mainPanel.setName("mainPanel");
        panelCont.add(mainPanel, "mainPanel");
        cardLayout.show(panelCont, "mainPanel");

    }

    public static void setPage(String panelName) {
        cardLayout.show(panelCont, panelName);
        for (Component component : panelCont.getComponents()) {
            if (component.getName().equals(panelName) && component instanceof Dilaver_Kilic_IPanel) {
                Dilaver_Kilic_IPanel iPanel = (Dilaver_Kilic_IPanel) component;
                iPanel.onPageSet();

            }
           
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Dilaver_Kilic_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dilaver_Kilic_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dilaver_Kilic_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dilaver_Kilic_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dilaver_Kilic_MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
