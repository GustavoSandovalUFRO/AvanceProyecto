/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author kamik
 */

public class PanelBotonesInicial extends JPanel{
    private JButton botonCompatibilidad;
    private JButton botonVoltaje;

    public PanelBotonesInicial() {
        initComponent();
    }
    private void initComponent(){
        BorderLayout dis = new BorderLayout();
        this.setLayout(dis);

        this.botonCompatibilidad = new JButton("Aceptar");
        this.add(botonCompatibilidad, BorderLayout.EAST);

        this.botonVoltaje = new JButton("Salir");
        this.add(botonVoltaje, BorderLayout.WEST);
    }

    public JButton getBotonCompatibilidad() {
        return botonCompatibilidad;
    }

    public JButton getBotonVoltaje() {
        return botonVoltaje;
    }
    
    
}

