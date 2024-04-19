package unit8_Excepciones.EntradaDatos;

import javax.swing.*;
import java.io.IOException;

/**
 * @author Saulolo
 */

public class ExcepcionesPersonalizadas {

    /**
     * Construir Excepciones personalizadas.
     */

    public static void main(String[] args) throws LongitudMailErroneaPreferencial {
        String email = JOptionPane.showInputDialog("Introduce tu dirección de email.");

        try {
            examinaMail(email);
        } catch (LongitudMailErroneaPreferencial e) {
            System.out.println("El mail es demasiado corto.");        }

    }


    static void examinaMail(String email) throws LongitudMailErroneaPreferencial {


        if (email.length() <= 3) {
/*                LongitudMailErronea miExcepcion = new LongitudMailErronea("Mail con tres o menos caracteres.");
        throw miExcepcion;*/
        }

        JOptionPane.showMessageDialog(null, "Email correcto válido");
    }


}


/**
 * Excepción lanzada cuando se detecta una longitud errónea en una dirección de correo electrónico.
 * @apiNote Esta implementación no es una buena practica ya que no obliga a encerrar en un Try - Catch
 */
/*class LongitudMailErronea extends RuntimeException{

    //Constructor por defecto
    public LongitudMailErronea() {

    }

    //Constructor que recibe un mensaje de tipo String
    public LongitudMailErronea(String mensajeError) {
        super(mensajeError);
    }

}*/



/**
 * Excepción lanzada cuando se detecta una longitud errónea en una dirección de correo electrónico preferencial.
 * @apiNote Por buenas prcaticas, es la mejor manera de hacer una excepción personalizada para obligar
 * a encerrar el metodo o condición a evaluar en un Try - Catch.
 */
class LongitudMailErroneaPreferencial extends Exception {
    public LongitudMailErroneaPreferencial() {

    }

    public LongitudMailErroneaPreferencial(String mensaje) {

    }

}
