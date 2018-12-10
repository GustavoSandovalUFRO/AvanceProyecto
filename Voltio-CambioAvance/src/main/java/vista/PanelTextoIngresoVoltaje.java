/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelTextoIngresoVoltaje extends JPanel{
    
    private JTextField voltaje;
    
    public PanelTextoIngresoVoltaje(){
        initComponent();
    }
    
    private void initComponent(){
        FlowLayout dist = new FlowLayout();
        this.setLayout(dist);
        
        Label texto = new Label("Voltaje");
        this.add(texto);
        
        this.voltaje = new JTextField(10);
        this.add(voltaje);
    }
    
}
