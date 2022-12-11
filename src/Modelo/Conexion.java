
package Modelo;

import java.sql.*;
import javax.swing.*;

public class Conexion {
    
    Connection conect = null;
    public Connection conexion(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conect = DriverManager.getConnection("jdbc:mysql://localhost/gestion_citas","root","Sena2022");
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Error"+ e);
        }
        return conect;
    }
    
    public static void main(String[] args){
        
    }
    
        
}
