/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Lenovo X1
 */
public class Gestor {
    



public class GestorArchivosTxt {

  
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
            bw.write(contenido);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

   
    public boolean agregarLinea(String ruta, String linea) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
            bw.write(linea);
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
}

}
