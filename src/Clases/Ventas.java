/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static Clases.Mantenimiento.res;
import conexiones.Conexion;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Samsung
 */
public class Ventas extends javax.swing.JFrame {

    Connection conn;
    Conexion conexiones = new Conexion();
    static ResultSet res;
    int idVenta = 0;

    /**
     * Creates new form Ventas
     */
    public Ventas() {
        initComponents();
        this.setLocationRelativeTo(null);

        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/recursos/23.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        //FECHA DEL SISTEMA
        Date sistFecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMMM YYYY");
        fecha.setText(formato.format(sistFecha));

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new Ventas.horas());
        tiempo.start();

        agregar.setEnabled(false);
        finalizar.setEnabled(false);

        todosArticulos();
        articulo.hidePopup();

        sub.setText("0");
        iva.setText("0");
        total.setText("0");
    }

    public void Cargar() {
        DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Venta");
        modelo.addColumn("id Art");
        modelo.addColumn("Artículo");
        modelo.addColumn("Cant");
        modelo.addColumn("Precio");
        tabla.setModel(modelo);
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call VerCarritoVenta(?)}");
            proc.setInt(1, idVenta);
            res = proc.executeQuery();
            while (res.next()) {
                Object vector[] = new Object[5];
                for (int i = 0; i < vector.length; i++) {
                    vector[i] = res.getObject(i + 1);
                    tabla.getColumnModel().getColumn(i).setCellRenderer(alinearCentro);
                }
                modelo.addRow(vector);
            }
            conexiones.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Error SQL: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        } catch (Exception e) {
            System.out.println("Error Genérico: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        }
    }

    public void Cargar2() {
        DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Venta");
        modelo.addColumn("id Art");
        modelo.addColumn("Artículo");
        modelo.addColumn("Cant");
        modelo.addColumn("Precio");
        tabla.setModel(modelo);
        int cont = 0;
        while (cont < 29) {
            Object vector[] = new Object[5];
            for (int i = 0; i < vector.length; i++) {
                vector[i] = "";
                tabla.getColumnModel().getColumn(i).setCellRenderer(alinearCentro);
            }
            modelo.addRow(vector);
        }
        conexiones.cierraConexion();
    }

    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date sistHora = new Date();
            String pmAm = "hh:mm:ss a";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            hora.setText(String.format(format.format(sistHora), hoy));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sub = new javax.swing.JTextField();
        iva = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        nueva = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        etqArt = new javax.swing.JLabel();
        etqCant = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        registro = new javax.swing.JButton();
        articulo = new javax.swing.JComboBox<>();
        buscador = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Modern No. 20", 0, 20)); // NOI18N
        titulo.setText("MÓDULO VENTAS");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Articulos"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Articulo", "Cant", "Pc. Unit.", "Pc. Tot"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("SubTotal:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("IVA:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("TOTAL:");

        sub.setEditable(false);

        iva.setEditable(false);

        total.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iva)
                            .addComponent(total))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_Plus__Orange_34237.png"))); // NOI18N
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_button_ok_3207 (2).png"))); // NOI18N
        finalizar.setText("Finalizar");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_Line_ui_icons_Svg-03_1465842.png"))); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        nueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_sign-add_299068.png"))); // NOI18N
        nueva.setText("Nueva Venta");
        nueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nueva, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nueva)
                        .addGap(18, 18, 18)
                        .addComponent(agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminar)
                        .addGap(78, 78, 78)
                        .addComponent(finalizar)
                        .addGap(14, 14, 14)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/IMG-20190402-WA0002.jpg"))); // NOI18N
        logo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fecha.setText("fec");

        hora.setText("hor");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Fecha:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Hora:");

        menu.setText("MENU");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        etqArt.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        etqArt.setText("Articulo");

        etqCant.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        etqCant.setText("Cant");

        registro.setText("Registro de ventas");
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });

        articulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Articulos" }));
        articulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                articuloMousePressed(evt);
            }
        });

        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorKeyReleased(evt);
            }
        });

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_search_285651.png"))); // NOI18N
        buscar.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(logo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(hora))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(buscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etqArt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(articulo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(etqCant)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(titulo)
                            .addComponent(fecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(hora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscar))))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqArt)
                    .addComponent(etqCant)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu)
                    .addComponent(registro))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call NuevaVenta2(?,?)}");
            proc.setString(1, articulo.getSelectedItem().toString());
            proc.setFloat(2, Float.parseFloat(cantidad.getText()));
            int filasAfectadas = proc.executeUpdate();
            if (filasAfectadas != 0) {
                Cargar();
                limpiar();
                calcularTotales();
            } else {
                System.out.println("Ocurrió un error, inténtelo de nuevo más tarde.");
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println("Error Genérico: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        }
        conexiones.cierraConexion();
    }//GEN-LAST:event_agregarActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int opc = JOptionPane.showConfirmDialog(this, "¿ESTAS SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opc == JOptionPane.YES_OPTION) {
            try {
                conn = conexiones.Conexion();
                CallableStatement proc = conn.prepareCall("{call EliminarArticuloDeVenta(?,?)}");
                proc.setInt(1, idVenta);
                proc.setString(2, articulo.getSelectedItem().toString());
                int band = proc.executeUpdate();
                if (band != 0) {
                    limpiar();
                    Cargar();
                    calcularTotales();
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un problema al intentar eliminar el registro.");
                }
                limpiar();
                Cargar();
            } catch (SQLException e) {
                System.out.println("Error SQL: ");
                e.printStackTrace(System.out);
                conexiones.cierraConexion();
            } catch (HeadlessException | NumberFormatException e) {
                System.out.println("Error Genérico: ");
                e.printStackTrace(System.out);
                conexiones.cierraConexion();
            }
        }
        conexiones.cierraConexion();
    }//GEN-LAST:event_eliminarActionPerformed

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        InfoRegistro ir = new InfoRegistro();
        ir.setVisible(true);
        dispose();
    }//GEN-LAST:event_registroActionPerformed

    private void buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyReleased
        if (buscador.getText().equals("")) {
            todosArticulos();
            articulo.hidePopup();
        } else {
            ventaArticulos(buscador.getText());
            articulo.showPopup();
        }
    }//GEN-LAST:event_buscadorKeyReleased

    private void articuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_articuloMousePressed
        if (articulo.getSelectedIndex() != 0) {

        } else {
            limpiar();
        }
    }//GEN-LAST:event_articuloMousePressed

    private void nuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaActionPerformed
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call NuevaVenta(?)}");
            proc.setString(1, fecha.getText());
            int filasAfectadas = proc.executeUpdate();
            if (filasAfectadas != 0) {
                nueva.setEnabled(false);
                agregar.setEnabled(true);
                finalizar.setEnabled(true);
                Statement sql = conexiones.Conexion().createStatement();
                res = sql.executeQuery("SELECT * FROM ObtenerIdVenta");
                if (res.next()) {
                    idVenta = Integer.parseInt(res.getString("idVenta"));
                }
            } else {
                System.out.println("Ocurrió un error, inténtelo de nuevo más tarde.");
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println("Error Genérico: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        }
        conexiones.cierraConexion();
    }//GEN-LAST:event_nuevaActionPerformed

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call NuevaVenta3(?)}");
            proc.setFloat(1, Float.parseFloat(total.getText()));
            int filasAfectadas = proc.executeUpdate();
            if (filasAfectadas != 0) {
                finalizar.setEnabled(false);
                agregar.setEnabled(false);
                nueva.setEnabled(true);
                JOptionPane.showMessageDialog(this, "Venta realizada exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                Ventas v = new Ventas();
                v.setVisible(true);
                dispose();
            } else {
                System.out.println("Ocurrió un error, inténtelo de nuevo más tarde.");
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println("Error Genérico: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        }
        conexiones.cierraConexion();
    }//GEN-LAST:event_finalizarActionPerformed

    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
        int fila = tabla.rowAtPoint(evt.getPoint());
        int columna = tabla.columnAtPoint(evt.getPoint());
        try {
            if ((fila > -1) && (columna > -1)) {
                articulo.setSelectedIndex(Integer.parseInt(tabla.getValueAt(fila, 1).toString()));
                cantidad.setText(tabla.getValueAt(fila, 3).toString());
            }
        } catch (NullPointerException e) {

        }
    }//GEN-LAST:event_tablaMousePressed

    private void limpiar() {
        articulo.setSelectedIndex(0);
        cantidad.setText("");
    }

    private void calcularTotales() {
        int filas = tabla.getRowCount();
        float subtotal = 0;
        for (int i = 0; i <= filas; i++) {
            subtotal = subtotal + (Float.parseFloat(tabla.getValueAt(i, 4).toString()) * Float.parseFloat(tabla.getValueAt(i, 3).toString()));
            filas--;
        }
        sub.setText(subtotal + "");
        iva.setText(subtotal * 0.16 + "");
        total.setText(Float.parseFloat(sub.getText()) + Float.parseFloat(iva.getText()) + "");
    }

    public void todosArticulos() {
        try {
            ArrayList<String> arr = new ArrayList();
            arr = obtenerTodosArticulos();
            articulo.removeAllItems();
            if (!arr.isEmpty()) {
                articulo.addItem("Articulos");
                for (int i = 0; i < arr.size(); i++) {
                    articulo.addItem(arr.get(i));
                }
            }
        } catch (SQLException e) {
            System.out.println("No hay técnicos :c");
        }
    }

    public ArrayList<String> obtenerTodosArticulos() throws SQLException {
        Statement sql = conexiones.Conexion().createStatement();
        ArrayList<String> arr = new ArrayList<String>();
        ResultSet resultado = sql.executeQuery("SELECT * FROM VerTodosArticulos");
        while (resultado.next()) {
            arr.add(resultado.getString("Nombre"));
        }
        conexiones.cierraConexion();
        return arr;
    }

    public void ventaArticulos(String cadena) {
        try {
            ArrayList<String> arr = new ArrayList();
            arr = ventaArticulosDB(cadena);
            articulo.removeAllItems();
            if (!arr.isEmpty()) {
                articulo.addItem("Articulos");
                for (int i = 0; i < arr.size(); i++) {
                    articulo.addItem(arr.get(i));
                }
            }
        } catch (SQLException e) {
            System.out.println("No hay técnicos :c");
        }
    }

    public ArrayList<String> ventaArticulosDB(String cadena) throws SQLException {
        ArrayList<String> arr = new ArrayList<String>();
        conn = conexiones.Conexion();
        CallableStatement proc = conn.prepareCall("{call VentaArticulos(?)}");
        proc.setString(1, buscador.getText());
        res = proc.executeQuery();
        while (res.next()) {
            arr.add(res.getString("nombre"));
        }
        conexiones.cierraConexion();
        return arr;
    }

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
            java.util.logging.Logger.getLogger(Ventas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JComboBox<String> articulo;
    private javax.swing.JTextField buscador;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel etqArt;
    private javax.swing.JLabel etqCant;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton finalizar;
    private javax.swing.JLabel hora;
    private javax.swing.JTextField iva;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logo;
    private javax.swing.JButton menu;
    private javax.swing.JButton nueva;
    private javax.swing.JButton registro;
    private javax.swing.JTextField sub;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
