
package Vistas;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrmLogin extends javax.swing.JFrame {

    void accesosistema(String Usuario, String Pass){
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        String cap="";
        String sql = "SELECT * FROM empleado WHERE EmpUsuario='"+Usuario+"' && EmpPassword='"+Pass+"'";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                cap = rs.getString("EmpTipoUsuario");
                if(cap.equals("Administrador")){
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(null, "BIENVENIDO '"+Usuario+"'");
                    FrmPrincipal Ventana = new FrmPrincipal();
                    Ventana.setVisible(true);
                    Ventana.pack();
                    Ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);      
                }
                else{
                    if(cap.equals("Moderado")){
                        this.setVisible(false);
                        JOptionPane.showMessageDialog(null, "BIENVENIDO '"+Usuario+"'");
                        FrmModerado Ventana = new FrmModerado();
                        Ventana.setVisible(true);
                        Ventana.pack();
                        Ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No existe este usuario");
                    }
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    public FrmLogin() {
        initComponents();
        
        setLocationRelativeTo(null);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        btnIniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 30)); // NOI18N
        jLabel5.setText("LOGIN");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 100, 30));

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setText("Usuario ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel4.setText("Contraseña ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(249, 249, 249));
        txtUsuario.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUsuario.setBorder(null);
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 208, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 208, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 208, 10));

        txtPassword.setBackground(new java.awt.Color(249, 249, 249));
        txtPassword.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPassword.setBorder(null);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 250, 170));

        btnIniciar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnIniciar.setText("INICIAR");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ray\\Documents\\SENA\\TECNÓLOGO\\Trimestre 4\\Programación\\JAVA\\Gestion de citas\\SESIÓN 11\\GestionCitas\\src\\Imagenes\\User.png")); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 60, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        
        String use = txtUsuario.getText();
        String pass= new String(txtPassword.getPassword());
        accesosistema(use,pass);
        
    }//GEN-LAST:event_btnIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
