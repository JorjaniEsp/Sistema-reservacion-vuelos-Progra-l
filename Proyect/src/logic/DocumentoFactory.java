/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Factura;
import domain.MetodoPago;
import domain.Reservacion;
import domain.Tiquete;

/**
 *
 * @author josse
 */
public class DocumentoFactory {
  


    public static Tiquete crearTiquete(Reservacion reservacion) {
        if (reservacion == null) {
            throw new IllegalArgumentException("La reservación no puede ser nula.");
        }
        return new Tiquete(reservacion);
    }

    /**
     * Crea una factura a partir de una reservación y método de pago.
     */
    public static Factura crearFactura(Reservacion reservacion, MetodoPago metodoPago, int idDocumento) {
        if (reservacion == null || metodoPago == null) {
            throw new IllegalArgumentException("La reservación y el método de pago no pueden ser nulos.");
        }

        String fechaEmision = java.time.LocalDate.now().toString();
        return new Factura(reservacion, metodoPago, idDocumento, fechaEmision);
    }
}
 
