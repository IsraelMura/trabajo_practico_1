package PRODUCTOS;

public class Limpieza extends Productos {
    protected String id;
    protected String nombre;
    protected double precio;
    protected int stock;
    protected boolean disponible;
    public enum Aplicacion{
        COCINA, BAÑO, ROPA, MULTIUSO
    }

    protected Aplicacion aplicacion;

    public Limpieza(String id, String nombre, double precio, int stock, boolean importado, boolean disponible, double calorias, String id1, String nombre1, double precio1, int stock1, boolean disponible1, Aplicacion aplicacion) {
        super(id, nombre, precio, stock, importado, disponible, calorias);
        this.id = id1;
        this.nombre = nombre1;
        this.precio = precio1;
        this.stock = stock1;
        this.disponible = disponible1;
        this.aplicacion = aplicacion;
    }
    public String toString() {
        return "Limpieza [Codigo=" + getId() + ", Nombre=" + getNombre() + ", Precio=" + getPrecio() +
                ", En Stock=" + getStock() +  ", Esta disponible=" + isDisponible() + ", Aplicacion=" + aplicacion + "]";
    }
}