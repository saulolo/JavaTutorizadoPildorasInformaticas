package unit8_Excepciones.EjercicioI_Excepciones;

import javax.swing.*;

/**
 * Crea un programa que pida al usuario introducir un número desde una ventana JOptionPane.
 * El programa debe devolver  un mensaje también en un JOptionPane especificando si el número
 * introducido por el usuario es par o impar.
 * Además, el programa debe controlar la excepción si el usuario introduce texto en lugar de un
 * valor numérico en la ventana JOptionPane. En caso de introducir texto, se debe advertir al
 * usuario que “El valor introducido no es numérico. El programa se cerrará”, terminando la
 * ejecución del programa sin hacer nada más.
 *
 * @author Saulolo
 */
public class ExcepcionesIValidarNumero {

    /**
     * Valida si el número ingresado por el usuario es par o impar.
     * Muestra un mensaje indicando si el número es par o impar.
     * Si el valor ingresado no es numérico, muestra un mensaje de error y cierra el programa.
     */

    public void validarNumero() {

        try {
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número: "));

            if (numero % 2 == 0) JOptionPane.showMessageDialog(null, "El número " + numero + " es par.");
            else if (!(numero % 2 == 0)) JOptionPane.showMessageDialog(null, "El número " + numero + " es impar.");
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "EL valor introducido no es numérico, el programa se cerrará");
            System.exit(1);
        }
    }


}
