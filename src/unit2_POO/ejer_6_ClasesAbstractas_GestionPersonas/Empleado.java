package unit2_POO.ejer_6_ClasesAbstractas_GestionPersonas;

/**
 * @author Saulolo
 * @description
 * En este ejercicio se trata de crear una aplicación de gestión de personal de una empresa.
 * Del personal se conocen:
 * - DNI
 * - Nombre
 * - Apellidos
 * - Año de alta en la empresa
 * Hoy dos tipos de empelados:
 * - Empleados con salario fijo: estos empleados tienen un sueldo base y un porcentaje
 * adicional en función del nº de años que lleven en la empresa con los siguientes cálculos:
 * - Menos de 2 años: Solo tienen salario base
 * - Entre 2 y 3 años: Un 7% del salario base
 * - Entre 4 y 8 años: Un 11% del salario base
 * - Entre 9 y 15 años: Un 17% del salario base
 * Empleados a comisión: estos empleados tendrán todos un salario fijo de 950 €, un nº de
 * clientes captados y una comisión por cada cliente captado. El sueldo es el resultado
 * de multiplicar el nº de clientes captados por la comisión por cliente. Si el resultado
 * de este cálculo no llega al salario fijo, se cobra solo el salario fijo.
 * @requirements
 * - Clase padre Empleado que no se podrá instanciar.
 * - Clases EmpleadoAsalariado y EmpleadoComision que heredarán de Empleado.
 * - Todas las clases deberán tener un constructor con parámetros y un constructor por
 * defecto.
 * - La clase Empleado tendrá un método imprimir() y un método abstracto getSalario()
 * - Clase principal donde se creará un array en el método main con los siguientes datos:
 * - Antonio López. DNI: 6546546Z, año de alta: 2014, salario fijo: 1125
 * - Sandra Nieto. DNI: 7879879S, año de alta: 2011, 169 clientes captados a 7.10 cada uno.
 * - Manuel Ruíz. DNI: 4654654D, año de alta: 2010, 35 clientes captados a 6.90 cada uno.
 * - María Ramos. DNI: 77879878F, año de alta: 2011, salario fijo: 1055
 * - Los dos primeros empleados se crearán utilizando el constructor con parámetros. Los
 * dos últimos con el constructor por defecto y los getters y setters correspondientes.
 * Desde el main de la clase principal se llamarán a dos métodos:
 * - sueldoMayor(). Este método recibirá un array de tipo Empleado por parámetros y
 * devolverá el nombre apellido y salario del Empleado con el salario más alto
 * - mostrarTodos(). Este método recibirá por parámetros un array de tipo Empleado y
 * mostrará los datos de toso los Empleados del array
 */

public abstract class Empleado {

    //Atributos
    private String DNI;
    private String nombre;
    private String apellidos;
    protected int anioIngreso;

    //Constructores
    public Empleado() {
        DNI = "00000000";
        nombre = "No disponible";
        apellidos = "No disponible";
        anioIngreso = 2010;
    }

    public Empleado(String DNI, String nombre, String apellidos, int anioIngreso) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anioIngreso = anioIngreso;
    }

    //Getters and Setters
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    //Métodos

    /**
     * Imprime los detalles de una persona, incluyendo su DNI, nombre completo y año de ingreso.
     * Los detalles se imprimen en la consola en un formato estructurado.
     */
    public void imprimir() {
        System.out.println("DNI: " + getDNI() +
                "\nNombre y Apellido: " + getNombre() + " " + getApellidos() +
                "\nAño de ingreso: " + getAnioIngreso());
    }


    //Método abstracto
    /**
     * Devuelve el salario de la persona.
     *
     * @return El salario de la persona.
     */
    abstract public double getSalario();

}
