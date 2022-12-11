
package Vistas;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class FrmRegConsultorio extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;

    void mostrarConsultorio(){
        
        String[] titulos = {"Codigo", "Nro Consultorio", "Descripción"};
        
        String [] registros = new String[3];
        
        String sql = "SELECT * FROM consultorio";
        modelo = new DefaultTableModel(null,titulos);
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registros[0] = rs.getString("idConsultorio");
                registros[1] = rs.getString("ConNumero");
                registros[2] = rs.getString("ConNombre");
                modelo.addRow(registros);
            }
            jTConsultorios.setModel(modelo);
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    void ajustarColumnas(){
        TableColumnModel columnModel = jTConsultorios.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(130);
        columnModel.getColumn(2).setPreferredWidth(170);
        
    }
    
    public FrmRegConsultorio() {
        initComponents();
        
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        mostrarConsultorio();
        ajustarColumnas();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNConsultorio = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtidConsultorio = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTConsultorios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "DETALLES DEL CONSULTORIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel1.setText("Nro de consultorio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel2.setText("Descripción");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txtNConsultorio.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtNConsultorio.setBorder(null);
        jPanel1.add(txtNConsultorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 56, 210, 20));

        txtDescripcion.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtDescripcion.setBorder(null);
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 310, 20));

        txtidConsultorio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(txtidConsultorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 14, 18));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 310, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 420, 170));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btnNuevo.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        btnModificar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 420, 70));

        jTConsultorios.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTConsultorios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTConsultorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTConsultoriosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTConsultorios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 312, 250));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 290));

        setBounds(400, 100, 799, 324);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
        txtNConsultorio.setText("");
        txtDescripcion.setText("");
        txtNConsultorio.requestFocus();
        txtidConsultorio.setVisible(false);
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO consultorio(ConNumero,ConNombre)VALUES(?,?)");
            
            pps.setString(1,txtNConsultorio.getText());
            pps.setString(2,txtDescripcion.getText());
            
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro Guardado");
            
            mostrarConsultorio();
            ajustarColumnas();
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmRegConsultorio.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jTConsultoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTConsultoriosMouseClicked
        
        int fila = jTConsultorios.getSelectedRow();
        
        if(fila>=0){
            
            txtidConsultorio.setText(jTConsultorios.getValueAt(fila,0).toString());
            
            txtNConsultorio.setText(jTConsultorios.getValueAt(fila,1).toString());
            txtDescripcion.setText(jTConsultorios.getValueAt(fila,2).toString());
        }else{
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún Registro");
        }
        
        btnRegistrar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txtidConsultorio.setVisible(true);
        
    }//GEN-LAST:event_jTConsultoriosMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        try{
            
            PreparedStatement pps = cn.prepareStatement("UPDATE consultorio SET "
            +"ConNumero='"+txtNConsultorio.getText()+"',"
            +"ConNombre='"+txtDescripcion.getText()+"' "
            +"WHERE idConsultorio='"+txtidConsultorio.getText()+"'");
            
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos del consultorio se han actualizado");
            mostrarConsultorio();
            ajustarColumnas();
            
        }catch(SQLException ex){
            Logger.getLogger(FrmRegConsultorio.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        int fila = jTConsultorios.getSelectedRow();
        String valor = jTConsultorios.getValueAt(fila, 0).toString();
        
        if (fila>=0){
            
            try{
                
                PreparedStatement pps = cn.prepareStatement("DELETE FROM consultorio WHERE idConsultorio='"+valor+"'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "El registro se ha eliminado");
                mostrarConsultorio();
                ajustarColumnas();
                txtNConsultorio.setText("");
                txtDescripcion.setText("");
                txtNConsultorio.requestFocus();
                txtidConsultorio.setVisible(false);
                btnRegistrar.setEnabled(true);
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
                
            
            }catch (SQLException ex) {
                
                Logger.getLogger(FrmRegConsultorio.class.getName()).log(Level.SEVERE,null,ex);
                
            }
            
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTConsultorios;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNConsultorio;
    private javax.swing.JLabel txtidConsultorio;
    // End of variables declaration//GEN-END:variables
}
