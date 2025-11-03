package domain;


public class Tiquete {
    
    private Reservacion reservacion;
    
    public Tiquete(Reservacion reservacion){
        this.reservacion = reservacion;
    }
    
    public String mostrar(){
        return this.toString();
    }
    @Override
    public String toString(){
    return "=======================\n" +
           "     TIQUETE EMITIDO   \n" +
           "=======================\n" +
           "Detalles de la Reservación: \n" +
            reservacion.toString() + "\n" +
           "------------------------------------\n" +
           "Gracias por su compra\n" +
           "============================";
    }
    
    public Reservacion getReservacion(){
        return reservacion;
    }
    
}
