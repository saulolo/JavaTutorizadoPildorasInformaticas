package Unit2_POO.Ejer_2_EmpresaDeEnvios;

import java.util.Scanner;

/**
 * @author Saulolo
 */
public class UsoSucursalYPaquetes {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int nSucursal, nPaquetes, ref, prioridad;
        String direccion, ciudad, DNI;
        double peso;

        System.out.println("Ingrese los datos de la sucursal");
        System.out.println();
        System.out.println("Número de la sucursal: ");
        nSucursal = input.nextInt();
        System.out.println("Dirección: ");
        direccion = input.next();
        System.out.println("Ciudad");
        ciudad = input.next();

        Sucursal s1 = new Sucursal(nSucursal, direccion, ciudad);

        System.out.println("Introduzca el número de paquetes a enviar: ");
        nPaquetes = input.nextInt();

        Paquete[] paquetes = new Paquete[nPaquetes];

        System.out.println("Introduzca los datos de cada paquete: ");
        for (int i = 0; i < nPaquetes; i++) {
            System.out.println("Introduzca los datos del paquete " + (i + 1));
            System.out.println("Referencia: ");
            ref = input.nextInt();
            System.out.println("DNI del remitente: ");
            DNI = input.next();
            System.out.println("Peso: ");
            peso = input.nextDouble();
            System.out.println("Prioridad: ");
            prioridad = input.nextInt();
            paquetes[i] = new Paquete(ref, peso, DNI, prioridad);
        }

        System.out.println("\n Los datos de la sucursal son: ");
        System.out.printf("Sucursal ", s1.getNumeroSucursal());
        System.out.println("Situada en " + s1.getDireccion() + " de " + s1.getCiudad());
        System.out.println("\n\n Los datos de los paquetes son: ");

        for (int i = 0; i < nPaquetes; i++) {
            System.out.println("Paquete: " + (i + 1));
            System.out.println("Precio = " + s1.calcularPrecio(paquetes[i]));
            System.out.println("Peso = " + paquetes[i].getPeso());
            System.out.println("-------------------------------------------");

        }

    }

}
