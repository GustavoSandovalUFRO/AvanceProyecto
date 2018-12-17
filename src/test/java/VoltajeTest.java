/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import modelo.Pieza;
import modelo.Socket;
import modelo.TipoPieza;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class VoltajeTest {
    
    Pieza fuentePoder;
    Pieza tarjetaVideo;
    Pieza procesador;
    Pieza placaMadre;
    Pieza ram;
    
    ArrayList<Pieza> piezas;
    
    @Before
    public void setUp() {
        piezas = new ArrayList<>();
    }
    
    @Test
    public void voltajeInsuficiente(){
        fuentePoder = new Pieza(TipoPieza.FuentePoder, 350);
        tarjetaVideo = new Pieza(TipoPieza.TarjetaVideo, 150);
        procesador = new Pieza(TipoPieza.Procesador, 120);
        ram = new Pieza(TipoPieza.RAM, 2.5);
        placaMadre = new Pieza(TipoPieza.PlacaMadre, 80);
        
        piezas.add(fuentePoder);
        piezas.add(tarjetaVideo);
        piezas.add(procesador);
        piezas.add(placaMadre);
        piezas.add(ram);
        piezas.add(ram);
        piezas.add(ram);
        piezas.add(ram);
        
        Pieza.calcularVoltaje(piezas);
    }
    
    @Test
    public void socketsIncompatibles(){
        procesador = new Pieza(TipoPieza.Procesador, 120, Socket.s1150);
        placaMadre = new Pieza(TipoPieza.PlacaMadre, 80, Socket.s2011);

        boolean resultadoEsperado = false;
        boolean resultadoObtenido = Pieza.validarCompatibilidad(placaMadre.getSocket(), procesador.getSocket());
        
        Assert.assertEquals(resultadoEsperado, resultadoObtenido);
        
    }
    
    @Test
    public void voltajeCercanoLimite(){
        fuentePoder = new Pieza(TipoPieza.FuentePoder, 350);
        tarjetaVideo = new Pieza(TipoPieza.TarjetaVideo, 150);
        procesador = new Pieza(TipoPieza.Procesador, 120);
        ram = new Pieza(TipoPieza.RAM, 2.5);
        placaMadre = new Pieza(TipoPieza.PlacaMadre, 50);
        
        piezas.add(fuentePoder);
        piezas.add(tarjetaVideo);
        piezas.add(procesador);
        piezas.add(placaMadre);
        piezas.add(ram);
        piezas.add(ram);
        piezas.add(ram);
        piezas.add(ram);
        
        Pieza.calcularVoltaje(piezas);
    }
    
    @Test
    public void voltajeSuficiente(){
        fuentePoder = new Pieza(TipoPieza.FuentePoder, 650);
        tarjetaVideo = new Pieza(TipoPieza.TarjetaVideo, 150);
        procesador = new Pieza(TipoPieza.Procesador, 120);
        ram = new Pieza(TipoPieza.RAM, 2.5);
        placaMadre = new Pieza(TipoPieza.PlacaMadre, 80);
        
        piezas.add(fuentePoder);
        piezas.add(tarjetaVideo);
        piezas.add(procesador);
        piezas.add(placaMadre);
        piezas.add(ram);
        piezas.add(ram);
        piezas.add(ram);
        piezas.add(ram);
        
        Pieza.calcularVoltaje(piezas);
        
    }
    
    
}
