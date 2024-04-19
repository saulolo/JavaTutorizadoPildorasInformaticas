package unit12_AccesoFicherosExternos;

import java.io.File;

/**
 * Acceso a ficheros externos
 * @author Saulolo
 */
public class AccesoRutas {

    public static void main(String[] args) {

        File directorio = new File("C:\\Users\\SECHEVERRI\\Documents\\Proyectos\\JavaTutorizadoPildorasInformaticas\\src\\unit12_AccesoFicherosExternos\\Carpeta_acceso");
        //--------------------------- MUESTRA LA RUTA ABSOLUTA -------------------------------//
        System.out.println(directorio.getAbsoluteFile()); //Para mostrar la ruta absoluta.

        //--------------------------- MUESTRA INDICA SI LA RUTA EXISTE O NO -------------------------------//
        System.out.println(directorio.exists());  //Para saber si el archivo existe o no.

        //--------------------------- DEVUELVE EL CONTENIDO DE UN DIRECTORIO -------------------------------//
        String[] nombres = directorio.list();

        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        //--------------------------- VERIFICA SI HAY UN DIRECTORIO INTERNO Y LO DEVUELVE  -------------------------------//
        String[] carpetas = directorio.list();

        for (String carpeta : carpetas) {
            System.out.println(carpeta);

            File file = new File(directorio.getAbsolutePath(), carpeta);

            if (file.isDirectory()) {
                String[] archivosSubcarpeta = file.list();

                for (String archivo : archivosSubcarpeta) {
                    System.out.println(archivo);
                }
            }
        }
    }
}
