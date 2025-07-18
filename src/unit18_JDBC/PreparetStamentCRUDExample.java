package unit18_JDBC;

import java.sql.*;

public class PreparetStamentCRUDExample {

    public static void main(String[] args) {


                                        /* CONSULTA PREPARADA */

        try {
            //1. Crear Conexión
            Connection miCon = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PildorasIgestionpedidosJDBC", "postgres", "1234");

            //2. Crear PreparedStatemet
            PreparedStatement miPSt = miCon.prepareStatement("SELECT NOMBRE_ARTICULO, SECCION, PRECIO, PAIS_ORIGEN FROM PRODUCTOS WHERE SECCION = ? AND PAIS_ORIGEN = ?");
            miPSt.setString(1, "CONFECCIÓN");
            miPSt.setString(2, "ITALIA");
            ResultSet miRs = miPSt.executeQuery();

            while (miRs.next()) {
                System.out.println(miRs.getString(1) + " ==> " + miRs.getString(2) + " ==> " + miRs.getString(3 ));
            }
            miRs.close();

            //Reutilización de consulta preparada
            System.out.println();
            System.out.println();
            miPSt.setString(1, "JUGUETERÍA");
            miPSt.setString(2, "MARRUECOS");

            ResultSet miRs2 = miPSt.executeQuery();
            while (miRs2.next()) {
                System.out.println(miRs2.getString(1) + " ==> " + miRs2.getString(2) + " ==> " + miRs2.getString(3 ));
            }

            miCon.close();

        } catch (SQLException e) {
            System.err.println("Error de conexión");
            e.printStackTrace();
        }
    }

}
