/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class VentanaBienvenida extends JPanel{
    
    private PanelImagenInicial panelImagen;
    
    public VentanaBienvenida(){
        initComponent();
    }
    
    private void initComponent(){
        BorderLayout dist = new BorderLayout();
        this.setLayout(dist);
        
        
        
        this.panelImagen = new PanelImagenInicial();
        this.add(panelImagen, BorderLayout.CENTER);
    }
    
}
