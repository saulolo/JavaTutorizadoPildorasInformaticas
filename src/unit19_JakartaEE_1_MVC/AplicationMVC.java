package unit19_JakartaEE_1_MVC;

import unit19_JakartaEE_1_MVC.view.MarcoMVC;

import javax.swing.*;

public class AplicationMVC {

    public static void main(String[] args) {

        MarcoMVC miApp = new MarcoMVC();
        miApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miApp.setVisible(true);

    }
}
