/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ContPropuesta;
import Logica.ContUsuario;
import Logica.dtColaborador;
import Logica.dtFecha;
import Logica.dtHora;
import Logica.dtProponente;
import Logica.dtPropuesta;
import Logica.dtUsuario;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicolasgutierrez
 */
public class Registrar_Colaboracion_a_Propuesta extends javax.swing.JInternalFrame {
    
    ContUsuario contUsu = ContUsuario.getInstance();
    ContPropuesta contProp = ContPropuesta.getInstance();
    int maxmonto;

    /**
     * Creates new form Registrar_Colaboracion_a_Propuesta
     */
    public Registrar_Colaboracion_a_Propuesta() {
        initComponents();
        contProp.verificarPropHora();
        this.setSize(666, 553);
        //String titulo[]={"nickName"};
        // llenarGrilla(jTable_proponente, titulo, proponentes);

        jLabel1.setText("Propuestas");
        jLabel5.setText("Monto total recaudado");
        jLabel3.setText("Estado");
        jLabel2.setText("Colaboradores");
        jLabel8.setText("Propuesta");
        txttituloprop.setText("Seleccione una");
        jLabel4.setText("Colaborador");
        txtnickcolaborador.setText("Seleccione uno");
        jLabel6.setText("Tipo de retorno");
        jLabel7.setText("Monto");
        btnaceptar.setText("Aceptar");
        btncancelar.setText("Cancelar");
        cbporcentaje.setText("Porcentaje");
        cbentradas.setText("Entrada");
        jTA_comentario.setEnabled(false);
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
        tpropuestas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_propuestas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtmontotoal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtestado = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablecolaboradores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablecolaborador = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtnickcolaborador = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtmontoacolaborar = new javax.swing.JTextField();
        btnaceptar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        busquedapropuestas = new javax.swing.JTextField();
        cbporcentaje = new javax.swing.JCheckBox();
        cbentradas = new javax.swing.JCheckBox();
        busuqedacolaboradores = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txttituloprop = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTA_comentario = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tpropuestas.setModel(new javax.swing.table.DefaultTableModel(
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
        tpropuestas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpropuestasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tpropuestas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 57, 220, -1));

        jLabel1.setText("Propuestas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 27, -1, -1));

        jTable_propuestas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable_propuestas);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 25, 367, 97));

        jLabel5.setText("Monto total recaudado");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 128, 150, -1));
        getContentPane().add(txtmontotoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 161, 150, -1));

        jLabel3.setText("Estado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 128, -1, -1));

        txtestado.setEditable(false);
        txtestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtestadoActionPerformed(evt);
            }
        });
        getContentPane().add(txtestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 182, -1));

        tablecolaboradores.setModel(new javax.swing.table.DefaultTableModel(
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
        tablecolaboradores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablecolaboradoresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablecolaboradores);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 245, 150, 230));

        jLabel2.setText("  Colaboradores");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 192, -1, -1));

        tablecolaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Email"
            }
        ));
        jScrollPane4.setViewportView(tablecolaborador);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 220, 71));

        jLabel4.setText("Colaborador");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, -1));

        txtnickcolaborador.setText("Seleccione uno");
        getContentPane().add(txtnickcolaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, -1, -1));

        jLabel6.setText("Tipo de retorno");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 345, -1, -1));

        jLabel7.setText("Monto");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, -1, -1));
        getContentPane().add(txtmontoacolaborar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 120, -1));

        btnaceptar.setText("Aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 182, -1));

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 182, -1));

        busquedapropuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedapropuestasActionPerformed(evt);
            }
        });
        busquedapropuestas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                busquedapropuestasKeyPressed(evt);
            }
        });
        getContentPane().add(busquedapropuestas, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 25, 147, -1));

        cbporcentaje.setText("Procentaje");
        getContentPane().add(cbporcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 361, -1, -1));

        cbentradas.setText("Entrada");
        getContentPane().add(cbentradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 381, -1, -1));

        busuqedacolaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busuqedacolaboradoresActionPerformed(evt);
            }
        });
        busuqedacolaboradores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                busuqedacolaboradoresKeyPressed(evt);
            }
        });
        getContentPane().add(busuqedacolaboradores, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 214, 140, -1));

        jLabel8.setText("Propuesta");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        txttituloprop.setText("Seleccione una");
        getContentPane().add(txttituloprop, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 157, -1));

        jTA_comentario.setColumns(20);
        jTA_comentario.setRows(5);
        jScrollPane5.setViewportView(jTA_comentario);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 155, 450));

        jLabel9.setText("Comentario");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busquedapropuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedapropuestasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busquedapropuestasActionPerformed

    private void busquedapropuestasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busquedapropuestasKeyPressed
        List<String> proponentes = contUsu.listartodaslaspropuestas(busquedapropuestas.getText());
        DefaultTableModel modelo = (DefaultTableModel) tpropuestas.getModel();
        modelo.setRowCount(0);
        for (int i = 0; i < proponentes.size(); i++) {
            String p = proponentes.get(i);
            Object[] dat = {p};
            modelo.addRow(dat);
        }
    }//GEN-LAST:event_busquedapropuestasKeyPressed

    private void txtestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtestadoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tpropuestas.getModel();
        modelo.setRowCount(0);
        
        DefaultTableModel modelo2 = (DefaultTableModel) jTable_propuestas.getModel();
        modelo2.setRowCount(0);
        
        DefaultTableModel modelo3 = (DefaultTableModel) tablecolaboradores.getModel();
        modelo3.setRowCount(0);
        
        DefaultTableModel modelo4 = (DefaultTableModel) tablecolaborador.getModel();
        modelo4.setRowCount(0);
        
        txtmontotoal.setText("");
        txtestado.setText("");
        txtnickcolaborador.setText("Seleccione uno");
        txttituloprop.setText("Seleccione una");
        
        cbentradas.setSelected(false);
        cbporcentaje.setSelected(false);
        maxmonto = 0;
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelarActionPerformed

    private void busuqedacolaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busuqedacolaboradoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busuqedacolaboradoresActionPerformed

    private void busuqedacolaboradoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busuqedacolaboradoresKeyPressed
        // TODO add your handling code here:

        List<String> colaboradores = contUsu.listarColaboradoresLike(busuqedacolaboradores.getText());
        DefaultTableModel modelo = (DefaultTableModel) tablecolaboradores.getModel();
        modelo.setRowCount(0);
        for (int i = 0; i < colaboradores.size(); i++) {
            String c = colaboradores.get(i);
            Object[] dat = {c};
            modelo.addRow(dat);
        }

    }//GEN-LAST:event_busuqedacolaboradoresKeyPressed
    private void habilitado(String estado) {
        if (estado.equals("Financiada")) {
            
            jTA_comentario.setEnabled(true);
        } else {
            jTA_comentario.setEnabled(false);
        }
    }
    private void tpropuestasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpropuestasMouseClicked
        // TODO add your handling code here:
        try {
            limpiarlabasura();
            
            int row = tpropuestas.rowAtPoint(evt.getPoint());
            int col = tpropuestas.columnAtPoint(evt.getPoint());
            dtPropuesta dtp;
            
            dtp = contUsu.infoPropuesta((String) tpropuestas.getValueAt(row, col));
            
            DefaultTableModel modelo = (DefaultTableModel) jTable_propuestas.getModel();
            modelo.setRowCount(0);
            Object[] dat = {dtp.getTitulo(), dtp.getDescripcion(), dtp.getLugar(), dtp.getFechaRealizacion().getFecha(), dtp.getPrecioentrada(), dtp.getMontorequerido()};
            txtmontotoal.setText(Integer.toString(dtp.getMontoTotal()));
            txtestado.setText(dtp.getEstado());
            habilitado(dtp.getEstado());
            
            txttituloprop.setText(dtp.getTitulo());
            
            modelo.addRow(dat);
            cbentradas.setEnabled(false);
            cbporcentaje.setEnabled(false);

            /* System.out.println(dtp.getRetorno()+" xd");
        String[] rets=dtp.getRetorno().split("/");
        String one=rets[0],two=rets[1];
        System.out.println(one+" y "+two);
        if(one.contentEquals("Entrada") || two.contentEquals("Entrada") ){
            cbentradas.setEnabled(true);
        }
        if(one.contentEquals("Porcentaje") || two.contentEquals("Porcentaje")){
            cbporcentaje.setEnabled(true);
        }
             */
            if (dtp.getRetorno().contentEquals("Entrada")) {
                cbentradas.setEnabled(true);
            }
            if (dtp.getRetorno().contentEquals("Porcentaje")) {
                cbporcentaje.setEnabled(true);
            }
            if (dtp.getRetorno().contentEquals("Entrada/Porcentaje")) {
                cbporcentaje.setEnabled(true);
                cbentradas.setEnabled(true);
            }
            
            maxmonto = dtp.getMontorequerido() - dtp.getMontoTotal();
            
        } catch (Exception ex) {
            Logger.getLogger(Registrar_Colaboracion_a_Propuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tpropuestasMouseClicked

    private void tablecolaboradoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecolaboradoresMouseClicked
        // TODO add your handling code here:
        int row = tablecolaboradores.rowAtPoint(evt.getPoint());
        int col = tablecolaboradores.columnAtPoint(evt.getPoint());
        
        dtUsuario dtc;
        dtc = contUsu.infoColaborador((String) tablecolaboradores.getValueAt(row, col));
        DefaultTableModel modelo = (DefaultTableModel) tablecolaborador.getModel();
        modelo.setRowCount(0);
        
        Object[] dat = {dtc.getNombre(), dtc.getApellido(), dtc.getEmail()};
        modelo.addRow(dat);
        txtnickcolaborador.setText(dtc.getNickname());

    }//GEN-LAST:event_tablecolaboradoresMouseClicked
    private dtFecha getFecha() {
        dtFecha fecha = null;
        Calendar cal = Calendar.getInstance();
        Date da = cal.getTime();
        da.setYear(2018);
        fecha = new dtFecha(Integer.toString(da.getDay()), Integer.toString(da.getMonth()), Integer.toString(da.getYear()));
        return fecha;
    }
    
    private dtHora getHora() {
        dtHora hora = null;
        Calendar cal = Calendar.getInstance();
        Date da = cal.getTime();
        da.setYear(2018);
        hora = new dtHora(da.getHours(), da.getMinutes());
        return hora;
    }
    
    private String getPorcentaje() {
        String re = null;
        
        if (cbentradas.isSelected() && !cbporcentaje.isSelected()) {
            re = cbentradas.getText();
        } else if (cbentradas.isSelected() && cbporcentaje.isSelected()) {
            re = cbentradas.getText() + "/" + cbporcentaje.getText();
        } else if (!cbentradas.isSelected() && cbporcentaje.isSelected()) {
            re = cbporcentaje.getText();
        }
        return re;
    }
    

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        // TODO add your handling code here:

        String re = getPorcentaje();
        dtFecha dtf = getFecha();
        dtHora dth = getHora();

        // if(Integer.parseInt(txtmontoacolaborar.getText())<=maxmonto){ 
        if (txtestado.getText().contains("No financiada") == false) {
            if (txtestado.getText().contains("Cancelada") == false) {
                if (txtestado.getText().contains("Financiada") == false) {
                    if (txtestado.getText().contains("Ingresada") == false) {
                        if (Integer.parseInt(txtmontoacolaborar.getText()) <= maxmonto) {
                            if (re.isEmpty() == false) {
                                if (txtmontoacolaborar.getText().isEmpty() == false && txtmontoacolaborar.getText().contains(",") == false && txtmontoacolaborar.getText().contains(".") == false && txtmontoacolaborar.getText().contains(" ") == false && isNumeric(txtmontoacolaborar.getText())) {
                                    if (txttituloprop.getText().isEmpty() == false && txttituloprop.getText().contains("Seleccione una") == false) {
                                        if (txtnickcolaborador.getText().isEmpty() == false && txtnickcolaborador.getText().contains("Seleccione uno") == false) {
                                            
                                            boolean b = contUsu.registrarColaboracion(txttituloprop.getText(), txtnickcolaborador.getText(), Integer.parseInt(txtmontoacolaborar.getText()), re, jTA_comentario.getText());
                                            if (txtestado.getText().contains("Publicada") && b) {
                                                contProp.agregarEstadoAPropuesta("En financiacion", txttituloprop.getText(), dtf, dth);
                                            }
                                            
                                            if (txtestado.getText().contains("En financiacion") && (maxmonto - Integer.parseInt(txtmontoacolaborar.getText())) == 0 && b) {
                                                contProp.agregarEstadoAPropuesta("Financiada", txttituloprop.getText(), dtf, dth);
                                            }
                                            
                                            if (txtestado.getText().contains("Publicada") && (maxmonto - Integer.parseInt(txtmontoacolaborar.getText())) == 0 && b) {
                                                contProp.agregarEstadoAPropuesta("Financiada", txttituloprop.getText(), dtf, dth);
                                            }
                                            
                                            if (b) {
                                                JOptionPane.showMessageDialog(null, "Colaboracion registrada");
                                                limpiarlabasura();
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Imposible registrar la colaboracion");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Por favor seleccione un colaborador");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Por favor seleccione una propuesta");
                                    }
                                    
                                } else {
                                    JOptionPane.showMessageDialog(null, "Por favor coloque un monto valido");
                                    txtmontoacolaborar.selectAll();
                                    txtmontoacolaborar.requestFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Por favor seleccione un retorno");
                                cbporcentaje.requestFocus();
                                cbentradas.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El monto de colaboracion es superior al necesario por la propuesta, maximo posible: " + maxmonto);
                            txtmontoacolaborar.selectAll();
                            txtmontoacolaborar.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No es posible registrar una colaboracion en una propuesta Ingresada, esta debe ser verificada por un administrador");
                        txtestado.selectAll();
                        txtestado.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La propuesta ya fue financiada y no acepta colaboraciones");
                    txtestado.selectAll();
                    txtestado.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "La propuesta ha sido cancelada");
                txtestado.selectAll();
                txtestado.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "La propuesta no se encuentra en financiacion debido a que su fecha caduco");
            txtestado.selectAll();
            txtestado.requestFocus();
        }
//    }else{
//        JOptionPane.showMessageDialog(null, "El monto de colaboracion es superior al necesario por la propuesta, maximo posible: "+maxmonto);
//        txtmontoacolaborar.selectAll();
        //       txtmontoacolaborar.requestFocus();         
//    }        


    }//GEN-LAST:event_btnaceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JTextField busquedapropuestas;
    private javax.swing.JTextField busuqedacolaboradores;
    private javax.swing.JCheckBox cbentradas;
    private javax.swing.JCheckBox cbporcentaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTA_comentario;
    private javax.swing.JTable jTable_propuestas;
    private javax.swing.JTable tablecolaborador;
    private javax.swing.JTable tablecolaboradores;
    private javax.swing.JTable tpropuestas;
    private javax.swing.JTextField txtestado;
    private javax.swing.JTextField txtmontoacolaborar;
    private javax.swing.JTextField txtmontotoal;
    private javax.swing.JLabel txtnickcolaborador;
    private javax.swing.JLabel txttituloprop;
    // End of variables declaration//GEN-END:variables

// funciones
    private void llenarGrilla(JTable tabla, String titulo[], List<String> atributos) {
        // 
        Object[] fila = new Object[titulo.length];
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        for (int i = 0; i < atributos.size(); i++) {
            String p = atributos.get(i);
            Object[] dat = {p};
            modelo.addRow(dat);
        }
        tabla.setModel(modelo);
    }
    
    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    private void limpiarlabasura() {
        DefaultTableModel modelo = (DefaultTableModel) jTable_propuestas.getModel();
        modelo.setRowCount(0);
        
        DefaultTableModel modelo2 = (DefaultTableModel) tablecolaboradores.getModel();
        modelo2.setRowCount(0);
        
        DefaultTableModel modelo3 = (DefaultTableModel) tablecolaborador.getModel();
        modelo3.setRowCount(0);
        
        cbporcentaje.setSelected(false);
        cbentradas.setSelected(false);
        txtmontotoal.setText("");
        busuqedacolaboradores.setText("");
        txtestado.setText("");
        txtmontoacolaborar.setText("");
    }
    
}
