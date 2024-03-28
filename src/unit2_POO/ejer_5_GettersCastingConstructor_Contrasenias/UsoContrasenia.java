package unit2_POO.ejer_5_GettersCastingConstructor_Contrasenias;

import javax.swing.*;

/**
 * @author Saulolo
 */

public class UsoContrasenia {

    public static void main(String[] args) {


        int tamanioArray = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el tamaño del array: "));
        int longitudPass = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la longitud del password: "));

        CreaPassword arrayPasword[] = new CreaPassword[tamanioArray];

        for (int i = 0; i < arrayPasword.length; i++) {
            arrayPasword[i] = new CreaPassword(longitudPass);

            System.out.println("Password: " + arrayPasword[i].getPassword() +
                    " Longitud: " + arrayPasword[i].getLongitud() +
                    " Caracteres: " + arrayPasword[i].esSegura());
        }
    }
}
