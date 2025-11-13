package domain;

public class Tiquete extends Documento {

    private Reservacion reservacion;

    public Tiquete() { }

    public Tiquete(Reservacion reservacion) {
        super(0, null);
        this.reservacion = reservacion;
    }

    public Tiquete(Reservacion reservacion, int idDocumento, String fechaEmision) {
        super(idDocumento, fechaEmision);
        this.reservacion = reservacion;
    }

    public Reservacion getReservacion() { return reservacion; }
    public void setReservacion(Reservacion reservacion) { this.reservacion = reservacion; }

    @Override
    public String mostrar() {
        String pasajero = (reservacion != null && reservacion.getPasajero() != null)
                ? reservacion.getPasajero().getNombre() : "N/D";
        String origen = (reservacion != null && reservacion.getVuelo() != null)
                ? reservacion.getVuelo().getOrigen() : "N/D";
        String destino = (reservacion != null && reservacion.getVuelo() != null)
                ? reservacion.getVuelo().getDestino() : "N/D";
        String fechaVuelo = (reservacion != null && reservacion.getVuelo() != null)
                ? reservacion.getVuelo().getFecha() : "N/D";
        String hora = (reservacion != null && reservacion.getVuelo() != null)
                ? reservacion.getVuelo().getHorario() : "N/D";
        String clase = (reservacion != null && reservacion.getClase() != null)
                ? reservacion.getClase().name() : "N/D";
        String asiento = (reservacion != null && reservacion.getNumAsiento() != null)
                ? reservacion.getNumAsiento() : "N/D";
        double total = (reservacion != null) ? reservacion.getCostoFinal() : 0.0;

        StringBuilder sb = new StringBuilder();
        sb.append("=======================\n");
        sb.append("     TIQUETE EMITIDO   \n");
        sb.append("=======================\n");
        sb.append("Tiquete #: ").append(getIdDocumento()).append("\n");
        sb.append("Emitido  : ").append(getFechaEmision() != null ? getFechaEmision() : "N/D").append("\n");
        sb.append("-----------------------\n");
        sb.append("Pasajero : ").append(pasajero).append("\n");
        sb.append("Ruta     : ").append(origen).append(" → ").append(destino).append("\n");
        sb.append("Fecha    : ").append(fechaVuelo).append("\n");
        sb.append("Hora     : ").append(hora).append("\n");
        sb.append("Clase    : ").append(clase).append("\n");
        sb.append("Asiento  : ").append(asiento).append("\n");
        sb.append("-----------------------\n");
        sb.append(String.format("Total    : $%.2f\n", total));
        sb.append("=======================\n");
        sb.append(" ¡Gracias por su compra! \n");
        sb.append("=======================\n");
        return sb.toString();
    }

    @Override
    public String toString() { return mostrar(); }
}

