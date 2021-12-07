/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.project;

/**
 *
 * @author Huda
 */
import static database.project.userLogin.userEmail;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class donateBlood extends javax.swing.JFrame {

    /**
     * Creates new form donateBlood
     */
    public donateBlood() {
        initComponents();
    }

    Connection con;
    PreparedStatement pst;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bloodGroup = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comment = new javax.swing.JTextField();
        donate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Blood Group:");

        bloodGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloodGroupActionPerformed(evt);
            }
        });

        jLabel2.setText("Comment:");

        donate.setText("Donate");
        donate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bloodGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(comment)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(donate)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(donate)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bloodGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloodGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloodGroupActionPerformed

    private void donateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donateActionPerformed
        try {
            String data = "0";
            File file = new File("bloodId.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                data = myReader.next();
            }
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");
            pst = con.prepareStatement("SELECT * from ourUser where email = ?");
            pst.setString(1, userEmail);
            ResultSet rs = pst.executeQuery();
            rs.next();
            int userId = rs.getInt("USER_ID");
            pst = con.prepareStatement("SELECT BLOOD_GROUP_ID from BLOOD_GROUP where BLOOD_GROUP_DESCRIPTION = ?");
            pst.setString(1, bloodGroup.getText());
            rs = pst.executeQuery();
            rs.next();
            int bloodgroupId = rs.getInt("blood_group_id");
            pst = con.prepareStatement(
                    "INSERT INTO BLOOD_DONOR (DONOR_COMMENT, USER_ID, BLOOD_GROUP_ID) VALUES (?,?,?)"
            );
            pst.setString(1, comment.getText());
            pst.setInt(2, userId);
            pst.setInt(3, bloodgroupId);
            pst.executeUpdate();
            int i = Integer.parseInt(data);
            i = i + 1;
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            pst = con.prepareStatement(
                    "INSERT INTO BLOOD_DONATION_DETAILS (BLOOD_ID, BLOOD_DONATION_DATE) VALUES (?,?)"
            );
            pst.setInt(1, i);
            pst.setDate(2, date);
            JOptionPane.showMessageDialog(this, "Inserted");
            bloodGroup.setText("");
            comment.setText("");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(donateBlood.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(donateBlood.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(donateBlood.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_donateActionPerformed

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
            java.util.logging.Logger.getLogger(donateBlood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(donateBlood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(donateBlood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(donateBlood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new donateBlood().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bloodGroup;
    private javax.swing.JTextField comment;
    private javax.swing.JButton donate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
