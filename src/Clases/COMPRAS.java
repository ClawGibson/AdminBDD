/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import conexiones.Conexion;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.sql.ResultSet;
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
public class COMPRAS extends javax.swing.JFrame {

    ResultSet res;
    Connection conn;
    Conexion conexiones = new Conexion();
    int idCompra = 0;

    /**
     * Creates new form COMPRAS
     */
    public COMPRAS() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(getWidth(), getHeight());

        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/recursos/9.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());

        //FECHA DEL SISTEMA
        Date sistFecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMMM YYYY");
        fech.setText(formato.format(sistFecha));

        agregar.setEnabled(false);
        finalizar.setEnabled(false);
        eliminar.setEnabled(false);

        todosArticulos();
        articulo.hidePopup();

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new COMPRAS.horas());
        tiempo.start();
    }

    public void Cargar() {
        DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Compra");
        modelo.addColumn("id Art");
        modelo.addColumn("Artículo");
        modelo.addColumn("Cant");
        modelo.addColumn("Precio");
        tabla.setModel(modelo);
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call VerCarritoCompra(?)}");
            proc.setInt(1, idCompra);
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

    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date sistHora = new Date();
            String pmAm = "hh:mm:ss a";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            hor.setText(String.format(format.format(sistHora), hoy));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comprasEtq = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        nueva = new javax.swing.JButton();
        ivaPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sub = new javax.swing.JTextField();
        iva = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        marca = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        articuloEtq = new javax.swing.JLabel();
        p = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        fech = new javax.swing.JLabel();
        hor = new javax.swing.JLabel();
        fechaEtq = new javax.swing.JLabel();
        horaEtq = new javax.swing.JLabel();
        registro = new javax.swing.JButton();
        articulo1 = new javax.swing.JComboBox<>();
        articulo = new javax.swing.JComboBox<>();
        buscador = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comprasEtq.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        comprasEtq.setText("                          MÓDULO  COMPRAS");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Articulos y Proveedores"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Proveedor", "Articulo", "precio"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_Plus__Orange_34237.png"))); // NOI18N
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
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
        nueva.setText("Nueva compra");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nueva, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(nueva)
                .addGap(18, 18, 18)
                .addComponent(agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(eliminar)
                .addGap(92, 92, 92))
        );

        ivaPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Subtotal:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("IVA:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("TOTAL:");

        javax.swing.GroupLayout ivaPanelLayout = new javax.swing.GroupLayout(ivaPanel);
        ivaPanel.setLayout(ivaPanelLayout);
        ivaPanelLayout.setHorizontalGroup(
            ivaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ivaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ivaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ivaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total))
                    .addGroup(ivaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sub, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(ivaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iva)))
                .addContainerGap())
        );
        ivaPanelLayout.setVerticalGroup(
            ivaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ivaPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ivaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ivaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ivaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        marca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/IMG-20190402-WA0002.jpg"))); // NOI18N
        marca.setText("jLabel8");
        marca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        menu.setText("MENU");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        articuloEtq.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        articuloEtq.setText("Articulo");

        p.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        p.setText("Cantidad");

        fech.setText("fecha");

        hor.setText("hora");

        fechaEtq.setText("FECHA:");

        horaEtq.setText("HORA:");

        registro.setText("Registro de compras");
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });

        articulo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Articulos" }));

        articulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Articulos" }));

        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorKeyReleased(evt);
            }
        });

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_search_285651.png"))); // NOI18N
        buscar.setText("Buscar");

        finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_button_ok_3207 (2).png"))); // NOI18N
        finalizar.setText("Finalizar");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(comprasEtq, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(horaEtq)
                                    .addComponent(fechaEtq))
                                .addGap(45, 45, 45)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hor)
                            .addComponent(fech))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ivaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(finalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(12, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(articuloEtq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(buscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(articulo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(p)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 477, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(articulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(marca)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comprasEtq)
                            .addComponent(fech)
                            .addComponent(fechaEtq))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(horaEtq))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(hor)))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscar))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(ivaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(finalizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(articuloEtq)
                            .addComponent(p)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registro)
                    .addComponent(menu))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(articulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int opc = JOptionPane.showConfirmDialog(this, "¿ESTAS SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opc == JOptionPane.YES_OPTION) {
            try {
                conn = conexiones.Conexion();
                CallableStatement proc = conn.prepareCall("{call EliminarArticuloDeCompra(?,?)}");
                proc.setInt(1, idCompra);
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
        eliminar.setEnabled(false);
    }//GEN-LAST:event_eliminarActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call NuevaCompra2(?,?)}");
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
        MenuPrincipal c = new MenuPrincipal();
        c.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuActionPerformed

    private void nuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaActionPerformed
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call NuevaCompra(?)}");
            proc.setString(1, fech.getText());
            int filasAfectadas = proc.executeUpdate();
            if (filasAfectadas != 0) {
                nueva.setEnabled(false);
                agregar.setEnabled(true);
                finalizar.setEnabled(true);
                Statement sql = conexiones.Conexion().createStatement();
                res = sql.executeQuery("SELECT * FROM ObtenerIdCompra");
                if (res.next()) {
                    idCompra = Integer.parseInt(res.getString("idCompra"));
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

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        InfoCompras ic = new InfoCompras();
        ic.setVisible(true);
        dispose();
    }//GEN-LAST:event_registroActionPerformed

    private void buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyReleased
        if (buscador.getText().equals("")) {
            todosArticulos();
            articulo.hidePopup();
        } else {
            compraArticulos(buscador.getText());
            articulo.showPopup();
        }
    }//GEN-LAST:event_buscadorKeyReleased

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call NuevaCompra3(?)}");
            proc.setFloat(1, Float.parseFloat(total.getText()));
            int filasAfectadas = proc.executeUpdate();
            if (filasAfectadas != 0) {
                finalizar.setEnabled(false);
                agregar.setEnabled(false);
                nueva.setEnabled(true);
                JOptionPane.showMessageDialog(this, "Compra registrada exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                COMPRAS c = new COMPRAS();
                c.setVisible(true);
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
        eliminar.setEnabled(true);
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
        float subtotal = 0f;
        for (int i = 0; i <= filas; i++) {
            subtotal = subtotal + (Float.parseFloat(tabla.getValueAt(i, 4).toString()) * Float.parseFloat(tabla.getValueAt(i, 3).toString()));
            filas--;
        }
        sub.setText(subtotal + "");
        iva.setText(subtotal * 0.16 + "");
        total.setText(Float.parseFloat(sub.getText()) + Float.parseFloat(iva.getText()) + "");
    }

    private void todosArticulos() {
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

    private ArrayList<String> obtenerTodosArticulos() throws SQLException {
        Statement sql = conexiones.Conexion().createStatement();
        ArrayList<String> arr = new ArrayList<String>();
        ResultSet resultado = sql.executeQuery("SELECT * FROM VerTodosArticulos");
        while (resultado.next()) {
            arr.add(resultado.getString("Nombre"));
        }
        conexiones.cierraConexion();
        return arr;
    }

    private void compraArticulos(String cadena) {
        try {
            ArrayList<String> arr = new ArrayList();
            arr = compraArticulosDB(cadena);
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

    private ArrayList<String> compraArticulosDB(String cadena) throws SQLException {
        ArrayList<String> arr = new ArrayList<String>();
        conn = conexiones.Conexion();
        CallableStatement proc = conn.prepareCall("{call VentaArticulos(?)}");
        proc.setString(1, cadena);
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
            java.util.logging.Logger.getLogger(COMPRAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(COMPRAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(COMPRAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(COMPRAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new COMPRAS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JComboBox<String> articulo;
    private javax.swing.JComboBox<String> articulo1;
    private javax.swing.JLabel articuloEtq;
    private javax.swing.JTextField buscador;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JLabel comprasEtq;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel fech;
    private javax.swing.JLabel fechaEtq;
    private javax.swing.JButton finalizar;
    private javax.swing.JLabel hor;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel horaEtq;
    private javax.swing.JTextField iva;
    private javax.swing.JPanel ivaPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel marca;
    private javax.swing.JButton menu;
    private javax.swing.JButton nueva;
    private javax.swing.JLabel p;
    private javax.swing.JButton registro;
    private javax.swing.JTextField sub;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
