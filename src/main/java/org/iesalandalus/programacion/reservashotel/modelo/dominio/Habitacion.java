package org.iesalandalus.programacion.reservashotel.modelo.dominio;

import java.util.Objects;

public class Habitacion {

    // Se crean los atributos con su visibilidad adecuada
    public static final double MIN_PRECIO_HABITACION = 40.0;
    public static final double MAX_PRECIO_HABITACION = 150.0;
    public static final int MIN_NUMERO_PUERTA = 0;
    public static final int MAX_NUMERO_PUERTA = 14;
    public static final int MIN_NUMERO_PLANTA = 1;
    public static final int MAX_NUMERO_PLANTA = 3;
    private String identificador;
    private int planta;
    private int puerta;
    private double precio;
    private TipoHabitacion tipoHabitacion;

    //Constructores
    public Habitacion(int planta, int puerta, double precio,
                      TipoHabitacion tipoHabitacion){
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        setTipoHabitacion(tipoHabitacion);
        setIdentificador(String.valueOf(planta)+puerta);
    }

    public Habitacion(Habitacion habitacion){
        Objects.requireNonNull(habitacion,
                "ERROR: No es posible copiar una habitaci�n nula.");
        setPlanta(habitacion.getPlanta());
        setPuerta(habitacion.getPuerta());
        setPrecio(habitacion.getPrecio());
        setTipoHabitacion(habitacion.getTipoHabitacion());
        setIdentificador(String.valueOf(habitacion.getPlanta())+habitacion.getPuerta());
    }

    //M�todos de acceso y modificaci�n
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        if (planta < MIN_NUMERO_PLANTA || planta > MAX_NUMERO_PLANTA) {
            throw new IllegalArgumentException("ERROR: No se puede establecer como planta de una habitaci�n un valor menor que "
                    + MIN_NUMERO_PLANTA + " ni mayor que "
                    + MAX_NUMERO_PLANTA + ".");
        } else {
            this.planta = planta;
        }
    }

    public int getPuerta() {
        return puerta;
    }

    public void setPuerta(int puerta) {
        if (puerta < MIN_NUMERO_PUERTA || puerta > MAX_NUMERO_PUERTA) {
            throw new IllegalArgumentException("ERROR: No se puede establecer como puerta de una habitaci�n un valor menor que "
                    + MIN_NUMERO_PUERTA + " ni mayor que "
                    + MAX_NUMERO_PUERTA + ".");
        } else {
            this.puerta = puerta;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < MIN_PRECIO_HABITACION || precio > MAX_PRECIO_HABITACION) {
            throw new IllegalArgumentException("ERROR: No se puede establecer como precio de una habitaci�n un valor menor que "
                    + MIN_PRECIO_HABITACION + " ni mayor que "
                    + MAX_PRECIO_HABITACION + ".");
        } else {
            this.precio = precio;
        }
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        Objects.requireNonNull(tipoHabitacion,
                "ERROR: No se puede establecer un tipo de habitaci�n nula.");
        this.tipoHabitacion = tipoHabitacion;
    }

    //M�todos equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Habitacion habitacion2)) return false;
        return identificador.equals(habitacion2.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public String toString() {
        return String.format("identificador=%s (%d-%d), precio habitaci�n=%s, tipo habitaci�n=%s",
                this.identificador, this.planta, this.puerta, this.precio, this.tipoHabitacion);
    }
}
