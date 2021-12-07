/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huda
 */
public class emp extends javax.swing.JFrame {

    /**
     * Creates new form emp
     */
    Connection con;
    PreparedStatement pst;

    public emp() throws ClassNotFoundException, SQLException {

        initComponents();
        tableUpdate();
    }

    public void tableUpdate() throws ClassNotFoundException, SQLException {
        int c;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");
        pst = con.prepareStatement("SELECT * FROM EMPLOYEE e JOIN EMPLOYEEJOB j ON e.job_id = j.job_id");
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData rsd = rs.getMetaData();
        c = rsd.getColumnCount();
        DefaultTableModel dft = (DefaultTableModel) jTable1.getModel();
        dft.setRowCount(0);
        while (rs.next()) {
            Vector v2 = new Vector();
            for (int i = 0; i < c; i++) {
                v2.add(rs.getInt("employee_id"));
                v2.add(rs.getString("name"));
                v2.add(rs.getString("phoneno"));
                v2.add(rs.getDouble("salary"));
                v2.add(rs.getString("job_title"));
            }
            dft.addRow(v2);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        empname = new javax.swing.JTextField();
        empphone = new javax.swing.JTextField();
        empsalary = new javax.swing.JTextField();
        empjob = new javax.swing.JTextField();
        Insert = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name:");

        jLabel2.setText("Phone Number:");

        jLabel3.setText("Salary:");

        jLabel4.setText("Job:");

        empname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empnameActionPerformed(evt);
            }
        });

        empjob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empjobActionPerformed(evt);
            }
        });

        Insert.setText("Insert");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "PhoneNo", "Salary", "Job"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(115, 115, 115)
                                .addComponent(empjob))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(98, 98, 98)
                                .addComponent(empsalary))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(101, 101, 101)
                                        .addComponent(empname))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(50, 50, 50)
                                        .addComponent(empphone, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Insert)
                        .addGap(29, 29, 29)
                        .addComponent(edit)
                        .addGap(32, 32, 32)
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(empname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(empphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(empsalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(empjob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Insert)
                            .addComponent(edit)
                            .addComponent(delete)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void empjobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empjobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empjobActionPerformed

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        String name, phone, salary, job;
        boolean jobFound = false;
        int jobId = -1;
        name = empname.getText();
        phone = empphone.getText();
        job = empjob.getText();
        salary = empsalary.getText();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEEJOB");
            while (rs.next()) {
                int id = rs.getInt("job_id");
                String jobTitle = rs.getString("job_title");
                if (jobTitle.equals(job)) {
                    jobFound = true;
                    jobId = id;
                    break;
                }
            }
            st.close();
            if (jobFound) {
                pst = con.prepareStatement(
                        "INSERT INTO EMPLOYEE (NAME, PHONENO,SALARY,JOB_ID) VALUES (?,?,?,?)"
                );
                pst.setString(1, name);
                pst.setString(2, phone);
                pst.setDouble(3, Double.parseDouble(salary));
                pst.setInt(4, jobId);
                pst.executeUpdate();
                tableUpdate();
                JOptionPane.showMessageDialog(this, "Inserted");
            } else {
                pst = con.prepareStatement(
                        "INSERT INTO EMPLOYEEJOB(JOB_TITLE) VALUES (?)"
                );
                pst.setString(1, job.toLowerCase());
                pst.executeUpdate();
                pst = con.prepareStatement("SELECT JOB_ID FROM EMPLOYEEJOB WHERE JOB_TITLE = ?");
                pst.setString(1, job.toLowerCase());
                rs = pst.executeQuery();
                rs.next();
                jobId = rs.getInt("job_id");
                pst = con.prepareStatement(
                        "INSERT INTO EMPLOYEE (NAME, PHONENO,SALARY,JOB_ID) VALUES (?,?,?,?)"
                );
                pst.setString(1, name);
                pst.setString(2, phone);
                pst.setDouble(3, Double.parseDouble(salary));
                pst.setInt(4, jobId);
                pst.executeUpdate();
                tableUpdate();
                JOptionPane.showMessageDialog(this, "Inserted");
                empname.setText("");
                empphone.setText("");
                empjob.setText("");
                empsalary.setText("");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_InsertActionPerformed

    private void empnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empnameActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedindex = jTable1.getSelectedRow();
        empname.setText(model.getValueAt(selectedindex, 1).toString());
        empphone.setText(model.getValueAt(selectedindex, 2).toString());
        empsalary.setText(model.getValueAt(selectedindex, 3).toString());
        empjob.setText(model.getValueAt(selectedindex, 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        String name = empname.getText();
        String phone = empphone.getText();
        String salary = empsalary.getText();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedindex = jTable1.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedindex, 0).toString());
            pst = con.prepareStatement("UPDATE EMPLOYEE SET NAME =?, PHONENO =?, SALARY =? WHERE EMPLOYEE_ID = ?");
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setDouble(3, Double.parseDouble(salary));
            pst.setInt(4, id);
            pst.executeUpdate();
            tableUpdate();
            JOptionPane.showMessageDialog(this, "Updated");
            empname.setText("");
            empphone.setText("");
            empjob.setText("");
            empsalary.setText("");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedindex = jTable1.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedindex, 0).toString());
            pst = con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");
            pst.setInt(1, id);
            JOptionPane.showMessageDialog(this, "Deleted");
            empname.setText("");
            empphone.setText("");
            empjob.setText("");
            empsalary.setText("");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new emp().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Insert;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTextField empjob;
    private javax.swing.JTextField empname;
    private javax.swing.JTextField empphone;
    private javax.swing.JTextField empsalary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
