/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import dao.RoomDao;
import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Room;

/**
 *
 * @author hg_ofthecity
 */
public class RoomMgt extends javax.swing.JFrame {
    // Global variables
    DefaultTableModel tableModel = new DefaultTableModel();

    /**
     * Creates new form RoomMgt
     */
    public RoomMgt() {
        initComponents();
        addColumnsOnTable();
        retrieveDataFromDbToTable();
    }
    
    private void addColumnsOnTable() {
        tableModel.addColumn("Room Nr");
        tableModel.addColumn("Room type");
        tableModel.addColumn("Fee");
        displayRoomsTable.setModel(tableModel);
    }
    
    private void retrieveDataFromDbToTable () {
        Room theRoom = new Room();
        RoomDao roomDao = new RoomDao();
        try {
            ResultSet result = roomDao.displayRooms(theRoom);
            
            // clear rows
            int i = tableModel.getRowCount();
            while (i != 0) {
                i--;
                tableModel.removeRow(i);
            }
            
            while (result.next()) {
                tableModel.addRow(new Object[] {
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayRoomsTable = new javax.swing.JTable();
        searchInputBox = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        roomFeeBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        roomNoBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        roomTypeBox = new javax.swing.JTextField();
        newRoomLinkBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        gotoMenuLink = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        openClientMgtWindowLink = new javax.swing.JMenu();
        openAddClientWindowLink = new javax.swing.JMenu();
        adminWindowLink = new javax.swing.JMenu();
        openLogoutWindowLink = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayRoomsTable.setForeground(new java.awt.Color(0, 102, 102));
        displayRoomsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        displayRoomsTable.setCellSelectionEnabled(true);
        displayRoomsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayRoomsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(displayRoomsTable);

        searchInputBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchInputBoxKeyReleased(evt);
            }
        });

        searchBtn.setForeground(new java.awt.Color(0, 102, 102));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Enter room nr to search");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Fee");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Room Nr");

        roomNoBox.setEditable(false);
        roomNoBox.setBackground(new java.awt.Color(241, 240, 240));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Room type");

        newRoomLinkBtn.setForeground(new java.awt.Color(0, 102, 102));
        newRoomLinkBtn.setText("New room");
        newRoomLinkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRoomLinkBtnActionPerformed(evt);
            }
        });

        updateBtn.setForeground(new java.awt.Color(0, 102, 102));
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setForeground(new java.awt.Color(0, 102, 102));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        gotoMenuLink.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        gotoMenuLink.setForeground(new java.awt.Color(0, 153, 255));
        gotoMenuLink.setText("Cancel");
        gotoMenuLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gotoMenuLinkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(roomNoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(roomFeeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(searchInputBox, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gotoMenuLink)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(newRoomLinkBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(updateBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(deleteBtn)))))
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchInputBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roomTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomNoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomFeeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newRoomLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(gotoMenuLink)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        openClientMgtWindowLink.setForeground(new java.awt.Color(0, 153, 255));
        openClientMgtWindowLink.setText("Client management");
        openClientMgtWindowLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openClientMgtWindowLinkMouseClicked(evt);
            }
        });
        jMenuBar1.add(openClientMgtWindowLink);

        openAddClientWindowLink.setForeground(new java.awt.Color(0, 153, 255));
        openAddClientWindowLink.setText("Add Client");
        openAddClientWindowLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openAddClientWindowLinkMouseClicked(evt);
            }
        });
        jMenuBar1.add(openAddClientWindowLink);

        adminWindowLink.setForeground(new java.awt.Color(0, 153, 255));
        adminWindowLink.setText("Admin");
        adminWindowLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminWindowLinkMouseClicked(evt);
            }
        });
        jMenuBar1.add(adminWindowLink);

        openLogoutWindowLink.setForeground(new java.awt.Color(0, 153, 255));
        openLogoutWindowLink.setText("Logout");
        openLogoutWindowLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openLogoutWindowLinkMouseClicked(evt);
            }
        });
        jMenuBar1.add(openLogoutWindowLink);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newRoomLinkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRoomLinkBtnActionPerformed
        // TODO add your handling code here:
        RegisterRoom registerRoomForm = new RegisterRoom();
        registerRoomForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_newRoomLinkBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        // Instantiate the Room model object
        
        if (roomTypeBox.getText().isEmpty() ||
                roomFeeBox.getText().isEmpty() ||
                roomNoBox.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "First select a room to update");
        } else {
            if (roomNoBox.getText().length() == 5) { // #2 validation
                if (Integer.parseInt(roomFeeBox.getText()) > 10000) { // #3 validation
                    Room theRoom = new Room();
        
                    // set the rooms in model
                    theRoom.setRoomType(roomTypeBox.getText());
                    theRoom.setFee(roomFeeBox.getText());
                    theRoom.setRoomNo(roomNoBox.getText());

                    // Instantiate the User DAO object
                    RoomDao roomDao = new RoomDao();
                    int rows = roomDao.updateRoom(theRoom);

                    if (rows >= 1) {
                        JOptionPane.showMessageDialog(this, "Room updated");
                        retrieveDataFromDbToTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Room not updated");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Can't create room with fee less than 10 000");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Room number can't be less or greater than 5 characters");
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        
        if (roomTypeBox.getText().isEmpty() ||
                roomFeeBox.getText().isEmpty() ||
                roomNoBox.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "First select a room to delete");
        } else {
            // Instantiate the Room model object
            Room theRoom = new Room();

            // set the rooms in model
            theRoom.setRoomNo(roomNoBox.getText());

            // Instantiate the User DAO object
            RoomDao roomDao = new RoomDao();
            int rows = roomDao.deleteRoom(theRoom);

            if (rows >= 1) {
                JOptionPane.showMessageDialog(this, "Room deleted");
                retrieveDataFromDbToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Room not deleted");
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void displayRoomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayRoomsTableMouseClicked
        // TODO add your handling code here:
        tableModel = (DefaultTableModel) displayRoomsTable.getModel();
        int hr = displayRoomsTable.getSelectedRow();
        roomNoBox.setText(tableModel.getValueAt(hr, 0).toString());
        roomTypeBox.setText(tableModel.getValueAt(hr, 1).toString());
        roomFeeBox.setText(tableModel.getValueAt(hr, 2).toString());
    }//GEN-LAST:event_displayRoomsTableMouseClicked

    private void openClientMgtWindowLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openClientMgtWindowLinkMouseClicked
        // TODO add your handling code here:
        Home homeForm = new Home();
        homeForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_openClientMgtWindowLinkMouseClicked

    private void openAddClientWindowLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openAddClientWindowLinkMouseClicked
        // TODO add your handling code here:
        RegisterClient registerClientForm = new RegisterClient();
        registerClientForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_openAddClientWindowLinkMouseClicked

    private void openLogoutWindowLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openLogoutWindowLinkMouseClicked
        // TODO add your handling code here:
        Login loginForm = new Login();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_openLogoutWindowLinkMouseClicked

    private void searchInputBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInputBoxKeyReleased
        // TODO add your handling code here:
        Room theRoom = new Room();
        RoomDao roomDao = new RoomDao();
        
        if (searchInputBox.getText().isEmpty()) {
            retrieveDataFromDbToTable();
        } else {
            try {
                ResultSet result = roomDao.searchRoom(theRoom, searchInputBox.getText());
                
                // clear rows
                int i = tableModel.getRowCount();
                while (i != 0) {
                    i--;
                    tableModel.removeRow(i);
                }
                while (result.next()) {
                    tableModel.addRow(new Object[] {
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                    });
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_searchInputBoxKeyReleased

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        Room theRoom = new Room();
        RoomDao roomDao = new RoomDao();
        
        try {
            ResultSet result = roomDao.searchRoom(theRoom, searchInputBox.getText());
            
            // clear rows
            int i = tableModel.getRowCount();
            while (i != 0) {
                i--;
                tableModel.removeRow(i);
            }
            
            while (result.next()) {
                tableModel.addRow(new Object[] {
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private String getUserLevel() {
        File file = new File("usrlvl.txt");
        
        Path sourceFile = Paths.get(file.toURI());
        
        try (BufferedReader reader = Files.newBufferedReader(sourceFile)){
            String line = reader.readLine();
            return line;
        } catch (Exception e) {
            System.out.println("Something went wrong! " + e);
            return null;
        }
    }
    
    private void adminWindowLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminWindowLinkMouseClicked
        // TODO add your handling code here:
        if ((getUserLevel()).equals("1")) {
            Admin adminForm = new Admin();
            adminForm.setVisible(true);
            this.dispose();
        } else {
            Login loginForm = new Login();
            loginForm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_adminWindowLinkMouseClicked

    private void gotoMenuLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoMenuLinkMouseClicked
        // TODO add your handling code here:
        if ((getUserLevel()).equals("1")) {
            Admin adminForm = new Admin();
            adminForm.setVisible(true);
            this.dispose();
        } else {
            Receptionist recepForm = new Receptionist();
            recepForm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_gotoMenuLinkMouseClicked

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
            java.util.logging.Logger.getLogger(RoomMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomMgt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu adminWindowLink;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTable displayRoomsTable;
    private javax.swing.JLabel gotoMenuLink;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newRoomLinkBtn;
    private javax.swing.JMenu openAddClientWindowLink;
    private javax.swing.JMenu openClientMgtWindowLink;
    private javax.swing.JMenu openLogoutWindowLink;
    private javax.swing.JTextField roomFeeBox;
    private javax.swing.JTextField roomNoBox;
    private javax.swing.JTextField roomTypeBox;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInputBox;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}