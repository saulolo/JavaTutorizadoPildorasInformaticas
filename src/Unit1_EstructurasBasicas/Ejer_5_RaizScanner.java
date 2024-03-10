package Unit1_EstructurasBasicas;

import java.util.Scanner;

/**
 *@author Saulolo
 */

public class Ejer_5_RaizScanner {

    /**
     * Crea una clase con el nombre de RaizScanner. Al ejecutar el programa nos debe pedir introducir un nº
     * por consola. Después de introducir el nº y pulsar ENTER, el programa devuelve en consola la raíz
     * cuadrada del número tal y como aparece en la siguiente imagen:
     * Introduce un numéro:
     * 9
     * La raiz de 9 es = 3.0
     * Modifica el programa del ejercicio anterior para reducir lo máximo posible el nº de líneas de código.
     * El resultado al ejecutar el programa debe ser el que aparece en la siguiente imagen
     */

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Introduce un número: ");

        double raizCuadrada =  Math.sqrt(input.nextInt());

        System.out.println("La raiz es: " + raizCuadrada);

    }
}
