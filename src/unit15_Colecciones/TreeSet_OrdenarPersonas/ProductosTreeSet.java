package unit15_Colecciones.TreeSet_OrdenarPersonas;

public class ProductosTreeSet implements Comparable<ProductosTreeSet>{


    //Si quiero ordenar los productos por número de producto, debo implementar la interfaz Comparable
    public int numeroProducto;
    private String descripcion;


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

}
