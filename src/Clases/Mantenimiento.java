package Clases;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Acer
 */
public class Mantenimiento extends javax.swing.JFrame {

    Connection conn;
    Conexion conexiones = new Conexion();
    static ResultSet res;

    /**
     * Creates new form Mantenimiento
     */
    public Mantenimiento() {
        initComponents();
        this.setLocationRelativeTo(null);

        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/recursos/28.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        //FECHA DEL SISTEMA
        Date sistFecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMMM YYYY");
        fecha.setText(formato.format(sistFecha));

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new Mantenimiento.horas());
        tiempo.start();
        Cargar();

        actualizarTecnicos();
        actualizarMaquinaria();
        fechaa.setText(fecha.getText());
    }

    public void actualizarTecnicos() {
        try {
            ArrayList<String> arr = new ArrayList();
            arr = obtenerTecnicos();
            if (!arr.isEmpty()) {
                for (int i = tecnico.getItemCount() - 1; i < arr.size(); i++) {
                    tecnico.addItem(arr.get(i));
                }
            }
        } catch (SQLException e) {
            System.out.println("No hay técnicos :c");
        }
    }

    public void actualizarMaquinaria() {
        try {
            ArrayList<String> arr = new ArrayList();
            arr = obtenerMaquinaria();
            if (!arr.isEmpty()) {
                for (int i = nombre.getItemCount() - 1; i < arr.size(); i++) {
                    nombre.addItem(arr.get(i));
                }
            }
        } catch (SQLException e) {
            System.out.println("No hay maquinaria :c");
        }
    }

    public void Cargar() {
        DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Maquinaria");
        modelo.addColumn("Maquinaria");
        modelo.addColumn("Técnico");
        modelo.addColumn("Fecha");
        tabla.setModel(modelo);
        try {
            conn = conexiones.Conexion();
            PreparedStatement pStm = conn.prepareStatement("SELECT * FROM VerMantenimiento");
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

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        buscador = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        menu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fechaa = new javax.swing.JTextField();
        tecnico = new javax.swing.JComboBox<>();
        nombre = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        maq = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del Mantenimiento:"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "IDMaquinaria", "NombreTecnico", "Fecha"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setFont(new java.awt.Font("Modern No. 20", 0, 18)); // NOI18N
        jLabel1.setText("MÓDULO MANTENIMIENTO");

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

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_Cancel__Red_34208 (1).png"))); // NOI18N
        cancelar.setText("Limpiar seleccionado");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/IMG-20190402-WA0002.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Fecha:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Hora:");

        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorKeyReleased(evt);
            }
        });

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_search_285651.png"))); // NOI18N
        buscar.setText("Buscar");

        menu.setText("MENU");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Maquinaria:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("Fecha:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("Tecnico:");

        tecnico.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        tecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione técnico" }));

        nombre.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        nombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione maquinaria" }));

        jMenu1.setText("Opciones");

        maq.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        maq.setText("Maquinaria");
        maq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maqActionPerformed(evt);
            }
        });
        jMenu1.add(maq);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificar)
                .addGap(58, 58, 58)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscar)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel10)
                .addGap(41, 41, 41)
                .addComponent(tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buscar)))
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hora, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(fecha))
                                .addComponent(jLabel7)
                                .addGap(3, 3, 3)))))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(fechaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if (nombre.getSelectedIndex() == 0 || fechaa.getText().isEmpty() || tecnico.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Ingresa bien los datos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        } else {
            try {
                conn = conexiones.Conexion();
                CallableStatement proc = conn.prepareCall("{call NuevoMantenimiento(?,?,?)}");
                proc.setString(1, nombre.getSelectedItem().toString());
                proc.setString(2, tecnico.getSelectedItem().toString());
                proc.setString(3, fechaa.getText());
                int filasAfectadas = proc.executeUpdate();
                System.out.println("Filas afectadas: " + filasAfectadas);
                limpiar();
                Cargar();
                JOptionPane.showMessageDialog(this, "Datos almacenados correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
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

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int opc = JOptionPane.showConfirmDialog(this, "¿ESTAS SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opc == JOptionPane.YES_OPTION) {
            try {
                conn = conexiones.Conexion();
                CallableStatement proc = conn.prepareCall("{call EliminarMantenimiento(?,?,?)}");
                proc.setString(1, nombre.getSelectedItem().toString());
                proc.setString(2, tecnico.getSelectedItem().toString());
                proc.setString(3, fechaa.getText());
                int band = proc.executeUpdate();
                if (band != 0) {
                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente el registro.");
                    limpiar();
                    Cargar();
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un problema al intentar eliminar el registro.");
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
            CallableStatement proc = conn.prepareCall("{call ModificarMantenimiento(?,?,?)}");
            proc.setString(1, nombre.getSelectedItem().toString());
            proc.setString(2, tecnico.getSelectedItem().toString());
            proc.setString(3, fechaa.getText());
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

    private void maqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maqActionPerformed
        Maquinaria maq = new Maquinaria();
        maq.setVisible(true);
    }//GEN-LAST:event_maqActionPerformed

    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
        String meses[] = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio",
            "agosto", "septiembre", "noviembre", "diciembre"};
        int fila = tabla.rowAtPoint(evt.getPoint());
        int columna = tabla.columnAtPoint(evt.getPoint());
        if ((fila > -1) && (columna > -1)) {
            nombre.setSelectedItem(tabla.getValueAt(fila, 1).toString());
            String aux[] = tabla.getValueAt(fila, 3).toString().split("-");
            fechaa.setText(aux[2] + " " + meses[Integer.parseInt(aux[1]) - 1] + " " + aux[0]);
            tecnico.setSelectedItem((tabla.getValueAt(fila, 2).toString()));
        }
    }//GEN-LAST:event_tablaMousePressed

    private void buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyReleased
        if (buscador.getText().equals("")) {
            Cargar();
        } else {
            buscando();
        }
    }//GEN-LAST:event_buscadorKeyReleased

    private void buscando() {
        DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Maquinaria");
        modelo.addColumn("Maquinaria");
        modelo.addColumn("Técnico");
        modelo.addColumn("Fecha");
        tabla.setModel(modelo);
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call BuscarMantenimientos(?)}");
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

    public ArrayList<String> obtenerTecnicos() throws SQLException {
        Statement sql = conexiones.Conexion().createStatement();
        ArrayList<String> arr = new ArrayList<String>();
        ResultSet resultado = sql.executeQuery("SELECT * FROM Tecnicos");
        while (resultado.next()) {
            arr.add(resultado.getString("Nombre"));
        }
        conexiones.cierraConexion();
        return arr;
    }

    public ArrayList<String> obtenerMaquinaria() throws SQLException {
        Statement sql = conexiones.Conexion().createStatement();
        ArrayList<String> arr = new ArrayList<String>();
        ResultSet resultado = sql.executeQuery("SELECT * FROM VerMaquinaria");
        while (resultado.next()) {
            arr.add(resultado.getString("Nombre"));
        }
        conexiones.cierraConexion();
        return arr;
    }

    private void limpiar() {
        nombre.setSelectedIndex(0);
        fechaa.setText(fecha.getText());
        tecnico.setSelectedIndex(0);
        buscador.setText("");
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
            java.util.logging.Logger.getLogger(Mantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mantenimiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField buscador;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel fecha;
    private javax.swing.JTextField fechaa;
    private javax.swing.JLabel hora;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem maq;
    private javax.swing.JButton menu;
    private javax.swing.JButton modificar;
    private javax.swing.JComboBox<String> nombre;
    private javax.swing.JTable tabla;
    private javax.swing.JComboBox<String> tecnico;
    // End of variables declaration//GEN-END:variables
}
