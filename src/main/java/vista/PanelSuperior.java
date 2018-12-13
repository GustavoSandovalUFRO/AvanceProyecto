/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class PanelSuperior extends JPanel {

    private ImageIcon img;
    private JLabel label;
    
    public PanelSuperior() {
        initComponent();
    }
    
    public void initComponent(){
        FlowLayout dist = new FlowLayout();
        dist.setHgap(10);
        this.setLayout(dist);
        
        this.label = new JLabel("Voltio-Cambio");
        this.label.setFont(new Font("Helvetica Neue",Font.PLAIN,30));
        this.add(label);
        
    }
    
    
}
