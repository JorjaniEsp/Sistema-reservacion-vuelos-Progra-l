package domain;

public abstract class Documento {

    int idDocumento;
    String fechaEmision;


    public Documento() {
    }

    public Documento(int idDocumento, String fechaEmision) {
        this.idDocumento = idDocumento;
        this.fechaEmision = fechaEmision;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public abstract String mostrar();

    @Override
    public String toString() {
        return "Documento#" + idDocumento + " [emitido=" + fechaEmision + "]";
    }
    
}
