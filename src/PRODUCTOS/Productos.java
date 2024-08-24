package PRODUCTOS;

public class Productos {
    protected String id;
    protected String nombre;
    protected double precio;
    protected int stock;
    protected boolean disponible;
    protected boolean importado;

    public Productos(String id, String nombre, double precio, int stock, boolean importado, boolean disponible, double calorias) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.importado = importado;
        this.disponible = disponible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getImportado() {
        return importado;
    }
    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
