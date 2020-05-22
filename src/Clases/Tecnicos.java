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
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Acer
 */
public class Tecnicos extends javax.swing.JFrame {

    static ResultSet res;
    Connection conn;
    Conexion conexiones = new Conexion();

    /**
     * Creates new form Tecnicos
     */
    public Tecnicos() {
        initComponents();
        this.setLocationRelativeTo(null);

        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/recursos/22.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        //FECHA DEL SISTEMA
        Date sistFecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMMM YYYY");
        fecha.setText(formato.format(sistFecha));

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new Tecnicos.horas());
        tiempo.start();
        Cargar();

        // ACTUALIZACIÓN DE CIUDADES
        actualizarCiudades();
    }

    public void actualizarCiudades() {
        try {
            ArrayList<String> arr = new ArrayList();
            Ciudades c = new Ciudades();
            arr = c.obtenerCiudades();
            if (!arr.isEmpty()) {
                for (int i = ciudades.getItemCount() - 1; i < arr.size(); i++) {
                    ciudades.addItem(arr.get(i));
                }
            }
        } catch (SQLException e) {
            System.out.println("No hay ciudades :c");
        }
    }

    public void Cargar() {
        DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Técnico");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Ciudad");
        tabla.setModel(modelo);
        try {
            conn = conexiones.Conexion();
            PreparedStatement pStm = conn.prepareStatement("SELECT * FROM VerTecnicos");
            res = pStm.executeQuery();
            while (res.next()) {
                Object vector[] = new Object[4];
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
            hora.setText(String.format(format.format(sistHora), hoy));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ciudades = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buscador = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        fecha = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ciudades.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        ciudades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione ciudad" }));

        jLabel1.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel1.setText("MÓDULO TÉCNICOS");

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_Plus__Orange_34237.png"))); // NOI18N
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_Line_ui_icons_Svg-03_1465842.png"))); // NOI18N
        eliminar.setText("Eliminar seleccionado");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_pencil_285638.png"))); // NOI18N
        modificar.setText("Modificar seleccionado");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del Técnico:"));

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
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Telefono", "Ciudad"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_Cancel__Red_34208 (1).png"))); // NOI18N
        cancelar.setText("Limpiar selección");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/IMG-20190402-WA0002.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorKeyReleased(evt);
            }
        });

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_search_285651.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        fecha.setText("fec");

        hora.setText("hor");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Fecha:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Hora:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("ID:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Telefono:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Ciudad:");

        id.setEditable(false);

        menu.setText("MENU");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eliminar)
                        .addGap(169, 169, 169)
                        .addComponent(agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ciudades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(177, 177, 177))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar)
                        .addGap(182, 182, 182)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(hora)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(fecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buscar))
                            .addComponent(jLabel7)
                            .addComponent(hora)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ciudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(agregar)
                    .addComponent(eliminar)
                    .addComponent(modificar)
                    .addComponent(menu))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        limpiar();

    }//GEN-LAST:event_cancelarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        if (buscador.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Verifique su entrada de datos en el buscador", "Error", JOptionPane.ERROR_MESSAGE);
            buscador.setText("");
            buscador.requestFocus();
        } else {
            try {
                conn = conexiones.Conexion();
                CallableStatement proc = conn.prepareCall("{call Buscador(?)}");
                proc.setString(1, buscador.getText());
                res = proc.executeQuery();
                if (res.next()) {
                    JOptionPane.showMessageDialog(null, "DATOS ENCONTRADOS");
                } else {
                    JOptionPane.showMessageDialog(null, "DATOS NO ENCONTRADOS");
                }
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

    }//GEN-LAST:event_buscarActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if (nombre.getText().isEmpty() || telefono.getText().isEmpty() || ciudades.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Ingresa bien los datos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        } else {
            try {
                boolean band = buscarTecnico(nombre.getText());
                if (band == true) {
                    JOptionPane.showMessageDialog(this, "Este tecnico ya existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    conn = conexiones.Conexion();
                    CallableStatement proc = conn.prepareCall("{call NuevoTecnico(?,?,?)}");
                    proc.setString(1, nombre.getText());
                    proc.setInt(2, Integer.parseInt(telefono.getText()));
                    proc.setString(3, ciudades.getSelectedItem().toString());
                    int filasAfectadas = proc.executeUpdate();
                    System.out.println("Filas afectadas: " + filasAfectadas);
                    limpiar();
                    JOptionPane.showMessageDialog(this, "Datos almacenados correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    Cargar();
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
        }
        conexiones.cierraConexion();
    }//GEN-LAST:event_agregarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int opc = JOptionPane.showConfirmDialog(this, "¿ESTAS SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opc == JOptionPane.YES_OPTION) {
            try {
                conn = conexiones.Conexion();
                CallableStatement proc = conn.prepareCall("{call EliminarTecnico(?)}");
                proc.setString(1, nombre.getText());
                int band = proc.executeUpdate();
                if (band != 0) {
                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente al técnico.");
                    limpiar();
                    Cargar();
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un problema al intentar eliminar al técnico.");
                }
                limpiar();
                Cargar();
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
        conexiones.cierraConexion();
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call ModificarTecnico(?,?,?,?)}");
            proc.setInt(1, Integer.parseInt(id.getText()));
            proc.setString(2, nombre.getText());
            proc.setInt(3, Integer.parseInt(telefono.getText()));
            proc.setString(4, ciudades.getSelectedItem().toString());
            int band = proc.executeUpdate();
            if (band != 0) {
                JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO MODIFICADOS");
                limpiar();
                Cargar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar los datos");
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        } catch (Exception e) {
            System.out.println("Error Genérico: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        }
        conexiones.cierraConexion();
    }//GEN-LAST:event_modificarActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        MenuPrincipal tw = new MenuPrincipal();
        tw.setVisible(true);
        dispose();

    }//GEN-LAST:event_menuActionPerformed

    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
        int fila = tabla.rowAtPoint(evt.getPoint());
        int columna = tabla.columnAtPoint(evt.getPoint());
        if ((fila > -1) && (columna > -1)) {
            id.setText(tabla.getValueAt(fila, 0).toString()); // Obtenemos el ID del usuario.
            nombre.setText(tabla.getValueAt(fila, 1).toString()); // Mostramos el nombre del usuario.
            telefono.setText(tabla.getValueAt(fila, 2).toString()); // Mostramos la telefono del usuario seleccionado.
            ciudades.setSelectedItem((tabla.getValueAt(fila, 3).toString())); // Obtenemos el nombre de la ciudad del usuario seleccionado.
        }
    }//GEN-LAST:event_tablaMousePressed

    private void buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyReleased
        if (buscador.getText().equals("")) {
            Cargar();
        } else {
            buscando();
        }
    }//GEN-LAST:event_buscadorKeyReleased

    public void buscando() {
        DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Usuario");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Ciudad");
        tabla.setModel(modelo);
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call Buscador(?)}");
            proc.setString(1, buscador.getText());
            res = proc.executeQuery();
            while (res.next()) {
                Object vector[] = new Object[4];
                for (int i = 0; i < vector.length; i++) {
                    vector[i] = res.getObject(i + 1);
                    tabla.getColumnModel().getColumn(i).setCellRenderer(alinearCentro);
                }
                modelo.addRow(vector);
            }
            conexiones.cierraConexion();
        } catch (SQLException e) {

        } catch (Exception e) {

        }
    }

    public boolean buscarTecnico(String name) {
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call BuscarTecnico(?)}");
            proc.setString(1, nombre.getText());
            res = proc.executeQuery();
            if (res.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        } catch (Exception e) {
//            System.out.println("Error Genérico: ");
//            e.printStackTrace(System.out);
//            conexiones.cierraConexion();
        }
        return false;
    }

    public void limpiar() {
        buscador.setText("");
        id.setText("");
        nombre.setText("");
        telefono.setText("");
        ciudades.setSelectedItem(0);
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
            java.util.logging.Logger.getLogger(Tecnicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField buscador;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> ciudades;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel hora;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menu;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombre;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
