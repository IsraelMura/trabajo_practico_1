package PRODUCTOS;

import java.util.ArrayList;
import java.util.List;

public class Ventas {
    private List<Productos> productosVendidos;
    private static final int MAX_PRODUCTOS = 3;
    private static final int MAX_UNIDADES = 12;

    public Ventas() {
        this.productosVendidos = new ArrayList<>();
        }

        public boolean agregarProducto(Productos producto, int unidades) {
           /* if (productosVendidos.size() >= MAX_PRODUCTOS) {
                System.out.println("No se puede agregar más de 3 productos en una venta");
                return false;

            }
            if (unidades > MAX_UNIDADES) {
                System.out.println("No se puede agregar más de 12 productos");
                return false;
            }*/
            /*producto.setVendidos(unidades);
            productosVendidos.add(producto);
            return true;*/
            return false;
        }/*
        public void imprimirDetalles() {
            double total = 0;
            System.out.println("Detalle de venta: ");
            for (Productos producto : productosVendidos) {
            }*/
        }
