package unit2_POO.ejer_7_Interfaces_Vehiculos;

/**
 * En este ejercicio se crearán dos clases con los nombres de “Coche” y “Moto”. Ambas clases
 * tendrán una propiedad con el nombre de VELOCIDAD_MAXIMA=120 y tres comportamientos con
 * los nombres de ACELERAR, FRENAR y PLAZAS.
 * El comportamiento PLAZAS debe devolver el nº de plazas de motos y coches, siendo de 2
 * en al caso de las motos y 5 en el caso de los coches.
 * Los comportamientos ACELERAR Y FRENAR  deben incrementar o decrementar la velocidad del
 * coche o la moto la cantidad que se le pase por parámetro a los métodos que determinan
 * ambos comportamientos. En caso de que la velocidad supere la VELOCIDAD_MAXIMA establecida
 * en la propiedad, el método ACELERAR debe informar que la velocidad máxima ha sido superada.
 * Tanto la propiedad como los comportamientos deben ser definidos en una interfaz con el
 * nombre “Vehiculo” para que sea obligado su desarrollo en las clases “Moto” y “Coche”.
 * Los objetos de tipo “Coche” y “Moto” tendrán una velocidad inicial establecida en su
 * constructor.
 * En la clase principal se creará un array de tipo Vehiculo donde se almacenarán objetos
 * de tipo “Coche” y “Moto”. Usaremos los comportamientos ACELERAR, FRENAR Y PLAZAS con dichos
 * objetos para comprobar su buen funcionamiento.
 * @author Saulolo
 */

public class Coche implements Vehiculo{

    private int velocidad;

    //Constructor
    public Coche(int velocidadInicial) {
        this.velocidad = velocidadInicial;
    }

    /**
     * Incrementa la velocidad del coche en la cantidad especificada.
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
     * Reduce la velocidad del coche en la cantidad especificada.
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
     * Devuelve  el número de plazas disponibles que tiene un coche.
     * @return las cinco plazas dicponibles para un coche.
     */
    @Override
    public int plazas() {
        return 5;
    }
}
