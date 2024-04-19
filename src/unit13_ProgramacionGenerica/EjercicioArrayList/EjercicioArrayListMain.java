package unit13_ProgramacionGenerica.EjercicioArrayList;

/**
 * @author Saulolo
 */
public class EjercicioArrayListMain {

    public static void main(String[] args) {

        EjercicioArrayList miListaNumeros  = new EjercicioArrayList();

        //------------------------------- Almacena los numeros en el ArrayList ---------------------------------------
        miListaNumeros.almacenarNumeros();

        //------------------------------ Calcular suma --------------------------------------------------------------
        miListaNumeros.calcularSuma();

        //------------------------------ Calcular Promedio ----------------------------------------------------------
        miListaNumeros.calularPromedio();

        //------------------- Calcular los números mayores al promedio -----------------------------------------------
        miListaNumeros.contarMayoresMedia();

        //------------------------------ Imprimir resultados --------------------------------------------------------
        System.out.println(miListaNumeros.toString());

    }
}
