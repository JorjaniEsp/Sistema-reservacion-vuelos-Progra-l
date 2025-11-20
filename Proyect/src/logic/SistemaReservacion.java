package logic;
import domain.Avion;
import domain.Clase;
import domain.Factura;
import domain.MetodoPago;
import domain.Pasajero;
import domain.Reservacion;
import domain.Tiquete;
import domain.Vuelo;
import java.util.*;

public class SistemaReservacion {
 
    private final List<Vuelo> listaVuelos;
    private final List<Reservacion> listaReservaciones;
    private final PrecioService precioService;
    private final DisponibilidadService disponibilidadService;

    public SistemaReservacion() {
        this.listaVuelos = new ArrayList<>();
        this.listaReservaciones = new ArrayList<>();
        this.precioService = new PrecioService();
        this.disponibilidadService = new DisponibilidadService();
        inicializarDatos();
    }

    public List<Vuelo> buscarVuelos(String origen, String destino, String fecha) {
        List<Vuelo> resultados = new ArrayList<>();
        for (Vuelo v : listaVuelos) {
            if (v.getOrigen().equalsIgnoreCase(origen)
                    && v.getDestino().equalsIgnoreCase(destino)
                    && v.getFecha().equalsIgnoreCase(fecha)) {
                resultados.add(v);
            }
        }
        return resultados;
    }

    public double cotizar(Vuelo vuelo, Clase clase) {
        return precioService.calcularCosto(vuelo, clase);
    }

    public Reservacion reservar(Vuelo vuelo, Pasajero pasajero, Clase clase, String numAsiento, MetodoPago metodoPago) {
        if (vuelo == null || pasajero == null || clase == null || numAsiento == null || metodoPago == null) {
            return null;
        }

        if (!disponibilidadService.hayEspacio(vuelo, clase)) {
            System.out.println("No hay cupos disponibles para este vuelo.");
            return null;
        }
        if (!disponibilidadService.ocuparAsiento(vuelo, clase)) {
            System.out.println("No se pudo ocupar el asiento (posible concurrencia).");
            return null;
        }

        double costoFinal = cotizar(vuelo, clase);

        int idReservacion = listaReservaciones.size() + 1;
        Reservacion reservacion = new Reservacion(idReservacion, vuelo, pasajero, clase, costoFinal, numAsiento);

        int idDocBase = idReservacion * 10;
        String hoy = obtenerFechaActual();

        Tiquete tiquete = DocumentoFactory.crearTiquete(reservacion, idDocBase, hoy);
        Factura factura = DocumentoFactory.crearFactura(reservacion, metodoPago, idDocBase + 1, hoy);

        reservacion.enlazarTiquete(tiquete);
        reservacion.enlazarFactura(factura);

        listaReservaciones.add(reservacion);
        return reservacion;
    }

    public Reservacion obtenerReservacionPorId(int id) {
        for (Reservacion r : listaReservaciones) {
            if (r.getIdReservacion() == id) return r;
        }
        return null;
    }

    public List<Reservacion> listarReservaciones() {
        return listaReservaciones;
    }

    private void inicializarDatos() {

        Avion avion1 = new Avion(2, 2);  
        Avion avion2 = new Avion(2, 2);  

        listaVuelos.add(new Vuelo("SJO", "MEX", "2025-11-15", "08:00", 250.0, avion1));
        listaVuelos.add(new Vuelo("SJO", "MIA", "2025-11-20", "14:00", 220.0, avion2));
        listaVuelos.add(new Vuelo("SJO", "PAN", "2025-12-01", "06:30", 180.0, avion2));
        listaVuelos.add(new Vuelo("MEX", "SJO", "2025-11-25", "18:00", 230.0, avion1));
        listaVuelos.add(new Vuelo("MEX", "MIA", "2025-12-05", "09:15", 240.0, avion2));
        listaVuelos.add(new Vuelo("MEX", "PAN", "2025-12-10", "11:45", 260.0, avion1));
    
    }

    private String obtenerFechaActual() {

        return java.time.LocalDate.now().toString();
    }

}  

