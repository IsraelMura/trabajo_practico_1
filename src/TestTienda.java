import PRODUCTOS.Bebidas;
import PRODUCTOS.Envasados;
import PRODUCTOS.Limpieza;
import PRODUCTOS.Productos;

import java.util.ArrayList;
import java.util.List;

import static PRODUCTOS.Limpieza.Aplicacion.*;

public class TestTienda {
    public static void main(String[] args) {
        List<Productos> productos = new ArrayList<>();
        Bebidas bebida1 = new Bebidas("AC001", "Coca Cola x 3l", 3500, 24,true, true, "27/08/2024",0 );
        Bebidas bebida2 = new Bebidas("AC002", "Cerveza x 500ml", 1200, 34, true, true, "17/10/2024", 5 );
        Bebidas bebida3 = new Bebidas("AC003", "Speed x 500ml", 900, 20, false, true,"05/09/2024", 2.5);
        Bebidas bebida4 = new Bebidas("AC004", "Vino", 875, 10, false, false, "27/08/2024", 1.5);

        Envasados envasado1 = new Envasados("AB001", "Lata de Tomate", 900, 40, false, true, "27/08/2028", "LATA", 183 );
        Envasados envasado2 = new Envasados("AB002", "Arroz x 1kg", 1000, 20, true, true, "27/08/2028", "PAQUETE", 130 );
        Envasados envasado3 = new Envasados("AB003", "Leche x 1l", 850, 5, false, true, "02/02/2028", "SACHET", 42 );
        Envasados envasado4 = new Envasados("AB004", "Masitas Saladas", 500, 87, false, true, "14/12/2025", "CAJA",  69);

        Limpieza limpieza2 = new Limpieza("AZ001", "Lavandina x 900ml", 960, 55, true, true);
        Limpieza limpieza3 = new Limpieza("AZ002", "Esponga", 230, 83, true, false);
        Limpieza limpieza4 = new Limpieza("AZ003", "Jabon", 200, 27, true, true);
        Limpieza limpieza5 = new Limpieza("AZ004", "Suavizante", 1500, 3, false, false);

        productos.add(bebida1);
        productos.add(bebida2);
        productos.add(bebida3);
        productos.add(bebida4);
        productos.add(envasado1);
        productos.add(envasado2);
        productos.add(envasado3);
        productos.add(envasado4);
        productos.add(limpieza2);
        productos.add(limpieza3);
        productos.add(limpieza4);
        productos.add(limpieza5);

        for (Productos producto : productos) {
            System.out.println(producto);
        }
    }
}

