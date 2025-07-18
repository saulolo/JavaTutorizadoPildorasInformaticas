package unit19_JakartaEE_2_MetadatosProceAlma.transacciones;

import javax.swing.*;
import java.sql.*;

public class InsertaClientesPedidos {

    public static void main(String[] args) throws SQLException {

        Connection miConexion = null;
        String url = "jdbc:postgresql://localhost:5432/PildorasIgestionpedidosJDBC";
        String user = "postgres";
        String password = "1234";

        try {
            miConexion = DriverManager.getConnection(url, user, password);
            miConexion.setAutoCommit(false);
            Statement miStatement = miConexion.createStatement();
            String instruccionSQL_1 = "INSERT INTO clientes(codigocliente, empresa, direccion) VALUES('CT85', 'EJEMPLO', 'P BOTANICO')";
            miStatement.executeUpdate(instruccionSQL_1);

            String instruccionSQL_2 = "INSERT INTO pedidos(numeropedido, codigocliente, fechadepedido) VALUES('83', 'CT85', '11/03/2000')";
            miStatement.executeUpdate(instruccionSQL_2);
            miConexion.commit();
            JOptionPane.showMessageDialog(null, "Datos insertados correctamente.");

            miConexion.close();
        } catch (SQLException e) {
            System.err.println("Error de conexión.");
            miConexion.rollback();
            e.printStackTrace();
        }
    }

}
