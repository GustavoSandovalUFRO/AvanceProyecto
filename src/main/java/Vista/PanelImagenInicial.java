/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelImagenInicial extends JPanel {
    
    private ImageIcon img;
    private JButton boton;
    private JLabel label;
    
    public PanelImagenInicial(){
     initComponent();
    }
     private void initComponent(){
        BorderLayout dist = new BorderLayout();
        this.setLayout(dist);
        this.label = new JLabel("   Bienvenido");
        label.setFont(new Font("comic sans", 100, 80));
        this.add(label, BorderLayout.NORTH);
    
    }
    
    
}
