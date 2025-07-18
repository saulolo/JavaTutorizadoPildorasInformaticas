package unit19_JakartaEE_3_AplicacionUniveral.interfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class PanelBBDD extends JPanel {

    private JComboBox tablas;
    private JTextArea info;
    private Connection miConexion;
    private FileReader accesoConfig;

    /**
     * Constructor del panel que muestra las tablas de una base de datos.
     * Establece el layout, crea componentes, conecta a la base de datos y carga las tablas.
     */
    public PanelBBDD() {
        setLayout(new BorderLayout());
        tablas = new JComboBox();
        info = new JTextArea();
        add(tablas, BorderLayout.NORTH);
        add(info, BorderLayout.CENTER);
        conectaBBDD();
        nombreTablas();

        tablas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutaConsultaTablas((String) tablas.getSelectedItem());

            }
        });
    }

    /**
     * Establece la conexión con la base de datos usando un archivo de configuración externo.
     * Muestra un mensaje si hay errores en el archivo o en la conexión.
     */
    public void conectaBBDD() {
        miConexion = null;

        String[] datosFicheros = new String[3];

        try {
            accesoConfig = new FileReader("C:/Users/SaulHernandoEcheverr/Documents/Proyectos/JavaTutorizadoPildorasInformaticas/ConfigBBDD.txt");
            BufferedReader miBuffer = new BufferedReader(accesoConfig);
            for (int i = 0; i < datosFicheros.length; i++) {
                datosFicheros[i] = miBuffer.readLine();
            }
            miConexion = DriverManager.getConnection(datosFicheros[0], datosFicheros[1], datosFicheros[2] );
            System.out.println("✅ Conexión exitosa");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Revisa el archivo de configuración txt.");
        }
        catch (Exception e) {
            System.err.println("❌ Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Obtiene los nombres de todas las tablas de la base de datos y los carga en el comboBox.
     * Verifica que haya una conexión antes de intentar acceder a los metadatos.
     */
    public void nombreTablas() {
        ResultSet miRs = null;

        try {
            if (miConexion == null) {
                JOptionPane.showMessageDialog(null, "No hay conexión con la base de datos.");
                return;
            }
            DatabaseMetaData datosBBDD = miConexion.getMetaData();
            miRs = datosBBDD.getTables(null, null, null, new String[]{"TABLE"});
            while (miRs.next()) {
                tablas.addItem(miRs.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error de conexión: " + e);
            e.printStackTrace();
        } finally {
            try {
                if (miRs != null) miRs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Ejecuta una consulta SELECT * sobre la tabla especificada y muestra sus datos en el área de texto.
     *
     * @param nombreTabla Nombre de la tabla seleccionada del comboBox.
     */
    public void ejecutaConsultaTablas(String nombreTabla) {

        ArrayList<String> nCampos = new ArrayList<>();

        String consulta = "SELECT * FROM " + nombreTabla;
        try {
            info.setText("");
            Statement miSt = miConexion.createStatement();
            ResultSet miRs = miSt.executeQuery(consulta);

            ResultSetMetaData rsBD = miRs.getMetaData();

            for (int i = 1; i < rsBD.getColumnCount(); i++) {
                nCampos.add(rsBD.getColumnName(i));
            }

            while (miRs.next()) {
                for (String infoCampo : nCampos) {
                    info.append(miRs.getString(infoCampo) + " +");
                }
                info.append("\n");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
