/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class VentanaCompatibilidad extends JPanel {
    
    private PanelComboBoxCompatibilidadPlaca comBoxCompPlaca;
    private PanelComboBoxCompatibilidadProcesador comBoxCompProc;
    
    public VentanaCompatibilidad(){
        initComponent();
    }
    
    private void initComponent(){
        BoxLayout dist = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(dist);
        
        this.add(Box.createVerticalGlue());
        
        this.comBoxCompPlaca = new PanelComboBoxCompatibilidadPlaca();
        this.add(comBoxCompPlaca);
        
        this.comBoxCompProc = new PanelComboBoxCompatibilidadProcesador();
        this.add(comBoxCompProc);
    }
    
}
