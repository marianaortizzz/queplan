package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/queplan"
            + "?useSSL=false"
            + "&allowPublicKeyRetrieval=true"
            + "&serverTimezone=America/Mexico_City"
            + "&characterEncoding=UTF-8";
    private static final String USUARIO  = "root";
    private static final String PASSWORD = "root";

    // Bloque estático: se ejecuta UNA vez cuando se carga la clase.
    // Fuerza al driver de MySQL a registrarse en DriverManager.
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver de MySQL no encontrado en el classpath", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection con = getConnection()) {
            System.out.println("OK - Conexión exitosa a la BD: " + con.getCatalog());
        } catch (SQLException e) {
            System.out.println("ERROR - No se pudo conectar:");
            e.printStackTrace();
        }
    }
}