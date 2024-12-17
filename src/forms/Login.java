package forms;

import Mysql.Conexion;
import Mysql.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import validaciones.Validar;
import general.User;



public class Login extends javax.swing.JFrame {
    
  /*/instanceamos una clase tipo user como estatica y para poder leer desde otro form su oontenido*/
    static User usuario = new User();

 
    public Login() {
        initComponents();
         setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_bienvenido = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        lbl_iconkey = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();
        lbl_pass = new javax.swing.JLabel();
        btn_ingresar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        lbl_bienvenido.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        lbl_bienvenido.setForeground(new java.awt.Color(51, 204, 0));
        lbl_bienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_bienvenido.setText("Iniciar Sesión");

        txt_usuario.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(110, 110, 110));
        txt_usuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(202, 202, 202), 1, true));
        txt_usuario.setDisabledTextColor(new java.awt.Color(0, 153, 255));

        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_person_24.png"))); // NOI18N

        lbl_iconkey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_lock_24.png"))); // NOI18N

        lbl_user.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(255, 255, 255));
        lbl_user.setText("Usuario:");

        lbl_pass.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_pass.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pass.setText("Contraseña:");

        btn_ingresar.setBackground(new java.awt.Color(51, 204, 0));
        btn_ingresar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btn_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ingresar.setText("Ingresar");
        btn_ingresar.setBorder(null);
        btn_ingresar.setBorderPainted(false);
        btn_ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });

        btn_salir.setBackground(new java.awt.Color(51, 153, 255));
        btn_salir.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(255, 255, 255));
        btn_salir.setText("Salir");
        btn_salir.setBorder(null);
        btn_salir.setBorderPainted(false);
        btn_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_user)
                    .addComponent(lbl_pass)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_iconkey)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(lbl_bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbl_bienvenido)
                .addGap(18, 18, 18)
                .addComponent(lbl_user)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_pass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_iconkey, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 600, 400);

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        int confirm;

        confirm = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea salir del programa");

        if(confirm == JOptionPane.YES_OPTION){
            System.exit(0);
        }

    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed

        //Conexion cn = new Conexion();
        //ConexionMySQL cn = new ConexionMySQL();
        ConexionMySQL cn = new ConexionMySQL();
        Connection conexion = cn.conectarMySQL();
        PreparedStatement ps;
        ResultSet rs;
        String sql,user,pass,result_tipo;
        
        
       

        user = Validar.quitarEspaciosEnBlanco(txt_usuario);
        pass = Validar.quitarEspaciosEnBlanco(txt_password);
        sql = "select * from users where usuario = '"+user+"' and  password = '"+pass+"'";

        if(user.length() > 0 && pass.length() > 0){
            try{

                ps = conexion.prepareStatement(sql);
                rs = ps.executeQuery(sql);

                if(rs.next()){
                    result_tipo = rs.getString("tipo");
                    usuario.setTipo(result_tipo); //primero guardamos el usuario 
                    //Home frm_home = new Home();//luego llamamos el metodo de home
                    HomeGym frm_home = new HomeGym();
                    
                    if(result_tipo.equalsIgnoreCase("administrador")){
                        //JOptionPane.showMessageDialog(this, "Login correcto");
                         
                        //frm_home.lbl_result_tipo.setText(result_tipo);
                        frm_home.lbl_UserName.setText(user);
                        
                       
                        setVisible(false);
                        frm_home.setVisible(true);
                        
                                                

                    }else{
                        //JOptionPane.showMessageDialog(this, "Login correcto");
                         
                        //frm_home.lbl_result_tipo.setText(result_tipo);
                        //frm_home.lbl_result_user.setText(user); 
                        
                       
                        setVisible(false);
                        frm_home.setVisible(true);
                         
                         
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña no existen");
                    txt_usuario.setText("");
                    txt_password.setText("");
                    txt_usuario.requestFocus();
                }

            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }

        }else{
            JOptionPane.showMessageDialog(null,"No puedes dejar las cajas vacias. Ingresa tus datos");
            txt_usuario.setText("");
            txt_password.setText("");
            txt_usuario.requestFocus();
        }

    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_bienvenido;
    private javax.swing.JLabel lbl_iconkey;
    private javax.swing.JLabel lbl_pass;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
