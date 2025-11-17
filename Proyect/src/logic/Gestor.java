package logic;

import domain.Factura;
import domain.Tiquete;
import domain.Reservacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Gestor {

    private static final String BASE_DIR = "data";
    private static final String DIR_TIQUETES = BASE_DIR + File.separator + "tiquetes";
    private static final String DIR_FACTURAS = BASE_DIR + File.separator + "facturas";

    public Gestor() {
        asegurarDirectorios();
    }

    private void asegurarDirectorios() {
        new File(DIR_TIQUETES).mkdirs();
        new File(DIR_FACTURAS).mkdirs();
    }

    public boolean crearArchivo(String ruta) {
        try {
            File f = new File(ruta);
            if (!f.exists()) {
                return f.createNewFile();
            }
            return true; 
        } catch (IOException e) {
            return false;
        }
    }

    public boolean escribirArchivo(String ruta, String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write(contenido != null ? contenido : "");
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean agregarLinea(String ruta, String linea) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
            bw.write(linea != null ? linea : "");
            bw.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public String leerArchivo(String ruta) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append("\n");
            }
        } catch (IOException e) {
            return "";
        }

        return sb.toString();
    }

    public boolean existe(String ruta) {
        File f = new File(ruta);
        return f.exists();
    }

    public boolean eliminarArchivo(String ruta) {
        File f = new File(ruta);
        return f.delete();
    }

    public boolean guardarTiquete(Tiquete tiquete) {
        if (tiquete == null) return false;

        asegurarDirectorios();

        int id = tiquete.getIdDocumento();
        String nombreArchivo = DIR_TIQUETES + File.separator + "tiquete_" + id + ".txt";

        String contenido = tiquete.mostrar();
        return escribirArchivo(nombreArchivo, contenido);
    }

    public boolean guardarFactura(Factura factura) {
        if (factura == null) return false;

        asegurarDirectorios();

        int id = factura.getIdDocumento();
        String nombreArchivo = DIR_FACTURAS + File.separator + "factura_" + id + ".txt";

        String contenido = factura.mostrar();
        return escribirArchivo(nombreArchivo, contenido);
    }

    public boolean guardarDocumentosReservacion(Reservacion r) {
        if (r == null) return false;

        boolean okTiquete = true;
        boolean okFactura = true;

        if (r.getMiTiquete() != null) {
            okTiquete = guardarTiquete(r.getMiTiquete());
        }

        if (r.getMiFactura() != null) {
            okFactura = guardarFactura(r.getMiFactura());
        }

        return okTiquete && okFactura;
    }

    public String leerTiquetePorId(int idDocumento) {
        String ruta = DIR_TIQUETES + File.separator + "tiquete_" + idDocumento + ".txt";
        if (!existe(ruta)) return "";
        return leerArchivo(ruta);
    }

    public String leerFacturaPorId(int idDocumento) {
        String ruta = DIR_FACTURAS + File.separator + "factura_" + idDocumento + ".txt";
        if (!existe(ruta)) return "";
        return leerArchivo(ruta);
    }
}
