package Unit1_EstructurasBasicas;

import javax.swing.*;

/**
 * @author Saulolo
 */

public class Ejer_9_BucleFor_ValidarEmail {

    /**
     * En este ejercicio se pide al usuario que introduzca su dirección de email con ayuda de la clase
     * JOptionPane.
     * Una vez introducido el email, el programa debe decir si la dirección de email es correcta o no
     * teniendo en cuenta los siguientes requisitos:
     * 1. Debe tener una @
     * 2. No debe tener más de una @
     * 3. Debe tener un punto
     * 4. La dirección de email debe tener al menos 4 caracteres.
     * El programa pedirá introducir indefinidamente la dirección de email si no es correcta o si tienes
     * menos de 4 caracteres.
     */


    public static void main(String[] args) {

        boolean valido = false;

        do {
            String email = JOptionPane.showInputDialog("Introduce tu dirección de email.");
            int arroba = 0;
            boolean punto = false;

            for (int i = 0; i < email.length(); i++) {

                if (email.charAt(i) == '@') arroba++;
                if (email.charAt(i) == '.') punto = true;
            }
            if (arroba == 1 && punto == true && email.length() > 4) {
                valido = true;
            } else {
                JOptionPane.showMessageDialog(null, "Email no válido");
            }
        }while (!valido);
        JOptionPane.showMessageDialog(null , "Email correcto válido");
    }

}
