package org.iesalandalus.programacion.reservashotel.modelo.negocio;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Habitaciones {

    // Se crean los atributos con su visibilidad adecuada
    private List<Habitacion> coleccionHabitaciones;

    //Constructores
    public Habitaciones() {
        this.coleccionHabitaciones = new ArrayList<>();
    }

    //M�todos de acceso y modificaci�n
    public List<Habitacion> get() {
        return copiaProfundaHabitaciones();
    }

    public List<Habitacion> get(TipoHabitacion tipoHabitacion) {
        List<Habitacion> copiaHabitaciones = new ArrayList<>();
        for (Habitacion habitacion : get()){
            if(!(habitacion == null) && habitacion.getTipoHabitacion().equals(tipoHabitacion)) {
                copiaHabitaciones.add(new Habitacion(habitacion));
            }
        }
        return copiaHabitaciones;
    }

    private List<Habitacion> copiaProfundaHabitaciones() {
        List<Habitacion> copiaHabitaciones = new ArrayList<>();
        for (Habitacion habitacion : coleccionHabitaciones) {
            copiaHabitaciones.add(new Habitacion(habitacion));
        }
        return copiaHabitaciones;
    }

    public int getTamano() {
        return coleccionHabitaciones.size();
    }

    public void insertar(Habitacion habitacion) throws OperationNotSupportedException {
        Objects.requireNonNull(habitacion, "ERROR: No se puede insertar una habitaci�n nula.");
        if (!coleccionHabitaciones.contains(habitacion)) {
            coleccionHabitaciones.add(new Habitacion(habitacion));
        } else {
            throw new OperationNotSupportedException("ERROR: Ya existe una habitaci�n con ese identificador.");
        }
    }

    public Habitacion buscar(Habitacion habitacion) {
        int indice = coleccionHabitaciones.indexOf(habitacion);
        if (indice == -1) {
            return null;
        } else {
            return new Habitacion(coleccionHabitaciones.get(indice));
        }
    }

    public void borrar(Habitacion habitacion) throws OperationNotSupportedException {
        Objects.requireNonNull(habitacion, "ERROR: No se puede borrar una habitaci�n nula.");

        int indice = coleccionHabitaciones.indexOf(habitacion);
        if (indice == -1) {
            throw new OperationNotSupportedException("ERROR: No existe ning�n aula con ese nombre.");
        } else {
            coleccionHabitaciones.remove(indice);
        }
    }

}
