package unit18_JDBC;

public class JDBCExample {

    public static void main(String[] args) {

        System.out.println("-------------- JDBC ------------ ");
        /*JDBC: Java DataBase Connectivity
        * 1. Nos proporciona acceso a varios SGBD
        *    a. Establece una conexión
        *    b. Permite manipulación a BBDD utilizando SQL
        * 2. Proporcionado por el fabricante del SGBD.*/


        /*
                                         JDBC. Clases a manejar

                           +-------------------+     +-------------------+
                           |     java.sql      |     |     javax.sql     |
                           +-------------------+     +-------------------+

                                                 |
                                                 v
                                       +--------------------+
                                       |   DriverManager    |  <-- Clase (C)
                                       +--------------------+

                   +-------------+   +-------------+   +-------------+   +-------------+
                   |  ResultSet  |   | Connection  |   |  Statement  |   | DataSource  |
                   |   (Interf.) |   |  (Interf.)  |   |  (Interf.)  |   |  (Interf.)  |
                   +-------------+   +-------------+   +-------------+   +-------------+

        * */
        //Proceso acceso a BBDD
        /*1. Establecer conexión con la la BBDD.
        * 2. Crear un objeto statement.
        * 3. Ejecutar sentencia SQL
        * 4. leer el resultSet
        * */

    }
}
