package unit9_Debugger;

import javax.swing.*;

/**
 * Práctica para aprender a depurar.
 * @author Saulolo
 */
public class AleatoriosDebugger {

    public static void main(String[] args) {

        int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño de la matriz."));
        int numAleatorio[] = new int[elementos];

        for (int i = 0; i < numAleatorio.length; i++) {
            numAleatorio[i] = ((int)(Math.random() * 100));
        }

        for (int numero : numAleatorio) {
            System.out.println(numero);
        }

    }
}
