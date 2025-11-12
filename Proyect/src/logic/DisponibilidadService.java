
package logic;
import domain.Clase;
import domain.Vuelo;

public class DisponibilidadService {
    
    public boolean hayEspacio(Vuelo vuelo, Clase clase) {
        if (vuelo == null || clase == null) return false;
        return vuelo.verificarDisponibilidad(clase);
        
    }

    public boolean ocuparAsiento(Vuelo vuelo, Clase clase) {
        if (vuelo == null || clase == null) return false;
        if (!vuelo.verificarDisponibilidad(clase)) return false; 
        return vuelo.ocuparAsiento(clase); 
    }
}
