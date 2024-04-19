package unit8_Excepciones.EntradaDatos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Manejo de los Try - Catch con RuntimeException
 * @author Saulolo
 */
public class EntradaDatosRuntimeException {

    public static void main(String[] args) {

        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Introducir datos");
        System.out.println("2. Salir del programa");

        Scanner entrada=new Scanner (System.in);

        int decision=entrada.nextInt();

        if (decision==1){

            try {
                pedirDatos();
            } catch (InputMismatchException e){ //Puedo poner el la clase padre Excepcion
                System.out.println("No se permite ingresar cadena de texto.");
                e.printStackTrace(); //Para imprimir la pila de excepciones
            }

        }else{

            System.out.println("Adios");

            System.exit(0);
        }

        entrada.close();

        System.out.println("Hemos terminado");

    }


    static void pedirDatos() throws InputMismatchException {

        Scanner entrada=new Scanner(System.in);

        System.out.println("Introduce tu nombre, por favor");

        String nombre_usuario=entrada.nextLine();

        System.out.println("Introduce edad, por favor");

        int edad=entrada.nextInt();

        System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad+1) + " años");

        entrada.close();

    }
}
