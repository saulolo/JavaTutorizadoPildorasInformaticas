package unit10_StreamsDeDatos.Buffers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Leer ficheros externos muy grandes don Buffers para optimización de recursos.
 * @author Saulolo
 */
public class LecturaFicherosBuffers {


    /**
     * Lee y muestra el contenido de un archivo utilizando buffers para mejorar el rendimiento de la lectura.
     * @throws IOException Se captura cualquier excepción de E/S (IOException) y se muestra un mensaje de error.
     */
    public void leeDatos() {

        try {
            FileReader entrada = new FileReader("src/unit10_StreamsDeDatos/Buffers/ficheroALeerBuffers.txt");

            BufferedReader miBuffer = new BufferedReader(entrada);

            String linea = "";

            while (linea != null) {

                linea = miBuffer.readLine();

                if (linea != null) System.out.println(linea);

            }

            entrada.close();

        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo Buffers.");
        }

    }
}
