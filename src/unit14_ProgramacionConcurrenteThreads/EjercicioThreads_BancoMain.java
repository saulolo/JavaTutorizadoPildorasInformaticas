package unit14_ProgramacionConcurrenteThreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Construir un banco donde se van a abrir 100 cuentas corrientes, cada cuenta ciorriente
 * tendra un saldo inicial de 2000 euros, eso quiere decir que el saldo total del banco
 * es: 200.000 euros, ademas de esto, el programa se encargará de hacer transferencias
 * inifinitas entre una cuenta y otra, pero el saldo total del banco sigue siendo 200.000
 * euros. Debemos mostrar el saldo cada x tiempo.
 * resumen:
 * Cuentas: 100.
 * Saldo inicial en cuentas: 2.000 euros.
 * Saldo total en todaas la cuentas: 2.000 x 100 = 200.000 euros.
 *
 * @author Saulolo
 */

public class EjercicioThreads_BancoMain {
    public static void main(String[] args) {

        Banco b = new Banco();

        for (int i = 0; i < 100; i++) {
            EjecutandoTransferencia r = new EjecutandoTransferencia(b, i, 2000);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
class Banco {

    //Atributos
    private final double[] cuentas;
    private Lock bloqueaBanco = new ReentrantLock();
    private Condition saldoSuficiente;

    //Constructor
    public Banco() {
        cuentas = new double[100]; //Inicialice el tamaño del array desde el constructor.

        //Inicio cada cuenta con un saldo inisial de 2000 euros.
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }

        saldoSuficiente = bloqueaBanco.newCondition();
    }

    //Métodos
    public void tansferencia(int cuentaOrigen, int cuentaDestrino, double cantidad) throws InterruptedException {

        bloqueaBanco.lock();

        try {
            //if(cuentas[cuentaOrigen] < cantidad) return;  //Evitar que se haga la transferencia.

            while (cuentas[cuentaOrigen] < cantidad) saldoSuficiente.await();
            System.out.println(Thread.currentThread());

            cuentas[cuentaOrigen] -= cantidad;

            //Formato de impresion
            //System.out.println(cantidad + " Є de la cuenta " + cuentaOrigen + " a la cuenta " + cuentaDestrino);
            System.out.printf("%10.2f de %d para la cuenta %d" ,cantidad, cuentaOrigen, cuentaDestrino);
            System.out.println();
            cuentas[cuentaDestrino] += cantidad;

            System.out.printf("Saldo Total: %10.2f%n", getSaldoTotal());

            saldoSuficiente.signalAll();
        } finally {
            bloqueaBanco.unlock();
        }
    }


    public double getSaldoTotal() {
        double sumaSaldoBanco = 0;

        for (double a : cuentas) {
            sumaSaldoBanco = a;
        }
        return sumaSaldoBanco;
    }

}

class EjecutandoTransferencia implements Runnable{

    private Banco miBanco;
    private int cuentaDeOrigen;
    private double cantidadMaxima;

    public EjecutandoTransferencia(Banco miBanco, int cuentaDeOrigen, double cantidadMaxima) {
        this.miBanco = miBanco;
        this.cuentaDeOrigen = cuentaDeOrigen;
        this.cantidadMaxima = cantidadMaxima;
    }

    @Override
    public void run() {

        //Bucle infinito
        while (true) {
            int cuentaDeDestino = (int) (Math.random() * 100);
            double cantidadATransferir = cantidadMaxima * Math.random();

            try {
            miBanco.tansferencia(cuentaDeOrigen, cuentaDeDestino, cantidadATransferir);
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
