package unit19_JakartaEE_3_AplicacionUniveral.interfazGrafica;

import javax.swing.*;

public class MarcoBBDD extends JFrame {

    /**
     * Constructor del marco principal de la aplicación.
     * Crea una ventana con título y tamaño definido, y añade el panel de consulta a la base de datos.
     */
    public MarcoBBDD() {
    setTitle("Consulta a Bases de Datos");
        setBounds(300, 300, 700, 700);

        PanelBBDD miPanel = new PanelBBDD();
        add(miPanel);
    }

}
