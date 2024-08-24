package PRODUCTOS;

public class Bebidas extends Productos {
    private static final double calorias = 0;
    protected String id;
    protected String nombre;
    protected double precio;
    protected int stock;
    protected boolean importado;
    protected boolean disponible;
    protected String fecha;

 protected double graduacionAlcoholica;

    public Bebidas(String id, String nombre, double precio, int stock, boolean importado, boolean disponible, String fecha, double graduacionAlcoholica) {
        super(id, nombre, precio, stock,importado, disponible, calorias);
        this.fecha = fecha;
        this.graduacionAlcoholica = graduacionAlcoholica;
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public double getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    public String toString() {
        return "Bebida [Codigo=" + getId() + ", Nombre=" + getNombre() + ", Precio=" + getPrecio() +
                ", En Stock=" + getStock() + ", Es importado o no=" + getImportado() + ", Esta disponible=" + isDisponible() +
                ", Fecha de Expiracion=" + getFecha() + ", Alcohol=" + getGraduacionAlcoholica() + "]";
    }
}
