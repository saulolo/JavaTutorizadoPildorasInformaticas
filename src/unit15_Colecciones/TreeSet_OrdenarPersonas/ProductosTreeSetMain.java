package unit15_Colecciones.TreeSet_OrdenarPersonas;

import unit15_Colecciones.TreeSet_OrdenarNoNatural.ProductosTreeSet;

import java.util.TreeSet;

public class ProductosTreeSetMain {

    public static void main(String[] args) {

        ProductosTreeSet comparadoPr = new ProductosTreeSet();


        TreeSet<unit15_Colecciones.TreeSet_OrdenarNoNatural.ProductosTreeSet> ordenaProductos = new TreeSet<ProductosTreeSet>();

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
