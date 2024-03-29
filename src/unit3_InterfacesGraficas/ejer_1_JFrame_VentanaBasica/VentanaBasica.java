package unit3_InterfacesGraficas.ejer_1_JFrame_VentanaBasica;

import javax.swing.*;
import java.awt.*;

/**
 * En este ejercicio se trata de crear una un programa que reproduzca las ventanas que vemos en la imagen:
 * (Java Tutorizado. Ejercicio JFrame. Pildoras Informaticas).
 * - Al cerrar cualquiera de las 3 ventanas, se cerrarán las demás automáticamente.
 * - Habrá una clase diferente de la principal encargada de la construcción de las ventanas.
 * - El tamaño, la posición y el título de las ventanas se darán desde el constructor de la clase encargada de
 * construir las ventanas.
 * @author Saulolo
 */

public class VentanaBasica extends JFrame {

    //Constructor
    public VentanaBasica(int ancho, int alto, int posicionX, int posicionY, String titulo) throws HeadlessException {
        setSize(ancho, alto);
        setLocation(posicionX, posicionY);
        setTitle(titulo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //setBounds: me estrablece de una vez posicion en X, Y, ancho y alto.

    }

}
