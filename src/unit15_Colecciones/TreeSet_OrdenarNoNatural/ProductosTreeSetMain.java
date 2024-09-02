package unit15_Colecciones.TreeSet_OrdenarNoNatural;

import java.util.TreeSet;

public class ProductosTreeSetMain {

    public static void main(String[] args) {

        ProductosTreeSet comparadorPr = new ProductosTreeSet();

        //El ordenamiento no natural es el que establecemos nosotros segun nuestra necesidad, en este caso lo organizar
        //segun el número de caractéres de los objetos.
        TreeSet<ProductosTreeSet> ordenaProductos = new TreeSet<ProductosTreeSet>(comparadorPr);

        ProductosTreeSet producto1 = new ProductosTreeSet(3, "Televisor");
        ProductosTreeSet producto2 = new ProductosTreeSet(2, "Telefono");
        ProductosTreeSet producto3 = new ProductosTreeSet(7, "Computador");

        ordenaProductos.add(producto1);
        ordenaProductos.add(producto2);
        ordenaProductos.add(producto3);

        for (ProductosTreeSet ordenaProducto : ordenaProductos) {
            System.out.println(ordenaProducto.getDescripcion());
        }
    }
}
