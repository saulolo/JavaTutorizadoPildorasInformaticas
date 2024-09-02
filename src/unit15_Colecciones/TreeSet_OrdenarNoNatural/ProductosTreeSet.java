package unit15_Colecciones.TreeSet_OrdenarNoNatural;

import java.util.Comparator;

public class ProductosTreeSet implements Comparable<ProductosTreeSet>, Comparator<ProductosTreeSet> {

    //Si quiero ordenar los productos por número de producto, debo implementar la interfaz Comparable
    private int numeroProducto;
    private String descripcion;

    public ProductosTreeSet() {
    }

    public ProductosTreeSet(int numeroProducto, String descripcion) {
        this.numeroProducto = numeroProducto;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }


    @Override
    public int compareTo(ProductosTreeSet producto) {
        return numeroProducto - producto.numeroProducto;
    }


    @Override
    public int compare(ProductosTreeSet o1, ProductosTreeSet o2) {
        int carac1 = o1.getDescripcion().length();
        int carac2 = o2.getDescripcion().length();

        if (carac1 < carac2) return -1;
        else if (carac1 > carac2) return 1;
        else return 0;
    }
}
