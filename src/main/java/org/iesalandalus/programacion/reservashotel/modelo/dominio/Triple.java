package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public class Triple extends Habitacion{

    // Atributos
    private static final int NUM_MAXIMO_PERSONAS=3;
    static final int MIN_NUM_BANOS=1;
    static final int MAX_NUM_BANOS=2;
    static final int MIN_NUM_CAMAS_INDIVIDUALES=2;
    static final int MAX_NUM_CAMAS_INDIVIDUALES=3;
    static final int MIN_NUM_CAMAS_DOBLES=0;
    static final int MAX_NUM_CAMAS_DOBLES=1;
    private int numBanos;
    private int numCamasIndividuales;
    private int numCamasDobles;

    //Constructores
    public Triple(int planta, int puerta, double precio, int numBanos,
                  int numCamasIndividuales, int numCamasDobles){
        super(planta, puerta, precio);
        setNumBanos(numBanos);
        setNumCamasIndividuales(numCamasIndividuales);
        setNumCamasDobles(numCamasDobles);
    }

    public Triple(Triple habitacionTriple){
        super(habitacionTriple.getPlanta(), habitacionTriple.getPuerta(),
                habitacionTriple.getPrecio());
        setNumBanos(habitacionTriple.getNumBanos());
        setNumCamasIndividuales(habitacionTriple.getNumCamasIndividuales());
        setNumCamasDobles(habitacionTriple.getNumCamasDobles());
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        this.numBanos = numBanos;
    }

    public int getNumCamasIndividuales() {
        return numCamasIndividuales;
    }

    public void setNumCamasIndividuales(int numCamasIndividuales) {
        this.numCamasIndividuales = numCamasIndividuales;
    }

    public int getNumCamasDobles() {
        return numCamasDobles;
    }

    public void setNumCamasDobles(int numCamasDobles) {
        this.numCamasDobles = numCamasDobles;
    }

    private void validaNumCamas(){
        if (getNumCamasIndividuales() < MIN_NUM_CAMAS_INDIVIDUALES ||
                getNumCamasIndividuales() > MAX_NUM_CAMAS_INDIVIDUALES) {
            throw new IllegalArgumentException("ERROR: El número de camas individuales no puede ser " +
                    "inferior a " + MIN_NUM_CAMAS_INDIVIDUALES + " ni mayor que " +
                    MAX_NUM_CAMAS_INDIVIDUALES + ".");
        }
        if (getNumCamasDobles() < MIN_NUM_CAMAS_DOBLES ||
                getNumCamasDobles() > MAX_NUM_CAMAS_DOBLES) {
            throw new IllegalArgumentException("ERROR: El número de camas dobles no puede ser " +
                    "inferior a " + MIN_NUM_CAMAS_DOBLES + " ni mayor que " +
                    MAX_NUM_CAMAS_DOBLES + ".");
        }
    }

    @Override
    public int getNumeroMaximoPersonas() {
        return NUM_MAXIMO_PERSONAS;
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                String.format("habitación triple, capacidad=%d personas, " +
                              "baños=%d, camas individuales=%d, camas dobles=%d",
                               this.getNumeroMaximoPersonas(), this.getNumBanos(),
                        this.getNumCamasIndividuales(), this.getNumCamasDobles());
    }
}
