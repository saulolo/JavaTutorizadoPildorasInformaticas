package unit19_JakartaEE_2_MetadatosProceAlma;

import java.sql.*;
import java.util.Scanner;

public class ActualizaProductos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int miPrecio;
        String miArticulo;

        Connection miConexion = null;
        String url = "jdbc:postgresql://localhost:5432/PildorasIgestionpedidosJDBC";
        String user = "postgres";
        String password = "1234";

        System.out.print("Introduce el precio a actualizar: ");
        miPrecio = scanner.nextInt();

        System.out.print("Introduce el articulo a actualizar: ");
        miArticulo = scanner.next();

        try {
            miConexion = DriverManager.getConnection(url, user, password);
            CallableStatement miStatement = miConexion.prepareCall("SELECT * FROM actualizaArticulo(?, ?)");
            miStatement.setInt(1, miPrecio);
            miStatement.setString(2, miArticulo);

            miStatement.execute();
            System.out.println("Actualización OK");

            miConexion.close();
        } catch (SQLException e) {
            System.err.println("Error de conexión.");
            e.printStackTrace();
        }
    }

}
