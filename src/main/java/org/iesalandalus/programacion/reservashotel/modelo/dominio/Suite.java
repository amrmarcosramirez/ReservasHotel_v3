package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public class Suite extends Habitacion{

    // Atributos
    private static final int NUM_MAXIMO_PERSONAS=4;
    static final int MIN_NUM_BANOS=1;
    static final int MAX_NUM_BANOS=2;
    private int numBanos;
    private boolean tieneJacuzzi;

    //Constructores
    public Suite(int planta, int puerta, double precio, int numBanos,
                 boolean tieneJacuzzi){
        super(planta, puerta, precio);
        setNumBanos(numBanos);
        setTieneJacuzzi(tieneJacuzzi);
    }

    public Suite(Suite suite){
        super(suite.getPlanta(), suite.getPuerta(), suite.getPrecio());
        setNumBanos(suite.numBanos);
        setTieneJacuzzi(suite.tieneJacuzzi);
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        this.numBanos = numBanos;
    }

    public boolean isTieneJacuzzi() {
        return tieneJacuzzi;
    }

    public void setTieneJacuzzi(boolean tieneJacuzzi) {
        this.tieneJacuzzi = tieneJacuzzi;
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
