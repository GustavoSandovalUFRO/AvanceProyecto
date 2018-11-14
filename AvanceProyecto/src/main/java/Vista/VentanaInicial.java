/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class VentanaInicial extends JFrame implements ActionListener{
    private PanelImagenInicial panelmagen;
    private PanelBotonesInicial panelBotones;

    public VentanaInicial() {
        initComponent();
    }
    
    private void initComponent(){
        BorderLayout dist = new BorderLayout();
        this.setLayout(dist);
        this.setSize(600, 300);
        this.setTitle("Voltio-Cambio");
        
        this.panelmagen = new PanelImagenInicial();
        this.add(panelmagen, BorderLayout.NORTH);
        
        this.panelBotones = new PanelBotonesInicial();
        this.add(panelBotones, BorderLayout.SOUTH);
        this.panelBotones.getBotonCompatibilidad().addActionListener(this);
        this.panelBotones.getBotonVoltaje().addActionListener(this);
                
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelBotones.getBotonCompatibilidad()){
            VentanaCompatibilidad compatibilidad = new VentanaCompatibilidad();
            this.dispose();
        }else if (e.getSource() == this.panelBotones.getBotonVoltaje()){
            VentanaVoltaje voltaje = new VentanaVoltaje();
            this.dispose();
        }
    }
}