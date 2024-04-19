package unit14_ProgramacionConcurrenteThreads;

import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {

    public static void main(String[] args) {

        JFrame marco = new MarcoRebote();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.setVisible(true);

    }

}


//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota {

    // Mueve la pelota invirtiendo posición si choca con límites

    public void mueve_pelota(Rectangle2D limites) {

        x += dx;

        y += dy;

        if (x < limites.getMinX()) {

            x = limites.getMinX();

            dx = -dx;
        }

        if (x + TAMX >= limites.getMaxX()) {

            x = limites.getMaxX() - TAMX;

            dx = -dx;
        }

        if (y < limites.getMinY()) {

            y = limites.getMinY();

            dy = -dy;
        }

        if (y + TAMY >= limites.getMaxY()) {

            y = limites.getMaxY() - TAMY;

            dy = -dy;

        }

    }

    //Forma de la pelota en su posición inicial

    public Ellipse2D getShape() {

        return new Ellipse2D.Double(x, y, TAMX, TAMY);

    }

    private static final int TAMX = 15;

    private static final int TAMY = 15;

    private double x = 0;

    private double y = 0;

    private double dx = 1;

    private double dy = 1;


}

// Lámina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel {

    //Añadimos pelota a la lámina

    public void add(Pelota b) {

        pelotas.add(b);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        for (Pelota b : pelotas) {

            g2.fill(b.getShape());
        }

    }

    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
}

/*--------------------- PASOS PARA CREAR HILOS DE EJECUCIÓN ---------------*/
//Paso 1. Creamos la clase que implemente la interfaz Runnable (método run()).
class PelotaThreads implements Runnable {

    private Pelota pelota;
    private Component lamina;
    public PelotaThreads(Pelota pelota, Component lamina) {
        this.pelota = pelota;
        this.lamina = lamina;
    }

    //Paso 2. Escribir el código de la tarea dentro de un método run
    @Override
    public void run() {

       // for (int i = 1; i <= 3000; i++) {

        System.out.println("Estado del hilo antes de comenzar la tarea " + Thread.currentThread().isInterrupted());

        while (!Thread.currentThread().isInterrupted()) {

        pelota.mueve_pelota(lamina.getBounds());
        lamina.paint(lamina.getGraphics());


            /*
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

             */


        }
        System.out.println("Estado del hilo despues de terminar la tarea " + Thread.currentThread().isInterrupted());


    }

}


//Marco con lámina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame {

    private Thread t;
    private LaminaPelota lamina;

    public MarcoRebote() {

        setBounds(600, 300, 400, 350);

        setTitle("Rebotes");

        lamina = new LaminaPelota();

        add(lamina, BorderLayout.CENTER);

        JPanel laminaBotones = new JPanel();

        ponerBoton(laminaBotones, "Dale!", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                comienza_el_juego();
            }

        });


        ponerBoton(laminaBotones, "Salir", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                System.exit(0);

            }

        });

        ponerBoton(laminaBotones, "Parar", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {
                parar();

            }

        });

        add(laminaBotones, BorderLayout.SOUTH);
    }


    //Ponemos botones

    public void ponerBoton(Container c, String titulo, ActionListener oyente) {

        JButton boton = new JButton(titulo);

        c.add(boton);

        boton.addActionListener(oyente);

    }

    //Añade pelota y la bota 1000 veces

    public void comienza_el_juego() {


        Pelota pelota = new Pelota();

        lamina.add(pelota);

        //Paso 3. Instanciar la clase creada y almacenar la instancia en variable
        //de tipo Runnable.
        Runnable r = new PelotaThreads(pelota,lamina);

        //Paso 4. Crear instacia de la clase Thread pasando como parámetro al
        //constructor de Thread el objeto Runnable anterior
        t = new Thread(r);

        //Paso 5. Poner en marcha el hilo de ejecución con el método star() de
        //la clase Thread.

        // t.start(); //Método que ya esta deprecado por errores en apps grandes.
        t.interrupt();

    }

    //Método para detener un hilo
    public void parar() {
        t.stop();
    }




}

