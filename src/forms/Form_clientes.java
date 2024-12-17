package forms;
import javax.swing.*;
import Mysql.*;//clase que me hace la conexion
import validaciones.*;//clase paera validar
import general.*;
import java.awt.Component;
import java.awt.TextField;
import java.io.Console;
import java.util.*;
import java.sql.*;


public class Form_clientes extends JFrame {
    
        Conexion cn = new Conexion();
        Connection conexion = cn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql;
        
        //variables
            private String cedula;
            private String nombres;
            private String apellidos;
            //private String dir;
           
            private String telefono;
            //private String celular;
            private String day,month,year;
            private String fecha_fin;
            String fecha_inicio2;
          
        //declaramos un objeto tipo cliente
            Cliente cliente = new  Cliente();
        //instacnceamos calsde ficha
          Ficha ficha = new Ficha();
          Membresia membresia = new Membresia();
          Pagos pagos = new Pagos();
          //Rutina rutinas =  new Rutina();
 
      public Form_clientes() {
            initComponents();
            setLocationRelativeTo(null);
        
        
            //para esconder los demas paneles
             this.panelPrincipal.setEnabledAt(1,false);
             //this.panelPrincipal.setEnabledAt(2,false);
             //this.panelPrincipal.setEnabledAt(3,false);
             //this.panelPrincipal.setEnabledAt(4,false);
             
                try{
                    
                    /*this.panelPrincipal.removeTabAt(1);
                    this.panelPrincipal.removeTabAt(1);
                    this.panelPrincipal.removeTabAt(1);*/

                }catch(Exception ex){
                   JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }  

        
        //para cargar el combo nivel con  rutinas que existen
           //cargarRutinas();
   
         
        //this.panelPrincipal.addTab("Datos Finales", spanel_finales);//para agregar
       
        //cargamos los datos de la tablam mebresia
        cargarMembresias();
        setTitle("Clientes");
        this.txt_cedula.requestFocus();
        //para limitar ingreso de caracteres en la cajas      
        this.txt_cedula.setDocument(new Validar(txt_cedula,10));
        this.txt_nombres.setDocument(new Validar(txt_nombres,35));
        this.txt_apellidos.setDocument(new Validar(txt_apellidos,40));
        //this.txt_dir.setDocument(new Validar(txt_dir,100));
        this.txt_telefono.setDocument(new Validar(txt_telefono,10));
        //this.txt_celular.setDocument(new Validar(txt_celular,10));
        this.txt_dias.setDocument(new Validar(txt_dias,3));

       /*this.txt_peso.setDocument(new Validar(txt_peso,3));
       this.txt_altura.setDocument(new Validar(txt_altura,3));
       this.txt_cintura.setDocument(new Validar(txt_cintura,3));
       this.txt_cuello.setDocument(new Validar(txt_cuello,3));
       this.txt_cadera.setDocument(new Validar(txt_cadera,3));*/
      
       
      //para centrar el texto de las cajas de texto 
        this.txt_costo.setHorizontalAlignment((int) TextField.CENTER_ALIGNMENT);
        this.txt_dias.setHorizontalAlignment((int) TextField.CENTER_ALIGNMENT);
  
      //para ocultar caja yl el label de los dias para para la membresia especial
        lbl_dias.setVisible(false);
        txt_dias.setVisible(false);
        
      //para ocultar caja para que ingresa medida de cadera 
        /*txt_cadera.setVisible(true);
        lbl_cadera.setVisible(false);*/
        
      //generamos los 100 años par el combo box de fecha de nacimiento
        for(int i=100;i>=1;i--){
            
            //cbo_year.addItem(1924 + i );
            cbo_years1.addItem(1924 + i );
        
        }
        
        
    }

      
      
      
  /*-----------------------------------------------------------------------------------
      metodo para limpiar cajas de texto
 -------------------------------------------------------------------------------------*/ 
      
 public void limpiar(){
      this.txt_cedula.setText("");
       this.txt_nombres.setText("");
       this.txt_apellidos.setText("");
       //this.txt_dir.setText("");
       this.txt_telefono.setText("");
       //this.txt_celular.setText("");
  }
 
 
 
 
 
/*-----------------------------------------------------------------------------------------------------------------------------------------
        Metodos cargar combo de rutinas existentes
 ------------------------------------------------------------------------------------------------------------------------------------------*/
 /*public void cargarRutinas(){
        
        try{
            
            sql = "select nivel from rutinas";
            
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
               // cbo_nivel.addItem(rs.getString("nivel"));
            }
        
        
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
            
        } 
        
 }//fin del metodo
 */
 
 
  /*-----------------------------------------------------------------------------------
      metodo cargar fecha de proximo pago 
 -------------------------------------------------------------------------------------*/ 
 public  void cargarProxPago(){
     
      day = this.cbo_days1.getSelectedItem().toString();
      month = String.valueOf(this.cbo_month1.getSelectedIndex() + 1);
      int year = Integer.parseInt(this.cbo_years1.getSelectedItem().toString());
      int month2 = Integer.parseInt(month);
      String membresia = cbo_membresia.getSelectedItem().toString();
      
      if(cbo_membresia.getSelectedIndex() > 0){
            //para pago anual
          if(membresia.equals("Anual")){
              
             year = Integer.parseInt(this.cbo_years1.getSelectedItem().toString()) + 1;
             this.txt_prox_pago.setText(day +"/"+ month+ "/"+ year);
             fecha_fin=year +"-"+ month2+ "-"+ day;
            
             
            //para pago semestral
         }else if(membresia.equals("Semestral")){
              
              for(int i=0;i<6;i++){
                   month2 = month2 + 1;
                  
                  if(month2 > 12){
                      month2 = 1 + 1;
                      year = Integer.parseInt(this.cbo_years1.getSelectedItem().toString()) + 1;
                  }
              }
               fecha_fin=year +"-"+ month2+ "-"+ day;
               this.txt_prox_pago.setText(day +"/"+ month2+ "/"+ year);
               
               
             //para pago   mensual
          }else if(membresia.equals("Mensual")){
                                       
                  if(month2 == 12){
                      month2 = 1;
                       year = Integer.parseInt(this.cbo_years1.getSelectedItem().toString()) + 1;
                       
                      fecha_fin=year +"-"+ month2+ "-"+ day;
                      this.txt_prox_pago.setText(day +"/"+ month2+ "/"+ year);
                                           
                  }else{
                         this.txt_prox_pago.setText(day +"/"+ (month2 +1 )+ "/"+ year);
                         fecha_fin=year +"-"+ (month2 + 1) + "-"+ day;
                 }
              //para pago diario
          }else if(membresia.equals("Diario")){
                fecha_fin=year +"-"+ month+ "-"+ day;
               this.txt_prox_pago.setText(day+"/"+month+"/"+year);
          }
          else if(membresia.equals("Especial") && !txt_dias.getText().equals("")){
                    
                     this.txt_dias.requestFocus();
               }       
       
      }

    
 }
 
 
   /*-----------------------------------------------------------------------------------
      metodo para cargar mmebresias
 -------------------------------------------------------------------------------------*/ 
 public void cargarMembresias(){
        try{
            sql = "select tipo , costo from tipo";
            
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                cbo_membresia.addItem( rs.getString("tipo")) ;  
                System.out.print("Membresia cargada");
            }
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(rootPane, ex.getMessage());
             System.out.print("Error al cargar membresias");
        }  
 }
 
 
       
       
 /*-----------------------------------------------------------------------------------
 $Clientes Codigo genrado por netbeans para la interfas
 -------------------------------------------------------------------------------------*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_sexo = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JTabbedPane();
        spanel_personales = new javax.swing.JScrollPane();
        panel_personales = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_siguiente = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btn_volver = new javax.swing.JButton();
        spanel_membresia = new javax.swing.JScrollPane();
        panel_membresia = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        lbl_dias = new javax.swing.JLabel();
        cbo_membresia = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        txt_dias = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txt_prox_pago = new javax.swing.JTextField();
        cbo_days1 = new javax.swing.JComboBox();
        cbo_month1 = new javax.swing.JComboBox();
        cbo_years1 = new javax.swing.JComboBox();
        btn_siguiente2 = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        txt_costo = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        txt_total_pagar = new javax.swing.JTextField();
        btn_limpiar42 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(new java.awt.Color(250, 250, 250));
        panelPrincipal.setForeground(new java.awt.Color(110, 110, 110));
        panelPrincipal.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        panelPrincipal.setAutoscrolls(true);
        panelPrincipal.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        panelPrincipal.setPreferredSize(new java.awt.Dimension(800, 600));

        spanel_personales.setBorder(null);
        spanel_personales.setPreferredSize(new java.awt.Dimension(800, 600));

        panel_personales.setBackground(new java.awt.Color(250, 250, 250));
        panel_personales.setToolTipText("");
        panel_personales.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_personales.setPreferredSize(new java.awt.Dimension(800, 900));
        panel_personales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(110, 110, 110));
        jLabel10.setText("Cédula:");
        panel_personales.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(110, 110, 110));
        jLabel11.setText("Nombre:");
        panel_personales.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(110, 110, 110));
        jLabel12.setText("Apellido:");
        panel_personales.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(110, 110, 110));
        jLabel13.setText("Teléfono:");
        panel_personales.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        txt_nombres.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_nombres.setForeground(new java.awt.Color(110, 110, 110));
        txt_nombres.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(202, 202, 202), 1, true));
        txt_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombresKeyTyped(evt);
            }
        });
        panel_personales.add(txt_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 200, 350, 39));

        txt_cedula.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_cedula.setForeground(new java.awt.Color(110, 110, 110));
        txt_cedula.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(202, 202, 202), 1, true));
        txt_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedulaActionPerformed(evt);
            }
        });
        txt_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cedulaKeyTyped(evt);
            }
        });
        panel_personales.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 140, 350, 39));

        txt_apellidos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_apellidos.setForeground(new java.awt.Color(110, 110, 110));
        txt_apellidos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(202, 202, 202), 1, true));
        txt_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidosKeyTyped(evt);
            }
        });
        panel_personales.add(txt_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 260, 350, 39));

        txt_telefono.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(110, 110, 110));
        txt_telefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(202, 202, 202), 1, true));
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        panel_personales.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 350, 39));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(110, 110, 110));
        jLabel18.setText("Datos Personales");
        panel_personales.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        btn_cancelar.setBackground(new java.awt.Color(0, 153, 204));
        btn_cancelar.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setBorder(null);
        btn_cancelar.setBorderPainted(false);
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        panel_personales.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 100, 40));

        btn_siguiente.setBackground(new java.awt.Color(0, 153, 204));
        btn_siguiente.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        btn_siguiente.setForeground(new java.awt.Color(255, 255, 255));
        btn_siguiente.setText("Siguiente");
        btn_siguiente.setBorder(null);
        btn_siguiente.setBorderPainted(false);
        btn_siguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_siguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_siguienteActionPerformed(evt);
            }
        });
        panel_personales.add(btn_siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 100, 40));

        btn_limpiar.setBackground(new java.awt.Color(0, 153, 204));
        btn_limpiar.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        btn_limpiar.setForeground(new java.awt.Color(255, 255, 255));
        btn_limpiar.setText("Limpiar");
        btn_limpiar.setBorder(null);
        btn_limpiar.setBorderPainted(false);
        btn_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        panel_personales.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 100, 40));

        jSeparator3.setBackground(new java.awt.Color(51, 204, 255));
        panel_personales.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 478, 12));

        btn_volver.setBackground(new java.awt.Color(250, 250, 250));
        btn_volver.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        btn_volver.setForeground(new java.awt.Color(110, 110, 110));
        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_home_64.png"))); // NOI18N
        btn_volver.setText("Volver");
        btn_volver.setAutoscrolls(true);
        btn_volver.setBorder(null);
        btn_volver.setBorderPainted(false);
        btn_volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_volver.setFocusPainted(false);
        btn_volver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_volver.setIconTextGap(-8);
        btn_volver.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_volver.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        panel_personales.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 30, 70, 90));

        spanel_personales.setViewportView(panel_personales);

        panelPrincipal.addTab("Datos personales", spanel_personales);

        spanel_membresia.setBorder(null);

        panel_membresia.setBackground(new java.awt.Color(250, 250, 250));
        panel_membresia.setPreferredSize(new java.awt.Dimension(800, 900));
        panel_membresia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(110, 110, 110));
        jLabel56.setText("Datos Personales");
        panel_membresia.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 50, -1, -1));

        lbl_dias.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lbl_dias.setForeground(new java.awt.Color(110, 110, 110));
        lbl_dias.setText("Días:");
        panel_membresia.add(lbl_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 50, -1));

        cbo_membresia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbo_membresia.setForeground(new java.awt.Color(110, 110, 110));
        cbo_membresia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elije membresia" }));
        cbo_membresia.setToolTipText("");
        cbo_membresia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbo_membresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_membresiaActionPerformed(evt);
            }
        });
        panel_membresia.add(cbo_membresia, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 160, 150, 43));

        jLabel57.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(110, 110, 110));
        jLabel57.setText("Costo:");
        panel_membresia.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 230, -1, -1));

        txt_dias.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txt_dias.setForeground(new java.awt.Color(110, 110, 110));
        txt_dias.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(202, 202, 202), 1, true));
        txt_dias.setDisabledTextColor(new java.awt.Color(0, 204, 255));
        txt_dias.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_diasInputMethodTextChanged(evt);
            }
        });
        txt_dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_diasActionPerformed(evt);
            }
        });
        txt_dias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_diasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_diasKeyTyped(evt);
            }
        });
        panel_membresia.add(txt_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 130, 40));

        jLabel59.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(110, 110, 110));
        jLabel59.setText("Fecha pago:");
        panel_membresia.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 291, -1, -1));

        jLabel60.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(110, 110, 110));
        jLabel60.setText("Proximo pago:");
        panel_membresia.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 361, 160, 30));

        txt_prox_pago.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txt_prox_pago.setForeground(new java.awt.Color(110, 110, 110));
        txt_prox_pago.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(202, 202, 202), 1, true));
        txt_prox_pago.setDisabledTextColor(new java.awt.Color(110, 110, 110));
        txt_prox_pago.setEnabled(false);
        txt_prox_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_prox_pagoActionPerformed(evt);
            }
        });
        panel_membresia.add(txt_prox_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 351, 350, 39));

        cbo_days1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbo_days1.setForeground(new java.awt.Color(110, 110, 110));
        cbo_days1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbo_days1.setToolTipText("");
        cbo_days1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbo_days1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_days1ActionPerformed(evt);
            }
        });
        panel_membresia.add(cbo_days1, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 281, 70, 33));

        cbo_month1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbo_month1.setForeground(new java.awt.Color(110, 110, 110));
        cbo_month1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cbo_month1.setToolTipText("");
        cbo_month1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbo_month1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_month1ActionPerformed(evt);
            }
        });
        panel_membresia.add(cbo_month1, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 281, -1, 33));

        cbo_years1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbo_years1.setForeground(new java.awt.Color(110, 110, 110));
        cbo_years1.setToolTipText("");
        cbo_years1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_years1ActionPerformed(evt);
            }
        });
        panel_membresia.add(cbo_years1, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 281, 73, 33));

        btn_siguiente2.setBackground(new java.awt.Color(0, 153, 204));
        btn_siguiente2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        btn_siguiente2.setForeground(new java.awt.Color(255, 255, 255));
        btn_siguiente2.setText("Finalizar");
        btn_siguiente2.setBorder(null);
        btn_siguiente2.setBorderPainted(false);
        btn_siguiente2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_siguiente2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_siguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_siguiente2ActionPerformed(evt);
            }
        });
        panel_membresia.add(btn_siguiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 510, 100, 40));

        btn_atras.setBackground(new java.awt.Color(0, 153, 204));
        btn_atras.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setText("Atrás");
        btn_atras.setBorder(null);
        btn_atras.setBorderPainted(false);
        btn_atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        panel_membresia.add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 510, 100, 40));

        jSeparator2.setBackground(new java.awt.Color(51, 204, 255));
        panel_membresia.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 110, 426, 10));

        txt_costo.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txt_costo.setForeground(new java.awt.Color(110, 110, 110));
        txt_costo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(202, 202, 202), 1, true));
        txt_costo.setDisabledTextColor(new java.awt.Color(110, 110, 110));
        txt_costo.setEnabled(false);
        panel_membresia.add(txt_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 220, 150, 39));

        jLabel71.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(110, 110, 110));
        jLabel71.setText("Membresia:");
        panel_membresia.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 170, 100, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(110, 110, 110));
        jLabel1.setText("MXN");
        panel_membresia.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 221, 74, 39));

        jLabel72.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(110, 110, 110));
        jLabel72.setText("Total a pagar:");
        panel_membresia.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 427, 160, 30));

        txt_total_pagar.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txt_total_pagar.setForeground(new java.awt.Color(110, 110, 110));
        txt_total_pagar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(202, 202, 202), 1, true));
        txt_total_pagar.setDisabledTextColor(new java.awt.Color(110, 110, 110));
        txt_total_pagar.setEnabled(false);
        panel_membresia.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 423, 350, 39));

        btn_limpiar42.setBackground(new java.awt.Color(0, 153, 204));
        btn_limpiar42.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        btn_limpiar42.setForeground(new java.awt.Color(255, 255, 255));
        btn_limpiar42.setText("Limpiar");
        btn_limpiar42.setBorder(null);
        btn_limpiar42.setBorderPainted(false);
        btn_limpiar42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_limpiar42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar42ActionPerformed(evt);
            }
        });
        panel_membresia.add(btn_limpiar42, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 510, 100, 40));

        spanel_membresia.setViewportView(panel_membresia);

        panelPrincipal.addTab("Datos Membresia", spanel_membresia);

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 991, 960));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        Home frm_home = new Home();
        frm_home.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

/*---------------------------------------------------------------------------------
    metodo para el boto limpiar
 -------------------------------------------------------------------------------------*/
    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar();
        this.txt_cedula.requestFocus();
    }//GEN-LAST:event_btn_limpiarActionPerformed

  /*---------------------------------------------------------------------------------
    metodo para el boton agregar usuario
 -------------------------------------------------------------------------------------*/
    
    private void btn_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_siguienteActionPerformed

        cedula = Validar.quitarEspaciosEnBlanco(txt_cedula);
        nombres= Validar.quitarEspaciosEnBlanco(txt_nombres);
        apellidos= Validar.quitarEspaciosEnBlanco(txt_apellidos);

        //quitamos espacios al inicio y al final de la cadena
        //dir = txt_dir.getText();
        telefono=Validar.quitarEspaciosEnBlanco(txt_telefono);
        //celular=Validar.quitarEspaciosEnBlanco(txt_celular);
        //verificar telefono

        /*dato importantisimoooooo jajaja por lo simple que es y lo mucho que demore en descubirlo el cadenaTexto.trim().length() > 0   en las cadenas verifica
        que asi se ponga espacios en blanco en una cadena  nos dara 0  por el contrario devolvera el largo de la cadena ya que si solo ponemos  cadenaTextp.lenght( )> 0 con
        espacios en blanco falla y nos devuelve el numero de caracteres en blanco que ingresemos */

        if(  cedula.length() > 0 && nombres.length() >  0 && apellidos.length() > 0
            && telefono.length() > 0  )
        {

            if(!nombres.matches("[A-Z-áéíóúÁÉÍÓÚ][a-zA-Z-áéíóúÁÉÍÓÚ]*\\D{2}")){
                JOptionPane.showMessageDialog(rootPane, "El nombre debe Empezar con mayúsculas y tener minimo 3 caracteres");
                txt_nombres.setText("");
                txt_nombres.requestFocus();

            }else if(!apellidos.matches("[A-Z-áéíóúÁÉÍÓÚ][a-zA-Z-áéíóúÁÉÍÓÚ]*\\D{2}")){
                JOptionPane.showMessageDialog(rootPane, "El apellido debe Empezar con mayúsculas y tener minimo 3 caracteres");
                txt_apellidos.setText("");
                txt_apellidos.requestFocus();

            }else if(telefono.length() < 7){
                JOptionPane.showMessageDialog(rootPane, "Número de telefono incorrecto");
                txt_telefono.setText("");
                txt_telefono.requestFocus();

            }
            else{

                //para guargar los que tenga en el combo
                /*if(this.radio_masculino.isSelected()){
                    cliente.setSexo( radio_masculino.getText());

                }else{
                    cliente.setSexo( radio_femenino.getText());
                }*/

                //fecha
                String day2,month2,year2;
                //day2 = this.cbo_day.getSelectedItem().toString();
                //month2 = String.valueOf(this.cbo_month.getSelectedIndex() + 1);
                //year2 = this.cbo_year.getSelectedItem().toString();

                if(!cedula.equals("")){

                    try {
                        sql = "select * from clientes where cedula = "+cedula+"";
                        ps = conexion.prepareStatement(sql);
                        rs = ps.executeQuery(sql);

                        if(rs.next()){
                            JOptionPane.showMessageDialog(rootPane, "El cliente con la cedula "+ rs.getString("cedula") + " ya existe");

                        }else{

                            cliente.setCi(Integer.parseInt(cedula));
                            cliente.setNombres(nombres);
                            cliente.setApellidos(apellidos);
                            //cliente.setDir(dir.trim());
                            //cliente.setFechaNacimiento(year2 + "-" + month2 + "-" + day2);
                            cliente.setTelefono(telefono);
                            //cliente.setCelular(celular);

                            //para mostra la caja cadera solo si sexp es femenino
                            if(cliente.getSexo().equals("Femenino")){
                             //   lbl_cadera.setVisible(true);
                                //txt_cadera.setVisible(true);
                            }else{
                              //  lbl_cadera.setVisible(false);
                               // txt_cadera.setVisible(false);
                            }

                            //JOptionPane.showMessageDialog(rootPane, "Todo ok " + cliente.getFechaNacimiento() +"  "+ cliente.getSexo() + " " + cliente.getDir());
                            //JOptionPane.showMessageDialog(rootPane, "Datos ingresados conexito");

                            this.panelPrincipal.setEnabledAt(0, false);
                            //this.panelPrincipal.setEnabledAt(1, true);
                            this.panelPrincipal.setSelectedIndex(1);

                            //panelPrincipal.setSelectedIndex(0);

                        }//fin de if par comprobar que no exista ya la cedula que se queire guardar

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }

                }else{

                    JOptionPane.showMessageDialog(rootPane, "cedula incorrecta");
                    txt_cedula.setText("");
                    txt_cedula.requestFocus();
                }//find del if y else para verficar que la cedula sea correcta

            }//find del if y else para verficar nombres,apellidos,telefonos

        }else{
            JOptionPane.showMessageDialog(rootPane, "Llene todos los campos");
        }//find del if y else para verficar que esten llenos todos los campos
    }//GEN-LAST:event_btn_siguienteActionPerformed

   /*---------------------------------------------------------------------------------
    metodo para cancelar
 -------------------------------------------------------------------------------------*/
    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        int confirm;

        confirm = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea cancelar accion");

        if(confirm == JOptionPane.YES_OPTION){
            limpiar();
            Home frm_home = new Home();
            frm_home.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        Validar.soloNumeros(evt);
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_apellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidosKeyTyped
        Validar.soloLetrasAcentos(evt);
    }//GEN-LAST:event_txt_apellidosKeyTyped

/*---------------------------------------------------------------------------------
    para no permitir letras en la caja de texto de cedula
 -------------------------------------------------------------------------------------*/
    private void txt_cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cedulaKeyTyped

        Validar.soloNumeros(evt);
    }//GEN-LAST:event_txt_cedulaKeyTyped

    private void txt_nombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombresKeyTyped
        Validar.soloLetrasAcentos(evt);
    }//GEN-LAST:event_txt_nombresKeyTyped

 /*-------------------------------------------------------------------------------------
       METODO LIMPIAR BOTONES
 -------------------------------------------------------------------------------------*/    
    private void btn_limpiar42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar42ActionPerformed

        cbo_membresia.setSelectedIndex(0);
        txt_costo.setText("");
        txt_prox_pago.setText("");
        lbl_dias.setVisible(false);
        txt_dias.setVisible(false);
    }//GEN-LAST:event_btn_limpiar42ActionPerformed

/*---------------------------------------------------------------------------------
   para obtener fechas de los cbo
 -------------------------------------------------------------------------------------*/    
    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        this.panelPrincipal.setEnabledAt(1,false);
        this.panelPrincipal.setEnabledAt(0,true);
        panelPrincipal.setSelectedIndex(0);
    }//GEN-LAST:event_btn_atrasActionPerformed

/*-------------------------------------------------------------------------------------
    metodo para el boton siguiente2 que sirve para guardar datos de la membresia y pago
 -------------------------------------------------------------------------------------*/

    private void btn_siguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_siguiente2ActionPerformed

        if(txt_costo.getText().length() >  0 && txt_prox_pago.getText().length() > 0 && txt_total_pagar.getText().length() > 0){

            month = String.valueOf(this.cbo_month1.getSelectedIndex() + 1);

            String mem = cbo_membresia.getSelectedItem().toString();
            float costo = Float.parseFloat(txt_costo.getText());
            float total = Float.parseFloat(txt_total_pagar.getText());
            String fecha_inicio = cbo_years1.getSelectedItem().toString() +"-"+ String.valueOf(this.cbo_month1.getSelectedIndex() + 1) + "-"+cbo_days1.getSelectedItem().toString();

            fecha_inicio2 = cbo_days1.getSelectedItem().toString() + "/"+String.valueOf(this.cbo_month1.getSelectedIndex() + 1) + "/"+cbo_years1.getSelectedItem().toString();

            if(!mem.equals("Especial") && txt_costo.toString().length() > 0
                && txt_total_pagar.toString().length() > 0 && !fecha_inicio.equals("")
                && cbo_membresia.getSelectedIndex() > 0){

                /*
                    sql = "select id_tipo from tipo where tipo = '"+mem+"'";

                    ps = conexion.prepareStatement(sql);
                    rs = ps.executeQuery(sql);

                    if(rs.next())
                    //membresia.setIdTipoMembresia(rs.getInt("id_tipo"));

                */

                //membresia.setFechaInicio(fecha_inicio);
                //membresia.setFechaFin(fecha_fin);
                //membresia.setAsistencias(0);
                //membresia.setDiasTotal(0);

                pagos.setCosto(costo);
                pagos.setTotal(total);

                //JOptionPane.showMessageDialog(rootPane, membresia.getIdTipoMembresia() +" - "+ membresia.getFechaInicio() +" - "+ membresia.getFechaFin());
                this.panelPrincipal.setEnabledAt(1, false);
                //this.panelPrincipal.setEnabledAt(2, true);
                panelPrincipal.setSelectedIndex(1);
                
                sql="insert into clientes(cedula,nombres,apellidos) values(?,?,?)";
        
                try
                {
                    ps = conexion.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(txt_cedula.getText()));
                    ps.setString(2,txt_nombres.getText());
                    ps.setString(3,txt_apellidos.getText());
                    //ps.setBlob(2,img, longitud);

                    int a  = ps.executeUpdate();
                    if(a > 0){
                        JOptionPane.showMessageDialog(null, "Cliente registrado con éxito");
                    }


                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }else if(mem.equals("Especial") && txt_costo.toString().length() > 0
                && txt_total_pagar.toString().length() > 0 && !fecha_inicio.equals("")
                && cbo_membresia.getSelectedIndex() > 0 && txt_dias.getText().toString().length() > 0 &&  Integer.parseInt(txt_dias.getText()) >  0
                && !txt_total_pagar.getText().equals("")){

                /*try{
                    sql = "select id_tipo from tipo where tipo = '"+mem+"'";
                    ps = conexion.prepareStatement(sql);
                    rs = ps.executeQuery(sql);

                    if(rs.next())
                    //membresia.setIdTipoMembresia(rs.getInt("id_tipo"));
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }*/

                //membresia.setFechaInicio(fecha_inicio);
                //membresia.setFechaFin(null);
                //membresia.setAsistencias(0);
                //membresia.setDiasTotal(Integer.parseInt(txt_dias.getText()));

                pagos.setCosto(costo);
                pagos.setTotal(total);

                this.panelPrincipal.setEnabledAt(1, false);
               //this.panelPrincipal.setEnabledAt(2, true);
                panelPrincipal.setSelectedIndex(1);

                //JOptionPane.showMessageDialog(rootPane, membresia.getIdTipoMembresia() +" - "+ membresia.getFechaInicio() +" - "+ membresia.getFechaFin()+ membresia.getDiasTotal());
                
                sql="insert into clientes(cedula,nombres,apellidos) values(?,?,?)";
        
                try
                {
                    ps = conexion.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(txt_cedula.getText()));
                    ps.setString(2,txt_nombres.getText());
                    ps.setString(3,txt_apellidos.getText());
                    //ps.setBlob(2,img, longitud);

                    int a  = ps.executeUpdate();
                    if(a > 0){
                        JOptionPane.showMessageDialog(null, "Rutina insertada con éxito");
                    }


                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
                
            }else{
                JOptionPane.showMessageDialog(rootPane, "Escoge una membresia y llena todos los campos");
            }

        }else{
            JOptionPane.showMessageDialog(rootPane, "Llena todos losc campos para continuar");

        }
    }//GEN-LAST:event_btn_siguiente2ActionPerformed

/*---------------------------------------------------------------------------------------------------------------
    metodo obtener mes del cbo años de la interfaz membresia
 --------------------------------------------------------------------------------------------------------------*/  
    private void cbo_years1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_years1ActionPerformed
        cargarProxPago();
    }//GEN-LAST:event_cbo_years1ActionPerformed

/*---------------------------------------------------------------------------------------------------------------
    metodo obtener mes del cbo_month de la interfaz membresia
 --------------------------------------------------------------------------------------------------------------*/     
    private void cbo_month1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_month1ActionPerformed

        cargarProxPago();
    }//GEN-LAST:event_cbo_month1ActionPerformed

/*---------------------------------------------------------------------------------
   para obtener fechas e los cbo
 -------------------------------------------------------------------------------------*/    
 
    private void cbo_days1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_days1ActionPerformed

        cargarProxPago();
    }//GEN-LAST:event_cbo_days1ActionPerformed

    private void txt_prox_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_prox_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_prox_pagoActionPerformed

    private void txt_diasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diasKeyTyped

        Validar.soloNumeros(evt);

        //JOptionPane.showMessageDialog(rootPane, "Datos ingresados conexito");
    }//GEN-LAST:event_txt_diasKeyTyped

/*-------------------------------------------------------------------------------------
       METODO CON EVENTO KEYRELEASED PARA CALCULAR VALOR A PAGAR EN MEBRESIA ESPECIAL
 -------------------------------------------------------------------------------------*/  
    private void txt_diasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diasKeyReleased
        if(!txt_dias.getText().equals("") && Integer.parseInt(txt_dias.getText()) > 0){

            float total;
            total =  Float.parseFloat(txt_costo.getText()) * Float.parseFloat(txt_dias.getText());
            this.txt_prox_pago.setText("Hasta agotar los " + txt_dias.getText() + " contratados");
            this.txt_total_pagar.setText(String.valueOf(total ));

        }
        else{
            this.txt_total_pagar.setText("");
            this.txt_prox_pago.setText("");
        }
    }//GEN-LAST:event_txt_diasKeyReleased

    private void txt_diasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diasActionPerformed

    private void txt_diasInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_diasInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diasInputMethodTextChanged

/*---------------------------------------------------------------------------------------------------------------
    metodo para saber que seleciona del combo box mwebresia el usuario y poder cargar el costo de la misma
 --------------------------------------------------------------------------------------------------------------*/
    private void cbo_membresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_membresiaActionPerformed
        if(cbo_membresia.getSelectedIndex() > 0){

            try{
                sql = "select costo from tipo where tipo = '"+cbo_membresia.getSelectedItem().toString()+"'";

                ps = conexion.prepareStatement(sql);
                rs = ps.executeQuery();
                if(rs.next()){
                    txt_costo.setText(String.valueOf(rs.getFloat("costo")));
                    txt_total_pagar.setText(String.valueOf(rs.getFloat("costo")));

                    if(cbo_membresia.getSelectedItem().toString().equals("Especial")){
                        lbl_dias.setVisible(true);
                        txt_dias.setVisible(true);
                        txt_total_pagar.setText("");
                        txt_prox_pago.setText("");
                        txt_dias.setText("");
                        txt_dias.requestFocus();

                    }else{
                        lbl_dias.setVisible(false);
                        txt_dias.setVisible(false);
                    }
                    cargarProxPago();
                }

            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
            //JOptionPane.showMessageDialog(rootPane, "elegiste la membresia "  + cbo_membresia.getSelectedItem().toString());        // TODO add your handling code here:
        }else{
            txt_dias.setText("");
            txt_costo.setText("");
            txt_prox_pago.setText("");
            txt_total_pagar.setText("");

        }
    }//GEN-LAST:event_cbo_membresiaActionPerformed

    private void txt_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedulaActionPerformed

    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    


    


    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_limpiar42;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.JButton btn_siguiente2;
    private javax.swing.JButton btn_volver;
    private javax.swing.ButtonGroup buttonGroup_sexo;
    private javax.swing.JComboBox cbo_days1;
    private javax.swing.JComboBox cbo_membresia;
    private javax.swing.JComboBox cbo_month1;
    private javax.swing.JComboBox cbo_years1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl_dias;
    private javax.swing.JTabbedPane panelPrincipal;
    private javax.swing.JPanel panel_membresia;
    private javax.swing.JPanel panel_personales;
    private javax.swing.JScrollPane spanel_membresia;
    private javax.swing.JScrollPane spanel_personales;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_costo;
    private javax.swing.JTextField txt_dias;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_prox_pago;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables
}
