/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author hg_ofthecity
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        createRoomFormLinkBtn = new javax.swing.JButton();
        roomMgtFormLinkBtn = new javax.swing.JButton();
        regClientFormLinkBtn = new javax.swing.JButton();
        clientMgtFormLinkBtn = new javax.swing.JButton();
        createUserFormLinkBtn = new javax.swing.JButton();
        userMgtFormLinkBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("HOTEL MANAGEMENT SYSTEM");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Admin Menu");

        createRoomFormLinkBtn.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        createRoomFormLinkBtn.setForeground(new java.awt.Color(0, 102, 102));
        createRoomFormLinkBtn.setText("Create room");
        createRoomFormLinkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRoomFormLinkBtnActionPerformed(evt);
            }
        });

        roomMgtFormLinkBtn.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        roomMgtFormLinkBtn.setForeground(new java.awt.Color(0, 102, 102));
        roomMgtFormLinkBtn.setText("Rooms Management Panel");
        roomMgtFormLinkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomMgtFormLinkBtnActionPerformed(evt);
            }
        });

        regClientFormLinkBtn.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        regClientFormLinkBtn.setForeground(new java.awt.Color(0, 102, 102));
        regClientFormLinkBtn.setText("Register client");
        regClientFormLinkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regClientFormLinkBtnActionPerformed(evt);
            }
        });

        clientMgtFormLinkBtn.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        clientMgtFormLinkBtn.setForeground(new java.awt.Color(0, 102, 102));
        clientMgtFormLinkBtn.setText("Client Management Panel");
        clientMgtFormLinkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientMgtFormLinkBtnActionPerformed(evt);
            }
        });

        createUserFormLinkBtn.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        createUserFormLinkBtn.setForeground(new java.awt.Color(0, 102, 102));
        createUserFormLinkBtn.setText("Create new user");
        createUserFormLinkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserFormLinkBtnActionPerformed(evt);
            }
        });

        userMgtFormLinkBtn.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        userMgtFormLinkBtn.setForeground(new java.awt.Color(0, 102, 102));
        userMgtFormLinkBtn.setText("User Management Panel");
        userMgtFormLinkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userMgtFormLinkBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Noteworthy", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("HAPPY STAY HOTEL ©  2023");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(userMgtFormLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(createUserFormLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clientMgtFormLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(regClientFormLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(roomMgtFormLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(createRoomFormLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel3)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(createRoomFormLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roomMgtFormLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(regClientFormLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clientMgtFormLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createUserFormLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userMgtFormLinkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createRoomFormLinkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRoomFormLinkBtnActionPerformed
        // TODO add your handling code here:
        RegisterRoom regRoomFrm = new RegisterRoom();
        regRoomFrm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createRoomFormLinkBtnActionPerformed

    private void roomMgtFormLinkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomMgtFormLinkBtnActionPerformed
        // TODO add your handling code here:
        RoomMgt linkForm = new RoomMgt();
        linkForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_roomMgtFormLinkBtnActionPerformed

    private void regClientFormLinkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regClientFormLinkBtnActionPerformed
        // TODO add your handling code here:
        RegisterClient linkForm = new RegisterClient();
        linkForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regClientFormLinkBtnActionPerformed

    private void clientMgtFormLinkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientMgtFormLinkBtnActionPerformed
        // TODO add your handling code here:
        Home linkForm = new Home();
        linkForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_clientMgtFormLinkBtnActionPerformed

    private void createUserFormLinkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserFormLinkBtnActionPerformed
        // TODO add your handling code here:
        RegisterUser linkForm = new RegisterUser();
        linkForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createUserFormLinkBtnActionPerformed

    private void userMgtFormLinkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMgtFormLinkBtnActionPerformed
        // TODO add your handling code here:
        UserMgt linkForm = new UserMgt();
        linkForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_userMgtFormLinkBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientMgtFormLinkBtn;
    private javax.swing.JButton createRoomFormLinkBtn;
    private javax.swing.JButton createUserFormLinkBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton regClientFormLinkBtn;
    private javax.swing.JButton roomMgtFormLinkBtn;
    private javax.swing.JButton userMgtFormLinkBtn;
    // End of variables declaration//GEN-END:variables
}
