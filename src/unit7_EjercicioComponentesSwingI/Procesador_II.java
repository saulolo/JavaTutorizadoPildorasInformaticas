package unit7_EjercicioComponentesSwingI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Saulolo
 */
public class Procesador_II {

    public static void main(String[] args) {

        MarcoCuadroTexto miMarco = new MarcoCuadroTexto();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}

class MarcoCuadroTexto extends JFrame {

    /**
     * Constructor de la clase MarcoCuadroTexto.
     * Crea una ventana con un tamaño específico y agrega una lámina que contiene componentes de cuadro de texto y un botón.
     * La ventana se hace visible después de su creación.
     */
    public MarcoCuadroTexto(){
        setBounds(600, 300, 600, 400);
        add(new LaminaCuadroTexto());
        setVisible(true);

    }
}

class LaminaCuadroTexto extends JPanel {

    private JTextField cuadroTexto;
    private JLabel etiquetaResultado;



    /**
     * Constructor de la clase LaminaCuadroTexto.
     * Crea una lámina con un diseño de cuadrícula de 3 filas y 1 columna.
     * Agrega un cuadro de texto, un botón y una etiqueta a la lámina.
     */
    public LaminaCuadroTexto() {
        setLayout(new GridLayout(3, 0));
        cuadroTexto = new JTextField(20);
        add(cuadroTexto);

        JButton comprobar = new JButton("Comprueba");
        comprobar.addActionListener(new ExaminaMail());
        add(comprobar);

        etiquetaResultado = new JLabel("");
        add(etiquetaResultado);

    }

    private class ExaminaMail implements ActionListener{


        /**
         * Método que se ejecuta cuando se produce un evento de acción.
         * Verifica si el texto ingresado en el cuadro de texto del email tiene exactamente un símbolo '@'.
         * Si el número de símbolos '@' es diferente de uno, establece el texto de la etiquetaResultado como "Email incorrecto!!!",
         * de lo contrario, establece el texto de la etiquetaResultado como "Email correcto.".
         * @param e El evento de acción que desencadenó este método.
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            String emailUsuario = cuadroTexto.getText();
            int arroba = 0;

            for (int i = 0; i < emailUsuario.length(); i++) {
                if (emailUsuario.charAt(i) == '@')
                    arroba++;
            }
            if (arroba !=1 )etiquetaResultado.setText("Email incorrecto!!!");
            else etiquetaResultado.setText("Email correcto.");

        }
    }

}
