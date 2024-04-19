package unit5_Layouts;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author Saulolo
 */
public class Calculadora {


    public static void main(String[] args) {

        MarcoCalculadora mimarco=new MarcoCalculadora();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);

    }

}


class MarcoCalculadora extends JFrame{

    /**
     * Constructor de la clase MarcoCalculadora.
     * Crea una nueva ventana de calculadora con un título predefinido,
     * un tamaño y una posición predeterminados, y agrega un panel de calculadora dentro de la ventana.
     */
    public MarcoCalculadora(){

        setTitle("Calculadora");

        setBounds(500,300,450,300);

        PanelCalculadora milamina=new PanelCalculadora();

        add(milamina);
    }
}

class PanelCalculadora extends JPanel{
    private JPanel numeracion;

    private JButton pantalla;

    private boolean comienzo;

    private String ultimaOperacion="";

    private double resultado;

    private double ultimoValor;


    /**
     * Constructor de la clase PanelCalculadora.
     * Crea un nuevo panel de calculadora con una pantalla inicializada a "0" y un diseño de BorderLayout.
     * Agrega la pantalla en la parte superior del panel y los botones numéricos y de operaciones en el centro del panel.
     */
    public PanelCalculadora() {

        comienzo=true;

        setLayout(new BorderLayout());

        pantalla=new JButton("0");

        pantalla.setEnabled(false);

        add(pantalla,BorderLayout.NORTH);

        numeracion=new JPanel();

        numeracion.setLayout(new GridLayout(4,4));

		/*numeracion.add(new JButton("7"));
		numeracion.add(new JButton("8"));
		numeracion.add(new JButton("9"));
		numeracion.add(new JButton("x"));
		numeracion.add(new JButton("4"));
		numeracion.add(new JButton("5"));
		numeracion.add(new JButton("6"));
		numeracion.add(new JButton("-"));
		numeracion.add(new JButton("1"));
		numeracion.add(new JButton("2"));
		numeracion.add(new JButton("3"));
		numeracion.add(new JButton("+"));
		numeracion.add(new JButton("0"));
		numeracion.add(new JButton(","));
		numeracion.add(new JButton("="));
		numeracion.add(new JButton(""));*/

        InsertarNumero insertar=new InsertarNumero();
        Operacion realizarOperacion=new Operacion();


        ponerBoton("7", insertar);
        ponerBoton("8", insertar);
        ponerBoton("9", insertar);
        ponerBotonOperaciones("x", realizarOperacion);
        ponerBoton("4", insertar);
        ponerBoton("5", insertar);
        ponerBoton("6", insertar);
        ponerBotonOperaciones("-", realizarOperacion);
        ponerBoton("1", insertar);
        ponerBoton("2", insertar);
        ponerBoton("3", insertar);
        ponerBotonOperaciones("+", realizarOperacion);
        ponerBoton("0", insertar);
        ponerBoton(",", insertar);
        ponerBotonOperaciones("=", realizarOperacion);
        ponerBotonOperaciones("/", realizarOperacion);



        add(numeracion, BorderLayout.CENTER);


    }

    /**
     * Agrega un botón con el texto especificado al panel de numeración de la calculadora.
     * Asocia un ActionListener proporcionado al botón para manejar eventos de clic.
     * @param textoBoton El texto que se mostrará en el botón.
     * @param oyente El ActionListener que manejará los eventos de clic del botón.
     */
    private void ponerBoton(String textoBoton, InsertarNumero oyente) {

        JButton boton=new JButton(textoBoton);

        boton.addActionListener(oyente);

        numeracion.add(boton);
    }


    /**
     * Agrega un botón con el texto especificado al panel de numeración de la calculadora para operaciones.
     * Asocia un ActionListener proporcionado al botón para manejar eventos de clic.
     * @param textoBoton El texto que se mostrará en el botón.
     * @param oyente El ActionListener que manejará los eventos de clic del botón.
     */
    private void ponerBotonOperaciones(String textoBoton, Operacion oyente) {

        JButton boton=new JButton(textoBoton);

        boton.addActionListener(oyente);

        numeracion.add(boton);

    }


    private class InsertarNumero implements ActionListener{

        /**
         * Realiza las acciones correspondientes cuando se produce un evento de acción, es decir, cuando se hace clic en un botón.
         * @param e El evento de acción que se ha producido.
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            String entrada=e.getActionCommand();

            if(comienzo) {

                pantalla.setText(entrada);

                comienzo=false;

            }

            else {

                pantalla.setText(pantalla.getText()+entrada);

            }

            ultimoValor=Double.parseDouble(pantalla.getText());

        }

    }


    private class Operacion implements ActionListener{

        /**
         * Realiza las acciones correspondientes cuando se produce un evento de acción, es decir, cuando se hace clic en un botón de operación.
         * @param e El evento de acción que se ha producido.
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            String operacionPulsada=e.getActionCommand();

            if (operacionPulsada.equals("+")) {

                resultado+=ultimoValor;

                pantalla.setText("" + resultado);

                ultimaOperacion="+";

            }else if(operacionPulsada.equals("-")) {

                double valor=Double.parseDouble(pantalla.getText());

                if(contador==0) resultado=valor;

                else { resultado-=ultimoValor;}

                pantalla.setText("" + resultado);

                ultimaOperacion="-";

                contador++;


            }else if(operacionPulsada.equals("x")) {

                double valor=Double.parseDouble(pantalla.getText());

                if(contador==0) resultado=valor*1;

                else { resultado*=ultimoValor;}

                pantalla.setText("" + resultado);

                ultimaOperacion="x";

                contador++;
            }

            else if(operacionPulsada.equals("/")) {

                double valor=Double.parseDouble(pantalla.getText());

                if(contador==0) resultado=valor;

                else { resultado/=ultimoValor;}

                pantalla.setText("" + resultado);

                ultimaOperacion="/";

                contador++;
            }


            else {

                if(ultimaOperacion.equals("+")) resultado+=ultimoValor;
                if(ultimaOperacion.equals("-")) resultado-=ultimoValor; contador=0;
                if(ultimaOperacion.equals("x")) resultado*=ultimoValor; contador=0;
                if(ultimaOperacion.equals("/")) resultado/=ultimoValor; contador=0;

                pantalla.setText("" + resultado);

                ultimoValor=0;

            }

            comienzo=true;

        }
        private String ultimaOperacion;
        private int contador;

    }






}