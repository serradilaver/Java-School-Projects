package Dilaver_Kilic_DesktopSearchEngine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author merye
 */
public class Dilaver_Kilic_MainPanel extends javax.swing.JPanel implements Dilaver_Kilic_IPanel {

    public ArrayList<File> selectedFiles = new ArrayList<>();
    private Set<String> ignoreList = new HashSet<>();
    DefaultListModel listModelFiles = new DefaultListModel();
    DefaultListModel listModel = new DefaultListModel();

    public File[] allFiles;
    private Dilaver_Kilic_BinarySearchTree binarySearchTree;

    public Dilaver_Kilic_MainPanel() {
        initComponents();
        loadIgnoreList();
        addFilesToJList();

        jListWords.setModel(listModel);
        jList.setModel(listModelFiles);
        binarySearchTree = new Dilaver_Kilic_BinarySearchTree();
        jComboBox.setEnabled(false);
        searchJButton1.setEnabled(false);
    }

    private void loadIgnoreList() {
        JOptionPane.showMessageDialog(this, "Please select the ignore list file.", "Select Ignore List", JOptionPane.INFORMATION_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Ignore List File");
        fileChooser.setFileFilter(new FileNameExtensionFilter("TXT Files", "txt"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (Scanner scanner = new Scanner(selectedFile)) {
                ignoreList.clear();
                while (scanner.hasNextLine()) {
                    String word = scanner.nextLine().trim().toLowerCase();
                    if (!word.isEmpty()) {
                        ignoreList.add(word);
                    }
                }
                JOptionPane.showMessageDialog(this, "Ignore list loaded successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error reading file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "No file selected.", "Cancelled", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }

    public void addFilesToJList() {
        JOptionPane.showMessageDialog(this, "Please select HTML files to add to the list.", "Select HTML Files", JOptionPane.INFORMATION_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select All HTML Files");
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new FileNameExtensionFilter("HTML Files", "html"));
        int option = fileChooser.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            allFiles = fileChooser.getSelectedFiles();
            if (allFiles.length == 0) {
                JOptionPane.showMessageDialog(this, "No files were selected.", "No Selection", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int addedCount = 0;
            for (File file : allFiles) {
                boolean fileAlreadyAdded = false;
                for (int i = 0; i < listModelFiles.size(); i++) {
                    if (listModelFiles.getElementAt(i).equals(file.getName())) {
                        fileAlreadyAdded = true;
                        break;
                    }
                }
                if (!fileAlreadyAdded) {
                    listModelFiles.addElement(file.getName());
                    addedCount++;
                }
            }

            if (addedCount > 0) {
                JOptionPane.showMessageDialog(this, addedCount + " file(s) added successfully.", "Files Added", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "All selected files are already in the list.", "No Files Added", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "File selection cancelled.", "Cancelled", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }

    public void getSelectedFiles() {
        selectedFiles.clear();
        List<String> selectedFileNames = jList.getSelectedValuesList();

        if (selectedFileNames.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No files selected.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            for (String selectedFileName : selectedFileNames) {
                for (File file : allFiles) {
                    if (file.getName().equals(selectedFileName)) {
                        selectedFiles.add(file);
                        break;
                    }
                }
            }
        }

    }

    public void processWords() {
        for (File file : selectedFiles) {
            try {
                Document doc = Jsoup.parse(file, "UTF-8");
                String text = doc.text();
                String[] words = text.split("\\s+");

                for (String word : words) {
                    String cleanWord = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
                    if (!ignoreList.contains(cleanWord) && !cleanWord.isEmpty()) {
                        binarySearchTree.insert(cleanWord, file.getName()); // Ignore list'te yoksa pushWord metodunu çağır
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error processing file: " + file.getName(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    private void updateList(String order) {
        listModel.clear(); // Listeyi temizle
        String data = "";

        switch (order) {
            case "Pre-Order":
                data = binarySearchTree.printPreOrder();
                break;
            case "In-Order":
                data = binarySearchTree.printInOrder();
                break;
            case "Post-Order":
                data = binarySearchTree.printPostOrder();
                break;
        }

        for (String entry : data.split("\n")) {
            if (!entry.isEmpty()) {
                listModel.addElement(entry);
            }
        }
    }

    private void performSearch(String query) {
        if (!query.isEmpty()) {
            String result = binarySearchTree.search(query); // Arama metodu çağırılır.
            if (result != null) {
                listModel.clear(); // Listeyi temizle.
                String[] entries = result.split("\n"); // Sonuçları satır satır ayır.
                for (String entry : entries) {
                    if (!entry.isEmpty()) {
                        listModel.addElement(entry); // Her bir satırı listeye ekle.
                    }
                }
            } else {
                listModel.clear();
                listModel.addElement("No results found for: " + query); // Sonuç bulunamazsa mesaj göster.
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        searchJButton1 = new javax.swing.JButton();
        selectFilesJButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane3 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListWords = new javax.swing.JList<>();
        jSeparator3 = new javax.swing.JSeparator();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 6), new java.awt.Dimension(0, 6), new java.awt.Dimension(32767, 6));

        setBackground(new java.awt.Color(245, 239, 231));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox.setBackground(new java.awt.Color(23, 39, 66));
        jComboBox.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jComboBox.setForeground(new java.awt.Color(245, 239, 231));
        jComboBox.setMaximumRowCount(3);
        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pre-Order", "Post-Order", "In-Order" }));
        jComboBox.setSelectedIndex(2);
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });
        add(jComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 120, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 39, 66));
        jLabel1.setText("Engine");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, 50));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(794, 400, 19, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 2, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(23, 39, 66));
        jLabel4.setText("Search with words:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 200, -1));

        jTextField1.setBackground(new java.awt.Color(23, 39, 66));
        jTextField1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(245, 239, 231));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 180, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 2, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(23, 39, 66));
        jLabel5.setText("Please select a sorting: ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 200, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(23, 39, 66));
        jLabel6.setText("Desktop");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(23, 39, 66));
        jLabel7.setText("Search");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 100, 30));

        searchJButton1.setBackground(new java.awt.Color(23, 39, 66));
        searchJButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        searchJButton1.setForeground(new java.awt.Color(245, 239, 231));
        searchJButton1.setText("Search");
        searchJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJButton1ActionPerformed(evt);
            }
        });
        add(searchJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 120, 30));

        selectFilesJButton.setBackground(new java.awt.Color(23, 39, 66));
        selectFilesJButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        selectFilesJButton.setForeground(new java.awt.Color(245, 239, 231));
        selectFilesJButton.setText("Select Files");
        selectFilesJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFilesJButtonActionPerformed(evt);
            }
        });
        add(selectFilesJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 120, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 2, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(23, 39, 66));
        jLabel9.setText("Please select files:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 120, -1));
        add(filler3, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 446, -1, 19));
        add(filler4, new org.netbeans.lib.awtextra.AbsoluteConstraints(818, 446, -1, 19));
        add(filler2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 435, -1, 24));
        add(filler5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 450, 40, 20));
        add(filler6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, 60, 30));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jList.setBackground(new java.awt.Color(23, 39, 66));
        jList.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jList.setForeground(new java.awt.Color(245, 239, 231));
        jList.setToolTipText("");
        jList.setVisibleRowCount(10);
        jScrollPane3.setViewportView(jList);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 140, 210));

        jListWords.setBackground(new java.awt.Color(23, 39, 66));
        jListWords.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jListWords.setForeground(new java.awt.Color(245, 239, 231));
        jScrollPane2.setViewportView(jListWords);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 340, 310));

        jSeparator3.setBackground(new java.awt.Color(23, 39, 66));
        jSeparator3.setForeground(new java.awt.Color(23, 39, 66));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator3.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jSeparator3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 20, 290));
        add(filler7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 20, 30));
        add(filler8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 0, 30));
        add(filler9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 446, 350, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void searchJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJButton1ActionPerformed
        performSearch(jTextField1.getText());
    }//GEN-LAST:event_searchJButton1ActionPerformed

    private void selectFilesJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFilesJButtonActionPerformed
        getSelectedFiles();
        processWords();
        jComboBox.setEnabled(true);
        searchJButton1.setEnabled(true);
    }//GEN-LAST:event_selectFilesJButtonActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        String selectedOrder = (String) jComboBox.getSelectedItem();
        updateList(selectedOrder);
    }//GEN-LAST:event_jComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList;
    private javax.swing.JList<String> jListWords;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton searchJButton1;
    private javax.swing.JButton selectFilesJButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onPageSet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
