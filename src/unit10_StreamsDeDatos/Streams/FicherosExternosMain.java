package unit10_StreamsDeDatos.Streams;

/**
 * @author Saulolo
 */
public class FicherosExternosMain {

    public static void main(String[] args) {

        //1. Lectura del archivo externo.
        LecturaFicherosExternos lectura = new LecturaFicherosExternos();
        lectura.leeDatos();

        //2. Creando un archivo externo desde Java.
        EscrituraFicherosExternos escritura = new EscrituraFicherosExternos();
        escritura.escribiendo();

    }
}
