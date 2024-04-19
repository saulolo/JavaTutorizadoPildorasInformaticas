package unit13_ProgramacionGenerica.EjercicioArrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * En este ejercicio se trata de crear una aplicación que pida introducir números enteros por
 * consola y que los vaya almacenando en un ArrayList. Cuando se introduce el número 0, el
 * programa deja de pedir números e imprime en consola 3 cálculos:
 * La suma de los números introducidos
 * La media de los números introducidos
 * Cuántos números se han introducido que son superiores a la media.
 * @author Saulolo
 */
public class EjercicioArrayList {

    int numIntroducido;
    int suma = 0;
    double promedio = 0;
    int numMayorMedia = 0;

    ArrayList<Integer> arrayNumeros = new ArrayList<>();


    /**
     * Almacena números ingresados por el usuario en un ArrayList.
     * Los números se ingresan desde la entrada estándar (consola).
     * El proceso de ingreso de números termina cuando se ingresa el número 0.
     */
    public void almacenarNumeros() {
        Scanner input = new Scanner(System.in);

        System.out.println("Introduce los números (Escribe el número 0 para terminar): ");
        while (true) {
            numIntroducido = input.nextInt();
            if (numIntroducido == 0) {
                break;
            }
            arrayNumeros.add(numIntroducido);
        }
    }


    /**
     * Calcula la suma de los números almacenados en el ArrayList.
     *
     * @return La suma de los números almacenados en el ArrayList.
     */
    public int calcularSuma() {
        for (int num : arrayNumeros) {
            suma = suma + num;
        }
        return suma;
    }


    public double calularPromedio() {
        promedio = (double) suma / arrayNumeros.size();
        return promedio;
    }

    /**
     * Calcula el promedio de los números almacenados en el ArrayList.
     *
     * @return El promedio de los números almacenados en el ArrayList.
     */
    public int contarMayoresMedia() {
        calularPromedio();
        for (Integer num : arrayNumeros) {
            if (num >= promedio) {
                numMayorMedia++;
            }
        }
        return numMayorMedia;
    }


    /**
     * Devuelve una representación en forma de cadena de texto de los números ingresados, la suma, el promedio
     * y la cantidad de números mayores o iguales al promedio.
     *
     * @return Una cadena de texto que representa los números ingresados, la suma, el promedio y la cantidad
     * de números mayores o iguales al promedio.
     */
    @Override
    public String toString() {
        return  "Numeros ingresados =" + arrayNumeros +
                ", \nLa Suma de los números introducidos es = " + suma +
                ", \nEl promedio de los números introducidos es = " + promedio +
                ", \nCantidad de números mayores o iguales a la media = " + numMayorMedia;
    }
}
