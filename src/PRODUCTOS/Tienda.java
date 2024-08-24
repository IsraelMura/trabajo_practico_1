package PRODUCTOS;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private int maxStock;
    private double saldoCaja;
    private List<Productos> inventario;
    private List<CantProductos> unidades;

    public Tienda(String nombre, int maxStock, double saldoCaja) {
        this.nombre = nombre;
        this.maxStock = maxStock;
        this.saldoCaja = saldoCaja;
        this.inventario = new ArrayList<Productos>();
        this.unidades = new ArrayList<CantProductos>();
    }
    public void agregarProducto(Productos producto) {
        /*if (inventario.size() < maxStock) {
            /*Productos p = new Productos(1, "pepe", 21.5, true, 5, true);
            inventario.add(p);

            Productos p1 = new Productos(2, "pepe", 21.5, true, 5, true);
            inventario.add(producto);
        } else {
            System.out.println("No se puede agregar el producto. El stock está lleno.");
        }
        if ((inventario + > maxStock) {
            System.out.println("No se pueden agregar nuevos productos a la tienda ya que se alcanzó el máximo de stock.");
            return;
        }
        saldoCaja -= importeTotal;
        inventario.add(producto);
        System.out.println("Producto agregado correctamente.");*/
        inventario.add(producto);
    }

    public void compras(List<CantProductos> cp) {
        Productos producto = null;
        if (inventario.size() < maxStock) {
            /*Productos p = new Productos(1, "pepe", 21.5, true, 5, true);
            inventario.add(p);

            Productos p1 = new Productos(2, "pepe", 21.5, true, 5, true);*/
            inventario.add(producto);
        } else {
            System.out.println("No se puede agregar el producto. El stock está lleno.");
        }
        double importeTotal = 0;
        saldoCaja -= importeTotal;
        inventario.add(producto);
        System.out.println("Producto agregado correctamente.");
    }
}
