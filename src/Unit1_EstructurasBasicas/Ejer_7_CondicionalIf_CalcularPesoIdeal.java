package Unit1_EstructurasBasicas;

import javax.swing.*;

/**
 *@author Saulolo
 */

public class Ejer_7_CondicionalIf_CalcularPesoIdeal {

    /**
     * Debes crear un programa que permita calcular el peso ideal de una persona teniendo en cuenta lo siguiente:
     * Si la persona es una mujer, el peso ideal será igual a la altura en cm -120
     * Si la persona es un hombre, el peso ideal será igual a la altura en cm -110
     * El programa pedirá al usuario mediante una ventana emergente de tipo JOptionPane dos datos:
     * La altura en cm
     * El género, pudiendo ser este hombre o mujer.
     * En función de los datos introducidos, el programa imprimirá en consola el peso ideal.
     */

    public static void main(String[] args) {

        int altura;
        String genero;
        int pesoIdeal;

        altura = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la altura en cm: "));
        genero = JOptionPane.showInputDialog("Ingresa el genero (mujer || hombre): ");

        if (genero.equalsIgnoreCase("mujer")) {
            pesoIdeal = altura - 120;
        } else {
            pesoIdeal = altura - 110;
        }
        JOptionPane.showMessageDialog(null,"Tu peso ideal es: " + pesoIdeal + " Kg");
    }
}
