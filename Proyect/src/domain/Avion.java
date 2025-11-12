package domain;

public class Avion {
    
    private final int capacidadEjecutiva;
    private final int capacidadEconomica;
    private int ocupadosEjecutiva;
    private int ocupadosEconomica;
    
   public Avion(int capacidadEjecutiva, int capacidadEconomica){
   
   this.capacidadEjecutiva = Math.max(0, capacidadEjecutiva);
    this.capacidadEconomica = Math.max(0, capacidadEconomica);
    this.ocupadosEjecutiva = 0;
    this.ocupadosEconomica = 0;
   }

    public Avion(String airbus_A320, int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   public boolean hayEspacio(Clase clase){
   
   if (clase == null) return false;
   if(clase == Clase.EJECUTIVA){
       return ocupadosEjecutiva < capacidadEjecutiva;
   } else if (clase == Clase.ECONOMICA){
       return ocupadosEconomica < capacidadEconomica;
   }
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
   
   public int disponibles(Clase clase){
    if (clase == null) return 0;
    if (clase == Clase.EJECUTIVA)  return Math.max(0, capacidadEjecutiva - ocupadosEjecutiva);
    if (clase == Clase.ECONOMICA)  return Math.max(0, capacidadEconomica - ocupadosEconomica);
    return 0;
   }
   
   public boolean liberarAsiento(Clase clase) {
    if (clase == null) return false;
    if (clase == Clase.EJECUTIVA && ocupadosEjecutiva > 0) { 
        ocupadosEjecutiva--; return true; 
    }
    if (clase == Clase.ECONOMICA && ocupadosEconomica > 0) { 
        ocupadosEconomica--; return true; 
    }
    return false;
}
   
   
   @Override
   public String toString(){
       return "Avion {" +
               "Cap. Ejecutiva: " + capacidadEjecutiva +
               ", Disp. Ejecutiva: " + disponibles(Clase.EJECUTIVA) + 
               ", Cap. Económica: " + capacidadEconomica +
               ", Disp. Económica: " + disponibles(Clase.ECONOMICA) +
               "}";
   }
   
   public int getCapacidadEjecutiva(){return capacidadEjecutiva;}
   public int getCapacidadEconomica(){return capacidadEconomica;}
   public int getOcupadosEjecutiva(){return ocupadosEjecutiva;}
   public int getOcupadosEconomica(){return ocupadosEconomica;}
     
}