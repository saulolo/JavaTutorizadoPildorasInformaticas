package unit2_POO.ejer_7_Interfaces_Vehiculos;

import java.util.Scanner;

/**
 * @author Saulolo
 */
public class VehiculosPrueba {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Array de tipo Vehiculo
        Vehiculo[] vehiculos = new Vehiculo[4];

        //Creo un coche con velocidad 0
        Coche miCoche1 = new Coche(0);

        //Creo un coche con velocidad 0
        Moto miMoto1 = new Moto(0);

        //Agregar los vehiculos(objetos) creados al array
        vehiculos[0] = miCoche1;
        vehiculos[1] = miMoto1;

        //Otra forma de crear vehiculos
        vehiculos[2] = new Coche(0);
        vehiculos[3] = new Moto(0);

        //Mostrar las opciones del ususario:
        System.out.println("Seleccione una opción: " +
                " \n1. Acelerar." +
                " \n2. Frenar." +
                " \n3. Mostrar plazas.");
        int opcion = input.nextInt();

        int cantidad;

        switch (opcion) {
            case 1:
                System.out.println("Ingrese la cantidad de aceleración: ");
                cantidad = input.nextInt();
                for (Vehiculo vehiculo : vehiculos) {
                    System.out.println(vehiculo.acelerar(cantidad));
                }
                break;

            case 2:
                System.out.println("Ingrese la cantidad de frenado: ");
                cantidad = input.nextInt();
                for (int i = 0; i < vehiculos.length; i++) {
                    System.out.println(vehiculos[i].frenar(cantidad));
                }
                break;
            case 3:
                System.out.println("Muestre el número de plazas disponibles.");
                for (Vehiculo vehiculo : vehiculos) {
                    System.out.println(vehiculo.plazas());
                }
                break;
            default:
                System.out.println("Opción no válida.");
        }

        input.close();



        /* SOLUCIÓN PRUEBA 2 */
        System.out.println();
        System.out.println("================================================================");
        System.out.println("SEGUNDA SOLUCIÓN DE PRUEBA");
        System.out.println("================================================================");

        Vehiculo[] autos = new Vehiculo[3];

        autos[0] = new Moto(30);
        autos[1] = new Moto(260);
        autos[2] = new Coche(60);

        System.out.println(autos[0].acelerar(50));
        System.out.println(autos[1].frenar(20));
        System.out.println(autos[2].plazas());
    }

}
