package unit8_Excepciones.EntradaDatos;

import javax.swing.*;

/**
 * Manejo de varias excepciones
 * @author Saulolo
 */
public class VariasExcepciones {

    public static void main(String[] args) {

        try {
            division();
        } catch (ArithmeticException a){
            System.out.println("Division por 0.");
        } catch (NumberFormatException e) {
            //System.out.println("Has introducido un valor númerico no válido.");
            System.out.println("Se ha lanzado una excepción de tipo: " + e.getClass().getName());
        }
        
    }


    static void division() {

        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo."));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor."));

        System.out.println("El resultado es: " + num1 / num2);
    }
}
