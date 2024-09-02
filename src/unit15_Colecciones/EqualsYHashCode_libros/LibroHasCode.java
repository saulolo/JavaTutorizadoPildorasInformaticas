package unit15_Colecciones.EqualsYHashCode_libros;

import java.util.Objects;

public class LibroHasCode {

	public String autor;
	public String titulo;
	public int isbn;



	public LibroHasCode() {
	}

	public LibroHasCode(String autor, String titulo, int isbn) {
		this.autor = autor;
		this.titulo = titulo;
		this.isbn = isbn;
	}

	//Generado con el IDE


	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		LibroHasCode that = (LibroHasCode) object;
		return isbn == that.isbn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}
}
