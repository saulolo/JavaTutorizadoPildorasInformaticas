package unit19_JakartaEE_2_MetadatosProceAlma.Metadatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MostrarMetadatos {

    public static void main(String[] args) {

            mostrarInfoBD();
    }


    static void mostrarInfoBD() {
        Connection miConexion = null;
        String url = "jdbc:postgresql://localhost:5432/PildorasIgestionpedidosJDBC";
        String user = "postgres";
        String password = "1234";

        try {
            miConexion = DriverManager.getConnection(url, user, password);

            DatabaseMetaData misDatos = miConexion.getMetaData();
            System.out.println("Nombre del gestor: " + misDatos.getDatabaseProductName()); //Muestra info de la BD
            System.out.println("Nombre del gestor: " + misDatos.getDatabaseProductVersion()); //Muestra version gestor
            System.out.println("Nombre del gestor: " + misDatos.getDriverName()); //Muestra nombre del driver
            System.out.println("Nombre del gestor: " + misDatos.getDriverVersion()); //Muestra la version del driver

        } catch (
                SQLException e) {
            System.err.println("Error de conexión.");
            e.printStackTrace();
        } finally {
            try {
                miConexion.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
