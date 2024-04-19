package unit12_AccesoFicherosExternos;

import java.io.File;
import java.io.IOException;

/**
 * Creando directorios y archivos externos.
 * @author Saulolo
 */
public class CreandoDirectorios {

    public static void main(String[] args) {

        //Utilizo la constante de clase separator para no tener problemas de formato de path en distintos S.O.
        File nuevoDirectorio = new File("C:" + File.separator + "Users"+ File.separator + "SECHEVERRI" +
                File.separator + "Documents"+ File.separator + "Proyectos" + File.separator +
                "JavaTutorizadoPildorasInformaticas" + File.separator + "src" + File.separator +
                "unit12_AccesoFicherosExternos" + File.separator + "Carpeta_acceso" + File.separator +
                "Nuevo directorio" + File.separator + "Nuevo_archivo.xlsx");

        //------------------------------- CREANDO NUEVO DIRECTORIO ------------------
        //nuevoDirectorio.mkdirs();

        //------------- CREANDO NUEVO ARCHIVO DENTRO DEL DIRECTORIO ANTERIOR ------------------
        try {
            nuevoDirectorio.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
