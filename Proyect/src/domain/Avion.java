package domain;

public class Avion {
    
    public int capacidadEjecutiva;
    public int capacidadEconomica;
    public int ocupadosEjecutiva;
    public int ocupadosEconomica;
    
   public Avion(int capacidadEjecutiva, int capacidadEconomica){
   
   this.capacidadEjecutiva = capacidadEjecutiva;
   this.capacidadEconomica = capacidadEconomica;
   this.ocupadosEjecutiva = 0;
   this.ocupadosEconomica = 0;
   }

    public Avion(String airbus_A320, int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   
   public boolean hayEspacio(Clase clase){
   
   if(clase == Clase.EJECUTIVA){
       return ocupadosEjecutiva < capacidadEjecutiva;
   } else if (clase == Clase.ECONOMICA){
       return ocupadosEconomica < capacidadEconomica;
   }
   return false;
   }
   
   public void ocuparAsiento(Clase clase){
       
       if(hayEspacio(clase)){
           if(clase == Clase.EJECUTIVA){
               ocupadosEjecutiva++;
           }else if (clase == Clase.ECONOMICA){
               ocupadosEconomica++;
           }
           System.out.println("Asientos ocupado en " + clase + ".");
       }else{
           System.out.println("No hay espacio disponible en " + clase + ".");
       }
   }
   
   public int disponibles (Clase clase){
       
       if (clase == Clase.EJECUTIVA){
           return capacidadEjecutiva - ocupadosEjecutiva;
       }else if (clase == Clase.ECONOMICA){
           return capacidadEconomica - ocupadosEconomica;
       }
       return 0;
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
