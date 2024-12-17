package general;
import javax.swing.*;



public class Membresia extends Cliente{
    
    //variables o propiedades de mi obejeto
    
    //private int id_tipo_membresia;
    private String Nombre;
    private String Apellido;
    private String fecha_inicio;
    private String fecha_fin;
    private int Total;
    //private int asistencias;
    //private int dias_total;
    
    //contructor de la clase 
    public Membresia(){
        Nombre = "";
        Apellido = "";
        fecha_inicio = "";
        fecha_fin = "";
        Total = 0;
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

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    
    
/*---------------------------------------------------------------------------------------------------------------------------------------
        insertar membresia
 ------------------------------------------------------------------------------------------------------------------------------------------*/
    public boolean setMembresia(String Nombre, String Apellido, String FechaInicio, String FechaFin, int Total){
            
        try{              
            sql = "insert into pagosmembresia(Nombre, Apellido, FechaInicio, FechaTermino, Total)"
                    + "values(?,?,?,?,?)";
                    //vector para gurdar registros de la tabla
                      ps = conexion.prepareStatement(sql);
                        //mandamos los valores a ejecutar
                        ps.setString(1,Nombre);
                        ps.setString(2,Apellido);
                        ps.setString(3,FechaInicio);
                        ps.setString(4,FechaFin);
                        ps.setInt(5, Total);
                        
                        int n = ps.executeUpdate();
                        
                        if(n > 0){
                             return true;   
                        }else{
                             return false;
                        }

          }catch(Exception ex){             
             JOptionPane.showMessageDialog(null, ex.getMessage());
             return false;
          }  
    
    }
    
    
    
    
    /*---------------------------------------------------------------------------------------------------------------------------------------
        cargar membresia su 
 ------------------------------------------------------------------------------------------------------------------------------------------*/
    
    public String[] buscarMembresia(int id){    
    
            String[] registros = new String[3];

           try{  
               sql="select * from  tipo where id_tipo = "+id+"";
               ps =  conexion.prepareStatement(sql);
               rs = ps.executeQuery();
              
               
                       if(rs.next()){

                          registros[0]  = rs.getString(2);
                          registros[1]  = String.valueOf(rs.getFloat(3));
                          
                          JOptionPane.showMessageDialog(null,  "Membresia Encontrada");
                          return registros;
                       }                                  

           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, ex.getMessage()+ "hola");
           } 
           JOptionPane.showMessageDialog(null, "Membresia con el id "+id+" no existe");
           return registros; 
        }
    
    
    
    
/*---------------------------------------------------------------------------------------------------------------------------------------
        Metodo para eliminar
 ------------------------------------------------------------------------------------------------------------------------------------------*/
    
    public void updaterMemebresia(int id,double costo){
        
       try{  
              
               sql="update tipo  set costo = "+costo+" where id_tipo = "+id+"";
               ps =  conexion.prepareStatement(sql);
               int a = ps.executeUpdate();
               if(a > 0){
                   
                   JOptionPane.showMessageDialog(null,"Precio Acualizado");               
               }else{
                       JOptionPane.showMessageDialog(null,"El precio no se pudo actualizar");               
               }
               
               
               
              
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, ex.getMessage()+ "hola");
           } 
        
    }
    
    
    
    
    
}
