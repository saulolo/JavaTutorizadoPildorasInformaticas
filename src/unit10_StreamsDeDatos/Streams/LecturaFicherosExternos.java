package unit10_StreamsDeDatos.Streams;

import java.io.FileReader;
import java.io.IOException;

/**
 * Leer ficheros externos con Stream de datos.
 * @author Saulolo
 */
public class LecturaFicherosExternos {

    /**
     * Lee los datos de un archivo de texto y los muestra en la consola.
     *
     * Este método intenta abrir y leer un archivo de texto llamado "ficheroALeer.txt"
     * ubicado en el directorio src/unit10_StreamsDeDatos/. Lee los datos del archivo
     * carácter por carácter y los muestra en la consola. Si el archivo no se encuentra
     * o no se puede leer, imprime un mensaje indicando que el archivo no se ha encontrado.
     *
     * @throws IOException si ocurre un error de lectura o el archivo no se encuentra.
     */
    public void leeDatos() {

        try {
            FileReader entrada = new FileReader("src/unit10_StreamsDeDatos/Streams/ficheroALeer.txt");
            int caracter = entrada.read();
            char letra = (char) caracter;

            while (caracter != -1) {
                System.out.print(letra);
                caracter = entrada.read();
                letra = (char) caracter;
            }

            entrada.close();

        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo.");
        }

    }
}
