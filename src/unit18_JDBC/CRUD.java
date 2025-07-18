package unit18_JDBC;

import java.sql.*;

public class CRUD {

    public static void main(String[] args) {


                                        /* INSERTANDO REGISTROS*/

        try {
            //1. Crear Conexión
            Connection miCon = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PildorasIgestionpedidosJDBC", "postgres", "1234");

            //2. Crear Statemet
            Statement miSt = miCon.createStatement();

            //3. Crear instrucción SQL de insertado
            //int insert = miSt.executeUpdate("INSERT INTO PRODUCTOS (CODIGO_ARTICULO, NOMBRE_ARTICULO, PRECIO) VALUES ('AR42', 'COMPUTADOR', 3_000_000)");

            //3.1 Actualizar un registro ya inserdado
             //int update = miSt.executeUpdate("UPDATE PRODUCTOS SET PRECIO = 2_000_000 WHERE CODIGO_ARTICULO = 'AR42'");

            //3.3 Actualizar un registro ya inserdado
             int delete = miSt.executeUpdate("DELETE FROM PRODUCTOS WHERE CODIGO_ARTICULO = 'AR42'");

            System.out.println("Registro Insertado/Actualización/Eliminado correctamente.");
            miCon.close();

        } catch (SQLException e) {
            System.err.println("Error de conexión");
            e.printStackTrace();
        }
    }

}
