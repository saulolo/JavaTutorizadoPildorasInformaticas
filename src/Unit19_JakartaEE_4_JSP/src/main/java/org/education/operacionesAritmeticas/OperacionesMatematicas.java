package org.education.operacionesAritmeticas;

public class OperacionesMatematicas {



    public static int suma(int numA, int numB) {
        return numA + numB;
    }

    public static int resta(int numA, int numB) {
        return numA - numB;
    }

    public static int multiplicacion(int numA, int numB) {
        return numA * numB;
    }

    public static void division(int numA, int numB) {
        if (numB != 0) {
            int resultado = numA / numB;
        }
        else System.out.println("La division por cero no es posible dentro de los números reales.");
    }
}
