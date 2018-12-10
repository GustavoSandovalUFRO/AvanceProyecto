/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesDuales extends JPanel{
    public JButton botonLadoDerecho;
    public JButton botonLadoIzquierdo;

    public PanelBotonesDuales() {
        initComponent();
    }
    private void initComponent(){
        FlowLayout dis = new FlowLayout();
        dis.setHgap(10);
        this.setLayout(dis);

        this.botonLadoIzquierdo = new JButton();
        this.add(botonLadoIzquierdo, BorderLayout.WEST);
        
        this.botonLadoDerecho = new JButton();
        this.add(botonLadoDerecho, BorderLayout.EAST);

    }
    
}
