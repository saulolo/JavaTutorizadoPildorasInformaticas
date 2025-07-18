package unit19_JakartaEE_3_AplicacionUniveral;

import unit19_JakartaEE_3_AplicacionUniveral.interfazGrafica.MarcoBBDD;

import javax.swing.*;

public class AplicacionUniversalMain {

    public static void main(String[] args) {

        MarcoBBDD miJFrame = new MarcoBBDD();

        miJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        miJFrame.setVisible(true);
    }

}
