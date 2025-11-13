
package logic;
import domain.*;

public class DisponibilidadService {
    
    public boolean hayEspacio(Vuelo vuelo, Clase clase) {
        if (vuelo == null || clase == null) return false;
        return vuelo.verificarDisponibilidad(clase);
    }

    public boolean ocuparAsiento(Vuelo vuelo, Clase clase) {
        if (vuelo == null || clase == null) return false;
        return vuelo.ocuparAsiento(clase);
    }

    public int disponibles(Vuelo vuelo, Clase clase) {
        if (vuelo == null || clase == null) return 0;
        return vuelo.disponibles(clase);
    }

    public boolean liberarAsiento(Vuelo vuelo, Clase clase) {
        if (vuelo == null || clase == null) return false;
        Avion avion = vuelo.getAvion();
        if (avion == null) return false;
        return avion.liberarAsiento(clase);
    }
}
