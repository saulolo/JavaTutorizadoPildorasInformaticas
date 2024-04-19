package unit8_Excepciones.EjercicioII_ExcepcionesCustom;

import javax.swing.*;

public class CustomExceptionMain {

    public static void main(String[] args) {

        CustomException miExcepcionPer = new CustomException();

        try {
            miExcepcionPer.evaluaNumero();
        } catch (NumeroFueraRango e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
}
