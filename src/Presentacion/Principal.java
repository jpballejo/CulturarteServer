/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.culturarteFabrica;
import Logica.iConColaboracion;
import Logica.iConPropuesta;
import Logica.iConUsuario;

/**
 *
 * @author nicolasgutierrez
 */
public class Principal extends javax.swing.JFrame {

    
    private iConUsuario ICU;
    private iConColaboracion ICC;
    private iConPropuesta ICP;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        
        //   this.setJMenuBar(jMenuBar1); 
        //   this.jMenuBar1.setVisible(true);
           
           
           culturarteFabrica Fabrica= culturarteFabrica.getInstance();
           ICU=Fabrica.getIContUsuario();
           ICC=Fabrica.getIContColaboracion();
           ICP=Fabrica.getIContPropuesta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        menuprincipal = new javax.swing.JMenuBar();
        menuusuarios = new javax.swing.JMenu();
        altadeperfil = new javax.swing.JMenuItem();
        consultadecolaborador = new javax.swing.JMenuItem();
        consultadeproponente = new javax.swing.JMenuItem();
        seguirusuario = new javax.swing.JMenuItem();
        dejardeseguir = new javax.swing.JMenuItem();
        menupropuestas = new javax.swing.JMenu();
        altapropuesta = new javax.swing.JMenuItem();
        consultapropuesta = new javax.swing.JMenuItem();
        consultapropuestaporestado = new javax.swing.JMenuItem();
        modificarpropuesta = new javax.swing.JMenuItem();
        menucolaboraciones = new javax.swing.JMenu();
        cancelarcolaboracion = new javax.swing.JMenuItem();
        consultacolaboracion = new javax.swing.JMenuItem();
        registrarcolaboracion = new javax.swing.JMenuItem();
        menucategoria = new javax.swing.JMenu();
        altacategoria = new javax.swing.JMenuItem();

        jScrollPane1.setViewportView(jEditorPane1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuusuarios.setText("Usuarios");

        altadeperfil.setText("Alta de Perfil");
        altadeperfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                altadeperfilMouseClicked(evt);
            }
        });
        altadeperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altadeperfilActionPerformed(evt);
            }
        });
        menuusuarios.add(altadeperfil);

        consultadecolaborador.setText("Consulta perfil de Colaborador");
        consultadecolaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultadecolaboradorActionPerformed(evt);
            }
        });
        menuusuarios.add(consultadecolaborador);

        consultadeproponente.setText("Consulta de perfil de Proponente");
        consultadeproponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultadeproponenteActionPerformed(evt);
            }
        });
        menuusuarios.add(consultadeproponente);

        seguirusuario.setText("Seguir Usuario");
        menuusuarios.add(seguirusuario);

        dejardeseguir.setText("Dejar de Seguir a Usuario");
        dejardeseguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dejardeseguirActionPerformed(evt);
            }
        });
        menuusuarios.add(dejardeseguir);

        menuprincipal.add(menuusuarios);

        menupropuestas.setText("Propuestas");

        altapropuesta.setText("Alta de Propuesta");
        menupropuestas.add(altapropuesta);

        consultapropuesta.setText("Consulta de Propuesta");
        menupropuestas.add(consultapropuesta);

        consultapropuestaporestado.setText("Consulta de Propuesta por estado");
        menupropuestas.add(consultapropuestaporestado);

        modificarpropuesta.setText("Modificar datos Propuesta");
        menupropuestas.add(modificarpropuesta);

        menuprincipal.add(menupropuestas);

        menucolaboraciones.setText("Colaboraciones");

        cancelarcolaboracion.setText("Cancelar Colaboracion");
        menucolaboraciones.add(cancelarcolaboracion);

        consultacolaboracion.setText("Consulta de Colaboracion");
        menucolaboraciones.add(consultacolaboracion);

        registrarcolaboracion.setText("Registrar Colaboracion");
        menucolaboraciones.add(registrarcolaboracion);

        menuprincipal.add(menucolaboraciones);

        menucategoria.setText("Categoria");

        altacategoria.setText("Alta de Categoria");
        altacategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altacategoriaActionPerformed(evt);
            }
        });
        menucategoria.add(altacategoria);

        menuprincipal.add(menucategoria);

        setJMenuBar(menuprincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void altadeperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altadeperfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_altadeperfilActionPerformed

    private void altadeperfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_altadeperfilMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_altadeperfilMouseClicked

    private void consultadeproponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultadeproponenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultadeproponenteActionPerformed

    private void consultadecolaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultadecolaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultadecolaboradorActionPerformed

    private void dejardeseguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dejardeseguirActionPerformed
        // TODO add your handling code here:
        Dejar_de_Seguir_Usuario ddsu= new Dejar_de_Seguir_Usuario(ICU);
        ddsu.setVisible(true);
    }//GEN-LAST:event_dejardeseguirActionPerformed

    private void altacategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altacategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_altacategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            //@Override
            public void run() {
                
                new Principal().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem altacategoria;
    private javax.swing.JMenuItem altadeperfil;
    private javax.swing.JMenuItem altapropuesta;
    private javax.swing.JMenuItem cancelarcolaboracion;
    private javax.swing.JMenuItem consultacolaboracion;
    private javax.swing.JMenuItem consultadecolaborador;
    private javax.swing.JMenuItem consultadeproponente;
    private javax.swing.JMenuItem consultapropuesta;
    private javax.swing.JMenuItem consultapropuestaporestado;
    private javax.swing.JMenuItem dejardeseguir;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menucategoria;
    private javax.swing.JMenu menucolaboraciones;
    private javax.swing.JMenuBar menuprincipal;
    private javax.swing.JMenu menupropuestas;
    private javax.swing.JMenu menuusuarios;
    private javax.swing.JMenuItem modificarpropuesta;
    private javax.swing.JMenuItem registrarcolaboracion;
    private javax.swing.JMenuItem seguirusuario;
    // End of variables declaration//GEN-END:variables
}
