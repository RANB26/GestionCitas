
package Modelo;

import Modelo.Conexion;
import Vistas.FrmRegEmpleado;
import javax.swing.JComboBox;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClaseEmpleado {
    
    private String IdEmp;
    private String EmpNomb;
    private String EmpApe;
    
    Conexion con = new Conexion();

    public ClaseEmpleado(String IdEmp, String EmpNomb, String EmpApe) {
        this.IdEmp = IdEmp;
        this.EmpNomb = EmpNomb;
        this.EmpApe = EmpApe;
    }
    
    public ClaseEmpleado() {
        
    }

    public String getIdEmp() {
        return IdEmp;
    }

    public void setIdEmp(String IdEmp) {
        this.IdEmp = IdEmp;
    }

    public String getEmpNomb() {
        return EmpNomb;
    }

    public void setEmpNomb(String EmpNomb) {
        this.EmpNomb = EmpNomb;
    }

    public String getEmpApe() {
        return EmpApe;
    }

    public void setEmpApe(String EmpApe) {
        this.EmpApe = EmpApe;
    }
    
    public void llenarComboEmpleado(JComboBox<ClaseEmpleado>ComboEmpleado){
        
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        String sql = "SELECT * FROM empleado order by EmpApellidos";
        
        ComboEmpleado.removeAllItems();
        
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                ComboEmpleado.addItem(new ClaseEmpleado(
                    rs.getString("idEmpleado"),
                    rs.getString("EmpNombres"),
                    rs.getString("EmpApellidos")));
            }
        
        } catch(SQLException e){
            Logger.getLogger(ClaseEmpleado.class.getName()).log(Level.SEVERE,null,e);
        }   
        
    }
    
    @Override
    
    public String toString(){
        return EmpNomb+ " "+EmpApe;
    }
    
}
