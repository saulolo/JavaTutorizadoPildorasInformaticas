package unit18_JDBC;

import java.sql.*;

public class ConectaGestion {

    public static void main(String[] args) {


                                            /* ACCEDIENDO Y LEYENDO LA BD*/
        try {
            //1. Crear Conexión
            Connection miCon = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PildorasIgestionpedidosJDBC", "postgres", "1234");

            //2. Crear Statemet
            Statement miSt = miCon.createStatement();

            //3. Ejecutar instrucción SQL
            ResultSet miRs = miSt.executeQuery("SELECT * FROM PRODUCTOS");

            //4. Leer el resulset
            while (miRs.next()) {
                System.out.println(miRs.getString(1) + " ==> " + miRs.getString("nombre_articulo"));
            }
            miRs.close();
            miCon.close();

        } catch (SQLException e) {
            System.err.println("Error de conexión");
            e.printStackTrace();
        }
    }

}
