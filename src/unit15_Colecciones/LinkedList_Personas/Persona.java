package unit15_Colecciones.LinkedList_Personas;

import java.util.LinkedList;
import java.util.ListIterator;

public class Persona {

	public static void main(String[] args) {

		LinkedList<String> personas = new LinkedList<String>(); //Creamos la lista de personas
		personas.add("Saul"); //Agrega con el método add
		personas.add("Felipe");
		personas.add("Diego");
		personas.add("Alvaro");

		System.out.println("Cantidad de personas: " + personas.size());

		System.out.println("Lista de personas: ");

		//Si queremos agregar operaciones como quitar, mover, introducir un elemento en una posición en concretro, etc..
		//Hacemos uso de la interfas ListIterator
		ListIterator<String> it = personas.listIterator();
		it.next(); //Le damos siguiente con este método para avanzar una posición
		it.add("Pablo"); //Para agregar a Pablo entre Saul y Felipe


		for (String persona : personas) {
			System.out.println("Nombre: " + persona);
		}

		System.out.println(personas); //Tambien se puede imprimir la lista completa sin utilizar bucles
	}
}
