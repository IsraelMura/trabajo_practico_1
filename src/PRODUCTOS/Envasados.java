package PRODUCTOS;

import java.util.regex.Pattern;

public class Envasados extends Productos {
    protected String fecha;
    protected String tipoEnvasado;
    protected double calorias;

    public Envasados(String id, String nombre, double precio, int stock, boolean importado, boolean disponible, double porcentajeGanancia, String fecha, String tipoEnvasado, double calorias) {
        super(id, nombre, precio, stock, importado, disponible, porcentajeGanancia);
        this.fecha = fecha;
        this.tipoEnvasado = tipoEnvasado;
        this.calorias = calorias;
        validarPorcentajeGanancia();
    }

    @Override
    protected void validarId(String id) {
        if (!Pattern.matches("AB\\d{3}", id)) {
            throw new IllegalArgumentException("ID no válido para producto envasado");
        }
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

    private void validarPorcentajeGanancia() {
        if (porcentajeGanancia < 0) {
            porcentajeGanancia = 0;
        } else if (porcentajeGanancia > 15) {
            porcentajeGanancia = 15;
        }
        setPorcentajeGanancia(porcentajeGanancia);
    }

    @Override
    public double obtenerImpuesto() {
        return importado ? 0.12 : 0;
    }

    @Override
    public String toString() {
        return "Envasados{" +
                "fecha='" + fecha + '\'' +
                ", tipoEnvasado='" + tipoEnvasado + '\'' +
                ", calorias=" + calorias +
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
