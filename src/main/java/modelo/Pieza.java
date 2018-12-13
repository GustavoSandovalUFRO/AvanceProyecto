/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


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

    public boolean validarCompatibilidad(){
        return false;
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
    
    
}
