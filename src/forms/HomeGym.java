/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import com.sun.tools.javac.comp.Todo;
import general.Membresia;
import general.Miembros;
import general.TipoMembresia;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author elias_villanueva
 */
public class HomeGym extends javax.swing.JFrame{

    /**
     * Creates new form NewJFramegym
     */

    public int CostoMembresia;
    
    public Calendar date;
    public int horas;
    public int minutos;
    public int segundos;

    public HomeGym() {
        initComponents();
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        //String timeStampBD = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        lbl_FechaActual.setText(timeStamp);
        
        Panel_AddUser.setVisible(false);
        
        TipoMembresia tipoMembresia = new TipoMembresia();
        tipoMembresia.setTipo("Mensual");
        CostoMembresia = tipoMembresia.obtenerCostoActual();
        lbl_CostoActual.setText("$"+CostoMembresia+".00");
        
        //setLocationRelativeTo(null);//para centrar la ventana
        //setVisible(true);
        
        Thread r = new Thread();
        r.start();
       
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_General = new javax.swing.JPanel();
        jPanel_Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_Home = new javax.swing.JButton();
        btn_AddUser = new javax.swing.JButton();
        bnt_InsertAsistencia = new javax.swing.JButton();
        bnt_InsertMensauelida = new javax.swing.JButton();
        btn_SearchUser = new javax.swing.JButton();
        btn_CloseSesion = new javax.swing.JButton();
        lbl_UserName = new javax.swing.JLabel();
        jPanel_Rigth = new javax.swing.JPanel();
        Panel_Main = new javax.swing.JPanel();
        lbl_Nombre1 = new javax.swing.JLabel();
        lbl_Appelido1 = new javax.swing.JLabel();
        lbl_Fecha1 = new javax.swing.JLabel();
        lbl_TotalCosto1 = new javax.swing.JLabel();
        lbl_Hora = new javax.swing.JLabel();
        lbl_RegistrarNuevo2 = new javax.swing.JLabel();
        Panel_AddUser = new javax.swing.JPanel();
        lbl_Nombre = new javax.swing.JLabel();
        lbl_Appelido = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        lbl_FechaActual = new javax.swing.JLabel();
        lbl_Fecha = new javax.swing.JLabel();
        btn_SaveMember = new javax.swing.JButton();
        lbl_TotalCosto = new javax.swing.JLabel();
        lbl_CostoActual = new javax.swing.JLabel();
        lbl_RegistrarNuevo = new javax.swing.JLabel();
        btn_CloseMain = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        jPanel_General.setBackground(new java.awt.Color(0, 0, 0));

        jPanel_Left.setBackground(new java.awt.Color(51, 51, 51));
        jPanel_Left.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GYM");
        jLabel1.setToolTipText("");
        jPanel_Left.add(jLabel1);
        jLabel1.setBounds(0, 60, 257, 25);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Marciano's");
        jLabel2.setToolTipText("");
        jPanel_Left.add(jLabel2);
        jLabel2.setBounds(0, 20, 257, 37);

        btn_Home.setBackground(new java.awt.Color(51, 51, 51));
        btn_Home.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btn_Home.setForeground(new java.awt.Color(255, 255, 255));
        btn_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/hogar_32.png"))); // NOI18N
        btn_Home.setText("Pantalla Principal");
        btn_Home.setToolTipText("");
        btn_Home.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btn_Home.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Home.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Home.setIconTextGap(20);
        btn_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HomeActionPerformed(evt);
            }
        });
        jPanel_Left.add(btn_Home);
        btn_Home.setBounds(0, 160, 260, 50);

        btn_AddUser.setBackground(new java.awt.Color(51, 51, 51));
        btn_AddUser.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btn_AddUser.setForeground(new java.awt.Color(255, 255, 255));
        btn_AddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar-usuario_32.png"))); // NOI18N
        btn_AddUser.setText("Agregar Usuario");
        btn_AddUser.setToolTipText("");
        btn_AddUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btn_AddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_AddUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_AddUser.setIconTextGap(20);
        btn_AddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddUserActionPerformed(evt);
            }
        });
        jPanel_Left.add(btn_AddUser);
        btn_AddUser.setBounds(0, 220, 260, 50);

        bnt_InsertAsistencia.setBackground(new java.awt.Color(51, 51, 51));
        bnt_InsertAsistencia.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        bnt_InsertAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        bnt_InsertAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar_32.png"))); // NOI18N
        bnt_InsertAsistencia.setText("Registrar Asistencia");
        bnt_InsertAsistencia.setToolTipText("");
        bnt_InsertAsistencia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        bnt_InsertAsistencia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bnt_InsertAsistencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bnt_InsertAsistencia.setIconTextGap(20);
        bnt_InsertAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_InsertAsistenciaActionPerformed(evt);
            }
        });
        jPanel_Left.add(bnt_InsertAsistencia);
        bnt_InsertAsistencia.setBounds(0, 280, 260, 50);

        bnt_InsertMensauelida.setBackground(new java.awt.Color(51, 51, 51));
        bnt_InsertMensauelida.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        bnt_InsertMensauelida.setForeground(new java.awt.Color(255, 255, 255));
        bnt_InsertMensauelida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/monedas_32.png"))); // NOI18N
        bnt_InsertMensauelida.setText("Registrar Mensualidad");
        bnt_InsertMensauelida.setToolTipText("");
        bnt_InsertMensauelida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        bnt_InsertMensauelida.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bnt_InsertMensauelida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bnt_InsertMensauelida.setIconTextGap(20);
        bnt_InsertMensauelida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_InsertMensauelidaActionPerformed(evt);
            }
        });
        jPanel_Left.add(bnt_InsertMensauelida);
        bnt_InsertMensauelida.setBounds(0, 340, 260, 50);

        btn_SearchUser.setBackground(new java.awt.Color(51, 51, 51));
        btn_SearchUser.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btn_SearchUser.setForeground(new java.awt.Color(255, 255, 255));
        btn_SearchUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/busqueda_32.png"))); // NOI18N
        btn_SearchUser.setText("Buscar Usuario");
        btn_SearchUser.setToolTipText("");
        btn_SearchUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btn_SearchUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_SearchUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_SearchUser.setIconTextGap(20);
        btn_SearchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchUserActionPerformed(evt);
            }
        });
        jPanel_Left.add(btn_SearchUser);
        btn_SearchUser.setBounds(0, 400, 260, 50);

        btn_CloseSesion.setBackground(new java.awt.Color(102, 0, 51));
        btn_CloseSesion.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btn_CloseSesion.setForeground(new java.awt.Color(255, 255, 255));
        btn_CloseSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salida_24.png"))); // NOI18N
        btn_CloseSesion.setText("Cerrar Sesión");
        btn_CloseSesion.setToolTipText("");
        btn_CloseSesion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btn_CloseSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_CloseSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_CloseSesion.setIconTextGap(20);
        btn_CloseSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CloseSesionActionPerformed(evt);
            }
        });
        jPanel_Left.add(btn_CloseSesion);
        btn_CloseSesion.setBounds(0, 650, 260, 50);

        lbl_UserName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_UserName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_UserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_UserName.setText("Name");
        jPanel_Left.add(lbl_UserName);
        lbl_UserName.setBounds(0, 620, 260, 20);

        jPanel_Rigth.setBackground(new java.awt.Color(51, 51, 51));

        Panel_Main.setBackground(new java.awt.Color(51, 51, 51));
        Panel_Main.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel_Main.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbl_Nombre1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Nombre1.setText("Nombre");
        lbl_Nombre1.setMaximumSize(new java.awt.Dimension(90, 30));

        lbl_Appelido1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Appelido1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Appelido1.setText("Apellido");
        lbl_Appelido1.setPreferredSize(new java.awt.Dimension(90, 30));

        lbl_Fecha1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Fecha1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Fecha1.setText("Fecha");
        lbl_Fecha1.setPreferredSize(new java.awt.Dimension(90, 30));

        lbl_TotalCosto1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_TotalCosto1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TotalCosto1.setText("Total");
        lbl_TotalCosto1.setPreferredSize(new java.awt.Dimension(90, 30));

        lbl_Hora.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lbl_Hora.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Hora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_Hora.setText("00:00");
        lbl_Hora.setToolTipText("");

        lbl_RegistrarNuevo2.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lbl_RegistrarNuevo2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_RegistrarNuevo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_RegistrarNuevo2.setText("Pantalla Principal");
        lbl_RegistrarNuevo2.setToolTipText("");

        javax.swing.GroupLayout Panel_MainLayout = new javax.swing.GroupLayout(Panel_Main);
        Panel_Main.setLayout(Panel_MainLayout);
        Panel_MainLayout.setHorizontalGroup(
            Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_MainLayout.createSequentialGroup()
                .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_MainLayout.createSequentialGroup()
                        .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_MainLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(lbl_Fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_MainLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_TotalCosto1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_Appelido1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_Nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 824, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_MainLayout.createSequentialGroup()
                        .addGap(0, 585, Short.MAX_VALUE)
                        .addComponent(lbl_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_MainLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(lbl_RegistrarNuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(549, Short.MAX_VALUE)))
        );
        Panel_MainLayout.setVerticalGroup(
            Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_MainLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbl_Hora)
                .addGap(44, 44, 44)
                .addComponent(lbl_Nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(lbl_Appelido1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(lbl_Fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(lbl_TotalCosto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
            .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_MainLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(lbl_RegistrarNuevo2)
                    .addContainerGap(571, Short.MAX_VALUE)))
        );

        Panel_AddUser.setBackground(new java.awt.Color(51, 51, 51));
        Panel_AddUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel_AddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbl_Nombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Nombre.setText("Nombre");
        lbl_Nombre.setMaximumSize(new java.awt.Dimension(90, 30));

        lbl_Appelido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Appelido.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Appelido.setText("Apellido");
        lbl_Appelido.setPreferredSize(new java.awt.Dimension(90, 30));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        lbl_FechaActual.setBackground(new java.awt.Color(204, 204, 204));
        lbl_FechaActual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_FechaActual.setForeground(new java.awt.Color(51, 51, 51));
        lbl_FechaActual.setText("MM-dd-yyyy");
        lbl_FechaActual.setToolTipText("");
        lbl_FechaActual.setOpaque(true);
        lbl_FechaActual.setPreferredSize(new java.awt.Dimension(90, 30));

        lbl_Fecha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Fecha.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Fecha.setText("Fecha");
        lbl_Fecha.setPreferredSize(new java.awt.Dimension(90, 30));

        btn_SaveMember.setBackground(new java.awt.Color(102, 0, 51));
        btn_SaveMember.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btn_SaveMember.setForeground(new java.awt.Color(255, 255, 255));
        btn_SaveMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/disco_32.png"))); // NOI18N
        btn_SaveMember.setText("Guardar Usuario");
        btn_SaveMember.setToolTipText("");
        btn_SaveMember.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btn_SaveMember.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_SaveMember.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_SaveMember.setIconTextGap(20);
        btn_SaveMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveMemberActionPerformed(evt);
            }
        });

        lbl_TotalCosto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_TotalCosto.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TotalCosto.setText("Total");
        lbl_TotalCosto.setPreferredSize(new java.awt.Dimension(90, 30));

        lbl_CostoActual.setBackground(new java.awt.Color(204, 204, 204));
        lbl_CostoActual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_CostoActual.setForeground(new java.awt.Color(51, 51, 51));
        lbl_CostoActual.setText("0");
        lbl_CostoActual.setOpaque(true);
        lbl_CostoActual.setPreferredSize(new java.awt.Dimension(90, 30));

        lbl_RegistrarNuevo.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lbl_RegistrarNuevo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_RegistrarNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_RegistrarNuevo.setText("Registrar Nuevo Usuario");
        lbl_RegistrarNuevo.setToolTipText("");

        javax.swing.GroupLayout Panel_AddUserLayout = new javax.swing.GroupLayout(Panel_AddUser);
        Panel_AddUser.setLayout(Panel_AddUserLayout);
        Panel_AddUserLayout.setHorizontalGroup(
            Panel_AddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AddUserLayout.createSequentialGroup()
                .addGroup(Panel_AddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_AddUserLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_RegistrarNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
                    .addGroup(Panel_AddUserLayout.createSequentialGroup()
                        .addGroup(Panel_AddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_AddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_AddUserLayout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(Panel_AddUserLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(Panel_AddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_FechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(Panel_AddUserLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(Panel_AddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_TotalCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Panel_AddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_Appelido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl_CostoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(Panel_AddUserLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btn_SaveMember, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_AddUserLayout.setVerticalGroup(
            Panel_AddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AddUserLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbl_RegistrarNuevo)
                .addGap(54, 54, 54)
                .addComponent(lbl_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lbl_Appelido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbl_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_FechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_TotalCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_CostoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_SaveMember, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        btn_CloseMain.setBackground(new java.awt.Color(51, 51, 51));
        btn_CloseMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cruz_16.png"))); // NOI18N
        btn_CloseMain.setBorder(null);
        btn_CloseMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CloseMainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_RigthLayout = new javax.swing.GroupLayout(jPanel_Rigth);
        jPanel_Rigth.setLayout(jPanel_RigthLayout);
        jPanel_RigthLayout.setHorizontalGroup(
            jPanel_RigthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_RigthLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_CloseMain)
                .addContainerGap())
            .addGroup(jPanel_RigthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_AddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_RigthLayout.setVerticalGroup(
            jPanel_RigthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_RigthLayout.createSequentialGroup()
                .addGroup(jPanel_RigthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_RigthLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_CloseMain))
                    .addComponent(Panel_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel_AddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout jPanel_GeneralLayout = new javax.swing.GroupLayout(jPanel_General);
        jPanel_General.setLayout(jPanel_GeneralLayout);
        jPanel_GeneralLayout.setHorizontalGroup(
            jPanel_GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_GeneralLayout.createSequentialGroup()
                .addComponent(jPanel_Left, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Rigth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_GeneralLayout.setVerticalGroup(
            jPanel_GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_Rigth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_General, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_General, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1264, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CloseSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CloseSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_CloseSesionActionPerformed

    private void bnt_InsertAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_InsertAsistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bnt_InsertAsistenciaActionPerformed

    private void bnt_InsertMensauelidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_InsertMensauelidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bnt_InsertMensauelidaActionPerformed

    private void btn_SearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SearchUserActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void btn_SaveMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveMemberActionPerformed
        // TODO add your handling code here:
        Miembros miembro = new Miembros();
        Membresia membresia = new Membresia();
        
        miembro.setNombre(txtNombre.getText());
        miembro.setApellido(txtApellido.getText());
        String timeStampBD = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        miembro.setFechaInicio(timeStampBD);
        miembro.setAlCorriente(true);
        miembro.setNoVisitas(0);
        
        // Crear una instancia del calendario con la fecha actual
        Calendar calendar = Calendar.getInstance();       
        // Sumar un mes a la fecha actual
        calendar.add(Calendar.MONTH, 1);
        // Formatear la fecha resultante
        String timeStampBDFin = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        
        membresia.setMembresia(txtNombre.getText(),txtApellido.getText(),timeStampBD,timeStampBDFin,CostoMembresia);
        miembro.setMiembro();
    }//GEN-LAST:event_btn_SaveMemberActionPerformed

    private void btn_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HomeActionPerformed
        // TODO add your handling code here:
        Panel_AddUser.setVisible(false);
        Panel_Main.setVisible(true);
    }//GEN-LAST:event_btn_HomeActionPerformed

    private void btn_AddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddUserActionPerformed
        // TODO add your handling code here:
        Panel_AddUser.setVisible(true);
        Panel_Main.setVisible(false);
    }//GEN-LAST:event_btn_AddUserActionPerformed

    private void btn_CloseMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CloseMainActionPerformed
        // TODO add your handling code here:
        int confirm;

        confirm = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea salir");

        if(confirm == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btn_CloseMainActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeGym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeGym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeGym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeGym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //new HomeGym();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeGym().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_AddUser;
    private javax.swing.JPanel Panel_Main;
    private javax.swing.JButton bnt_InsertAsistencia;
    private javax.swing.JButton bnt_InsertMensauelida;
    private javax.swing.JButton btn_AddUser;
    private javax.swing.JButton btn_CloseMain;
    private javax.swing.JButton btn_CloseSesion;
    private javax.swing.JButton btn_Home;
    private javax.swing.JButton btn_SaveMember;
    private javax.swing.JButton btn_SearchUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel_General;
    private javax.swing.JPanel jPanel_Left;
    private javax.swing.JPanel jPanel_Rigth;
    private javax.swing.JLabel lbl_Appelido;
    private javax.swing.JLabel lbl_Appelido1;
    private javax.swing.JLabel lbl_CostoActual;
    private javax.swing.JLabel lbl_Fecha;
    private javax.swing.JLabel lbl_Fecha1;
    private javax.swing.JLabel lbl_FechaActual;
    private static javax.swing.JLabel lbl_Hora;
    private javax.swing.JLabel lbl_Nombre;
    private javax.swing.JLabel lbl_Nombre1;
    private javax.swing.JLabel lbl_RegistrarNuevo;
    private javax.swing.JLabel lbl_RegistrarNuevo2;
    private javax.swing.JLabel lbl_TotalCosto;
    private javax.swing.JLabel lbl_TotalCosto1;
    public javax.swing.JLabel lbl_UserName;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    /*@Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }*/
}
