package Unit2_POO.Ejer_3_GettersYSetters;

import java.util.Random;

public class CuentaCorriente {

    //Atributos
    private String nombreTitular;
    private double saldoInicial;
    private long NroCuenta;


    //Constructor
    public CuentaCorriente(String nombreTitular, double saldoInicial) {
        this.nombreTitular = nombreTitular;
        this.saldoInicial = saldoInicial;
        NroCuenta = getNroCuenta();

    }



    //Métodos

    //Ingresa saldo a la cuenta
    public void setIngreso(double ingreso) {
        if (ingreso >= 0) saldoInicial = saldoInicial + ingreso;
        else System.out.println("No se permiten ingresos negativos.");;
    }

    //Retira saldo de la cuentas
    public void setReintegro(double reintegro) {
        saldoInicial -= reintegro;

    }

    //Muestra saldo final
    public String getSaldoFinal() {
        return "El saldo de la cuenta es: " + saldoInicial;
    }

    //Transferencia
    public static void transferencia(CuentaCorriente origen, CuentaCorriente destino, double cantidad) {
        origen.saldoInicial -= cantidad;
        destino.saldoInicial += cantidad;
    }


    //Devuelve un número aleatorio
    public static long getNroCuenta() {
        Random rnd = new Random();
        long aleatorio = Math.abs(rnd.nextLong());
        return aleatorio;
    }


    //Devuele datos de la cuenta
    public String getDatosCuenta() {
        return "El Titual de la cuenta con nombre: " + nombreTitular + "\n" +
                " y número de cuenta: " + NroCuenta + "\n" +
                " tiene un saldo de: " + saldoInicial;
    }

}


class UsoCuentaCorreinte {

    public static void main(String[] args) {


        CuentaCorriente cuenta1 = new CuentaCorriente("Saul Echeverri", 1500);
        CuentaCorriente cuenta2 = new CuentaCorriente("Maria Lopez", 2500);

        CuentaCorriente.transferencia(cuenta1, cuenta2, 200);

        System.out.println(cuenta1.getDatosCuenta());
        System.out.println(cuenta2.getDatosCuenta());

    }

}
