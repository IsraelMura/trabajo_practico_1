package PRODUCTOS;

public class Envasados extends Productos {
    protected String id;
    protected String nombre;
    protected double precio;
    protected int stock;
    protected boolean importado;
    protected boolean disponible;
    protected String fecha;
    protected String tipoEnvasado;
    protected double calorias;

    public Envasados(String id, String nombre, double precio, int stock, boolean importado, boolean disponible, String fecha,  String tipoEnvasado, double calorias) {
        super(id, nombre, precio, stock, importado, disponible, calorias);
        this.fecha = fecha;
        this.tipoEnvasado = tipoEnvasado;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoEnvasado() {
        return tipoEnvasado;
    }
    public void setTipoEnvasado(String tipoEnvasado) {
        this.tipoEnvasado = tipoEnvasado;
    }

    public String toString() {
        return "Envasados [Codigo=" + getId() + ", Nombre=" + getNombre() + ", Precio=" + getPrecio() +
                ", En Stock=" + getStock() + ", Es importado o no=" + getImportado() + ", Esta disponible=" + isDisponible() +
                ", Fecha de Expiracion=" + getFecha() + ", Tipo de Envasado=" + getTipoEnvasado() + "]";
    }
}
