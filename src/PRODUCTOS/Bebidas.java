package PRODUCTOS;

import java.util.regex.Pattern;

public class Bebidas extends Productos {
    private double calorias;
    protected String fecha;

 protected double graduacionAlcoholica;

    public Bebidas(String id, String nombre, double precio, int stock, boolean importado, boolean disponible, double porcentajeGanancia, double calorias, String fecha, double graduacionAlcoholica) {
        super(id, nombre, precio, stock, importado, disponible, porcentajeGanancia);
        this.calorias = calorias;
        this.fecha = fecha;
        this.graduacionAlcoholica = graduacionAlcoholica;
        validarPorcentajeGanancia();
    }

    @Override
    protected void validarId(String id) {
        if (!Pattern.matches("AC\\d{3}", id)) {
            throw new IllegalArgumentException("ID no válido para bebida");
        }
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
    private void validarPorcentajeGanancia() {
        if (porcentajeGanancia > 10) {
            porcentajeGanancia = 10;
        }
        setPorcentajeGanancia(porcentajeGanancia);
    }

    @Override
    public double obtenerImpuesto() {
        return importado ? 0.12 : 0;
    }

    public double calcularCalorias(double calorias) {
        if (graduacionAlcoholica <= 2) {
            return calorias;
        } else if (graduacionAlcoholica <= 4.5) {
            return calorias * 1.25;
        } else {
            return calorias * 1.5;
        }
    }

    @Override
    public String toString() {
        return "Bebidas{" +
                "calorias=" + calorias +
                ", fecha='" + fecha + '\'' +
                ", graduacionAlcoholica=" + graduacionAlcoholica +
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
