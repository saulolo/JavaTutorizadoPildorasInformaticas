package unit11_Serializacion.serializacionDeObjetos;

import java.io.*;

/**
 * Recuperando el objeto creado en la clase Serializado.S
 * @author Saulolo
 */
public class Recuperando {

    public static void main(String[] args) {

        try {
            ObjectInputStream flutoEntrada = new ObjectInputStream(new FileInputStream("src/unit11_Serializacion/serializacionDeObjetos/extensionJava/miObjetoSerializado.dat"));
            Empleado[] entradaObjeto = (Empleado[]) flutoEntrada.readObject();
            flutoEntrada.close();

            for (Empleado e : entradaObjeto) {
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
