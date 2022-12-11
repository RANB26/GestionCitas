
package Modelo;

import Modelo.Conexion;
import Vistas.FrmRegConsultorio;
import javax.swing.JComboBox;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClaseConsultorio {
    
    private String IdCon;
    private String ConNum;
    
    Conexion con = new Conexion();

    public ClaseConsultorio(String IdCon, String ConNum) {
        this.IdCon = IdCon;
        this.ConNum = ConNum;
    }
    
    public ClaseConsultorio() {
        
    }

    public String getIdCon() {
        return IdCon;
    }

    public void setIdCon(String IdCon) {
        this.IdCon = IdCon;
    }

    public String getConNum() {
        return ConNum;
    }

    public void setConNum(String ConNum) {
        this.ConNum = ConNum;
    }
    
    public void llenarComboConsultorio(JComboBox<ClaseConsultorio>ComboConsultorio){
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        String sql = "SELECT * FROM consultorio order by ConNumero";
        
        ComboConsultorio.removeAllItems();
        
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                ComboConsultorio.addItem(new ClaseConsultorio(
                    rs.getString("idConsultorio"),
                    rs.getString("ConNumero")));
            }
        
        } catch(SQLException e){
            Logger.getLogger(ClaseConsultorio.class.getName()).log(Level.SEVERE,null,e);
        }   
        
    }
    
    @Override
    
    public String toString(){
        return ConNum;
    }
    
}
