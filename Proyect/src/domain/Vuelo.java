
package domain;

public class Vuelo {
    
    private String origen;
    private String destino;
    private String fecha;
    private String horario;
    private double costoBase;
    private Avion avion;

    public Vuelo() {
    }

    public Vuelo(String origen, String destino, String fecha, String horario, double costoBase, Avion avion) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.horario = horario;
        this.costoBase = costoBase;
        this.avion = avion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public boolean verificarDisponibilidad(Clase clase) {
        if (avion == null || clase == null) return false;
        return avion.hayEspacio(clase);
    }
    
    public boolean ocuparAsiento(Clase clase) {
        if (avion == null || clase == null) return false;
        int antes = avion.disponibles(clase);
        if (antes <= 0) return false;
        if (!avion.ocuparAsiento(clase)) return false;
        
        return avion.disponibles(clase) == antes - 1;
    }
    
    public int disponibles(Clase clase) {
        if (avion == null || clase == null) return 0;
        return avion.disponibles(clase);
    
    }
 
    @Override
    public String toString() {
        return "Vuelo[" + origen + "→" + destino + ", " + fecha + " " + horario + ", base=" + costoBase + "]";
    }
    
}
