package unit18_JDBC;

import java.sql.*;

public class ConectaGestion {

    public static void main(String[] args) {


                                            /* ACCEDIENDO Y LEYENDO LA BD*/
        System.out.println("-------------------- ACCEDIENDO Y LEYENDO LA BD --------------------");
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


        System.out.println("-------------------- OBTENIEDNO LA METADATA DE LA BD --------------------");
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PildorasIgestionpedidosJDBC", "postgres", "1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCTOS");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            System.out.println("\n--------------------------------------------------------------------------------------------------");
            System.out.printf("| %-20s | %-35s | %-15s | %-10s |\n",
                    "NOMBRE COLUMNA",
                    "CLASE JAVA",
                    "TIPO SQL",
                    "CÓDIGO TIPO");
            System.out.println("--------------------------------------------------------------------------------------------------");

            for (int column = 1; column <= columnCount; column++) {
                String name = resultSetMetaData.getColumnName(column);
                String className = resultSetMetaData.getColumnClassName(column);
                String typeName = resultSetMetaData.getColumnTypeName(column);
                int type = resultSetMetaData.getColumnType(column);

                System.out.printf("| %-20s | %-35s | %-15s | %-10d |\n",
                        name,
                        className,
                        typeName,
                        type);
            }

            System.out.println("--------------------------------------------------------------------------------------------------");

            connection.close();
            statement.close();
            resultSet.close();

        } catch (SQLException e) {
            System.err.println("Error de conexión");
            e.printStackTrace();
        }


        System.out.println("-------------------- OBTENIEDNO EL NULL DE LA BD --------------------");

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PildorasIgestionpedidosJDBC", "postgres", "1234");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCTOS")) {

            if (resultSet.next()) {

                int price = resultSet.getInt("precio");

                if (resultSet.wasNull()) {
                    System.out.println("El precio es nulo (NULL) en la base de datos para el primer producto.");
                } else {
                    System.out.println("El precio del primer producto es: " + price);
                }

            } else {
                System.out.println("La consulta no devolvió resultados (tabla PRODUCTOS vacía).");
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión o JDBC:");
            e.printStackTrace();
        }




    }

}
