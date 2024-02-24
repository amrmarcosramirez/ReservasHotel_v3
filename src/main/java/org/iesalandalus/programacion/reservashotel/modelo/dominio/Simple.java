package org.iesalandalus.programacion.reservashotel.modelo.dominio;


public class Simple extends Habitacion{

    // Atributos
    private static final int NUM_MAXIMO_PERSONAS=1;

    //Constructores
    public Simple(int planta, int puerta, double precio){
        super(planta, puerta, precio);
    }

    public Simple(Simple habitacionSimple){
        super(habitacionSimple.getPlanta(), habitacionSimple.getPuerta(),
                habitacionSimple.getPrecio());
    }

    @Override
    public int getNumeroMaximoPersonas() {
        return NUM_MAXIMO_PERSONAS;
    }

    @Override
    public String toString() {
        return String.format("capacidad=%d personas", this.getNumeroMaximoPersonas());
    }
}
