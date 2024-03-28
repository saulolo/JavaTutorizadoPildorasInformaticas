package unit2_POO.ejer_2_EmpresaDeEnvios;

/**
 * @author Saulolo
 */

public class Sucursal {

    //Atributos
    private int numeroSucursal;
    private String direccion;
    private String ciudad;


    //Constructor
    public Sucursal(int numeroSucursal, String direccion, String ciudad) {
        this.numeroSucursal = numeroSucursal;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    //Getters and Setters
    public int getNumeroSucursal() {
        return numeroSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    /**
     * Calcula el precio de envío de un paquete en función de su prioridad.
     * Si la prioridad del envío es 1, se agrega un recargo de 10 euros al precio.
     * Si la prioridad del envío es 2, se agrega un recargo de 20 euros al precio.
     * @param paquete El paquete del cual se calculará el precio de envío.
     * @return El precio calculado del envío del paquete.
     */
    public double calcularPrecio(Paquete paquete) {
        double precio;
        precio = paquete.getPeso();
        if (paquete.getPrioridadEnvio() == 1) precio = precio + 10;
        else if (paquete.getPrioridadEnvio() == 2) precio = precio + 20;
        return precio;

    }


}
