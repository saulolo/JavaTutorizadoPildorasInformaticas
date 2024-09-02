package unit15_Colecciones.EqualsYHashCode_libros;

public class Libro {

    public String autor;
    public String titulo;
    public int isbn;

    public Libro() {
    }


    public Libro(String autor, String titulo, int isbn) {
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
    }


    public String getDatos() {
        return "El titulo es: " + titulo + " El autor es: " + autor + " y el isbn es: " + isbn;
    }

    //[2]. Sobreescritura del método equals para poder posibiltar la comparacióbn de mis objetos propios
    public boolean equals(Object obj) {
        Libro ptroLibro = (Libro) obj; //Hago un parse.
        if (obj instanceof Libro) { //Instancio con el método instanceof el Objeto que quiero comparar.
            if (this.isbn == ((Libro) obj).isbn) {
                return true;
            } return false;
        } return false;
    }





}
