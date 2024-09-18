package unit15_Colecciones.Maps_Empleados;

public class EmpleadosMaps {

    private String nombre;
    private double salario;


    public EmpleadosMaps(String nombre) {
        this.nombre = nombre;

        salario = 1_300_000;
    }


    @Override
    public String toString() {
        return "Empleado{" + "nombre='" + nombre + ", salario=" + salario + '}';
    }
}
