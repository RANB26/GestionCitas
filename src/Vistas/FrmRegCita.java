
package Vistas;

import Modelo.ClasePaciente;
import Modelo.ClaseMedico;
import Modelo.ClaseConsultorio;
import Modelo.ClaseEmpleado;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrmRegCita extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmRegCita
     */
    public FrmRegCita() {
        initComponents();
        
        ClasePaciente pac = new ClasePaciente();
        pac.llenarComboPaciente(ComboPaciente);
        
        ClaseMedico med = new ClaseMedico();
        med.llenarComboMedico(ComboMedico);
        
        ClaseConsultorio con = new ClaseConsultorio();
        con.llenarComboConsultorio(ComboConsultorio);
        
        ClaseEmpleado emp = new ClaseEmpleado();
        emp.llenarComboEmpleado(ComboEmpleado);
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ComboPaciente = new javax.swing.JComboBox<>();
        ComboMedico = new javax.swing.JComboBox<>();
        ComboConsultorio = new javax.swing.JComboBox<>();
        ComboEmpleado = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        LblFecha = new rojeru_san.RSLabelFecha();
        LblHora = new rojeru_san.RSLabelHora();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel1.setText("GESTIONAR CITA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 6, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "DATOS DE LA CITA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel2.setText("Atendida por");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setText("Paciente");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel4.setText("Consultorio");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel5.setText("Observación");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel7.setText("Médico");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel9.setText("Estado");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        ComboPaciente.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jPanel2.add(ComboPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 190, -1));

        ComboMedico.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jPanel2.add(ComboMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 190, -1));

        ComboConsultorio.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jPanel2.add(ComboConsultorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 190, -1));

        ComboEmpleado.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jPanel2.add(ComboEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 190, -1));

        jRadioButton1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jRadioButton1.setText("Atendida");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jRadioButton2.setText("Asignada");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane1.setViewportView(txtObservacion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 340, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 410, 360));

        LblFecha.setFormato("YYYY/MM/dd");
        jPanel1.add(LblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 160, 30));
        jPanel1.add(LblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 140, 30));

        jPanel4.setBackground(new java.awt.Color(241, 241, 241));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jButton1.setText("DAR DE ALTA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jButton2.setText("REPROGRAMAR");
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jButton3.setText("SALIR");
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 80, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 140, 140));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 130, 130));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 40, 50));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 40, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        Estado = "Atendida";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        Estado = "Asignada";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String Paciente;
        Paciente = ComboPaciente.getItemAt(ComboPaciente.getSelectedIndex()).getIdPac();
        
        String Medico;
        Medico = ComboMedico.getItemAt(ComboMedico.getSelectedIndex()).getIdMed();
        
        String Empleado;
        Empleado = ComboEmpleado.getItemAt(ComboEmpleado.getSelectedIndex()).getIdEmp();
        
        String Consultorio;
        Consultorio = ComboConsultorio.getItemAt(ComboConsultorio.getSelectedIndex()).getIdCon();
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        
        try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO citas(CitFecha,CitHora,CitEstado,CitObservacion,idPaciente,idMedico,idEmpleado,idConsultorio)VALUES(?,?,?,?,?,?,?,?)");
            
            pps.setString(1,LblFecha.getFecha());
            pps.setString(2,LblHora.getHora());
            pps.setString(3,Estado);  
            pps.setString(4,txtObservacion.getText());
            pps.setString(5, Paciente);
            pps.setString(6, Medico);
            pps.setString(7, Empleado);
            pps.setString(8, Consultorio);

            
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"La cita ha sido asignada");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmRegCita.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ClaseConsultorio> ComboConsultorio;
    private javax.swing.JComboBox<ClaseEmpleado> ComboEmpleado;
    private javax.swing.JComboBox<ClaseMedico> ComboMedico;
    private javax.swing.JComboBox<ClasePaciente> ComboPaciente;
    private rojeru_san.RSLabelFecha LblFecha;
    private rojeru_san.RSLabelHora LblHora;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtObservacion;
    // End of variables declaration//GEN-END:variables
    private String Estado;
}