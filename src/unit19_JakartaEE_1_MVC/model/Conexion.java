package unit19_JakartaEE_1_MVC.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection miConexion = null;
    String url = "jdbc:postgresql://localhost:5432/PildorasIgestionpedidosJDBC";
    String user = "postgres";
    String password = "1234";

    public Conexion() {
    }

    public Connection getConexion() {
        try {
            miConexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Error de conexión.");
            e.printStackTrace();
        }
        return miConexion;
    }


}
