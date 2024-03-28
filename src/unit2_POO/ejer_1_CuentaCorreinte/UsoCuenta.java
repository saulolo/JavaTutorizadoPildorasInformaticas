package unit2_POO.ejer_1_CuentaCorreinte;

/**
 * @author Saulolo
 */
public class UsoCuenta {

    public static void main(String[] args) {

        CuentaCorriente Cuenta1 = new CuentaCorriente("Juan Gomez", 1500);
        CuentaCorriente Cuenta2 = new CuentaCorriente("Maria Lopez", 2500);

        CuentaCorriente.Transferencia(Cuenta1, Cuenta2, 200);
        System.out.println(Cuenta1.getDatosCuenta());
        System.out.println(Cuenta2.getDatosCuenta());
    }
}
