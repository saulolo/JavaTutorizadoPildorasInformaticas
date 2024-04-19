package unit10_StreamsDeDatos.StreamByte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Escribir y leer cualquier tipo de archivos.
 * @author Saulolo
 */
public class LeyendoArchivoStreamsBytes {


    /**
     * Realiza la lectura de un archivo de tipo binario (imagen) byte a byte y muestra los bytes leídos por pantalla.
     * Almacena los bytes leídos en un array y muestra cada byte leído por pantalla.
     * @throws IOException Se captura cualquier excepción de E/S (IOException) y se muestra un mensaje de error.
     */
    public void lecturaEscritura() {
        int contador = 0;

        int bytesImage[] = new int[276691]; //Cantidad de bytes de la imagen

        try {
            FileInputStream lecturaArchivo = new FileInputStream("src/unit10_StreamsDeDatos/StreamByte/Imagenes/Goku.png");

            boolean finalArchivo = false;

            while (!finalArchivo) {
                int byteImagenEntrada = lecturaArchivo.read();

                if (byteImagenEntrada != -1) bytesImage[contador] = byteImagenEntrada;
                else finalArchivo = true;

                System.out.println(bytesImage[contador]);

                contador++;

            }

            lecturaArchivo.close();

        } catch (IOException e) {
            System.out.println("No se encontro el archivo.");
        }

       // System.out.println(contador);
    }

    public void crearFichero(String rutaOrigen, String rutaDestino) {
        try (FileInputStream lecturaArchivo = new FileInputStream(rutaOrigen);
             FileOutputStream ficheroExterno = new FileOutputStream(rutaDestino)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = lecturaArchivo.read(buffer)) != -1) {
                ficheroExterno.write(buffer, 0, bytesRead);
            }

            System.out.println("Archivo creado correctamente.");

        } catch (IOException e) {
            System.out.println("No se pudo crear el archivo: " + e.getMessage());
        }
    }
}
