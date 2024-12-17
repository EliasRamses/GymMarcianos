package Mysql;
import java.sql.*;
import javax.swing.*;


public class Conexion{
    
    Connection conectar = null;
    public Connection getConexion(){
        
        try{
        //Cargamos el Driver MySQL
           Class.forName("com.mysql.jdbc.Driver");//PARA LLAMAR AL DRIVER
           conectar = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_gymdatos","root","admin");//AGREAGAMOS DATOS DE NUETRA BASE DE DATOS Y USUARIO
           
           //JOptionPane.showMessageDialog(null, "Conexion con exito");
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null,"Sin Conexion "+e.getMessage());
        }
        return conectar;
    }
    
    

    
}
