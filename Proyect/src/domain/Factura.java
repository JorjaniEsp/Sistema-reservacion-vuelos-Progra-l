package domain;

public class Factura extends Documento {
    
    private Reservacion reservacion;
    private MetodoPago metodoPago;

    public Factura() {
    }

    public Factura(Reservacion reservacion, MetodoPago metodoPago) {
        this.reservacion = reservacion;
        this.metodoPago = metodoPago;
    }

    public Factura(Reservacion reservacion, MetodoPago metodoPago, int idDocumento, String fechaEmision) {
        super(idDocumento, fechaEmision);
        this.reservacion = reservacion;
        this.metodoPago = metodoPago;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    public String mostrar() {
    return "";
    }

    @Override
    public String toString() {
        return "---Informacion de factura---" +
                "ID documento: " + getIdDocumento() +
                "Fecha de emisión: " + getFechaEmision() +
                "Reservacion: " + reservacion +
                "Metodo de pago: " + metodoPago;
    }
   
}
