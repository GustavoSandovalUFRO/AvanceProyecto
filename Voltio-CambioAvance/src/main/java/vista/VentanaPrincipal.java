/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame implements ActionListener{
    private VentanaBienvenida ventBienv;
    private VentanaCompatibilidad ventComp;
    private VentanaVoltaje ventVolt;
    private PanelBotonesDuales pnlBtnDual;

    public VentanaPrincipal() {
        initComponent();
    }
    
    private void initComponent(){
        this.setSize(800, 600);
        this.setTitle("Voltio-Cambio");
        
        this.ventBienv = new VentanaBienvenida();
        this.ventComp = new VentanaCompatibilidad();
        this.ventVolt = new VentanaVoltaje();
        
        this.pnlBtnDual = new PanelBotonesDuales();
        
        this.pnlBtnDual.botonLadoDerecho.addActionListener(this);
        this.pnlBtnDual.botonLadoDerecho.setText("Verificar Compatibilidad");
        this.pnlBtnDual.botonLadoIzquierdo.addActionListener(this);
        this.pnlBtnDual.botonLadoIzquierdo.setText("Verificar Voltaje");
        
        this.getContentPane().add(ventBienv, BorderLayout.CENTER);
        this.getContentPane().add(pnlBtnDual, BorderLayout.SOUTH);
        
        this.ventVolt.getPnlBtnVolt().getIngVoltaje().addActionListener(this);
        this.ventVolt.getPnlBtnVolt().getIngVoltaje().addActionListener(this);
        
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pnlBtnDual.botonLadoDerecho && "Verificar Compatibilidad".equals(pnlBtnDual.botonLadoDerecho.getText())){
            this.getContentPane().remove(ventBienv);
            this.getContentPane().add(ventComp);
            this.revalidate();
            this.repaint();
            this.pnlBtnDual.botonLadoDerecho.setText("Aceptar");
            this.pnlBtnDual.botonLadoIzquierdo.setText("Atras");
        } else if (e.getSource() == pnlBtnDual.botonLadoIzquierdo && "Verificar Voltaje".equals(pnlBtnDual.botonLadoIzquierdo.getText())){
            this.getContentPane().remove(ventBienv);
            this.getContentPane().add(ventVolt);
            this.revalidate();
            this.repaint();
            this.pnlBtnDual.botonLadoDerecho.setText("Atras");
            this.pnlBtnDual.botonLadoIzquierdo.setText("Aceptar");
        } else if (e.getSource() == pnlBtnDual.botonLadoDerecho && "Aceptar".equals(pnlBtnDual.botonLadoDerecho.getText())){
            
            this.revalidate();
        } else if (e.getSource() == pnlBtnDual.botonLadoIzquierdo && "Atras".equals(pnlBtnDual.botonLadoIzquierdo.getText())){
            this.getContentPane().remove(ventComp);
            this.getContentPane().add(ventBienv);
            this.revalidate();
            this.repaint();
            this.pnlBtnDual.botonLadoDerecho.setText("Verificar Compatibilidad");
            this.pnlBtnDual.botonLadoIzquierdo.setText("Verificar Voltaje");
        } else if (e.getSource() == pnlBtnDual.botonLadoDerecho && "Atras".equals(pnlBtnDual.botonLadoDerecho.getText())){
            this.getContentPane().remove(ventVolt);
            this.getContentPane().add(ventBienv);
            this.revalidate();
            this.repaint();
            this.pnlBtnDual.botonLadoDerecho.setText("Verificar Compatibilidad");
            this.pnlBtnDual.botonLadoIzquierdo.setText("Verificar Voltaje");            
        } else if (e.getSource() == pnlBtnDual.botonLadoIzquierdo && "Aceptar".equals(pnlBtnDual.botonLadoIzquierdo.getText())){
            
            this.revalidate();
        }
    }
}