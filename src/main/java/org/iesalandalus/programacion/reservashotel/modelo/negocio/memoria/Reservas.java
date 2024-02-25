package org.iesalandalus.programacion.reservashotel.modelo.negocio.memoria;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.IReservas;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Reservas implements IReservas {

    // Se crean los atributos con su visibilidad adecuada
    private List<Reserva> coleccionReservas;

    public  Reservas() {
        this.coleccionReservas = new ArrayList<>();
    }

    public List<Reserva> get() {
        List<Reserva> copiaReservas = new ArrayList<>();
        for (Reserva coleccionReserva : coleccionReservas) {
            copiaReservas.add(new Reserva(coleccionReserva));
        }
        return copiaReservas;
    }

    public int getTamano() {
        return coleccionReservas.size();
    }

    public void insertar(Reserva reserva) throws OperationNotSupportedException {
       Objects.requireNonNull(reserva, "ERROR: No se puede insertar una reserva nula.");
        if (!coleccionReservas.contains(reserva)) {
            coleccionReservas.add(new Reserva(reserva));
        } else {
            throw new OperationNotSupportedException("ERROR: Ya existe un reserva con el mismo nombre.");
        }

    }

    public Reserva buscar(Reserva reserva) {
        Objects.requireNonNull(reserva, "ERROR: No se puede buscar una reserva nula.");
        int indice = coleccionReservas.indexOf(reserva);
        if (indice == -1) {
            return null;
        } else {
            return new Reserva(coleccionReservas.get(indice));
        }
    }

    public void borrar(Reserva reserva) throws OperationNotSupportedException {
        Objects.requireNonNull(reserva, "ERROR: No se puede borrar una reserva nula.");
        int indice = coleccionReservas.indexOf(reserva);
        if (indice == -1) {
            throw new OperationNotSupportedException("ERROR: No existe ninguna reserva con ese nombre.");
        } else {
            coleccionReservas.remove(indice);
        }
    }

    public List<Reserva> getReservas(Huesped huesped) {
        Objects.requireNonNull(huesped, "ERROR: No se pueden buscar reservas de un hu�sped nulo.");
        List<Reserva> reservasHuesped = new ArrayList<>();
        for (Iterator<Reserva> iterator = get().iterator(); iterator.hasNext();) {
            if (iterator.next() != null &&
                    iterator.next().getHuesped().equals(huesped)) {
                reservasHuesped.add(new Reserva(iterator.next()));
            }
        }
        return reservasHuesped;
    }

    public List<Reserva> getReservas(TipoHabitacion tipoHabitacion) {
        Objects.requireNonNull(tipoHabitacion, "ERROR: No se pueden buscar reservas de un tipo de habitaci�n nula.");
        List<Reserva> reservasHabitacion = new ArrayList<>();
        for (Iterator<Reserva> iterator = get().iterator(); iterator.hasNext();) {
            if (iterator.next().getHabitacion().getClass().isInstance(tipoHabitacion)) {
                reservasHabitacion.add(new Reserva(iterator.next()));
            }
        }
        return reservasHabitacion;
    }

    public List<Reserva> getReservasFuturas(Habitacion habitacion) {
        Objects.requireNonNull(habitacion, "ERROR: No se pueden buscar reservas de una habitaci�n nula.");
        List<Reserva> reservasHabitacion = new ArrayList<>();
        for (Iterator<Reserva> iterator = get().iterator(); iterator.hasNext();) {
            if (iterator.next() != null && iterator.next().getHabitacion().equals(habitacion)) {
                reservasHabitacion.add(new Reserva(iterator.next()));
            }
        }
        return reservasHabitacion;
    }

    public void realizarCheckin(Reserva reserva, LocalDateTime fecha){
        reserva.setCheckIn(fecha);
    }

    public void realizarCheckOut(Reserva reserva, LocalDateTime fecha){
        reserva.setCheckOut(fecha);
    }

}
