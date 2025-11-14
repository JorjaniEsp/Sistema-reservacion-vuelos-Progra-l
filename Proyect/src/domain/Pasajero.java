
package domain;

public class Pasajero {
    
    private int cedula;
    private String nombre;
    private String numero;
    private String correo;
    private String pasaporte;

    public Pasajero() {
    }

    public Pasajero(int cedula, String nombre, String numero, String correo, String pasaporte) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.numero = numero;
        this.correo = correo;
        this.pasaporte = pasaporte;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    @Override
    public String toString() {
        return "---Información del pasajero---" +
                "Cedula: " + cedula +
                "Nombre: " + nombre +
                "Numero: " + numero +
                "Correo: " + correo +
                "Pasaporte: " + pasaporte;
    }
    
    

    
    
    
    
}
