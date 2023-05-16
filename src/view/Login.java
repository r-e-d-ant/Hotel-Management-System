/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.formdev.flatlaf.FlatLightLaf;
import dao.UserDao;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

import model.User;

/**
 *
 * @author hg_ofthecity
 */
public class Login extends javax.swing.JFrame {
    public String db_name = "Hotel_management_system_db";
    public String db_url_test = "jdbc:mysql://localhost:3306/"+db_name+"";
    public String db_url = "jdbc:mysql://localhost:3306/";
    public String db_username = "root"; // insert your db username
    public String db_password = "mugishathi"; // insert your db password

    //We shall create the connection to the database only once, at the start
    //of our application, and close it once our application is closed
    public static Connection conn;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        int isThere = checkDB();
        if (isThere >= 1) {
            db_url = db_url_test;
            Integer isThereTables = tableExistsChecker();

            if (isThereTables == 3) {
                System.out.println("Alright lets start the hack");
            } else {
                createTables();
            }
        } else {
            Integer rows = createDB();
            if (rows != null) {
                db_url = db_url_test;
                createTables();
            }
        }
        
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
    
    // check if theres database and tables
    // if not create them
    // also add admin by default
    
    public int checkDB() {
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(db_url_test, db_username, db_password);
            stmt = conn.createStatement();
            stmt.executeQuery("SELECT 1 FROM dual"); // MySQL specific query to test if the connection is valid
            return 1;
        } catch (SQLException e) {
            System.out.println("Database does not exist or connection could not be established.");
            return 0;
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.out.println("Failed to close database resources: " + e.getMessage());
            }
        }
    }
    
    // for checking if all tables exists
    public Integer tableExistsChecker() {
        ResultSet rs = null;
        int three = 0;
        try {
            conn = DriverManager.getConnection(db_url, db_username, db_password);
            DatabaseMetaData dbmd = conn.getMetaData();
            String[] tables = {"user", "room", "client"}; // Change this to the names of the tables you want to check
            for (String table : tables) {
                rs = dbmd.getTables(null, null, table, null);
                if (rs.next()) {
                    three = three + 1;
                } else {
                    System.out.println(table + " does not exist.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to check if tables exist: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Failed to close database resources: " + e.getMessage());
            }
            return three;
        }
    }
    
    public Integer createDB() {

        Statement stmt = null;
        
        // Open a connection
        
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(db_url, db_username, db_password);
            
            // Create database if it doesn't exist
            System.out.println("Creating database...");
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS Hotel_management_system_db";
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
            // Close the connection
            stmt.close();
            System.out.println("Database connection closed...");
            return rowsAffected;
            
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void createTables() {
        Statement stmt = null;
        
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(db_url, db_username, db_password);
            
            stmt = conn.createStatement();
            
            // Create table if it doesn't exist
            System.out.println("Creating tables...");
            
            String sqlUser = "CREATE TABLE IF NOT EXISTS user (\n" +
                    "  `user_id` varchar(20) NOT NULL,\n" +
                    "  `fullname` varchar(45) NOT NULL,\n" +
                    "  `email` varchar(45) NOT NULL,\n" +
                    "  `password` varchar(60) NOT NULL,\n" +
                    "  `userLevel` int NOT NULL DEFAULT '0',\n" +
                    "  PRIMARY KEY (`user_id`),\n" +
                    "  UNIQUE KEY `id_UNIQUE` (`user_id`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(sqlUser);
            String sqlRoom = "CREATE TABLE IF NOT EXISTS room (\n" +
                    "  `room_no` varchar(5) NOT NULL,\n" +
                    "  `fee` float NOT NULL,\n" +
                    "  `status` varchar(45) DEFAULT 'available',\n" +
                    "  PRIMARY KEY (`room_no`),\n" +
                    "  UNIQUE KEY `id_UNIQUE` (`room_no`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            stmt.executeUpdate(sqlRoom);
            String sqlClient = "CREATE TABLE IF NOT EXISTS client (\n" +
                    "  `client_id` varchar(10) NOT NULL,\n" +
                    "  `first_name` varchar(20) NOT NULL,\n" +
                    "  `last_name` varchar(20) NOT NULL,\n" +
                    "  `client_room_no` varchar(5) NOT NULL,\n" +
                    "  `entrance_date` varchar(10) NOT NULL,\n" +
                    "  `exit_date` varchar(10) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`client_id`),\n" +
                    "  UNIQUE KEY `id_UNIQUE` (`client_id`),\n" +
                    "  KEY `room_no_idx` (`client_room_no`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            
            stmt.executeUpdate(sqlClient);
            System.out.println("Tables created successfully...");
            String sqlCreateAdmin = "INSERT INTO user (user_id, fullname, email, password, userLevel) VALUES ('1', 'The Admin', 'admin@me.com', 'admin123', 1)";
            stmt.executeUpdate(sqlCreateAdmin);
            // Close the connection
            stmt.close();
            System.out.println("Database connection closed...");
            
        } catch(Exception ex) {
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

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        emailBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        loginUserBtn = new javax.swing.JButton();
        passwordBox = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Login");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Email");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Password");

        loginUserBtn.setBackground(new java.awt.Color(255, 255, 255));
        loginUserBtn.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        loginUserBtn.setForeground(new java.awt.Color(0, 102, 102));
        loginUserBtn.setText("Login");
        loginUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUserBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1)
                        .addGap(0, 215, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(emailBox)
                    .addComponent(jLabel5)
                    .addComponent(loginUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(loginUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    // save user level in local file for the logged in user
    private void saveUserLevel(String usrLevel) {
        File file = new File("usrlvl.txt");
        
        try (final OutputStreamWriter wr = new OutputStreamWriter( new FileOutputStream(file))){
            try {
                wr.write(usrLevel);
            } catch (IOException e) {
                e.printStackTrace();
            }
            wr.flush();
        } catch (IOException e) {
            System.out.println("Something went wrong! " + e);
        }
    }
    
    private void loginUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUserBtnActionPerformed
        // TODO add your handling code here:
        
        if (emailBox.getText().isEmpty() || passwordBox.getText().isEmpty()) { // #1 validation
            JOptionPane.showMessageDialog(this, "Not logged in, fill all the fields.");
        } else {
            // Instantiate the model object
            try {
                User theUser = new User();

                theUser.setUserEmail(emailBox.getText());
                String enteredPassword = passwordBox.getText();

                // Instantiate the User DAO object
                UserDao userDao = new UserDao();
                ResultSet result = userDao.LoginUser(theUser); // get result

                if (result.next()) {
                    String userPwdInDb = result.getString(3);
                    // compare retrieved db password with entered password
                    if (userPwdInDb.equals(enteredPassword)) {
                        JOptionPane.showMessageDialog(this, "Logged in successfully");
                        
                        // get user level to be saved in file locally
                        String usrlvl = "" + result.getInt(4);
                        saveUserLevel(usrlvl);
                        
                        // get user level in order to decide which page to show
                        if (usrlvl.equals("1")) {
                            Admin adminLink = new Admin();
                            adminLink.setVisible(true);
                            this.dispose();
                        } else {
                            Receptionist recepLink = new Receptionist();
                            recepLink.setVisible(true);
                            this.dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Not logged in\nVerify email or password");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Not logged in\nVerify email or password");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_loginUserBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }


        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loginUserBtn;
    private javax.swing.JPasswordField passwordBox;
    // End of variables declaration//GEN-END:variables
}
