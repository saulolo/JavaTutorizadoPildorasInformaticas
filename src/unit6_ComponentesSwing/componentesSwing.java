package unit6_ComponentesSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Saulolo
 */
public class componentesSwing {

    public static void main(String[] args) {

        MarcoCuadroTexto miMarco = new MarcoCuadroTexto();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}

class MarcoCuadroTexto extends JFrame {

    /**
     * Constructor de la clase MarcoCuadroTexto.
     * Crea un nuevo marco con un cuadro de texto y lo hace visible.
     * El marco se posiciona en (600, 300) con dimensiones de 600x400 píxeles.
     */
    public MarcoCuadroTexto(){
        setBounds(600, 300, 600, 400);
        add(new LaminaCuadroTexto());
        setVisible(true);

    }
}

class LaminaCuadroTexto extends JPanel {

    private JTextField cuadroTexto;
    private JTextField cuadroTexto2;


    /**
     * Constructor de la clase LaminaCuadroTexto.
     * Crea una nueva lámina que contiene un cuadro de texto y un botón.
     * También agrega otro cuadro de texto a la lámina.
     * El cuadro de texto inicial tiene una longitud de 20 caracteres.
     * Cuando se hace clic en el botón, se activa un ActionListener para obtener el texto del primer cuadro de texto.
     */
    public LaminaCuadroTexto() {
        cuadroTexto = new JTextField(20);
        add(cuadroTexto);

        JButton boton = new JButton("Obtener texto");
        boton.addActionListener(new ObtenerTexto());
        add(boton);

        cuadroTexto2 = new JTextField(20);
        add(cuadroTexto2);

    }

    private class ObtenerTexto implements ActionListener{


        /**
         * Sobrescribe el método actionPerformed(ActionEvent e) de la interfaz ActionListener.
         * Este método se llama cuando se produce un evento de acción, en este caso, cuando se hace clic en el botón.
         * Obtiene el texto del primer cuadro de texto y lo establece como texto del segundo cuadro de texto.
         *
         * @param e El objeto ActionEvent que representa el evento de acción.
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            cuadroTexto2.setText(cuadroTexto.getText());

        }
    }

}
