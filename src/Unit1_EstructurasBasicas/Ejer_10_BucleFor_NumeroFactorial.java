package Unit1_EstructurasBasicas;

import javax.swing.*;

/**
 * @author Saulolo
 */

public class Ejer_10_BucleFor_NumeroFactorial {

    /**
     * En este ejercicio, se pide el cálculo del factorial de un número introducido por el usuario desde
     * una ventana JOptionPane. El factorial de un número es igual a ese número multiplicado por todos los
     * que le preceden. Por ejemplo, el factorial de 5 es igual a 5x4x3x2x1, es decir, 120.
     */


    public static void main(String[] args) {

        int numero;

        numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un número: "));

        long factorial = numero;

        for (int i = numero-1; i > 0; i--) {

            factorial = factorial * i;
        }
        System.out.println("El factorial de: " + numero + " es: " + factorial);
    }
}
