package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public enum Regimen {
    SOLO_ALOJAMIENTO("SOLO_ALOJAMIENTO", 0),
    ALOJAMIENTO_DESAYUNO("ALOJAMIENTO_DESAYUNO", 15),
    MEDIA_PENSION("MEDIA_PENSION", 30),
    PENSION_COMPLETA("PENSION_COMPLETA", 50);

    // Se crean los atributos con su visibilidad adecuada
    private String descripcion;
    private double incrementoPrecio;

    //Constructor
    Regimen(String descripcion, double incrementoPrecio) {
        this.descripcion = descripcion;
        this.incrementoPrecio = incrementoPrecio;
    }

    //M�todo de acceso
    public double getIncrementoPrecio() {
        return incrementoPrecio;
    }

    //M�todo toString
    @Override
    public String toString() {
        return String.format("R�gimen[descripci�n=%s, incremento precio=%s]",
                this.descripcion, getIncrementoPrecio());
    }
}
