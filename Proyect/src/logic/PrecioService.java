/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Vuelo;
import domain.Clase;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author josse
 */
public class PrecioService {
   
    private static final double RECARGO_EJECUTIVA = 150.00;
    private static final double RECARGO_ECONOMICA = 0.00;
    private static final double TASA_FIJA = 25.00;
    private static final double IMPUESTO = 0.13;
    
    public double calcularCosto(Vuelo vuelo, Clase clase){
        
        double costoBase = vuelo.getCostoBase();
        
        double recargoClase = (clase == Clase.EJECUTIVA) ? RECARGO_EJECUTIVA: RECARGO_ECONOMICA;
        
        double subtotal = costoBase + recargoClase + TASA_FIJA;
        
        double montoImpuesto = subtotal * IMPUESTO;
        
        double costoTotal = subtotal + montoImpuesto;
        
        BigDecimal bd = new BigDecimal(costoTotal).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    
}
