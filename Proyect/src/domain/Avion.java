package domain;

public class Avion {

    private final int capacidadEjecutiva;
    private final int capacidadEconomica;
    private int ocupadosEjecutiva;
    private int ocupadosEconomica;

    public Avion(int capacidadEjecutiva, int capacidadEconomica) {
        this.capacidadEjecutiva = Math.max(0, capacidadEjecutiva);
        this.capacidadEconomica = Math.max(0, capacidadEconomica);
        this.ocupadosEjecutiva = 0;
        this.ocupadosEconomica = 0;
    }

    public Avion(String modelo, int capEconomica, int capEjecutiva, int ocupadosEconomicaIniciales) {
        this.capacidadEconomica = Math.max(0, capEconomica);
        this.capacidadEjecutiva = Math.max(0, capEjecutiva);
        this.ocupadosEconomica = Math.min(this.capacidadEconomica, Math.max(0, ocupadosEconomicaIniciales));
        this.ocupadosEjecutiva = 0;
    }

    public int getCapacidadEjecutiva() { return capacidadEjecutiva; }
    public int getCapacidadEconomica() { return capacidadEconomica; }
    public int getOcupadosEjecutiva()  { return ocupadosEjecutiva; }
    public int getOcupadosEconomica()  { return ocupadosEconomica; }

    public boolean hayEspacio(Clase clase) {
        if (clase == null) return false;
        if (clase == Clase.EJECUTIVA) return ocupadosEjecutiva < capacidadEjecutiva;
        if (clase == Clase.ECONOMICA) return ocupadosEconomica < capacidadEconomica;
        return false;
    }

    public boolean ocuparAsiento(Clase clase) {
        if (!hayEspacio(clase)) return false;
        if (clase == Clase.EJECUTIVA) {
            if (ocupadosEjecutiva < capacidadEjecutiva) { ocupadosEjecutiva++; return true; }
            return false;
        }
        if (clase == Clase.ECONOMICA) {
            if (ocupadosEconomica < capacidadEconomica) { ocupadosEconomica++; return true; }
            return false;
        }
        return false;
    }

    public boolean liberarAsiento(Clase clase) {
        if (clase == null) return false;
        if (clase == Clase.EJECUTIVA && ocupadosEjecutiva > 0) { ocupadosEjecutiva--; return true; }
        if (clase == Clase.ECONOMICA && ocupadosEconomica > 0) { ocupadosEconomica--; return true; }
        return false;
    }

    public int disponibles(Clase clase) {
        if (clase == null) return 0;
        if (clase == Clase.EJECUTIVA) return Math.max(0, capacidadEjecutiva - ocupadosEjecutiva);
        if (clase == Clase.ECONOMICA) return Math.max(0, capacidadEconomica - ocupadosEconomica);
        return 0;
    }

    @Override
    public String toString() {
        return "Avion {"
                + "Cap. Ejecutiva: " + capacidadEjecutiva
                + ", Disp. Ejecutiva: " + disponibles(Clase.EJECUTIVA)
                + ", Cap. Económica: " + capacidadEconomica
                + ", Disp. Económica: " + disponibles(Clase.ECONOMICA)
                + "}";
    }
}
