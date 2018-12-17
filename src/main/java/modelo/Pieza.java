/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Pieza {
    
    private TipoPieza tipoPieza;
    private double voltaje;
    private Socket socket;
    
    public Pieza(TipoPieza tipoPieza, double voltaje){
        this.tipoPieza = tipoPieza;
        this.voltaje = voltaje;
        this.socket = null;
    }
    
    public Pieza(TipoPieza tipoPieza, double voltaje, Socket socket){
        this.tipoPieza = tipoPieza;
        this.voltaje = voltaje;
        this.socket = socket;
    }

    public static boolean validarCompatibilidad(Socket socketPlacaMadre, Socket socketProcesador){
        return socketPlacaMadre == socketProcesador;
    }
    
    public TipoPieza getTipoPieza() {
        return tipoPieza;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public Socket getSocket() {
        return socket;
    }
    
    public static void calcularVoltaje(ArrayList<Pieza> piezas){
        
        double voltajeTotal = 0;
        double voltajeFuenteDePoder = 0;
        
        for (Pieza p : piezas){
            if (p.getTipoPieza().equals(TipoPieza.FuentePoder)){
                voltajeFuenteDePoder = p.getVoltaje();
            } else {
                voltajeTotal += p.getVoltaje();
            }
            
        }
        
        if (voltajeTotal >= voltajeFuenteDePoder*0.9 && voltajeTotal <= voltajeFuenteDePoder) {
            JOptionPane.showMessageDialog(null,
            "Se sugiere un cambio de fuente de poder por encontrarse cerca de su límite",
            "Cambio de Fuente",
            JOptionPane.WARNING_MESSAGE);
            
            
        } else if (voltajeTotal > voltajeFuenteDePoder) {
            JOptionPane.showMessageDialog(null,
            "Se debe cambiar la fuente de poder",
            "Voltaje Insuficiente",
            JOptionPane.ERROR_MESSAGE);
            
            
        } else if (voltajeTotal*0.9 < voltajeFuenteDePoder*0.9) {
            JOptionPane.showMessageDialog(null,
            "Voltaje correcto para el funcionamiento");
            
            
        }
    }
    
}
