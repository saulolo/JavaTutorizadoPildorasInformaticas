package unit4_Eventos.ejer_1_EventosMouse_MensajeDeTexto;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * En este ejercicio debes crear un marco con un panel en su interior. Al hacer clic con el ratón en el
 * panel, debe salir un mensaje de texto en consola. El mensaje puede ser el que quieras. En la
 * siguiente imagen aparece un ejemplo del resultado:
 * (Pildoras Informaticas. Java Tutorizado. Ejercicio Eventos I)
 * Imprime en consola:
 * Hola alumnos de Java - Respondiendo a eventos.
 * @author Saulolo
 */

public class EjerciciosEventos1 {

    /**
     * La clase Main es la entrada principal del programa. Inicializa una instancia de VentanaSaludo
     * y configura la operación de cierre de la ventana.
     */
    public static void main(String[] args) {

        VentanaSaludo saludo = new VentanaSaludo();

        saludo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


/**
 * La clase VentanaSaludo representa una ventana de saludo en la aplicación. Extiende JFrame
 * y se utiliza para mostrar un panel de saludo al usuario.
 */
class VentanaSaludo extends JFrame{

    public VentanaSaludo() {
        setBounds(300, 300, 650, 400);
        PanelSaludo panel = new PanelSaludo();
        panel.addMouseListener(new saludoRaton());
        add(panel);
        setVisible(true);
    }
}

/**
 * La clase PanelSaludo representa un panel de saludo en la aplicación. Extiende JPanel
 * y se utiliza para mostrar un saludo al usuario.
 */
class PanelSaludo extends JPanel{
    public PanelSaludo() {
    }
}

/**
 * La clase saludoRaton implementa la interfaz MouseListener y define cómo responder a los eventos del ratón.
 * En este caso, muestra un saludo por consola cuando se hace clic en el área asociada.
 */
class saludoRaton implements MouseListener{

    /**
     * El método mouseClicked se invoca cuando se produce un evento de clic del ratón.
     * Imprime un mensaje en la consola indicando que se está respondiendo a eventos de Java.
     * @param e El evento de clic del ratón
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("Hola alumnos de Java - Respondiendo a eventos.");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}