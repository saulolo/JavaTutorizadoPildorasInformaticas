package unit11_Serializacion.serializacionDeObjetos;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Serializar un objeto.
 * @author Saulolo
 */
class Empleado implements Serializable {

    private String nombre;
    private double sueldo;
    private Date fechaContrato;

    public Empleado(String n, double s, int agno, int mes, int dia) {

        nombre = n;
        sueldo = s;

        GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
        fechaContrato = calendario.getTime();
    }


    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    /**
     * Aumenta el sueldo actual del empleado en un cierto porcentaje.
     *
     * @param porcentaje El porcentaje de aumento a aplicar al sueldo actual.
     * @throws IllegalArgumentException Si el porcentaje es negativo.
     */
    public void subirSueldo(double porcentaje) {
        if (porcentaje < 0) {
            throw new IllegalArgumentException("El porcentaje de aumento no puede ser negativo");
        }

        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }

    /**
     * Devuelve una representación en forma de cadena de caracteres de la instancia actual.
     * La cadena contiene el nombre del empleado, su sueldo y la fecha de contrato.
     *
     * @return Una cadena que representa la instancia actual.
     */
    public String toString() {
        return "El Nombre es =" + nombre + ",y su sueldo es =" + sueldo + ", fecha de contrato=" + fechaContrato;
    }
}

//--------------------------------------------------------------------------------------------------------

class Administrador extends Empleado {

    //Constante serializable
    private static final long serialVersionUID = 2L;
    private double incentivo;


    public Administrador(String n, double s, int agno, int mes, int dia) {

        super(n, s, agno, mes, dia);

        incentivo = 0;

    }

    public double getSueldo() {

        double sueldoBase = super.getSueldo();

        return sueldoBase + incentivo;

    }

    public void setIncentivo(double b) {

        incentivo = b;
    }


    /**
     * Devuelve una representación en forma de cadena de caracteres de la instancia actual.
     * La cadena contiene la representación de la instancia de la superclase, seguida del valor del incentivo.
     *
     * @return Una cadena que representa la instancia actual, incluyendo la representación de la superclase y el valor del incentivo.
     */
    public String toString() {
        return super.toString() + " Incentivo=" + incentivo;
    }

}

