/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ContUsuario;
import Logica.dtColaborador;
import Logica.dtFecha;
import Logica.dtProponente;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.util.Locale.filter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import Logica.ContUsuario;
import Logica.dtProponente;
import Logica.dtColaborador;
import Logica.dtFecha;
import javax.swing.JFileChooser;
/**
 *
 * @author nicolasgutierrez
 */
public class Alta_Perfil extends javax.swing.JInternalFrame {
ContUsuario contUsu = ContUsuario.getInstance();
boolean usuTipo = false;


String imagenRuta =null;
JFileChooser navegadorArchivos = new JFileChooser();
 
    public Alta_Perfil() {
        initComponents();
        String imagenRuta=null;
    JFileChooser navegadorArchivos=new JFileChooser();
    jT_direccion.enable(false);
        jT_web.enable(false);
        jtp_biografia.enable(false);
        jb_aceptar.enable(false);}
    
    



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jbtn_examinar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jT_nick = new javax.swing.JTextField();
        jT_nombre = new javax.swing.JTextField();
        jT_apellido = new javax.swing.JTextField();
        jT_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdc_fechaNac = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jL_imagenP = new javax.swing.JLabel();
        jb_aceptar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jrb_colaborador = new javax.swing.JRadioButton();
        Jrb_proponente = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jT_direccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jT_web = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtp_biografia = new javax.swing.JTextPane();

        setTitle("Alta Perfil");
        setToolTipText("Alta Perfil");
        setPreferredSize(new java.awt.Dimension(611, 1000));
        setRequestFocusEnabled(false);
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtn_examinar.setText("Examinar");
        jbtn_examinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_examinarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtn_examinar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jPanel6.setToolTipText("");

        jLabel8.setText("Nickname:");

        jLabel9.setText("Nombre:");

        jLabel14.setText("Apellido:");

        jLabel15.setText("Email:");

        jT_nick.setToolTipText("NickName");

        jT_nombre.setToolTipText("Nombre");

        jT_apellido.setToolTipText("Apellido");

        jT_email.setToolTipText("Email");

        jLabel6.setText("Fecha Nacimiento:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jT_nick, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jT_nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jT_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(jT_apellido, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jdc_fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jT_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jT_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jT_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jdc_fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 250));

        jLabel16.setText("Imagen Perfil");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, 40));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setToolTipText("");

        jL_imagenP.setText("Imagen");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_imagenP, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_imagenP, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 170, 150));

        jb_aceptar.setText("Aceptar");
        jb_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        jb_cancelar.setText("Cancelar");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));

        jrb_colaborador.setText("Colaborador");
        jrb_colaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_colaboradorActionPerformed(evt);
            }
        });
        getContentPane().add(jrb_colaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        Jrb_proponente.setText("Proponente");
        Jrb_proponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jrb_proponenteActionPerformed(evt);
            }
        });
        getContentPane().add(Jrb_proponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, -1, -1));

        jT_direccion.setToolTipText("Direccion");

        jLabel1.setText("Direccion");

        jLabel2.setText("Sitio Web");

        jT_web.setToolTipText("Sitio Web");

        jLabel3.setText("Biografia");

        jScrollPane1.setViewportView(jtp_biografia);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jT_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jT_web)))
                    .addComponent(jScrollPane1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_web, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, 490));

        getAccessibleContext().setAccessibleName("jpanel_altaPerfil");
        getAccessibleContext().setAccessibleDescription("");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_examinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_examinarActionPerformed

       selecImagen();
       


        // TODO add your handling code here:

    }//GEN-LAST:event_jbtn_examinarActionPerformed

    private void jrb_colaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_colaboradorActionPerformed
        this.setMinimumSize(new Dimension(384, 547));
        usuTipo=false;
        jb_aceptar.enable(true);
        jT_direccion.enable(false);
        jT_web.enable(false);
        jtp_biografia.enable(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_colaboradorActionPerformed

    private void Jrb_proponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jrb_proponenteActionPerformed
        this.setMinimumSize(new Dimension(641, 1000));
        usuTipo=true;
        jb_aceptar.enable(true);
        jT_direccion.enable(true);
        jT_web.enable(true);
        jtp_biografia.enable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Jrb_proponenteActionPerformed


    private void jb_aceptarActionPerformed(java.awt.event.ActionEvent evt) {                                           
       if(altaPerfil()==true)JOptionPane.showMessageDialog(null, "Usuario agregado con exito");
       limpiarTxt();
    }                                          

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
       limpiarTxt();
        this.dispose();
    }                                           


   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Jrb_proponente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jL_imagenP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jT_apellido;
    private javax.swing.JTextField jT_direccion;
    private javax.swing.JTextField jT_email;
    private javax.swing.JTextField jT_nick;
    private javax.swing.JTextField jT_nombre;
    private javax.swing.JTextField jT_web;
    private javax.swing.JButton jb_aceptar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jbtn_examinar;
    private com.toedter.calendar.JDateChooser jdc_fechaNac;
    private javax.swing.JRadioButton jrb_colaborador;
    private javax.swing.JTextPane jtp_biografia;
    // End of variables declaration//GEN-END:variables


   

   private boolean controlDatos () throws Exception{

       
        if(jT_nick.getText()==null){
            JOptionPane.showMessageDialog(null,"Nickname vacio");
            jT_nick.selectAll();
            jT_nick.requestFocus();
            return false;
        }
        if(jT_nombre.getText()==null){
            JOptionPane.showMessageDialog(null,"Nombre vacio");
            jT_nombre.selectAll();
            jT_nombre.requestFocus();
            return false;
        }
        if(jT_apellido.getText()==null){
            JOptionPane.showMessageDialog(null,"Apellido vacio");
            jT_apellido.selectAll();
            jT_apellido.requestFocus();
            return false;
        }
        if(jT_email.getText()==null){
            JOptionPane.showMessageDialog(null,"Email vacio");
            jT_email.selectAll();
            jT_email.requestFocus();
            return false;
        }
        if(compruebaEmail(jT_email.getText())!=true){
            JOptionPane.showMessageDialog(null,"Email incorrecto");
            jT_email.selectAll();
            jT_email.requestFocus();
            return false;
        }
        if(jdc_fechaNac==null){
            JOptionPane.showMessageDialog(null,"Fecha nacimiento vacia");
           jdc_fechaNac.requestFocus();
           return false;
        }
        return true;
   }
   private dtFecha getFechajdc(){
           dtFecha fecha;
           fecha = new dtFecha(Integer.toString(jdc_fechaNac.getDate().getDay()),Integer.toString(jdc_fechaNac.getDate().getMonth()),Integer.toString(jdc_fechaNac.getDate().getYear()));
           return fecha;}
   
   private boolean compruebaEmail(String email){
         // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        
    return mather.find();
    }
   private void limpiarTxt(){
        jT_nick.setText(" ");
        jT_nombre.setText(" ");
        jT_apellido.setText(" ");
        jT_email.setText(" ");

        jdc_fechaNac.cleanup();
        jT_direccion.setText(" ");
        jT_web.setText(" ");
        jtp_biografia.setText(" ");
        jrb_colaborador.setSelected(false);
        Jrb_proponente.setSelected(false);
        
    }

   private boolean altaPerfil(){
   try {
       if(controlDatos()==true){
       if (usuTipo==false){
      
           dtColaborador dtCola = new dtColaborador((jT_nombre.getText()), jT_apellido.getText(), jT_nick.getText()
                   ,imagenRuta, jT_email.getText(), getFechajdc());
           contUsu.agregarUsu(dtCola);
           return true;
       } 
   
        if (usuTipo==true && jT_direccion.getText()!=null&&jtp_biografia.getText()!=null&&jT_web.getText()!=null){
       dtProponente dtprop = new dtProponente(jT_nombre.getText(), jT_apellido.getText(), jT_nick.getText(), imagenRuta,jT_email.getText(), getFechajdc(), jT_direccion.getText(), jtp_biografia.getText(), jT_web.getText());
       contUsu.agregarUsu(dtprop);
       return true;
        }}
        } catch (Exception ex) {
           Logger.getLogger(Alta_Perfil.class.getName()).log(Level.SEVERE, null, ex);
       }
        return false; }
   
   
   private void selecImagen(){
       FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
       navegadorArchivos.setFileFilter(filtroImagen);
       navegadorArchivos.showOpenDialog(this);
       File imagen = navegadorArchivos.getSelectedFile();
       String path = navegadorArchivos.getSelectedFile().getPath();
       jL_imagenP.setIcon(new ImageIcon(path));
       ImageIcon icon = new ImageIcon(path);
       Image foto = icon.getImage();
       Image nuevaFoto = foto.getScaledInstance(jL_imagenP.getWidth(), jL_imagenP.getHeight(), Image.SCALE_DEFAULT);
       ImageIcon nuevoIcono = new ImageIcon(nuevaFoto);
       jL_imagenP.setIcon(nuevoIcono);
       //BufferedImage img= nuevoIcono;
       salvarImagen(foto);}

 
   
   private void salvarImagen(Image imagen){
   BufferedImage img = (BufferedImage) imagen;
   File outputfile = new File("/home/juan/ProgAplicaciones2018/progAplicaciones"+jT_nick.getText()+".png");
   imagenRuta="/home/juan/ProgAplicaciones2018/progAplicaciones"+jT_nick.getText()+".png";
    try { 
        ImageIO.write(img, "png", outputfile);
    } catch (IOException ex) {
        Logger.getLogger(Alta_Perfil.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
}
    
