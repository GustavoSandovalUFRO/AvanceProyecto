/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class PanelPrincipal extends JPanel {

    private PanelSuperior pnlSpr;
    private PanelCentralSuperior pnlCntrlSpr;
    private PanelCentralInferior pnlCntrlIfr;
    private PanelInferior pnlIfr;
    
    public PanelPrincipal() {
        initComponent();
    }
    
    private void initComponent(){
        BoxLayout dist = new BoxLayout(this, BoxLayout.Y_AXIS);
        
        this.pnlSpr = new PanelSuperior();
        this.add(pnlSpr, dist);
        
        this.pnlCntrlSpr = new PanelCentralSuperior();
        this.add(pnlCntrlSpr, dist);
        
        this.pnlCntrlIfr = new PanelCentralInferior();
        this.pnlCntrlIfr.setPreferredSize(new Dimension(460, 400));
        this.add(pnlCntrlIfr, dist);
//        System.out.println(this.pnlCntrlIfr.getPreferredSize());
        
        this.pnlIfr = new PanelInferior();
        this.add(pnlIfr, dist);
        
    }

    public PanelCentralSuperior getPnlCntrlSpr() {
        return pnlCntrlSpr;
    }

    public PanelCentralInferior getPnlCntrlIfr() {
        return pnlCntrlIfr;
    }

    public PanelInferior getPnlIfr() {
        return pnlIfr;
    }    
    
}
