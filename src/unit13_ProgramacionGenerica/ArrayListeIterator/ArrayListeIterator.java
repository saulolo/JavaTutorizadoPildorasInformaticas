package unit13_ProgramacionGenerica.ArrayListeIterator;

import java.util.Iterator;
import java.util.ArrayList;


/**
 * Introducción a la programación genérica. Creación de ArrayList.
 * @author Saulolo
 */
public class ArrayListeIterator {

    public static void main(String[] args) {

                                        /*  ARRAYLIST */

        //Se crea el array generando una instancia con la clase ArrayList
        ArrayList<String> listaEmpleados = new ArrayList<String>();

        //-----------------------------Definiendo el array (.ensureCapacity)--------------------------------
        /*Este método lo uso cuando estoy seguro de que mi array va a tener un tamaño fijo, con el objetivo de
        Optimizar recursos de memoria, pero si sigo agregando objetos, el array sigue incluyendolos normalmente.
        Tener en cuenta que la memoria por defecto que se asigna a un arrays es de 10 unidades.*/
        listaEmpleados.ensureCapacity(4);

        //-----------------Ajustar el tamaño del arrayList al tamaño actual-----------------------
        /* Un metodo mas eficiente a la hora de optimizar recursos, ya que el array se ajusta al tamaño actual
        del array.*/
        listaEmpleados.trimToSize();

        //---------------------------Agregar elementos al array (.add)-------------------------------------
        listaEmpleados.add("Saul");
        listaEmpleados.add("Felipe");
        listaEmpleados.add("Alejandra");
        listaEmpleados.add("Leidy");

        //-------------------------Reemplazar elementos (.set)------------------------------------------------
        listaEmpleados.set(1, "Diego");

        //--------------------------Imprimir un elemento en determinada posición (.get)------------------------
        System.out.println(listaEmpleados.get(2));


        //Imprimiendo el Array con forEach
        /*
        for (String obj : listaEmpleados) {
            System.out.println(obj);
        }
         */

        //Imprimiendo el Array con un bucle convencional
        /*
        for (int i = 0; i < listaEmpleados.size(); i++) {
            System.out.println(listaEmpleados.get(i));
        }

         */


        //-----------------------------Muestra el tamaño del array (.size)----------------------------------------
        System.out.println(listaEmpleados.size());

        //--------------------------Eliminando un elemento de un ArrayList----------------------------------------
        listaEmpleados.remove(2);


        //----------------Convirtiendo un ArrayList a un Array (.toArray)
        /*
        String[] empleadosArray = new String[listaEmpleados.size()];
        listaEmpleados.toArray(empleadosArray);

        for (String emp : empleadosArray) {
            System.out.println(emp);
        }
         */

                                                    /*  ITERATOR */
        //-----------------Recorriendo un Array usando un Iterador (.iterator)(.hasNext)(.next)---------------------
        Iterator<String> iteradorEmpelados = listaEmpleados.iterator();

        while (iteradorEmpelados.hasNext()) {
            System.out.println(iteradorEmpelados.next());
        }

    }
}
