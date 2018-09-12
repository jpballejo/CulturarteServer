/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ContPropuesta;
import Logica.dtProponente;
import Logica.dtPropuesta;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicolasgutierrez
 */
public class Consulta_de_Propuesta extends javax.swing.JInternalFrame {

    /**
     * Creates new form Consulta_de_Propuesta
     */
     private ContPropuesta ICP = ContPropuesta.getInstance();
    
    public Consulta_de_Propuesta() {
        initComponents();
        
        this.setSize(774, 579);
        
        jLabel1.setText("Propuestas");
        jLabel2.setText("Imagen");
        txtimagen.setText("");
        jLabel3.setText("Estado");
        jLabel4.setText("Colaboradores");
        jLabel5.setText("Monto total");
        jButton1.setText("Cancelar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablepropuestas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablepropuesta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtimagen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtestado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablacolaboradores = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        txtmontotoal1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablepropuestas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Titulo"
            }
        ));
        tablepropuestas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepropuestasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablepropuestas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 95, 130, -1));

        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 33, -1, -1));

        tablepropuesta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Descripcion", "Lugar", "Fecha", "Precio entrada", "Monto requerido"
            }
        ));
        jScrollPane2.setViewportView(tablepropuesta);
        if (tablepropuesta.getColumnModel().getColumnCount() > 0) {
            tablepropuesta.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 55, 540, 97));

        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 169, -1, -1));
        getContentPane().add(txtimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 196, 100, 100));

        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 169, -1, -1));
        getContentPane().add(txtestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 164, 206, -1));

        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        tablacolaboradores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nickname"
            }
        ));
        jScrollPane3.setViewportView(tablacolaboradores);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 247, 168));

        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 308, -1, -1));

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 55, 130, -1));
        getContentPane().add(txtmontotoal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 330, 89, -1));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 480, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        List<String> lprop= ICP.listartodasPropuestas(txtbuscar.getText());
        DefaultTableModel modelo=(DefaultTableModel) tablepropuestas.getModel();
        modelo.setRowCount(0);
        for (int i=0;i<lprop.size();i++){
            String p=lprop.get(i);
            Object[] dato={p};
            modelo.addRow(dato);
        }
        
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void tablepropuestasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepropuestasMouseClicked
        // TODO add your handling code here:
        try{
        int row=tablepropuestas.rowAtPoint(evt.getPoint());
        int col=tablepropuestas.columnAtPoint(evt.getPoint());
        dtPropuesta dtp=ICP.mostrarInfoPropuesta((String)tablepropuestas.getValueAt(row, col));
        
        DefaultTableModel model=(DefaultTableModel) tablepropuesta.getModel();
        model.setRowCount(0);
        
        Object[] dato={dtp.getTitulo(),dtp.getDescripcion(),dtp.getLugar(),dtp.getFechaRealizacion().getFecha(),dtp.getPrecioentrada(),dtp.getMontorequerido()};
        txtestado.setText(dtp.getEstado());
        txtmontotoal1.setText(Integer.toString(dtp.getMontoTotal()));
        model.addRow(dato);
        DefaultTableModel model2=(DefaultTableModel) tablacolaboradores.getModel();
        model2.setRowCount(0);
        List<String> colabs=dtp.detColaboradores();
        for (int i=0;i<colabs.size();i++){
            String c=colabs.get(i);
            Object[] dat={c};
            model2.addRow(dat);      
        }
        
        
        }catch(Exception ex){
         javax.swing.JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_tablepropuestasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablacolaboradores;
    private javax.swing.JTable tablepropuesta;
    private javax.swing.JTable tablepropuestas;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtestado;
    private javax.swing.JLabel txtimagen;
    private javax.swing.JTextField txtmontotoal1;
    // End of variables declaration//GEN-END:variables
}
