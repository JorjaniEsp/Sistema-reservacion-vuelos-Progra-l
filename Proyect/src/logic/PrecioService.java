package logic;

import domain.Vuelo;
import domain.Clase;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class PrecioService {
   
    private static final double RECARGO_EJECUTIVA = 150.00;
    private static final double RECARGO_ECONOMICA = 0.00;
    private static final double TASA_FIJA = 25.00;
    private static final double IMPUESTO = 0.13;
    
     public double calcularCosto(Vuelo vuelo, Clase clase) {
        if (vuelo == null || clase == null) return 0.0;

        double costoBase = Math.max(0.0, vuelo.getCostoBase());
        double recargoClase = (clase == Clase.EJECUTIVA) ? RECARGO_EJECUTIVA : RECARGO_ECONOMICA;

        double subtotal = costoBase + recargoClase + TASA_FIJA;
        double montoImpuesto = subtotal * IMPUESTO;
        double total = subtotal + montoImpuesto;

        return new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
    
    
}
