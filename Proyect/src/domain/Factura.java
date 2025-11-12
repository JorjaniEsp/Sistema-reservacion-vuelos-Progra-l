package domain;

public class Factura {

    private int idDocumento;
    private String fechaEmision;
    private Reservacion reservacion;
    private MetodoPago metodoPago;

    public Factura() {
    }

    public Factura(Reservacion reservacion, MetodoPago metodoPago) {
        this.reservacion = reservacion;
        this.metodoPago = metodoPago;
    }

    public Factura(Reservacion reservacion, MetodoPago metodoPago, int idDocumento, String fechaEmision) {
        this.idDocumento = idDocumento;
        this.fechaEmision = fechaEmision;
        this.reservacion = reservacion;
        this.metodoPago = metodoPago;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
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

   
    @Override
    public String toString() {
        return "---Informacion de factura---" +
                "ID documento: " + idDocumento +
                " | Fecha de emisión: " + fechaEmision +
                " | Reservacion: " + reservacion +
                " | Metodo de pago: " + metodoPago;
    }

 
    public String mostrar() {
        if (reservacion == null) {
            return "Factura sin reservación, raro pero bueno.";
        }

        String pasajeroNombre = reservacion.getPasajero() != null ? reservacion.getPasajero().getNombre() : "Desconocido";
        Vuelo vuelo = reservacion.getVuelo();
        String ruta = (vuelo != null) ? vuelo.getOrigen() + " → " + vuelo.getDestino() : "???";
        String claseTxt = (reservacion.getClase() != null) ? reservacion.getClase().name() : "Sin clase";
        String asiento = (reservacion.getNumAsiento() != null) ? reservacion.getNumAsiento() : "??";
        double total = reservacion.getCostoFinal();

        StringBuilder sb = new StringBuilder();
        sb.append("===== FACTURA #").append(idDocumento).append(" =====\n");
        sb.append("Fecha: ").append(fechaEmision != null ? fechaEmision : "sin fecha").append("\n");
        sb.append("\n--- Detalles ---\n");
        sb.append("Pasajero: ").append(pasajeroNombre).append("\n");
        sb.append("Ruta: ").append(ruta).append("\n");
        sb.append("Clase: ").append(claseTxt).append("\n");
        sb.append("Asiento: ").append(asiento).append("\n");
        sb.append("Método de pago: ").append(metodoPago != null ? metodoPago : "n/a").append("\n");
        sb.append("Total a pagar: $").append(String.format("%.2f", total)).append("\n");
        sb.append("(guarde esto.)\n");
        sb.append("=========================\n");
        sb.append("   Gracias por volar con nosotros!\n");
        sb.append("   (si el vuelo se retrasa, no nos culpe)\n");
        sb.append("=========================\n");

        return sb.toString();
    }

   
    public String toStringAlt() {
        return mostrar();
    }
}
