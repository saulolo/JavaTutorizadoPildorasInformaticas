package unit4_Eventos.ejer_1_EventosMouse_MensajeDeTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * En este ejercicio debes crear una interfaz gráfica como la que aparece en la siguiente imagen:
 * (Pildoras Informaticas. Java Tutorizado. Ejercicio Eventos II)
 * Se trata de que el usuario vaya rellenando los campos de texto. Si se deja vacío el campo usuario o el
 * campo contraseña, debe salir un mensaje emergente avisando de que no puede quedar en blanco. Tras
 * aceptar el mensaje emergente, el cursor debe volver automáticamente al campo vacío. Mientras no se
 * introduzca información en cualquiera de los dos campos, la aplicación no dejará continuar volviendo
 * el cursor automáticamente al campo que se dejó vacío. Ejemplo en la siguiente imagen:
 * (Pildoras Informaticas. Java Tutorizado. Ejercicio Eventos I)
 *
 * @author Saulolo
 */
public class EjerciciosEventos2 {

    /**
     * La clase principal que contiene el método main para iniciar la aplicación.
     */
    public static void main(String[] args) {

        VentanaEventos vEventos = new VentanaEventos();
        vEventos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


/**
 * La clase VentanaEventos representa una ventana de la aplicación que contiene una lámina para gestionar eventos.
 */
class VentanaEventos extends JFrame {

    public VentanaEventos() {
        setBounds(500, 300, 400, 250);
        add(new LaminaMarcoEventos());
        setVisible(true);
    }
}


/**
 * La clase LaminaMarcoEventos representa una lámina que contiene campos de texto para usuario, contraseña y email,
 * así como etiquetas asociadas a cada campo. Además, implementa un manejador de eventos de foco para validar la entrada
 * del usuario.
 */
class LaminaMarcoEventos extends JPanel {

    private JTextField campoTexto1;
    private JTextField campoTexto2;
    private JTextField campoTexto3;
    private JLabel etiq1;
    private JLabel etiq2;
    private JLabel etiq3;


    /**
     * La clase interna EventosDeFoco implementa un manejador de eventos de foco que valida la entrada del usuario
     * cuando pierde el foco el campo de texto correspondiente.
     */
    private class EventosDeFoco implements FocusListener {

        /**
         * Método que se invoca cuando el campo de texto pierde el foco.
         * Valida la entrada del usuario y muestra un mensaje de advertencia si es necesario.
         * @param e El evento de foco
         */
        @Override
        public void focusLost(FocusEvent e) {
            if (e.getSource() == campoTexto1) {
                if (campoTexto1.getText().equals("")) {
                    JOptionPane.showMessageDialog(getParent(), "El usuario no puede quedar vacio.");
                    campoTexto1.requestFocus();
                }
            }
            if (e.getSource() == campoTexto2 && !campoTexto1.getText().equals("")) {
                if (campoTexto2.getText().equals("")) {
                    JOptionPane.showMessageDialog(getParent(), "la contraeña no puede q");
                    campoTexto1.requestFocus();
                }
            }
        }

        @Override
        public void focusGained(FocusEvent e) {

        }

    }


    /**
     * Método que se invoca cuando el campo de texto gana el foco.
     * No realiza ninguna acción en este contexto.
     * @param g El evento de foco
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        campoTexto1 = new JTextField();
        campoTexto2 = new JTextField();
        campoTexto3 = new JTextField();

        etiq1 = new JLabel("Usuario");
        etiq2 = new JLabel("Contraseña");
        etiq3 = new JLabel("Email");

        campoTexto1.setBounds(120, 10, 150,20);
        campoTexto2.setBounds(120, 50, 150,20);
        campoTexto3.setBounds(120, 90, 150,20);

        etiq1.setBounds(70, 10, 150, 20);
        etiq2.setBounds(50, 50, 150, 20);
        etiq3.setBounds(70, 90, 150, 20);

        add(campoTexto1);
        add(campoTexto2);
        add(campoTexto3);
        add(etiq1);
        add(etiq2);
        add(etiq3);

        EventosDeFoco foco = new EventosDeFoco();
        campoTexto1.addFocusListener(foco);
        campoTexto2.addFocusListener(foco);
    }

}
