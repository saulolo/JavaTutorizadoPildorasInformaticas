package unit2_POO.ejer_6_ClasesAbstractas_GestionPersonas;

public class UsoEmpleado {
    public static void main(String[] args) {


        Empleado empleados[] = new Empleado[4];
        EmpleadoAsalariado empsal1 = new EmpleadoAsalariado("6546546Z", "Antonio" , "López", 2014, 1125);
        empleados[0] = empsal1;

        EmpleadoComision empcom1 = new EmpleadoComision("78798795", "Sandra", "Nieto" , 2011, 129, 7.10);
        empleados[1] = empcom1;

        EmpleadoComision empcom2 = new EmpleadoComision();
        empcom2.setDNI("4654654D");
        empcom2.setNombre("Manuel");
        empcom2.setApellidos("Ruiz");
        empcom2.setAnioIngreso(2010);
        empcom2.setClientesCaptados(35);
        empcom2.setComisionPorCliente(6.90);
        empleados[2] = empcom2;

        EmpleadoAsalariado empsal2 = new EmpleadoAsalariado();
        empsal2.setDNI("77879878F");
        empsal2.setNombre("Maria");
        empsal2.setApellidos("Ramos");
        empsal2.setAnioIngreso(2011);
        empsal2.setSalarioBase(1055);
        empleados[3] = empsal2;

        sueldoMayor(empleados);
        mostrarTodos(empleados);
    }


    //Métodos
    public static void sueldoMayor(Empleado empleado[]) {
        int empMayor = 0;
        double salarioMayor = 0;

        for (int i = 0; i < empleado.length; i++) {
            try {
                if (empleado[i].getSalario() > salarioMayor) {
                    empMayor = i;
                    salarioMayor = empleado[i].getSalario();
                }
            } catch (Exception e) {
                System.out.println(empleado[i].getNombre() + " " + empleado[i].getApellidos() + ": ");
                System.out.println(e.getMessage());
            }
        }
        System.out.printf("\nEl empelado con mayor salario es: " +
                empleado[empMayor].getNombre() + " " + empleado[empMayor].getApellidos() +
                " con salario %.2f\n", salarioMayor);
        System.out.println();
    }

    public static void mostrarTodos(Empleado empleado[]) {
        System.out.println("____Todos los empleados:____");
        for (int i = 0; i < empleado.length; i++) {
            empleado[i].imprimir();
        }

    }

}
