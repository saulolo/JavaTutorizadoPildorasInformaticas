package unit10_StreamsDeDatos.EjercicioStreams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.ZonedDateTime;

/**
 * Crea una interfaz gráfica como la que aparece en la imagen: (Pildoras
 * informaticas.Java tutorizado.Ejercicio Streams).
 * Al pulsar el boton "Escribir" se generará un fichero de texto txt con el
 * nombre "fichero_escritura" en cuyo interior estará el texto escrito en el
 * área de teto.
 * - Al pulsar el botón "Borrar", la información del área del exto se borrará.
 * - Al pulsa el botón "leer", el programa debe de leer la información
 * almacenada en el fichero externo y escribirla en el área de texto.
 * @author Saulolo
 */
public class MarcoTextos extends JFrame {

    public MarcoTextos() {
        setBounds(600, 300, 600, 400);
        add(new LaminaTexto());
        setVisible(true);
    }
}


class LaminaTexto extends JPanel {

    private JTextArea zona;

    public LaminaTexto() {
        setLayout(new BorderLayout()); //Estructura del contenedor principal

        zona = new JTextArea(); //Área de texto

        add(zona, BorderLayout.CENTER); //Colocación del area de texto

        JButton escribir = new JButton("Escribir");
        JButton borrar = new JButton("Boirrar");
        JButton leer = new JButton("Leer");

        //Acciones de botones
        escribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String texto = zona.getText();

                escribiendoFichero(texto);

            }
        });

        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zona.setText("");
            }
        });
        leer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leyendoFichero();
            }
        });
        JPanel botonera = new JPanel(); //Panel de botones

        botonera.setLayout(new FlowLayout());

        botonera.add(escribir);
        botonera.add(borrar);
        botonera.add(leer);

        add(botonera, BorderLayout.SOUTH);  //Colocación de botones

    }

    //Método de escritura de fichero externo
    public void escribiendoFichero(String texto) {
        FileWriter fichero = null;

        try {
            fichero = new FileWriter("src/unit10_StreamsDeDatos/EjercicioStreams/ficheroEscritura.txt");

            fichero.write(texto);

            fichero.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Método de lectura de fichero externo
    public void leyendoFichero() {

        try {
            FileReader entrada = new FileReader("src/unit10_StreamsDeDatos/EjercicioStreams/ficheroALeer2.txt");

            BufferedReader miBuffer = new BufferedReader(entrada);

            String linea = "";

            while (linea != null) {
                linea = miBuffer.readLine();
                if (linea != null) zona.setText(linea);
            }

            entrada.close();

        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo.");
        }
    }

}
