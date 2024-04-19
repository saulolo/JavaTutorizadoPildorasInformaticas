package unit10_StreamsDeDatos.Streams;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Saulolo
 */
public class EscrituraFicherosExternos {


    /**
     * Método que escribe un texto en un archivo utilizando un stream de datos.
     * @throws IOException Se captura cualquier excepción de E/S (IOException) y se muestra un mensaje de error
     */
    public void escribiendo() {

        String texto = "Estoy escribiendo a travez de un stream de datos";

        try {
            FileWriter escritura = new FileWriter("src/unit10_StreamsDeDatos/Streams/ficheroCreado.txt");

            for (int i = 0; i < texto.length(); i++) {
                escritura.write(texto.charAt(i));
            }

            escritura.close();
        } catch (IOException e) {
            System.out.println("El fichero no se pudo crear.");
        }

    }
}
