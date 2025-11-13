package domain;

public class Reservacion {

    private int idReservacion;
    private Vuelo vuelo;             
    private Pasajero pasajero;        
    private Clase clase;              
    private double costoFinal;
    private String numAsiento;
    private Tiquete miTiquete;        
    private Factura miFactura;  

    public Reservacion() {}

    public Reservacion(int idReservacion, Vuelo vuelo, Pasajero pasajero,
                       Clase clase, double costoFinal, String numAsiento) {
        this.idReservacion = idReservacion;
        this.vuelo = vuelo;
        this.pasajero = pasajero;
        this.clase = clase;
        this.costoFinal = costoFinal;
        this.numAsiento = numAsiento;
    }
    
    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public String getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }

    public Tiquete getMiTiquete() {
        return miTiquete;
    }

    public Factura getMiFactura() {
        return miFactura;
    }


    public boolean puedeConfirmarse() {
        
        boolean datosValidos = this.vuelo !=null &&
                               this.pasajero != null &&
                               this.clase != null;
        
        if(!datosValidos){
            return false;
        }
        
        if (this.costoFinal <= 0.0){
            return false;
        }
        
        return this.vuelo.verificarDisponibilidad(this.clase);
    }

    public void enlazarTiquete(Tiquete t) {
        this.miTiquete = t;
    }

    public void enlazarFactura(Factura f) {
        this.miFactura = f;
    }

    @Override
    public String toString() {
        String nombrePasajero = (pasajero != null ? pasajero.getNombre() : "N/D");
        String vueloResumen = (vuelo != null
                ? vuelo.getOrigen() + "→" + vuelo.getDestino() + " " + vuelo.getFecha() + " " + vuelo.getHorario()
                : "Vuelo N/D");
        String claseTxt = (clase != null ? clase.name() : "N/D");
        String asientoTxt = (numAsiento != null ? numAsiento : "N/D");

        return "Reservacion#" + idReservacion
                + " [Pasajero=" + nombrePasajero
                + ", Vuelo=" + vueloResumen
                + ", Clase=" + claseTxt
                + ", Asiento=" + asientoTxt
                + ", Total=" + costoFinal + "]";

    }
    
    
}
