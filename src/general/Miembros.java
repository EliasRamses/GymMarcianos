/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import Mysql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author elias_villanueva
 */
public class Miembros {
    private String Nombre;
    private String Apellido;
    private String FechaInicio;
    private boolean alCorriente;
    private int NoVisitas;
    
    //variables para los metodos
    Conexion cn = new Conexion();
        Connection conexion = cn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql;
    
   public Miembros(){
        String Nombre = "";
        String Apellido = "";
        String FechaInicio = "";
        boolean alCorriente = true;
        int NoVisitas = 0;
   }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public boolean isAlCorriente() {
        return alCorriente;
    }

    public void setAlCorriente(boolean alCorriente) {
        this.alCorriente = alCorriente;
    }

    public int getNoVisitas() {
        return NoVisitas;
    }

    public void setNoVisitas(int NoVisitas) {
        this.NoVisitas = NoVisitas;
    }
   
   public boolean setMiembro(){
   
       try{
                     
            sql = "insert into miembros(Nombre,Apellido,FechaInicio,AlCorriente,NoVisitas)"
                    + "values(?,?,?,?,?)";

        //vector para gurdar registros de la tabla

                      ps = conexion.prepareStatement(sql);
                        //mandamos los valores a ejecutar
                        //ps.setInt(1,this.getCi());
                        ps.setString(1, this.getNombre());
                        ps.setString(2, this.getApellido());
                        ps.setString(3, this.getFechaInicio());
                        ps.setBoolean(4, true);
                        ps.setInt(5,0);
                        
                        int n = ps.executeUpdate();
                        
                        if(n > 0){
                             JOptionPane.showMessageDialog(null, "Usuario guardado");
                             return true; 
                        }else{
                             return false;
                        }

          }catch(Exception ex){
              
             JOptionPane.showMessageDialog(null, ex.getMessage());
             return false;
          } 
       
   }
    
}
