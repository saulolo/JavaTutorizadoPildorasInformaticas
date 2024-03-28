package unit1_EstructurasBasicas;

import javax.swing.*;

/**
 *@author Saulolo
 */

public class Ejer_6_JOptionPane_CalculoPotencia {

    /**
     * Crea una clase con el nombre de CalculoPotenciaJOptionPane. Al ejecutar el programa nos debe pedir
     * introducir dos valores numéricos utilizando una ventana de tipo showInputDialog:
     * Una base
     * Un exponente
     * Una vez introducidos los dos valores, el programa mostrará en consola el resultado de elevar la base
     * al exponente tal y como aparece en la siguiente imagen:
     * El resultado de 5 elevado a 3 es 125.0
     */

    public static void main(String[] args) {

        int base = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la base: "));
        int exponente = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el exponente: "));

        System.out.println("El resultado de " + base + " elevado a la " + exponente + " es " + Math.pow(base, exponente));

    }
}
