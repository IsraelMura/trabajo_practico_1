package PRODUCTOS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tienda {
    private String nombre;
    private int maxStock;
    private double saldoCaja;
    private List<Productos> inventario;

    public Tienda(String nombre, int maxStock, double saldoCaja) {
        this.nombre = nombre;
        this.maxStock = maxStock;
        this.saldoCaja = saldoCaja;
        this.inventario = new ArrayList<Productos>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public double getSaldoCaja() {
        return saldoCaja;
    }

    public void setSaldoCaja(double saldoCaja) {
        this.saldoCaja = saldoCaja;
    }

    public List<Productos> getInventario() {
        return inventario;
    }

    public void setInventario(List<Productos> inventario) {
        this.inventario = inventario;
    }

    public void agregarProductos(Map<Productos, Integer> productos) {
        for (Map.Entry<Productos, Integer> entry : productos.entrySet()) {
            Productos producto = entry.getKey();
            int cantidad = entry.getValue();

            producto.setStock(cantidad);
            inventario.add(producto);
        }
    }

    public void realizarCompra(Map<Productos, Integer> productos) {
        double importeTotal = 0;
        int cantidadTotalAAgregar = 0;

        System.out.println();
        System.out.println(mostrarDatosTienda());
        System.out.println();
        System.out.println("Detalle de la compra:");
        System.out.println("_______________________________________");

        for (Map.Entry<Productos, Integer> entry : productos.entrySet()) {
            Productos producto = entry.getKey();
            int cantidad = entry.getValue();

            importeTotal += producto.precio * cantidad;
            cantidadTotalAAgregar += cantidad;
        }

        if (saldoCaja < importeTotal) {
            System.out.println("El producto no podrá ser agregado a la tienda por saldo insuficiente en la caja");
            return;
        }

        int cantidadTotalEnStock = inventario.stream().mapToInt(p -> p.getStock()).sum();
        if (cantidadTotalEnStock + cantidadTotalAAgregar > maxStock) {
            System.out.println("No se pueden agregar nuevos productos a la tienda ya que se alcanzó el máximo de stock");
            return;
        }

        saldoCaja -= importeTotal;
        for (Map.Entry<Productos, Integer> entry : productos.entrySet()) {
            Productos producto = entry.getKey();
            int cantidad = entry.getValue();

            boolean encontrado = false;
            for (Productos p : inventario) {
                if (p.id.equals(producto.id)) {
                    p.setStock(p.getStock() + cantidad);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                producto.setStock(cantidad);
                inventario.add(producto);
            }
            System.out.println(producto.getId() + " " + producto.getNombre() + " " + cantidad + " x " + producto.getPrecio());
        }
        System.out.println();
        System.out.println("_______________________________________");
        System.out.printf("TOTAL COMPRA: %.2f\n", importeTotal);
        System.out.printf("SALDO CAJA: %.2f\n", saldoCaja);
    }
    public void realizarVenta(Map<Productos, Integer> productosVenta) {
        double totalVenta = 0;
        boolean hayStockInsuficiente = false;
        boolean hayProductosNoDisponibles = false;

        System.out.println();
        System.out.println(mostrarDatosTienda());

        System.out.println();
        System.out.println("Detalle de la venta:");
        System.out.println("_______________________________________");

        for (Map.Entry<Productos, Integer> entry : productosVenta.entrySet()) {
            Productos producto = entry.getKey();
            int cantidad = entry.getValue();

            if (!producto.isDisponible()) {
                hayProductosNoDisponibles = true;
                System.out.println("El producto " + producto.getId() + " " + producto.getNombre()+ " no se encuentra disponible");
                continue;
            }

            if (producto.getStock() < cantidad) {
                cantidad = producto.getStock();
                hayStockInsuficiente = true;
                producto.setDisponible(false);
            }

            double precioVenta = producto.calcularPrecioConDescuento(0); // Aplicar descuento específico
            double subtotal = precioVenta * cantidad;
            totalVenta += subtotal;

            producto.setStock(producto.getStock() - cantidad);

            System.out.println(producto.getId() + " " + producto.getNombre() + " " + cantidad + " x " + precioVenta);
        }

        if (hayStockInsuficiente) {
            System.out.println("Hay productos con stock disponible menor al solicitado");
        }

        if (hayProductosNoDisponibles) {
            System.out.println("Algunos productos no estaban disponibles para la venta.");
        }

        saldoCaja += totalVenta;

        System.out.println();
        System.out.println("_______________________________________");
        System.out.printf("TOTAL VENTA: %.2f\n", totalVenta);
        System.out.printf("SALDO CAJA: %.2f\n", saldoCaja);
        System.out.println();
    }

    private String mostrarDatosTienda() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Tienda\n" +
                "_______________________________________\n" +
                "* Nombre = '" + nombre + '\'' +
                "\n* Stock = " + maxStock +
                "\n* SaldoCaja = " + saldoCaja;
    }
}
