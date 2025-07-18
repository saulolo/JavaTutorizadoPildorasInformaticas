package unit19_JakartaEE_1_MVC.model;

import java.sql.*;

public class CargaMenus {

    private Conexion miConexion;
    private ResultSet resultadosConsultas[];

    public CargaMenus() {
        miConexion = new Conexion();
    }

    public ResultSet[] ejecutaConsultas() {

        Connection accesoBBDD = miConexion.getConexion();
        ResultSet resSec = null;
        ResultSet resPaises = null;

        try {
            Statement secciones = accesoBBDD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resSec = secciones.executeQuery("SELECT DISTINCT seccion FROM productos");
            Statement paises = accesoBBDD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resPaises = paises.executeQuery("SELECT DISTINCT pais_origen FROM productos");


        } catch (SQLException e) {
            System.out.println("Avanzando al siguiente registro.");
        } catch (Exception e) {
            System.err.println("Error al conectar a la BBDD.");
            //Quito la impresión de la pila de llamadas para evitar los warning de la excepción de SQL.
        }
        resultadosConsultas = new ResultSet[2];
        resultadosConsultas[0] = resSec;
        resultadosConsultas[1] = resPaises;
        return resultadosConsultas;
    }

}
