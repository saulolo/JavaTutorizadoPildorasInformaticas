package unit19_JakartaEE_1_MVC.controller;

import unit19_JakartaEE_1_MVC.model.CargaMenus;
import unit19_JakartaEE_1_MVC.view.MarcoMVC;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

public class ControladorCargaMenus extends WindowAdapter {

    private MarcoMVC miJframe;
    CargaMenus obj = new CargaMenus();
    private ResultSet[] resultadosCombos;


    public ControladorCargaMenus(MarcoMVC miJFrame) {
        this.miJframe = miJFrame;
    }

    @Override
    public void windowOpened(WindowEvent e) {

        resultadosCombos = new ResultSet[2];

        resultadosCombos = obj.ejecutaConsultas();
        try {
            resultadosCombos[0].previous();
            while (resultadosCombos[0].next()) {
                miJframe.getSecciones().addItem(resultadosCombos[0].getString(1));
            }
            while (resultadosCombos[1].next()) {
                miJframe.getPaises().addItem(resultadosCombos[1].getString(1));
            }

        } catch (Exception ev) {
            ev.printStackTrace();
        }

    }
}
