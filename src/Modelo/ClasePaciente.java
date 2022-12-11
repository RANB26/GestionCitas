
package Modelo;

import Modelo.Conexion;
import Vistas.FrmRegPaciente;
import javax.swing.JComboBox;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClasePaciente {
    
    private String IdPac;
    private String PacNomb;
    private String PacApe;
    
    Conexion con = new Conexion();

    public ClasePaciente(String IdPac, String PacNomb, String PacApe) {
        this.IdPac = IdPac;
        this.PacNomb = PacNomb;
        this.PacApe = PacApe;
    }
    
    public ClasePaciente() {
        
    }

    public String getIdPac() {
        return IdPac;
    }

    public void setIdPac(String IdPac) {
        this.IdPac = IdPac;
    }

    public String getPacNomb() {
        return PacNomb;
    }

    public void setPacNomb(String PacNomb) {
        this.PacNomb = PacNomb;
    }

    public String getPacApe() {
        return PacApe;
    }

    public void setPacApe(String PacApe) {
        this.PacApe = PacApe;
    }
    
    public void llenarComboPaciente(JComboBox<ClasePaciente>ComboPaciente){
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        String sql = "SELECT * FROM Paciente order by PacApellidos";
        
        ComboPaciente.removeAllItems();
        
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                ComboPaciente.addItem(new ClasePaciente(
                    rs.getString("idPaciente"),
                    rs.getString("PacNombre"),
                    rs.getString("PacApellidos")));
            }
        
        } catch(SQLException e){
            Logger.getLogger(ClasePaciente.class.getName()).log(Level.SEVERE,null,e);
        }   
        
    }
    
    @Override
    
    public String toString(){
        return PacNomb+ " "+PacApe;
    }
    
}
