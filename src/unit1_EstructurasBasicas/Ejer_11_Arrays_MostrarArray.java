package unit1_EstructurasBasicas;

import java.util.Scanner;

/**
 * @author Saulolo
 */

public class Ejer_11_Arrays_MostrarArray {

    /**
     * En este ejercicio se pide al usuario que introduzca 10 números enteros por consola. Los números
     * introducidos se almacenarán en un array. El programa imprime en consola cuántos números negativos,
     * positivos y valores 0 hay en el array.
     */

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int positivos = 0;
        int negativos = 0;
        int cero = 0;
        int [] numeros = new int[10];

        System.out.println("Introduce 10 números");

        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce el número " + (i + 1) + ":");
            numeros[i] = input.nextInt();
        }
        System.out.println();
        System.out.println("Los números introducidos fueron: ");

        System.out.println("====================================================");

        for (int elemento : numeros) {

           int cond1 = (elemento > 0) ? positivos++ : positivos;
           int cond2 = (elemento < 0) ? negativos++ : negativos;
           int cond3 = (elemento == 0) ? cero++ : cero;

            System.out.print(elemento + ", ");
        }

        System.out.println();
        System.out.println("====================================================");
        System.out.println("Los números positivos introducidos fueron: " + positivos);
        System.out.println("Los números negativos introducidos fueron: " + negativos);
        System.out.println("Los ceros introducidos fueron: " + cero);
    }
}
