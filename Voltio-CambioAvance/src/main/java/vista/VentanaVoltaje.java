/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class VentanaVoltaje extends JPanel {
    
    private PanelTablaVoltaje pnlVolt;
    private PanelTextoIngresoVoltaje pnlTxtIngVolt;
    private PanelBotonesVoltaje pnlBtnVolt;
    private PanelComboBoxSeleccionPieza pnlComBoxSlcPieza;
    
    public VentanaVoltaje(){
        initComponent();
    }
    
    private void initComponent(){
        BorderLayout dist = new BorderLayout();
        this.setLayout(dist);
        
        this.pnlVolt = new PanelTablaVoltaje();
        this.add(pnlVolt, BorderLayout.SOUTH);
        
        this.pnlTxtIngVolt = new PanelTextoIngresoVoltaje();
        this.add(pnlTxtIngVolt, BorderLayout.CENTER);
        
        this.pnlBtnVolt = new PanelBotonesVoltaje();
        this.add(pnlBtnVolt, BorderLayout.EAST);
        
        this.pnlComBoxSlcPieza = new PanelComboBoxSeleccionPieza();
        this.add(pnlComBoxSlcPieza, BorderLayout.NORTH);
    }
    
    public PanelBotonesVoltaje getPnlBtnVolt(){
        return this.pnlBtnVolt;
    }
}
