/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.UserDao;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.User;
import static view.Login.conn;
/**
 *
 * @author hg_ofthecity
 */
public class UserMgt extends javax.swing.JFrame {
    
    // global variables
    DefaultTableModel tableModel = new DefaultTableModel();
    
    /**
     * Creates new form UserMgt
     */
    public UserMgt() {
        initComponents();
        addColumnsOnTable();
        retrieveDataFromDbToTable();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Close the database connection
                if (conn != null) {
                    try {
                        conn.close();
                        System.out.println("Connection closed");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        // Handle connection closing error
                    }
                }
                System.out.println("No connection was open");
                // Dispose or exit the form
                dispose();
                // or System.exit(0);
            }
        });
    }
    
    private void addColumnsOnTable() {
        tableModel.addColumn("Id");
        tableModel.addColumn("Full name");
        tableModel.addColumn("Email");
        tableModel.addColumn("Password");
        tableModel.addColumn("User level");
        displayUsersTable.setModel(tableModel);
    }
    
    private void retrieveDataFromDbToTable () {
        User theUser = new User();
        UserDao userDao = new UserDao();
        try {
            ResultSet result = userDao.displayUsers(theUser);
            
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
                    result.getString(4),
                    result.getString(5),
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
        displayUsersTable = new javax.swing.JTable();
        searchInputBox = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fullnameBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        emailBox = new javax.swing.JTextField();
        newUserLinkBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        userIdBox = new javax.swing.JTextField();
        passwordBox = new javax.swing.JPasswordField();
        gotoMenuLink = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        openClientMgtWindowLink = new javax.swing.JMenu();
        openAddClientWindowLink = new javax.swing.JMenu();
        adminWindowLink = new javax.swing.JMenu();
        openLogoutWindowLink = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayUsersTable.setForeground(new java.awt.Color(0, 102, 102));
        displayUsersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        displayUsersTable.setCellSelectionEnabled(true);
        displayUsersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayUsersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(displayUsersTable);

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
        jLabel1.setText("Enter name or id  to search");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Full name");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Email");

        newUserLinkBtn.setForeground(new java.awt.Color(0, 102, 102));
        newUserLinkBtn.setText("New user");
        newUserLinkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserLinkBtnActionPerformed(evt);
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

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Id");

        userIdBox.setEditable(false);
        userIdBox.setBackground(new java.awt.Color(241, 240, 240));

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(searchInputBox, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(userIdBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(fullnameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(emailBox, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(112, 112, 112))
                                    .addComponent(passwordBox)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gotoMenuLink)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(newUserLinkBtn)
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailBox, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(passwordBox))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newUserLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(userIdBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fullnameBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(45, 45, 45))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(gotoMenuLink)
                .addGap(14, 14, 14))
        );

        openClientMgtWindowLink.setForeground(new java.awt.Color(0, 153, 255));
        openClientMgtWindowLink.setText("Client Mgt");
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
                try {
                    adminWindowLinkMouseClicked(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        jMenuBar1.add(adminWindowLink);

        openLogoutWindowLink.setForeground(new java.awt.Color(0, 153, 255));
        openLogoutWindowLink.setText("Logout");
        openLogoutWindowLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    openLogoutWindowLinkMouseClicked(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayUsersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayUsersTableMouseClicked
        // TODO add your handling code here:
        tableModel = (DefaultTableModel) displayUsersTable.getModel();
        int hr = displayUsersTable.getSelectedRow();
        userIdBox.setText(tableModel.getValueAt(hr, 0).toString());
        fullnameBox.setText(tableModel.getValueAt(hr, 1).toString());
        emailBox.setText(tableModel.getValueAt(hr, 2).toString());
        passwordBox.setText(tableModel.getValueAt(hr, 3).toString());
    }//GEN-LAST:event_displayUsersTableMouseClicked

    private void searchInputBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInputBoxKeyReleased
        // TODO add your handling code here:
        User theUser = new User();
        UserDao userDao = new UserDao();

        if (searchInputBox.getText().isEmpty()) {
            retrieveDataFromDbToTable();
        } else {
            try {
                ResultSet result = userDao.searchUser(theUser, searchInputBox.getText());

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
                        result.getString(4),
                        result.getString(5),
                    });
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_searchInputBoxKeyReleased

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        User theUser = new User();
        UserDao userDao = new UserDao();

        if (searchInputBox.getText().isEmpty()) {
            retrieveDataFromDbToTable();
        } else {
            try {
                ResultSet result = userDao.searchUser(theUser, searchInputBox.getText());

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
                        result.getString(4),
                        result.getString(5),
                    });
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void newUserLinkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserLinkBtnActionPerformed
        // TODO add your handling code here:
        RegisterUser registerUserForm = new RegisterUser();
        registerUserForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_newUserLinkBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        // Instantiate the Room model object

        if (emailBox.getText().isEmpty() ||
            passwordBox.getText().isEmpty() ||
            fullnameBox.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "First select a user to update");
        } else {
            if (passwordBox.getText().length() >= 6) { // #2 validation
                User theUser = new User();
                
                // set the rooms in model
                theUser.setUserId(userIdBox.getText());
                theUser.setFullName(fullnameBox.getText());
                theUser.setUserEmail(emailBox.getText());
                theUser.setUserPassword(passwordBox.getText());

                // Instantiate the User DAO object
                UserDao userDao = new UserDao();
                int rows = userDao.updateUser(theUser);

                if (rows >= 1) {
                    JOptionPane.showMessageDialog(this, "User updated");
                    retrieveDataFromDbToTable();
                } else {
                    JOptionPane.showMessageDialog(this, "User not updated");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Password must be greater or equal than 6 characters");
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:

        if (emailBox.getText().isEmpty() ||
            passwordBox.getText().isEmpty() ||
            fullnameBox.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "First select a user to delete");
        } else {
            // Instantiate the Room model object
            User theUser = new User();

            // set the rooms in model
            theUser.setUserId(userIdBox.getText());

            // Instantiate the User DAO object
            UserDao userDao = new UserDao();
            int rows = userDao.deleteUser(theUser);

            if (rows >= 1) {
                JOptionPane.showMessageDialog(this, "User deleted");
                retrieveDataFromDbToTable();
            } else {
                JOptionPane.showMessageDialog(this, "User not deleted");
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

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

    private void openLogoutWindowLinkMouseClicked(java.awt.event.MouseEvent evt) throws SQLException {//GEN-FIRST:event_openLogoutWindowLinkMouseClicked
        // TODO add your handling code here:
        Login loginForm = new Login();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_openLogoutWindowLinkMouseClicked

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
    
    private void adminWindowLinkMouseClicked(java.awt.event.MouseEvent evt) throws SQLException {//GEN-FIRST:event_adminWindowLinkMouseClicked
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
            java.util.logging.Logger.getLogger(UserMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMgt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu adminWindowLink;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTable displayUsersTable;
    private javax.swing.JTextField emailBox;
    private javax.swing.JTextField fullnameBox;
    private javax.swing.JLabel gotoMenuLink;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newUserLinkBtn;
    private javax.swing.JMenu openAddClientWindowLink;
    private javax.swing.JMenu openClientMgtWindowLink;
    private javax.swing.JMenu openLogoutWindowLink;
    private javax.swing.JPasswordField passwordBox;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInputBox;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField userIdBox;
    // End of variables declaration//GEN-END:variables
}
