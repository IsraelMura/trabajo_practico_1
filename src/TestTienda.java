import PRODUCTOS.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestTienda {
    private static Tienda tienda = new Tienda("Tienda de Ejemplo", 1000, 5000.00);
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 3) {
            System.out.println("==== Menú de Tienda ====");
            System.out.println("1. Realizar compra");
            System.out.println("2. Realizar venta");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        realizarCompra();
                        break;
                    case 2:
                        realizarVenta();
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
                scanner.next();
            }
        }

        scanner.close();

        scanner.close();
    }

    private void inicializarTienda() {
        Envasados e1 = new Envasados("AB001", "Arroz Integral", 3.50, 100, false, true, 12, "2025-12-31", "Plástico", 350);
        Envasados e2 = new Envasados("AB002", "Harina de Trigo", 2.75, 50, false, true, 14, "2024-11-15", "Cartón", 250);
        Envasados e3 =new Envasados("AB003", "Azúcar Blanca", 1.99, 75, true, true, 15, "2025-10-01", "Vidrio", 400);
        tienda.agregarProductos(Map.of(e1, 45, e2, 60, e3, 40));
    }

    private static void realizarCompra() {
        System.out.println();
        System.out.println("=== Prueba: Realizar Compra ===");

        Bebidas b1 = new Bebidas("AC001", "Vino Tinto", 15.00, 30, true, true, 10, 250, "2026-05-30", 12.0);
        Bebidas b2 = new Bebidas("AC002", "Cerveza Lager", 4.50, 50, false, true, 8, 150, "2024-09-15", 5.0);
        Bebidas b3 = new Bebidas("AC003", "Whisky Escocés", 30.00, 20, true, true, 12, 400, "2026-03-10", 40.0);

        Limpieza l1 = new Limpieza("AZ001", "Limpiador Multiusos", 3.50, 100, false, true, 15, Limpieza.Aplicacion.MULTIUSO);
        Limpieza l2 =new Limpieza("AZ002", "Detergente para Cocina", 2.75, 60, false, true, 12, Limpieza.Aplicacion.COCINA);
        Limpieza l3 = new Limpieza("AZ003", "Desinfectante de Baño", 4.00, 45, false, true, 18, Limpieza.Aplicacion.BAÑO);

        tienda.realizarCompra(Map.of(b1, 25, b2, 20, b3, 10, l1, 3, l2, 5, l3, 8));
        System.out.println();
        verProductos(tienda.getInventario());
    }

    private static void verProductos(List<Productos> productos) {
        System.out.println("=== Productos en la tienda ===");
        for (Productos producto : productos) {
            System.out.println(producto);
        }
        System.out.println();
        System.out.println();
    }

    private static void realizarVenta() {
        System.out.println("=== Prueba: Realizar Venta ===");

        Bebidas b1 = new Bebidas("AC001", "Vino Tinto", 15.00, 30, true, true, 10, 250, "2026-05-30", 12.0);
        Limpieza l1 = new Limpieza("AZ001", "Limpiador Multiusos", 3.50, 100, false, true, 15, Limpieza.Aplicacion.MULTIUSO);
        Limpieza l2 =new Limpieza("AZ002", "Detergente para Cocina", 2.75, 60, false, true, 12, Limpieza.Aplicacion.COCINA);

        tienda.realizarVenta(Map.of(b1, 9, l1, 2, l2, 2));
        verProductos(tienda.getInventario());
    }
}
