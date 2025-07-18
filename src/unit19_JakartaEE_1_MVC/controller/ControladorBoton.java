package unit19_JakartaEE_1_MVC.controller;

import unit19_JakartaEE_1_MVC.model.EjecutaConsultas;
import unit19_JakartaEE_1_MVC.view.MarcoMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorBoton implements ActionListener {

    private MarcoMVC miFrame;
    private EjecutaConsultas obj = new EjecutaConsultas();
    private ResultSet resultadoConsulta;

    public ControladorBoton(MarcoMVC miFrame) {
        this.miFrame = miFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String seleccionSeccion = (String) miFrame.getSecciones().getSelectedItem();
        String seleccionPais = (String) miFrame.getPaises().getSelectedItem();

        resultadoConsulta = obj.consultaBBDD(seleccionSeccion, seleccionPais);

        try {
            miFrame.getResultados().setText("");
            while (resultadoConsulta.next()) {

                for (int i = 1; i < 5; i++) {
                    miFrame.getResultados().append(resultadoConsulta.getString(i));
                    miFrame.getResultados().append(", ");
                }
                miFrame.getResultados().append("\n");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

}

