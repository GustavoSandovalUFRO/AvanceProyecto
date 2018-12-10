/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;


public class PanelBotonesVoltaje extends JPanel {
    
    private JButton ingVoltaje;
    private JButton elimSelecc;
    
    public PanelBotonesVoltaje(){
        initComponent();
    }
    
    private void initComponent(){
        BoxLayout dist = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(dist);
        
        this.ingVoltaje = new JButton("Aceptar");
        this.add(ingVoltaje);
        
        
        this.elimSelecc = new JButton("Eliminar Seleccion");
        this.add(elimSelecc);
        
    }

    public JButton getIngVoltaje() {
        return ingVoltaje;
    }

    public JButton getElimSelecc() {
        return elimSelecc;
    }
    
    
}
