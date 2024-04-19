package unit13_ProgramacionGenerica.EjercicioArrayList;

import java.security.PublicKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
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
public class EjercicioArrayListSolucion2 {

    public static void main(String[] args) {


        ArrayList<Integer> miArrayList = leerDatos();
        double suma = calcularSuma(miArrayList);
        double media = suma / miArrayList.size();
        mostrarResultados(miArrayList, suma, media);


    }


    /**
     * Lee números enteros desde la entrada estándar y los almacena en un ArrayList.
     * El proceso termina cuando se ingresa el número 0.
     *
     * @return Un ArrayList que contiene los números ingresados, excluyendo el 0.
     */
    public static ArrayList<Integer> leerDatos() {
        ArrayList<Integer> datos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int num;
        System.out.println("Introduce un número entero: ");
        num = entrada.nextInt();
        while (num != 0) {
            datos.add(num);
            System.out.println("Introduce el número 0 para salir.");
            num = entrada.nextInt();
        }

        return datos;
    }


    /**
     * Calcula la suma de los valores en la lista proporcionada.
     *
     * @param valores La lista de valores de la cual se calculará la suma.
     * @return La suma de los valores en la lista.
     */
    public static double calcularSuma(ArrayList<Integer> valores){
        double suma = 0;
        Iterator iterator = valores.iterator();
        while (iterator.hasNext()) {
            suma = suma + (Integer) iterator.next(); //devuelve un dato de tipo Object,
            //hay que convertirlo a Integer.
        }
        return suma;
    }


    public static void mostrarResultados(ArrayList<Integer> valores, double suma, double media) {
        int contador = 0;
        System.out.println("Valores introducidos: ");
        System.out.println(valores);
        System.out.println("Suma: " + suma);
        System.out.printf("Media: %.2f %n" , media);
        for (Integer i : valores) {
            if (i > media) {
                contador++;
            }
        }
        System.out.println(contador + " Valores superiores a la media.");
    }
}
