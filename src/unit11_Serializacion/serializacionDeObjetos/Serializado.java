package unit11_Serializacion.serializacionDeObjetos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Saulolo
 */
public class Serializado {

    public static void main(String[] args) {

        Administrador jefe = new Administrador("Saulolo", 600000, 2006, 12, 17);
        jefe.setIncentivo(5000);

        Empleado[] personal = new Empleado[3];
        personal[0] = jefe;
        personal[1] = new Empleado("Ana", 25000, 2008, 11, 23);
        personal[2] = new Empleado("Luis", 45000, 2012, 4, 11);

        try {
            ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("src/unit11_Serializacion/serializacionDeObjetos/extensionJava/miObjetoSerializado.dat"));
            flujoSalida.writeObject(personal);
            flujoSalida.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
