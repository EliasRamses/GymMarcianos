/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import Mysql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author elias_villanueva
 */
public class TipoMembresia {
    private String Tipo;
    private int Costo;
    
    Conexion cn = new Conexion();
        Connection conexion = cn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql;
    
    public TipoMembresia(){
        Tipo = "";
        Costo = 0;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }
    
    public int obtenerCostoActual(){
        int Precio=0;
        try{  
              
               sql="select * from  tipo where id_tipo = 3";
               ps =  conexion.prepareStatement(sql);
               rs = ps.executeQuery();
              
               
                       if(rs.next()){

                          Precio  = rs.getInt(3);
                          //registros[1]  = String.valueOf(rs.getFloat(3));
                           System.out.println(""+Precio);
                          //JOptionPane.showMessageDialog(null,  "Membresia Encontrada");
                          return Precio;
                       }                                  

           }catch(SQLException ex){
               JOptionPane.showMessageDialog(null, ex.getMessage()+ "hola");
               System.out.println(""+ex.getMessage());
           }
        return Precio;
    }
}
