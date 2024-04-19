package unit8_Excepciones.EntradaDatos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDatosIOException {

    public static void main(String[] args) {

        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Introducir datos");
        System.out.println("2. Salir del programa");

        Scanner entrada=new Scanner (System.in);

        int decision=entrada.nextInt();

        if (decision==1){

            try {
                pedirDatos();
            } catch (Exception e) {
                System.out.println("Introducción errónea.");
                e.printStackTrace();
            }

        }else{

            System.out.println("Adios");

            System.exit(0);
        }

        entrada.close();

        System.out.println("Hemos terminado");


        /*
            Asi lanzo una excepción para usarla en cualquier parte pero tamnbien lo invoco
            en la declaración del método.
            ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException();
            throw e;
            y si quero encerrarlo con try - catch, debo hacer que me herede de Una excepción de
            IOException, pero esta es generica.
         */


    }


    //Es una mala practica lanzar una excepción generica, se debe capturar la excepción real.
    //En este caso la de InputMismatchException
    static void pedirDatos() throws IOException {

        Scanner entrada=new Scanner(System.in);

        System.out.println("Introduce tu nombre, por favor");

        String nombre_usuario=entrada.nextLine();

        System.out.println("Introduce edad, por favor");

        int edad=entrada.nextInt();

        System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad+1) + " años");

        entrada.close();

    }
}
