package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public enum TipoHabitacion {
    SUITE("SUITE"),
    SIMPLE("SIMPLE"),
    DOBLE("DOBLE"),
    TRIPLE("TRIPLE");

    // Se crean los atributos con su visibilidad adecuada
    private String cadenaAMostrar;

    //Constructor
    TipoHabitacion(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    //Método toString
    @Override
    public String toString() {
        return String.format("Tipo Habitacion: %s",
                this.cadenaAMostrar);
    }
}
