package PRODUCTOS;

import java.util.regex.Pattern;

public class Limpieza extends Productos {
    public enum Aplicacion{
        COCINA, BAÑO, ROPA, MULTIUSO
    }

    protected Aplicacion aplicacion;

    public Limpieza(String id, String nombre, double precio, int stock, boolean importado, boolean disponible, double porcentajeGanancia, Aplicacion aplicacion) {
        super(id, nombre, precio, stock, importado, disponible, porcentajeGanancia);
        this.aplicacion = aplicacion;
        validarPorcentajeGanancia();
    }

    @Override
    protected void validarId(String id) {
        if (!Pattern.matches("AZ\\d{3}", id)) {
            throw new IllegalArgumentException("ID no válido para producto de limpieza");
        }
    }
    private void validarPorcentajeGanancia() {
        if (aplicacion == Aplicacion.COCINA || aplicacion == Aplicacion.MULTIUSO) {
            if (porcentajeGanancia < 0) {
                porcentajeGanancia = 0;
            }
        } else {
            if (porcentajeGanancia < 10) {
                porcentajeGanancia = 10;
            } else if (porcentajeGanancia > 25) {
                porcentajeGanancia = 25;
            }
        }
        setPorcentajeGanancia(porcentajeGanancia);
    }

    @Override
    public double obtenerImpuesto() {
        return 0; // No hay impuesto para productos de limpieza
    }
    @Override
    public String toString() {
        return "Limpieza{" +
                "aplicacion=" + aplicacion +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", disponible=" + disponible +
                ", importado=" + importado +
                ", porcentajeGanancia=" + porcentajeGanancia +
                '}';
    }
}