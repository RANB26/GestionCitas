
package Modelo;

import Modelo.Conexion;
import Vistas.FrmRegMedico;
import javax.swing.JComboBox;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClaseMedico {
    
    private String IdMed;
    private String MedNomb;
    private String MedApe;
    
    Conexion con = new Conexion();

    public ClaseMedico(String IdMed, String MedNomb, String MedApe) {
        this.IdMed = IdMed;
        this.MedNomb = MedNomb;
        this.MedApe = MedApe;
    }
    
    public ClaseMedico() {
        
    }

    public String getIdMed() {
        return IdMed;
    }

    public void setIdMed(String IdMed) {
        this.IdMed = IdMed;
    }

    public String getMedNomb() {
        return MedNomb;
    }

    public void setMedNomb(String MedNomb) {
        this.MedNomb = MedNomb;
    }

    public String getMedApe() {
        return MedApe;
    }

    public void setMedApe(String MedApe) {
        this.MedApe = MedApe;
    }
    
    public void llenarComboMedico(JComboBox<ClaseMedico>ComboMedico){
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        String sql = "SELECT * FROM medico order by MedApellidos";
        
        ComboMedico.removeAllItems();
        
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                ComboMedico.addItem(new ClaseMedico(
                    rs.getString("idMedico"),
                    rs.getString("MedNombres"),
                    rs.getString("MedApellidos")));
            }
        
        } catch(SQLException e){
            Logger.getLogger(ClaseMedico.class.getName()).log(Level.SEVERE,null,e);
        }   
        
    }
    
    @Override
    
    public String toString(){
        return MedNomb+ " "+MedApe;
    }
    
}
