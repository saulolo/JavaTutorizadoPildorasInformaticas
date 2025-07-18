package unit19_JakartaEE_2_MetadatosProceAlma;

import java.sql.*;

public class ConsultaProductos {

    public static void main(String[] args) {

        Connection miConexion = null;
        String url = "jdbc:postgresql://localhost:5432/PildorasIgestionpedidosJDBC";
        String user = "postgres";
        String password = "1234";

        try {
            miConexion = DriverManager.getConnection(url, user, password);
            CallableStatement miStatement = miConexion.prepareCall("SELECT * FROM MUESTRADEPORTES()");
            ResultSet rs = miStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(5));
            }
            rs.close();
            miConexion.close();
        } catch (SQLException e) {
            System.err.println("Error de conexión.");
            e.printStackTrace();
        }

    }
}
