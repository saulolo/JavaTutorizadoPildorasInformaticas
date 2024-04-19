package unit7_EjercicioComponentesSwingI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ejercicio de componenets de swing de Pildiras Infornmaticas.Java Tutorizado Ejercicio
 * Componentes Swing II
 * @author Saulolo
 */
public class EjercicioSwing {

    public static void main(String[] args) {

        MarcoEjercicioSwing mimarco=new MarcoEjercicioSwing();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class MarcoEjercicioSwing extends JFrame{

    /**
     * Constructor de la clase MarcoEjercicioSwing.
     * Crea un nuevo marco de ventana con las dimensiones y posición especificadas.
     * Agrega una nueva lámina de ejercicio Swing al marco.
     * Hace visible el marco de la ventana.
     */
    public MarcoEjercicioSwing() {

        setBounds(600, 300, 600, 400);

        add(new LaminaEjercicioSwing());

        setVisible(true);

    }

}

class LaminaEjercicioSwing extends JPanel{
    private JTextArea areaTexto;
    private JTextField cuadroTexto1, cuadroTexto2;
    private JButton boton1, boton2;
    private JCheckBox casilla1, casilla2;
    private JRadioButton radio1, radio2;
    private JLabel etiqueta1, etiqueta2;
    private String resultado="";
    private int contador=0;



    /**
     * Constructor de la clase LaminaEjercicioSwing.
     * Crea una nueva lámina con un diseño BorderLayout que contiene varios componentes Swing, como etiquetas, campos de texto, botones, casillas de verificación y botones de radio.
     * Los botones tienen ActionListener asociados para gestionar eventos cuando se hace clic en ellos.
     * El área de texto se configura con un JScrollPane para permitir el desplazamiento.
     * Los componentes se agregan a la lámina en las regiones NORTH, CENTER y SOUTH del BorderLayout.
     */
    public LaminaEjercicioSwing() {

        setLayout(new BorderLayout());

        JPanel superior=new JPanel();
        JPanel central=new JPanel();
        JPanel inferior=new JPanel();


        etiqueta1=new JLabel("Nombre: ");
        etiqueta2=new JLabel("Apellido: ");

        cuadroTexto1=new JTextField(10);
        cuadroTexto2=new JTextField(10);

        superior.add(etiqueta1);
        superior.add(cuadroTexto1);
        superior.add(etiqueta2);
        superior.add(cuadroTexto2);

        boton1=new JButton("Boton 1");
        boton1.addActionListener(new GestionaEventos());
        boton2=new JButton("Boton 2");
        boton2.addActionListener(new GestionaEventos());
        casilla1=new JCheckBox("Casilla 1: ", true);
        casilla1.addActionListener(new GestionaEventos());
        casilla2=new JCheckBox("Casilla 2: ");
        casilla2.addActionListener(new GestionaEventos());
        radio1=new JRadioButton("Radio 1: ");
        radio1.addActionListener(new GestionaEventos());
        radio2=new JRadioButton("Radio 2: ");
        radio2.addActionListener(new GestionaEventos());

        inferior.add(boton1);
        inferior.add(boton2);
        inferior.add(casilla1);
        inferior.add(casilla2);
        ButtonGroup grupo=new ButtonGroup();
        grupo.add(radio1);
        grupo.add(radio2);
        inferior.add(radio1);
        inferior.add(radio2);

        areaTexto=new JTextArea(15,30);
        areaTexto.setLineWrap(true);
        JScrollPane centralArea=new JScrollPane(areaTexto);
        central.add(centralArea);

        add(superior, BorderLayout.NORTH);
        add(central, BorderLayout.CENTER);
        add(inferior, BorderLayout.SOUTH);

    }

    private class GestionaEventos implements ActionListener{

        /**
         * Maneja los eventos de acción generados por los componentes Swing asociados a este ActionListener.
         * Actualiza el área de texto con el resultado de las acciones realizadas por el usuario.
         * Si es la primera vez que se llama al método, obtiene el nombre y el apellido del cuadro de texto y los agrega al resultado.
         * Si se pulsa el botón 1, añade una línea al resultado indicando que se pulsó el botón 1.
         * Si se pulsa el botón 2, añade una línea al resultado indicando que se pulsó el botón 2.
         * Si se activa o desactiva la casilla 1, añade una línea al resultado indicando su estado.
         * Si se activa o desactiva la casilla 2, añade una línea al resultado indicando su estado.
         * Si se activa o desactiva el radio 1, añade una línea al resultado indicando su estado.
         * Si se activa o desactiva el radio 2, añade una línea al resultado indicando su estado.
         * Finalmente, actualiza el área de texto con el resultado acumulado y aumenta el contador de acciones realizadas.
         *
         * @param e Objeto ActionEvent que representa el evento de acción generado por un componente Swing.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(contador==0) {
                String nombre=cuadroTexto1.getText();
                String apellido=cuadroTexto2.getText();
                resultado+=nombre + " " + apellido + " realiza las siguientes acciones:\n";

            }

            if(e.getSource()==boton1) resultado+="Botón 1 pulsado\n";
            if(e.getSource()==boton2) resultado+="Botón 2 pulsado\n";
            if(e.getSource()==casilla1) {
                if(casilla1.isSelected()) resultado+="Casilla 1 activada\n";
                else resultado+="Casilla 1 desactivada\n";
            }
            if(e.getSource()==casilla2) {
                if(casilla2.isSelected()) resultado+="Casilla 2 activada\n";
                else resultado+="Casilla 2 desactivada\n";
            }

            if(e.getSource()==radio1) {
                if(radio1.isSelected()) resultado+="Radio 1 activado\n";
                else resultado+="Radio 1 desactivada\n";
            }

            if(e.getSource()==radio2) {
                if(radio2.isSelected()) resultado+="Radio 2 activado\n";
                else resultado+="Radio 2 desactivada\n";
            }

            areaTexto.setText(resultado);
            contador++;

        }

    }

}









