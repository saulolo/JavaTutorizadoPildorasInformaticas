package unit2_POO.ejer_7_Interfaces_Vehiculos;

/**
 * @author Saulolo
 */

public interface Vehiculo {

    //Constante
    public static final int VELOCIDAD_MAXIMA = 120;

    //Métodos
    public abstract String acelerar(int velocidad);

    int frenar(int velocidad);

    int plazas();

}
