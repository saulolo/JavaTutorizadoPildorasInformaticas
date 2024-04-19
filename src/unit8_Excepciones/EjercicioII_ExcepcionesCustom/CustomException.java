package unit8_Excepciones.EjercicioII_ExcepcionesCustom;

import javax.swing.*;

/**
 * Crea un programa que pida al usuario introducir desde una ventana JOptionPane un número entre
 * 1 y 100. Si el usuario introduce un número fuera de ese rango el programa lanzará una excepción
 * propia. El mensaje de la excepción será “El nº está fuera de rango”.
 * @author Saulolo
 */
public class CustomException {

    /**
     * Evalúa si el número ingresado por el usuario está dentro del rango de 1 a 100.
     * Si el número está dentro del rango, imprime un mensaje indicando que el número es correcto.
     * Si el número está fuera del rango, lanza una excepción.
     *
     * @throws NumeroFueraRango si el número está fuera del rango especificado.
     */
    public void evaluaNumero() throws NumeroFueraRango{

        int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número entre 1 y 100."));

        if (numero >= 1 && numero <= 100) {
            System.out.println("Número correcto");

        } else {
            throw new NumeroFueraRango("El número esta fuera del rango.");
        }

    }

}


/**
 * Esta clase representa una excepción que se lanza cuando un número está fuera del rango especificado.
 */
class NumeroFueraRango extends Exception {
    public NumeroFueraRango(String mensaje) {
        super(mensaje);
    }
}
