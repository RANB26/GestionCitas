
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class FrmRegEmpleado extends javax.swing.JInternalFrame {
    
    FileInputStream fis;
    int longitudbytes;
    
    DefaultTableModel modelo;

    void mostrarEmpleado(){
        
        String[] titulos = {"Codigo", "Identificación", "Nombres", "Apellidos", "Usuario", "Contraseña", "Tipo de usuario"};
        
        String [] registros = new String[7];
        
        String sql = "SELECT * FROM empleado";
        modelo = new DefaultTableModel(null,titulos);
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registros[0] = rs.getString("idEmpleado");
                registros[1] = rs.getString("EmpIdentificacion");
                registros[2] = rs.getString("EmpNombres");
                registros[3] = rs.getString("EmpApellidos");
                registros[4] = rs.getString("EmpUsuario");
                registros[5] = rs.getString("EmpPassword");
                registros[6] = rs.getString("EmpTipoUsuario");
                modelo.addRow(registros);
            }
            jTEmpleados.setModel(modelo);
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    void ajustarColumnas(){
        TableColumnModel columnModel = jTEmpleados.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(130);
        columnModel.getColumn(2).setPreferredWidth(170);
        columnModel.getColumn(3).setPreferredWidth(170);
        columnModel.getColumn(4).setPreferredWidth(120);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(150);
        
    }
    
    void mostrarFoto(){
        
        ImageIcon foto;
        InputStream is;
        
        try{
            String sql = "SELECT EmpFoto FROM empleado WHERE IdEmpleado="+txtidEmpleado.getText();
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
    
    public FrmRegEmpleado() {
        initComponents();
        
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        mostrarEmpleado();
        ajustarColumnas();
        
        v.ValidarSoloLetras(txtNombres);
        v.ValidarSoloLetras(txtApellidos);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContra = new javax.swing.JPasswordField();
        txtidEmpleado = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        ComboTipoUsuario = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTEmpleados = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "DATOS DEL EMPLEADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel1.setText("Identificación");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        txtIdentificacion.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtIdentificacion.setBorder(null);
        jPanel1.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 132, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel2.setText("Nombres");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtNombres.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtNombres.setBorder(null);
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 190, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setText("Apellidos ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 24, -1, -1));

        txtApellidos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtApellidos.setBorder(null);
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 190, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel6.setText("Usuario ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel7.setText("Tipo de usuario");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 20));

        txtUsuario.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtUsuario.setBorder(null);
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 190, -1));

        txtContra.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtContra.setBorder(null);
        jPanel1.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 190, -1));

        txtidEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(txtidEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 25, 22));

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 125, 160));

        btnCargar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnCargar.setText("CARGAR IMAGEN");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 190, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 130, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 190, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 190, 10));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 190, 10));

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel8.setText("Contraseña");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        ComboTipoUsuario.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        ComboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Administrador", "Moderado" }));
        jPanel1.add(ComboTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 420));

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
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        btnNuevo.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        btnModificar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 100, -1));

        btnEliminar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 470, 90));

        jTEmpleados.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jTEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jTEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTEmpleados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 10, 620, 520));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 540));

        setBounds(400, 200, 1151, 578);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO empleado(EmpIdentificacion,EmpNombres,EmpApellidos,EmpUsuario,EmpPassword,EmpFoto, EmpTipoUsuario)VALUES(?,?,?,?,?,?,?)");
            
            pps.setString(1,txtIdentificacion.getText());
            pps.setString(2,txtNombres.getText());
            pps.setString(3,txtApellidos.getText());
            pps.setString(4,txtUsuario.getText());
            pps.setString(5,txtContra.getText());
            pps.setBinaryStream(6, fis,longitudbytes);
            pps.setString(7, (String) ComboTipoUsuario.getSelectedItem());
            
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro Guardado");
            
            mostrarEmpleado();
            ajustarColumnas();
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmRegEmpleado.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
        txtIdentificacion.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtUsuario.setText("");
        txtContra.setText("");
        ComboTipoUsuario.setSelectedIndex(0);
        txtIdentificacion.requestFocus();
        txtidEmpleado.setVisible(false);
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        lblFoto.setIcon(null);
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jTEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEmpleadosMouseClicked
        
        int fila = jTEmpleados.getSelectedRow();
        
        if(fila>=0){
            
            txtidEmpleado.setText(jTEmpleados.getValueAt(fila,0).toString());
            
            txtIdentificacion.setText(jTEmpleados.getValueAt(fila,1).toString());
            txtNombres.setText(jTEmpleados.getValueAt(fila,2).toString());
            txtApellidos.setText(jTEmpleados.getValueAt(fila,3).toString());
            txtUsuario.setText(jTEmpleados.getValueAt(fila,4).toString());
            txtContra.setText(jTEmpleados.getValueAt(fila,5).toString());
            ComboTipoUsuario.setSelectedItem(jTEmpleados.getValueAt(fila,6).toString());
        }else{
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún Registro");
        }
        
        btnRegistrar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txtidEmpleado.setVisible(true);
        mostrarFoto();
        
    }//GEN-LAST:event_jTEmpleadosMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        try{
            
            PreparedStatement pps = cn.prepareStatement("UPDATE empleado SET "
            +"EmpIdentificacion='"+txtIdentificacion.getText()+"',"
            +"EmpNombres='"+txtNombres.getText()+"',"
            +"EmpApellidos='"+txtApellidos.getText()+"',"
            +"EmpUsuario='"+txtUsuario.getText()+"',"
            +"EmpPassword='"+txtContra.getText()+"',"
            +"EmpTipoUsuario='"+ComboTipoUsuario.getSelectedItem()+"' "
            +"WHERE idEmpleado='"+txtidEmpleado.getText()+"'");
            
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos del empleado se han actualizado");
            mostrarEmpleado();
            ajustarColumnas();
            
        }catch(SQLException ex){
            Logger.getLogger(FrmRegEmpleado.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        int fila = jTEmpleados.getSelectedRow();
        String valor = jTEmpleados.getValueAt(fila, 0).toString();
        
        if (fila>=0){
            
            try{
                
                PreparedStatement pps = cn.prepareStatement("DELETE FROM empleado WHERE idEmpleado='"+valor+"'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "El registro se ha eliminado");
                mostrarEmpleado();
                ajustarColumnas();
                txtIdentificacion.setText("");
                txtNombres.setText("");
                txtApellidos.setText("");
                txtUsuario.setText("");
                txtContra.setText("");
                ComboTipoUsuario.setSelectedIndex(0);
                txtIdentificacion.requestFocus();
                txtidEmpleado.setVisible(false);
                btnRegistrar.setEnabled(true);
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
                lblFoto.setIcon(null);
                
            
            }catch (SQLException ex) {
                
                Logger.getLogger(FrmRegEmpleado.class.getName()).log(Level.SEVERE,null,ex);
                
            }
            
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        
        agregarImagen();
        
    }//GEN-LAST:event_btnCargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboTipoUsuario;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTEmpleados;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel txtidEmpleado;
    // End of variables declaration//GEN-END:variables
}
