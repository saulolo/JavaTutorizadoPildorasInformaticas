package unit1_EstructurasBasicas;

import java.util.Scanner;

/**
 *@author Saulolo
 */

public class Ejer_8_BucleWhile_NumeroAleatorio {

    /**
     * Debes crear un programa que genere un número aleatorio entre 1 y 100 y lo guarde en una variable.
     * Al ejecutar el programa este pedirá por consola la introducción de un número entre 1 y 100.
     * Si el nº introducido por el usuario es mayor que el generado por el programa aleatoriamente, saldrá
     * un mensaje en consola indicando que “el nº es menor”.
     * Si el nº introducido por el usuario es menor que el generado por el programa aleatoriamente, saldrá
     * un mensaje en consola indicando que “el nº es mayor”.
     * La operativa se repetirá indefinidamente hasta que el usuario adivine el nº aleatorio generado por el
     * programa. Cuando se adivine el nº aleatorio, debe salir un mensaje en consola que diga “Correcto” y el
     * nº de intentos consumidos para averiguar el nº
     */

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numeroAleatorio = (int) (Math.random() * (100 - 1 + 1)) + 1;
        int numeroIntroducido = 0;
        int contador = 0;

        while (numeroIntroducido != numeroAleatorio) {

            String mensaje = (numeroIntroducido > numeroAleatorio) ? "El número es menor." : "El número es mayor.";

            System.out.println(mensaje);

            System.out.println("Introduce un número del 1 al 100: ");
            numeroIntroducido = input.nextInt();

            contador = contador + 1;

        }

        System.out.println("Correcto, lo adivinaste en: " + contador + " intentos.");

    }
}
