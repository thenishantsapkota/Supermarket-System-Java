/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package supermarket;

import SupermarketDatabase.SupermarketDatabaseHandler;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author snish
 */
public class SuperMarketHome extends javax.swing.JFrame {
    Connection con = null;
    CallableStatement csmt = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    /**
     * Creates new form SuperMarketHome
     */
    public SuperMarketHome() {
        initComponents();
        con = SupermarketDatabaseHandler.getConnection();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.setResizable(false);
        this.getFullName();
        this.getTotalEmployees();
        this.getTotalProducts();
   
    }
    
    private void getTotalProducts(){
        try{
            String query = "select count(*) from product_tbl";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next()){
                String count = String.valueOf(rs.getInt(1));
                totalProducts.setText("Total Products: " + count);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void getTotalEmployees(){
        try{
            String query = "select count(*) from employee_tbl";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next()){
                String count = String.valueOf(rs.getInt(1));
                totalEmployees.setText("Total Employees: " + count);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void getFullName(){
        try{
            String sql = "select * from register_tbl where is_logged_in=true";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                welcomeLabel.setText("Welcome" + " " + rs.getString("fname") + " " + rs.getString("lname") + "!");
                ps.close();
                rs.close();
            }else{
                profileButton.setEnabled(false);
                employeeButton.setEnabled(false);
                productsButton.setEnabled(false);
                welcomeLabel.setText("Welcome Guest User! Login to continue");
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        profileButton = new javax.swing.JButton();
        employeeButton = new javax.swing.JButton();
        productsButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        totalEmployees = new javax.swing.JButton();
        totalProducts = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel1.setText("Supermarket - Home");

        jPanel2.setBackground(new java.awt.Color(79, 55, 232));

        profileButton.setBackground(new java.awt.Color(79, 55, 232));
        profileButton.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        profileButton.setForeground(new java.awt.Color(255, 255, 255));
        profileButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\snish\\Downloads\\img_569204.png")); // NOI18N
        profileButton.setText("  Profile");
        profileButton.setContentAreaFilled(false);
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        employeeButton.setBackground(new java.awt.Color(79, 55, 232));
        employeeButton.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        employeeButton.setForeground(new java.awt.Color(255, 255, 255));
        employeeButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\snish\\Downloads\\255-2553833_employee-icon-png-white-employee-icon-png-transparent.png")); // NOI18N
        employeeButton.setText("  Employee");
        employeeButton.setContentAreaFilled(false);
        employeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeButtonActionPerformed(evt);
            }
        });

        productsButton.setBackground(new java.awt.Color(79, 55, 232));
        productsButton.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        productsButton.setForeground(new java.awt.Color(255, 255, 255));
        productsButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\snish\\Downloads\\Circle-icons-dolly.svg.png")); // NOI18N
        productsButton.setText("  Products");
        productsButton.setContentAreaFilled(false);
        productsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(79, 55, 232));
        logoutButton.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.setContentAreaFilled(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(employeeButton)
                            .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productsButton))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(employeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(productsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        welcomeLabel.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        welcomeLabel.setText("Welcome");

        totalEmployees.setBackground(new java.awt.Color(79, 55, 232));
        totalEmployees.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        totalEmployees.setForeground(new java.awt.Color(255, 255, 255));
        totalEmployees.setText("Total Employees");
        totalEmployees.setBorder(null);
        totalEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalEmployeesActionPerformed(evt);
            }
        });

        totalProducts.setBackground(new java.awt.Color(79, 55, 232));
        totalProducts.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        totalProducts.setForeground(new java.awt.Color(255, 255, 255));
        totalProducts.setText("Total Products");
        totalProducts.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(welcomeLabel)
                            .addGap(132, 132, 132)))
                    .addComponent(totalEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeLabel)
                .addGap(46, 46, 46)
                .addComponent(totalEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        try{
            String sql = "update register_tbl set is_logged_in=false where is_logged_in=true";
            ps = con.prepareStatement(sql);
            ps.execute();
            ps.close();
            new SuperMarketLogin().setVisible(true);
            this.setVisible(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        new SuperMarketProfile().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_profileButtonActionPerformed

    private void employeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeButtonActionPerformed
        this.setVisible(false);
        new SuperMarketEmployee().setVisible(true);
    }//GEN-LAST:event_employeeButtonActionPerformed

    private void productsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsButtonActionPerformed
        this.setVisible(false);
        new SuperMarketProducts().setVisible(true);
    }//GEN-LAST:event_productsButtonActionPerformed

    private void totalEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalEmployeesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalEmployeesActionPerformed

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
            java.util.logging.Logger.getLogger(SuperMarketHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuperMarketHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuperMarketHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuperMarketHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuperMarketHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton employeeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton productsButton;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton totalEmployees;
    private javax.swing.JButton totalProducts;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
