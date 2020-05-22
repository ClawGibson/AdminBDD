package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gamaliel Bernal
 */
public class Conexion {

    static Connection conect = null;
    static Conexion c = new Conexion();

//    public static void main(String args[]) {
//        Conexion("gama", "gama");
//    }
    public Connection Conexion() {
        String connectionUrl = "jdbc:sqlserver://Claw:1433;databaseName=PUNTO18ARQUITECTOS";
        try {
            conect = DriverManager.getConnection(connectionUrl, "gama", "gama");
            System.out.println("Conectado.");
            return conect;
        } catch (SQLException e) {
            System.out.println("ErrorSQL." + e.getMessage());
        }
        return null;
    }

    public void cierraConexion() {
        try {
            conect.close();
            System.out.println("Conexión cerrada :D");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al cerrar conexion", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }
}
