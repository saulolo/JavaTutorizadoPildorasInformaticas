package unit2_POO.ejer_7_Interfaces_Vehiculos;

/**
 * @author Saulolo
 */

public class Moto implements Vehiculo{

    private int velocidad;

    public Moto(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Incrementa la velocidad de la moto en la cantidad especificada.
     * Si la velocidad resultante supera la velocidad máxima permitida,
     * se devuelve un mensaje indicando que se ha excedido el límite.
     * En caso contrario, se devuelve un mensaje con la velocidad actual.
     * @param cantidad la cantidad de aceleración que se aplicará a la velocidad
     * @return un mensaje indicando la velocidad actual o un mensaje de advertencia
     * si se ha excedido la velocidad máxima permitida
     */
    @Override
    public String acelerar(int cantidad) {
        velocidad = velocidad + cantidad;
        if (velocidad >= VELOCIDAD_MAXIMA) return "Ha excedido el límite de velocidad máxima permitido.";
        return "Velocidad actual: " + velocidad;
    }

    /**
     * Reduce la velocidad de la moto en la cantidad especificada.
     * Si la velocidad resultante es menor a cero, se establece la velocidad a cero.
     * @param cantidad la cantidad de frenado que se aplicara a al velocidad.
     * @return la velocidad final despues de aplicar el frenado.
     */
    @Override
    public int frenar(int cantidad) {
        velocidad = velocidad - cantidad;
        if (velocidad < 0) velocidad = 0;
        return velocidad;
    }

    /**
     * Devuelve  el número de plazas disponibles que tiene una moto.
     * @return las cinco plazas dicponibles para un coche.
     */
    @Override
    public int plazas() {
        return 2;
    }
}
