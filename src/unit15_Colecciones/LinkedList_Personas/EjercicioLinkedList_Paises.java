package unit15_Colecciones.LinkedList_Personas;

import java.util.LinkedList;
import java.util.ListIterator;

public class EjercicioLinkedList_Paises {

    public static void main(String[] args) {


        /* PAISES */
        LinkedList<String> paises = new LinkedList<String>();
        paises.add("España");
        paises.add("Colombia");
        paises.add("México");
        paises.add("Perú");

        /* CAPITALES */
        LinkedList<String> capitales = new LinkedList<String>();
        capitales.add("Madrid");
        capitales.add("Bogotá");
        capitales.add("D.F.");
        capitales.add("Lima");

        System.out.println(""+ paises);
        System.out.println(""+ capitales);

        System.out.println("===================================");

        ListIterator<String> itPaises = paises.listIterator();

        ListIterator<String> itCapitales = capitales.listIterator();

        //Agregar las Capitales a los paises
        while (itCapitales.hasNext()) {
            if (itPaises.hasNext()) itPaises.next();
            itPaises.add(itCapitales.next());
        }
        System.out.println(paises);

        //Elimanr las Capitales pares
        itCapitales = capitales.listIterator(); //Inicie el curso al principio.
        while (itCapitales.hasNext()) {
            itCapitales.next();
            if (itCapitales.hasNext()) {
                itCapitales.next();
                itCapitales.remove();
            }
        }
        System.out.println(capitales);
    }
}
