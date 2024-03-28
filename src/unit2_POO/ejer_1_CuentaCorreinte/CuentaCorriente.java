package unit2_POO.ejer_1_CuentaCorreinte;

import java.util.Random;

/**
 * @author Saulolo
 */
public class CuentaCorriente {

    //Atributos
    private double saldo;
    private String nombreTitular;
    private long numeroCuenta;


    //Constructor
    public CuentaCorriente(String nombreTitular, double saldo) {
        this.saldo = saldo;
        this.nombreTitular = nombreTitular;
        Random rnd = new Random();
        numeroCuenta = Math.abs(rnd.nextLong());
    }

    //Métodos

    /**
     * Este método permite realizar un ingreso en la cuenta, aumentando el saldo disponible.
     * Si el valor del ingreso es negativo, se muestra un mensaje de advertencia en la consola
     * y no se realiza ninguna operación en la cuenta.
     *
     * @param ingreso El monto del ingreso a realizar.
     */
    public void setIngreso(double ingreso) {
        if (ingreso < 0) System.out.println("No se permiten ingresos negativos.");
        else saldo += ingreso;
    }

    public void setReintegro(double reintegro) {
        saldo -= reintegro;
    }

    public String getSaldo() {
        return "El saldo de la cuenta es: " + saldo;
    }


    /**
     * Realiza una transferencia de fondos entre dos cuentas corrientes.
     * La cantidad especificada se resta del saldo de la cuenta del primer titular
     * y se suma al saldo de la cuenta del segundo titular.
     *
     * @param titu1 La cuenta corriente del primer titular desde la que se restará la cantidad.
     * @param titu2 La cuenta corriente del segundo titular a la que se sumará la cantidad.
     * @param cantidad La cantidad de dinero a transferir entre las cuentas.
     * @throws IllegalArgumentException Si la cantidad es negativa.
     */
    public static void Transferencia(CuentaCorriente titu1, CuentaCorriente titu2, double cantidad) {
        if(cantidad >= 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        titu1.saldo -= cantidad;
        titu1.saldo += cantidad;
    }

    /**
     * Devuelve una cadena que contiene los datos de la cuenta corriente en un formato legible.
     *
     * @return Una cadena que contiene el nombre del titular, el número de cuenta y el saldo.
     */
    public String getDatosCuenta() {
        return "Titular: " + nombreTitular + "\n" +
                "No de Cuenta: " + numeroCuenta + "\n" +
                "Saldo: " + saldo;
    }

}
