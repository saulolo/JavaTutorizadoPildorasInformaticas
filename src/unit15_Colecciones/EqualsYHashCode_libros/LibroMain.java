package unit15_Colecciones.EqualsYHashCode_libros;

public class LibroMain {

    public static void main(String[] args) {


        Libro libro1 = new Libro("Julio verne", "Viaje al centro de la tierra", 12);
        Libro libro2 = new Libro("Julio verne", "Los hijos del Capitan Grant", 10);

        //libro1 = libro2;

        //[1]. EL metodo equals solo me permite comparar objetds de la Api de Java, para mis porpios objetos
        // debo sobreescribie el método eguals
        if (libro1.equals(libro2)) {
            System.out.println("Son iguales");
            System.out.println(libro1.hashCode());
            System.out.println(libro2.hashCode());

        }
        else {
            System.out.println("No son iguales");
            System.out.println(libro1.hashCode());
            System.out.println(libro2.hashCode());
        };



    }

}
