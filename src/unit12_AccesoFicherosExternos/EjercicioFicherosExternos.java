package unit12_AccesoFicherosExternos;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Crear un programa en el cual pregunte en una ventana de JOptionPane, donde desea crear el directorio,
 * como llamar el archivo y que frase poner dentro del archivo.
 *
 * @author Saulolo
 */
public class EjercicioFicherosExternos {

    public static void main(String[] args) {


        //------------------------Creando nuevo directorio---------------------------------------------
        String directorio = JOptionPane.showInputDialog("Ingrese el nombre del directorio raíz.");


        File carpeta = new File("C:" + File.separator + "Users" + File.separator + "SECHEVERRI" +
                File.separator + "Documents" + File.separator + "Proyectos" + File.separator +
                "JavaTutorizadoPildorasInformaticas" + File.separator + "src" + File.separator +
                "unit12_AccesoFicherosExternos" + File.separator + "Carpeta_acceso" + File.separator +
                directorio);


        carpeta.mkdirs();
        JOptionPane.showMessageDialog(null, "Directorio creado con éxito");


        //------------------------Creando nuevo archivo-----------------------------------------------------
        String archivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo a crear.");

        File file = new File(carpeta + File.separator + archivo + ".txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("El archivo no se pudo crear.");
        }
        JOptionPane.showMessageDialog(null, "Archivo creado con éxito");


        //---------------------Escribiendo en el archivo--------------------------------------------------
        String contenido = JOptionPane.showInputDialog("Ingrese la frase a guardar.");

        try {
            FileWriter escritura = new FileWriter(file);

            for (int i = 0; i < contenido.length(); i++) {
                escritura.write(contenido.charAt(i));
            }

            escritura.close();

        } catch (IOException e) {
            System.out.println("El fichero no se pudo crear.");
        }

        JOptionPane.showMessageDialog(null, "Contenido creado con éxito");



        /*
        //-------------------------Borrando archivo o directorio----------------------------------------------
        File carpetaBorrada = new File("C:" + File.separator + "Users"+ File.separator + "SECHEVERRI" +
                File.separator + "Documents"+ File.separator + "Proyectos" + File.separator +
                "JavaTutorizadoPildorasInformaticas" + File.separator + "src" + File.separator +
                "unit12_AccesoFicherosExternos" + File.separator + "Carpeta_acceso" + File.separator +
                "Carpeta Prueba" + File.separator + "Archivo de Pueba.txt");
        carpetaBorrada.delete();

        JOptionPane.showMessageDialog(null,"Archivo eliminando con éxito");
         */

    }

}
