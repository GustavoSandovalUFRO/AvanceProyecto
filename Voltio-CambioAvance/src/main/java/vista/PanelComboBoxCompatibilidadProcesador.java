/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelComboBoxCompatibilidadProcesador extends JPanel {
    private JComboBox<String> socket;
    
    public PanelComboBoxCompatibilidadProcesador() {
        initComponent();
    }
    
    private void initComponent(){
        FlowLayout dist = new FlowLayout();
        this.setLayout(dist);

        this.socket = new JComboBox<>();
        
        this.socket.addItem("Socket Procesador");
        this.socket.addItem("s1150");
        this.socket.addItem("s1151");
        this.socket.addItem("s2011");
        this.socket.addItem("s2066");
        this.socket.addItem("sAM3+");
        this.socket.addItem("sAM4");
        this.socket.addItem("sFM2");
        this.socket.addItem("sTR4");

        this.add(socket);

    }

}
  
   

