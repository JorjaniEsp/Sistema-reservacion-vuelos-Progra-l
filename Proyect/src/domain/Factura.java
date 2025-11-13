package domain;

public class Factura extends Documento {

    private Reservacion reservacion;
    private MetodoPago metodoPago;

    public Factura() { }

    public Factura(Reservacion reservacion, MetodoPago metodoPago) {
        this.reservacion = reservacion;
        this.metodoPago = metodoPago;
    }

    public Factura(Reservacion reservacion, MetodoPago metodoPago, int idDocumento, String fechaEmision) {
        super(idDocumento, fechaEmision);
        this.reservacion = reservacion;
        this.metodoPago = metodoPago;
    }

    public Reservacion getReservacion() { return reservacion; }
    public void setReservacion(Reservacion reservacion) { this.reservacion = reservacion; }

    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }

    public String mostrar() {
        String pasajero = (reservacion != null && reservacion.getPasajero() != null)
                ? reservacion.getPasajero().getNombre() : "N/D";
        String ruta = (reservacion != null && reservacion.getVuelo() != null)
                ? reservacion.getVuelo().getOrigen() + " → " + reservacion.getVuelo().getDestino() : "N/D";
        String claseTxt = (reservacion != null && reservacion.getClase() != null)
                ? reservacion.getClase().name() : "N/D";
        String asiento = (reservacion != null && reservacion.getNumAsiento() != null)
                ? reservacion.getNumAsiento() : "N/D";
        double total = (reservacion != null) ? reservacion.getCostoFinal() : 0.0;

        StringBuilder sb = new StringBuilder();
        sb.append("=======================\n");
        sb.append("        FACTURA        \n");
        sb.append("=======================\n");
        sb.append("Factura #: ").append(getIdDocumento()).append("\n");
        sb.append("Fecha    : ").append(getFechaEmision() != null ? getFechaEmision() : "N/D").append("\n");
        sb.append("-----------------------\n");
        sb.append("Pasajero : ").append(pasajero).append("\n");
        sb.append("Ruta     : ").append(ruta).append("\n");
        sb.append("Clase    : ").append(claseTxt).append("\n");
        sb.append("Asiento  : ").append(asiento).append("\n");
        sb.append("-----------------------\n");
        sb.append("Método de pago : ").append(metodoPago != null ? metodoPago.name() : "N/D").append("\n");
        sb.append(String.format("TOTAL          : $%.2f\n", total));
        sb.append("=======================\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return mostrar();
    }
}
