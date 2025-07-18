package unit19_JakartaEE_1_MVC.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EjecutaConsultas {

    private Conexion miConexion;
    private ResultSet rs;
    private PreparedStatement enviaConSeccion;
    private final String CONSULTASECCION = "SELECT nombre_articulo, seccion, precio, pais_origen FROM productos WHERE seccion = ?";
    private final String CONSULTAPAIS = "SELECT nombre_articulo, seccion, precio, pais_origen FROM productos WHERE pais_origen = ?";
    private final String CONSULTAPAISSECCION = "SELECT nombre_articulo, seccion, precio, pais_origen FROM productos WHERE pais_origen = ? AND seccion = ?";

    public EjecutaConsultas() {
        miConexion = new Conexion();
    }

    public ResultSet consultaBBDD(String seccion, String pais) {

        Connection conecta = miConexion.getConexion();

        rs = null;

        try {
            if (!seccion.equals("Todas") && pais.equals("Todos")) {
                enviaConSeccion = conecta.prepareStatement(CONSULTASECCION);
                enviaConSeccion.setString(1, seccion);
                rs = enviaConSeccion.executeQuery();
            } else if (seccion.equals("Todas") && !pais.equals("Todos")) {
                enviaConSeccion = conecta.prepareStatement(CONSULTAPAIS);
                enviaConSeccion.setString(1, pais);
                rs = enviaConSeccion.executeQuery();
            } else {
                enviaConSeccion = conecta.prepareStatement(CONSULTAPAISSECCION);
                enviaConSeccion.setString(1, pais);
                enviaConSeccion.setString(2, seccion);
                rs = enviaConSeccion.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
}
