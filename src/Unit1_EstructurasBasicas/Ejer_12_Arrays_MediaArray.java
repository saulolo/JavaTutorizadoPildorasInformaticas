package Unit1_EstructurasBasicas;

import java.util.Scanner;

/**
 * @author Saulolo
 */

public class Ejer_12_Arrays_MediaArray {

    /**
     * En este ejercicio, se pide al usuario que introduzca 10 números enteros por consola. Los números se
     * almacenarán en un array y el programa calculará la media de los números introducidos en las
     * posiciones pares del array. (Debes utilizar el operador módulo “%”).
     */

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int media = 0;
        int pares = 0;

        System.out.println("Introduce 10 números");

        int numeros[] = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce el número " + (i + 1) + ":");
            numeros[i] = input.nextInt();
        }

        for (int z = 0; z < 10 ; z++) {
            if (z % 2 == 0) {
                pares++;
                media = media + numeros[z];
            }
        }

        System.out.println("La media de las posiciones pares del array es: " + media / pares);
    }
}
