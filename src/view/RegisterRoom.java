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
import javax.swing.JOptionPane;
import model.Room;

/**
 *
 * @author hg_ofthecity
 */
public class RegisterRoom extends javax.swing.JFrame {

    /**
     * Creates new form RegisterRoom
     */
    public RegisterRoom() {
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

        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        roomTypeBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        createRoomBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        roomNoBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        roomFeeBox = new javax.swing.JTextField();
        gotoMenuLink = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("New Room");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Room type");

        createRoomBtn.setBackground(new java.awt.Color(255, 255, 255));
        createRoomBtn.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        createRoomBtn.setForeground(new java.awt.Color(0, 102, 102));
        createRoomBtn.setText("Save");
        createRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRoomBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Room Nr");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Fee");

        gotoMenuLink.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        gotoMenuLink.setForeground(new java.awt.Color(0, 153, 255));
        gotoMenuLink.setText("Cancel");
        gotoMenuLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gotoMenuLinkMouseClicked(evt);
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
                        .addComponent(jSeparator2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(roomNoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(roomTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomFeeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 30, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gotoMenuLink)
                                .addGap(38, 38, 38)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roomNoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(roomTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(roomFeeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gotoMenuLink))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRoomBtnActionPerformed
        // TODO add your handling code here:
        
        if (roomNoBox.getText().isEmpty()
                || roomTypeBox.getText().isEmpty()
                || roomFeeBox.getText().isEmpty()) { // #1 validation
            JOptionPane.showMessageDialog(this, "Room not created, fill all the fields.");
        } else {
            if (roomNoBox.getText().length() == 5) { // #2 validation
                if (Integer.parseInt(roomFeeBox.getText()) > 10000) { // #3 validation
                    // Instantiate the Room model object
                    Room theRoom = new Room();

                    // set the rooms in model
                    theRoom.setRoomNo(roomNoBox.getText());
                    theRoom.setRoomType(roomTypeBox.getText());
                    theRoom.setFee(roomFeeBox.getText());

                    // Instantiate the User DAO object
                    RoomDao roomDao = new RoomDao();
                    int rows = roomDao.registerRoom(theRoom);

                    if (rows >= 1) {
                        JOptionPane.showMessageDialog(this, "Room created");
                        RoomMgt roomForm = new RoomMgt();
                        roomForm.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Room not created");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Can't create room with fee less than 10 000");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Room number can't be less or greater than 5 characters");
            }
        }
    }//GEN-LAST:event_createRoomBtnActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createRoomBtn;
    private javax.swing.JLabel gotoMenuLink;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField roomFeeBox;
    private javax.swing.JTextField roomNoBox;
    private javax.swing.JTextField roomTypeBox;
    // End of variables declaration//GEN-END:variables
}
