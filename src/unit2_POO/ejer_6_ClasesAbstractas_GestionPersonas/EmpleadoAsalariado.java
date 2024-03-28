package unit2_POO.ejer_6_ClasesAbstractas_GestionPersonas;

import java.util.Calendar;

public class EmpleadoAsalariado extends Empleado{

    //Atributos
    private double salarioBase;


    //Constructores
    public EmpleadoAsalariado() {
        super();
        salarioBase = 0;
    }

    public EmpleadoAsalariado(String DNI, String nombre, String apellidos, int anioIngreso, double salarioBase) {
        super(DNI, nombre, apellidos, anioIngreso);
        this.salarioBase = salarioBase;
    }

    //Getters and Setters
    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    //Métodos
    @Override
    public double getSalario() {
        Calendar ahora = Calendar.getInstance();
        int anioActual = ahora.get(Calendar.YEAR);
        int anios = anioActual - getAnioIngreso();

        if (anios < 0) System.out.println("Los años no pueden ser negativos");
        else if (anios < 2) return salarioBase;
        else if (anios >= 2 && anios <= 3) return salarioBase * 0.07 + salarioBase;
        else if (anios >= 4 && anios <= 8) return  salarioBase * 0.11 + salarioBase;
        else if (anios >= 9 && anios <= 15) return salarioBase * 0.17 + salarioBase;
        return salarioBase * 0.22 + salarioBase;
    }


    public void imprimir() {
        super.imprimir();
        System.out.printf("Salario: %.2f\n", getSalario());
        System.out.println();
    }

}
