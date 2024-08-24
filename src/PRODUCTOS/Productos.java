package PRODUCTOS;

public abstract class Productos {
    protected String id;
    protected String nombre;
    protected double precio;
    protected int stock;
    protected boolean disponible;
    protected boolean importado;
    protected double porcentajeGanancia;

    public Productos(String id, String nombre, double precio, int stock, boolean importado, boolean disponible, double porcentajeGanancia) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.importado = importado;
        this.disponible = disponible;
        setPorcentajeGanancia(porcentajeGanancia);
        validarId(id);
    }

    protected abstract void validarId(String id);
    public void setPorcentajeGanancia(double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }
    public double calcularPrecioConDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 0) {
            porcentajeDescuento = 0;
        }
        double precioConDescuento = precio * (1 - porcentajeDescuento / 100);
        return precioConDescuento * (1 + obtenerImpuesto());
    }
    public double obtenerImpuesto() {
        return 0; // Por defecto, ningún impuesto
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
