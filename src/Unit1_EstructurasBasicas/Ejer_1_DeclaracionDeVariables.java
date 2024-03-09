package Unit1_EstructurasBasicas;

/**
 *@author Saulolo
 */

public class Ejer_1_DeclaracionDeVariables {

    /**
     * Declara e inicia las variables que aparecen en la siguiente tabla:
     * Nombre Variable                   Tipo de Datos             Valor de la Variable
     * edad                              Entero corto              Ana
     * salario                           Decimal corto             1800,50
     * carnet                            lógico                    verdadero
     * @author Saulolo
     */

    public static void main(String[] args) {

        //Variables
        String nombre = "Ana";
        short edad = 27;
        float salario = 1800.50F;
        boolean logico = true;

        System.out.println(nombre);
        System.out.println(edad);
        System.out.println(salario);
        System.out.println(logico);

    }
}
