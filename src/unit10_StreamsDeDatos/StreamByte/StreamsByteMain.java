package unit10_StreamsDeDatos.StreamByte;

/**
 * @author Saulolo
 */
public class StreamsByteMain {

    public static void main(String[] args) {

        //1. Lectura  Stream Bytes
        LeyendoArchivoStreamsBytes miImagen = new LeyendoArchivoStreamsBytes();
        miImagen.lecturaEscritura();

        //1. Lectura  Stream Bytes
        miImagen.crearFichero("src/unit10_StreamsDeDatos/StreamByte/Imagenes/Goku.png",
                "src/unit10_StreamsDeDatos/StreamByte/Imagenes/escritura/GokuClon.png");
    }
}
