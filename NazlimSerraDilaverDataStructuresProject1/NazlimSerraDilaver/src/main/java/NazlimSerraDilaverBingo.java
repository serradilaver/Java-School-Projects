
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author serra
 */
public class NazlimSerraDilaverBingo extends javax.swing.JFrame {

    /**
     * Creates new form NazlimSerraDilaverBingo
     */
    private Timer timer;
    NazlimSerraDilaverTombolaUtils a = new NazlimSerraDilaverTombolaUtils();
    NazlimSerraDilaverLinkedList<Integer> drawnNumbers = new NazlimSerraDilaverLinkedList();
    int[][] card1Data = a.createFilledCard();
    int[][] card2Data = a.createFilledCard();
    int[] randomNumbers;
    int[] card1BingoCounts = new int[3];
    int[] card2BingoCounts = new int[3];
    private boolean[] card1BingoLogged = new boolean[3];
    private boolean[] card2BingoLogged = new boolean[3];

    public NazlimSerraDilaverBingo() {

        initComponents();

        fillCardPanelWithNumbers(tombala1, card1Data);
        fillCardPanelWithNumbers(tombala2, card2Data);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tombala2 = new javax.swing.JPanel();
        tombala1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btn_start = new javax.swing.JButton();
        btn_restart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 204));
        setForeground(new java.awt.Color(0, 153, 204));
        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        tombala2.setBackground(new java.awt.Color(51, 204, 255));
        tombala2.setMaximumSize(new java.awt.Dimension(360, 160));
        tombala2.setMinimumSize(new java.awt.Dimension(360, 160));
        tombala2.setPreferredSize(new java.awt.Dimension(360, 160));
        tombala2.setLayout(new java.awt.GridLayout(3, 10));

        tombala1.setBackground(new java.awt.Color(51, 204, 255));
        tombala1.setMaximumSize(new java.awt.Dimension(360, 160));
        tombala1.setMinimumSize(new java.awt.Dimension(360, 160));
        tombala1.setPreferredSize(new java.awt.Dimension(360, 160));
        tombala1.setLayout(new java.awt.GridLayout(3, 10));

        jList1.setBackground(new java.awt.Color(204, 255, 255));
        jList1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        btn_start.setBackground(new java.awt.Color(0, 153, 255));
        btn_start.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_start.setText("Start");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });

        btn_restart.setBackground(new java.awt.Color(0, 153, 255));
        btn_restart.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_restart.setText("Restart");
        btn_restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_start, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_restart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tombala1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombala2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tombala1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(tombala2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_start, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_restart, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 91, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restartActionPerformed
        // TODO add your handling code here:
        restartGame();
    }//GEN-LAST:event_btn_restartActionPerformed

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        randomNumbers = generateRandomPermutation();
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        timer = new Timer(1000, new ActionListener() {
            private int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < randomNumbers.length) {
                    int number = randomNumbers[index++];
                    if (!drawnNumbers.contains(number)) {
                        drawnNumbers.add(number);
                        updateJList("Number drawn: " + number);
                        updateCardPanelWithNumber(tombala1, card1Data, number, card1BingoCounts, "Kullanıcı 1", card1BingoLogged);
                        updateCardPanelWithNumber(tombala2, card2Data, number, card2BingoCounts, "Kullanıcı 2", card2BingoLogged);

                    }
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
        btn_start.setEnabled(false);

    }//GEN-LAST:event_btn_startActionPerformed

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
            java.util.logging.Logger.getLogger(NazlimSerraDilaverBingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NazlimSerraDilaverBingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NazlimSerraDilaverBingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NazlimSerraDilaverBingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(() -> {
            new NazlimSerraDilaverBingo().setVisible(true);
        });
    }

    private void fillCardPanelWithNumbers(JPanel panel, int[][] cardData) {
        panel.removeAll();
        panel.setLayout(new GridLayout(3, 9, 10, 10));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                Integer value = cardData[row][col];
                String text = (value == null || value == -1) ? " " : value.toString();

                JLabel label = new JLabel(text, SwingConstants.CENTER);

                label.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                JPanel cellPanel = new JPanel(new BorderLayout());
                cellPanel.add(label);
                cellPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                panel.add(cellPanel);
            }
        }

        panel.revalidate();
        panel.repaint();
    }

    public JPanel getTombala1Panel() {
        return tombala1;
    }

    public JPanel getTombala2Panel() {
        return tombala2;
    }

    public void updateCardPanelWithNumber(JPanel panel, int[][] cardData, int number, int[] bingoCounts, String userName, boolean[] bingoLogged) {
        boolean numberFound = false;
        for (int row = 0; row < cardData.length; row++) {
            for (int col = 0; col < cardData[row].length; col++) {
                if (cardData[row][col] == number) {
                    JPanel cellPanel = (JPanel) panel.getComponent(row * cardData[row].length + col);
                    cellPanel.setBackground(Color.CYAN);
                    numberFound = true;
                    bingoCounts[row]++;
                    break;
                }
            }
            if (numberFound) {
                break;
            }
        }
        if (numberFound) {
            checkBingoStatus(bingoCounts, userName, bingoLogged);
        }
        panel.revalidate();
        panel.repaint();
    }

    public int[] generateRandomPermutation() {
        int[] numbers = new int[89];
        Random rand = new Random();
        for (int i = 0; i < 89; i++) {
            numbers[i] = i + 1;
        }
        for (int i = numbers.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = temp;
        }

        return numbers;
    }

    public void restartGame() {
        drawnNumbers.clear();

        for (int i = 0; i < card1BingoCounts.length; i++) {
            card1BingoCounts[i] = 0;
            card2BingoCounts[i] = 0;
        }

        for (int i = 0; i < card1BingoLogged.length; i++) {
            card1BingoLogged[i] = false;
            card2BingoLogged[i] = false;
        }
        card1Data = a.createFilledCard();
        card2Data = a.createFilledCard();
        fillCardPanelWithNumbers(tombala1, card1Data);
        fillCardPanelWithNumbers(tombala2, card2Data);
        randomNumbers = null;
        DefaultListModel<String> model = new DefaultListModel<>();
        jList1.setModel(model);

        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = null;

        updateJList("The game has been reset.");
        btn_start.setEnabled(true);

    }

    public void updateJList(String message) {
        ListModel<String> currentModel = jList1.getModel();
        DefaultListModel<String> model;
        if (currentModel instanceof DefaultListModel) {
            model = (DefaultListModel<String>) currentModel;
        } else {
            model = new DefaultListModel<>();
            jList1.setModel(model);
        }
        model.addElement(message);

        jList1.setSelectedValue(message, true);

        jList1.ensureIndexIsVisible(jList1.getSelectedIndex());
    }

    private void checkBingoStatus(int[] bingoCounts, String userName, boolean[] bingoLogged) {
        int bingoTotal = 0;
        for (int count : bingoCounts) {
            if (count == 5) {
                bingoTotal++;
            }
        }

        if (bingoTotal == 1 && !bingoLogged[0]) {
            updateJList(userName + " first bingo!");
            bingoLogged[0] = true;
        } else if (bingoTotal == 2 && !bingoLogged[1]) {
            updateJList(userName + " second bingo!");
            bingoLogged[1] = true;
        } else if (bingoTotal == 3 && !bingoLogged[2]) {
            updateJList(userName + " TOMBALA!");
            bingoLogged[2] = true;
            stopGameWithWinner(userName);
        }
    }

    private void stopGameWithWinner(String winnerName) {
        if (timer != null && timer.isRunning()) {
            timer.stop();
            JOptionPane.showMessageDialog(this, winnerName + " wins with TOMBALA!", "Game Over", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    // Ana metod ve diğer tanımlar...

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_restart;
    private javax.swing.JButton btn_start;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel tombala1;
    private javax.swing.JPanel tombala2;
    // End of variables declaration//GEN-END:variables
}
