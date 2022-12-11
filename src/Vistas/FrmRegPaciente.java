
package Vistas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import Modelo.Conexion;
import Modelo.Validacion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class FrmRegPaciente extends javax.swing.JInternalFrame {

    FileInputStream fis;
    int longitudbytes;
    
    DefaultTableModel modelo;
    
    void mostrarPaciente(){
        
        String[] titulos = {"Codigo", "Identificación", "Nombres", "Apellidos", "Fecha Nac", "Sexo"};
        
        String [] registros = new String[6];
        
        String sql = "SELECT * FROM paciente";
        modelo = new DefaultTableModel(null,titulos);
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registros[0] = rs.getString("idPaciente");
                registros[1] = rs.getString("PacIdentificacion");
                registros[2] = rs.getString("PacNombre");
                registros[3] = rs.getString("PacApellidos");
                registros[4] = rs.getString("PacFechaNac");
                registros[5] = rs.getString("PacSexo");
                modelo.addRow(registros);
            }
            jTPacientes.setModel(modelo);
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    void ajustarColumnas(){
        TableColumnModel columnModel = jTPacientes.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(130);
        columnModel.getColumn(2).setPreferredWidth(170);
        columnModel.getColumn(3).setPreferredWidth(170);
        columnModel.getColumn(4).setPreferredWidth(110);
        columnModel.getColumn(5).setPreferredWidth(120);
        
    }
    
    
    void mostrarFoto(){
        
        ImageIcon foto;
        InputStream is;
        
        try{
            String sql = "SELECT PacFoto FROM paciente WHERE IdPaciente="+txtidPaciente.getText();
            Conexion con=new Conexion();
            Connection cn=con.conexion();
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                is=rs.getBinaryStream(1);
                
                BufferedImage bi = ImageIO.read(is);
                foto=new ImageIcon(bi);
                
                Image img=foto.getImage();
                Image newimg=img.getScaledInstance(125, 160, java.awt.Image.SCALE_SMOOTH);
                
                ImageIcon newicon= new ImageIcon(newimg);
                lblFoto.setIcon(newicon);
            }   
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception: "+ex);
        }
        
    }
    
    void agregarImagen(){
        
        lblFoto.setIcon(null);
        JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado=j.showOpenDialog(null);
        
        if(estado==JFileChooser.APPROVE_OPTION){
            try{
                fis=new FileInputStream(j.getSelectedFile());
                this.longitudbytes=(int)j.getSelectedFile().length();
                try{
                    Image icono=ImageIO.read(j.getSelectedFile()).getScaledInstance
                    (lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);
                    lblFoto.setIcon(new ImageIcon(icono));
                    lblFoto.updateUI();
                }catch(IOException ex){
                    JOptionPane.showMessageDialog(rootPane, "Imagen: "+ex);
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
        }   
    }
    
    Validacion v = new Validacion();
    
    
    public FrmRegPaciente() {
        initComponents();
        
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        mostrarPaciente();
        ajustarColumnas();
        
        v.ValidarSoloLetras(txtNombres);
        v.ValidarSoloLetras(txtApellidos);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sexo = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        fechaNac = new com.toedter.calendar.JDateChooser();
        txtidPaciente = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTPacientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "DATOS DEL PACIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Emoji", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Sexo.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jRadioButton1.setText("Masculino");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        Sexo.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jRadioButton2.setText("Femenino");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 230, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel1.setText("Identificación");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel2.setText("Nombres");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setText("Apellidos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel4.setText("Fecha de nacimiento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        txtIdentificacion.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtIdentificacion.setBorder(null);
        jPanel1.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 141, 20));

        txtNombres.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtNombres.setBorder(null);
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 170, 20));

        txtApellidos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtApellidos.setBorder(null);
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 170, 20));

        fechaNac.setBackground(new java.awt.Color(255, 255, 255));
        fechaNac.setDateFormatString("YYYY/MM/dd");
        fechaNac.setName("fechaNac"); // NOI18N
        jPanel1.add(fechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 149, -1));

        txtidPaciente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(txtidPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 20, 22));

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 125, 160));

        btnCargar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnCargar.setText("CARGAR IMAGEN");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 170, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 170, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 340));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        btnNuevo.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        btnModificar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel3.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 470, 90));

        jTPacientes.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jTPacientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jTPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPacientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTPacientes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 10, 580, 449));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 470));

        setBounds(400, 100, 1104, 509);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        genero = "Femenino";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        genero = "Masculino";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO paciente(PacIdentificacion,PacNombre,PacApellidos,PacFechaNac,PacSexo,PacFoto)VALUES(?,?,?,?,?,?)");
            
            pps.setString(1,txtIdentificacion.getText());
            pps.setString(2,txtNombres.getText());
            pps.setString(3,txtApellidos.getText());
            
            
            pps.setString(4,((JTextField)fechaNac.getDateEditor().getUiComponent()).getText());
            pps.setString(5, genero);
            pps.setBinaryStream(6, fis,longitudbytes);
            
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro Guardado");
            
            mostrarPaciente();
            ajustarColumnas();
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmRegPaciente.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
        txtIdentificacion.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        fechaNac.setCalendar(null);
        Sexo.clearSelection();
        txtIdentificacion.requestFocus();
        txtidPaciente.setVisible(false);
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        lblFoto.setIcon(null);
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jTPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPacientesMouseClicked
        
        int fila = jTPacientes.getSelectedRow();
        
        if(fila>=0){
            
            txtidPaciente.setText(jTPacientes.getValueAt(fila,0).toString());
            
            txtIdentificacion.setText(jTPacientes.getValueAt(fila,1).toString());
            txtNombres.setText(jTPacientes.getValueAt(fila,2).toString());
            txtApellidos.setText(jTPacientes.getValueAt(fila,3).toString());
            fechaNac.setDate(Date.valueOf(jTPacientes.getValueAt(fila,4).toString()));
            
            if(jTPacientes.getValueAt(fila,5).toString().equals("Masculino")){
                jRadioButton1.setSelected(true);
                genero = "Masculino";
            }else{
                jRadioButton2.setSelected(true);
                genero = "Femenino";
            }
            
            btnRegistrar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            txtidPaciente.setVisible(true);
            mostrarFoto();
            
        }else{
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún Registro");
        }
        
    }//GEN-LAST:event_jTPacientesMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        try{
            
            PreparedStatement pps = cn.prepareStatement("UPDATE paciente SET "
            +"PacIdentificacion='"+txtIdentificacion.getText()+"',"
            +"PacNombre='"+txtNombres.getText()+"',"
            +"PacApellidos='"+txtApellidos.getText()+"',"
            +"PacSexo='"+ genero +"',"
            +"PacFechaNac='"+((JTextField)fechaNac.getDateEditor().getUiComponent()).getText()+"',"
            +"PacFoto='"+lblFoto.getIcon()+"' "
            +"WHERE idPaciente='"+txtidPaciente.getText()+"'");
            
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos del paciente se han actualizado");
            mostrarPaciente();
            ajustarColumnas();
            
        }catch(SQLException ex){
            Logger.getLogger(FrmRegPaciente.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        int fila = jTPacientes.getSelectedRow();
        String valor = jTPacientes.getValueAt(fila, 0).toString();
        
        if (fila>=0){
            
            try{
                
                PreparedStatement pps = cn.prepareStatement("DELETE FROM paciente WHERE idPaciente='"+valor+"'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "El registro se ha eliminado");
                mostrarPaciente();
                ajustarColumnas();
                txtIdentificacion.setText("");
                txtNombres.setText("");
                txtApellidos.setText("");
                fechaNac.setCalendar(null);
                Sexo.clearSelection();
                txtIdentificacion.requestFocus();
                txtidPaciente.setVisible(false);
                btnRegistrar.setEnabled(true);
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
                lblFoto.setIcon(null);
                
            
            }catch (SQLException ex) {
                
                Logger.getLogger(FrmRegPaciente.class.getName()).log(Level.SEVERE,null,ex);
                
            }
            
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        
        agregarImagen();
        
    }//GEN-LAST:event_btnCargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Sexo;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private com.toedter.calendar.JDateChooser fechaNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTPacientes;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JLabel txtidPaciente;
    // End of variables declaration//GEN-END:variables
    
    private String genero;

}
