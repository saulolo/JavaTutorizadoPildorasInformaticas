package unit2_POO.ejer_2_EmpresaDeEnvios;

/**
 * @author Saulolo
 */
public class Paquete {

    //Atributos
    private long ReferenciaEnvio;
    private double peso;
    private String dniremitente;
    private int prioridadEnvio;

    //Constructor
    public Paquete(long refererenciaEnvio, double peso, String dniremitente, int prioridadEnvio) {
        this.ReferenciaEnvio = refererenciaEnvio;
        this.peso = peso;
        this.dniremitente = dniremitente;
        this.prioridadEnvio = prioridadEnvio;
    }

    //Setter and Getter


    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getPrioridadEnvio() {
        return prioridadEnvio;
    }

    public void setPrioridadEnvio(short prioridadEnvio) {
        this.prioridadEnvio = prioridadEnvio;
    }


}
