package unit15_Colecciones.TreeSet_OrdenarPersonas;

import java.util.TreeSet;

public class ColeccionTreeSet {

    public static void main(String[] args) {

        //Esta colección organiza los elementos en orden alfabético cuando son de tipo String.
        TreeSet<String> ordenaGente = new TreeSet<String>();
        ordenaGente.add("Saul");
        ordenaGente.add("Felipe");
        ordenaGente.add("Aleajndra");
        ordenaGente.add("Diego");

        for (String persona : ordenaGente) {
            System.out.println(persona);
        }


    }
}
