package unit2_POO.ejer_6_ClasesAbstractas_GestionPersonas;


public class EmpleadoComision extends Empleado{

    //Atributos
    public static final double salarioMinimo = 950;
    private int clientesCaptados;
    private double comisionPorCliente;



    //Constructores
    public EmpleadoComision() {
        super();
        clientesCaptados = 0;
        comisionPorCliente = 0;
    }

    public EmpleadoComision(String DNI, String nombre, String apellidos, int anioIngreso,
                            int clientesCaptados, double comisionPorCliente) {
        super(DNI, nombre, apellidos, anioIngreso);
        this.clientesCaptados = clientesCaptados;
        this.comisionPorCliente = comisionPorCliente;
    }

    //Getters and Setters
    public int getClientesCaptados() {
        return clientesCaptados;
    }

    public void setClientesCaptados(int clientesCaptados) {
        this.clientesCaptados = clientesCaptados;
    }

    public double getComisionPorCliente() {
        return comisionPorCliente;
    }

    public void setComisionPorCliente(double comisionPorCliente) {
        this.comisionPorCliente = comisionPorCliente;
    }

    //Metodos

    @Override
    public double getSalario() {
        if (comisionPorCliente * clientesCaptados > salarioMinimo) return comisionPorCliente * clientesCaptados;
        else return salarioMinimo;
    }


    @Override
    public void imprimir() {
        super.imprimir();
        System.out.printf("Salario: %.2f\n", getSalario());
        System.out.println();
    }
}
