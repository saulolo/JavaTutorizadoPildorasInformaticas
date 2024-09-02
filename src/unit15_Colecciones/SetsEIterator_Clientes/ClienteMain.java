package unit15_Colecciones.SetsEIterator_Clientes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ClienteMain {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Felipe", "13131313", 5000);
        Cliente cliente2 = new Cliente("Diego", "12121212", 2000);
        Cliente cliente3 = new Cliente("Alejandra", "14141414", 15000);
        Cliente cliente4 = new Cliente("Leidy", "151515151", 2500);
        Cliente cliente5 = new Cliente("Pablo", "161616161", 20);
        Cliente cliente6 = new Cliente("Saul", "171717171", 500);
        Cliente cliente7 = new Cliente("Felipe", "13131313", 5000);

        //HashSet No permite tener dos objetos iguales

        /*
        Analizamos que necesitamos hacer con la lista según estas condiciones:
        Repetir clientes ==> No
        Permitir borrar ==> No
        Solo lectura ==> No
        y segun eso la Clase Set con su método Hashset es la que mejor se adapta.
         */
        Set<Cliente> clientesDelBanco = new HashSet<Cliente>();
        clientesDelBanco.add(cliente1);
        clientesDelBanco.add(cliente2);
        clientesDelBanco.add(cliente3);
        clientesDelBanco.add(cliente4);
        clientesDelBanco.add(cliente5);
        clientesDelBanco.add(cliente6);
        clientesDelBanco.add(cliente7);


        //1.Imprimo con un foreach
        //Nota: si escribo la palabra iter + Enter me autocompleta el bucle.
        //Para elimionar un elemento de una colección con un foreach no es tan sencillo, para ese caso es mejor con un iterator.
        for (Cliente unCliente : clientesDelBanco) {
            System.out.println("Nombre: " + unCliente.getNombre() +
                    " \nNro cuenta: " +  unCliente.getnCuenta() +
                    " \nSaldo: " + unCliente.getSaldo() + "\n");
        }



        //2.1 Removiendo un elemento con Iterator
        Iterator<Cliente> iterator = clientesDelBanco.iterator();
        while (iterator.hasNext()) {
            String nombreCliente = iterator.next().getNombre();

            if (nombreCliente.equals("Diego")) iterator.remove();
        }

        //2.Imprimo con un Iterator
        //Nota: Este método no es muy recomendable para imprimir varios atributos en un mismo bucle, tal cual como lo
        //hice con el bucle foreach, pero hay operaciones que son mas sencillas con un Iterator que con un foreach.
        Iterator<Cliente> it = clientesDelBanco.iterator();
        while (it.hasNext()) {
            String nombreCliente = it.next().getNombre();
            System.out.println("(Con Iterator => ) El nombre del cliente es: " + nombreCliente);
        }
    }
}
