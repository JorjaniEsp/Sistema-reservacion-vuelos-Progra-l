package logic;

import domain.Factura;
import domain.MetodoPago;
import domain.Reservacion;
import domain.Tiquete;

public class DocumentoFactory {

    public static Tiquete crearTiquete(Reservacion reservacion, int idDocumento, String fechaEmision) {
        if (reservacion == null) throw new IllegalArgumentException("La reservación no puede ser nula.");
        return new Tiquete(reservacion, idDocumento, fechaEmision);
    }

    public static Factura crearFactura(Reservacion reservacion, MetodoPago metodoPago, int idDocumento, String fechaEmision) {
        if (reservacion == null || metodoPago == null)
            throw new IllegalArgumentException("La reservación y el método de pago no pueden ser nulos.");
        return new Factura(reservacion, metodoPago, idDocumento, fechaEmision);
    }
}
 
