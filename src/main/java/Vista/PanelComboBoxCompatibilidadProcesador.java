/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelComboBoxCompatibilidadProcesador {
     private JComboBox<String> Socket;
     private JCheckBox confirmacion;
     public JButton confirmar;
    
    public PanelComboBoxCompatibilidadProcesador() {
        initComponent();
}
    
     private void initComponent(){
        GridBagLayout dist = new GridBagLayout();
        this.setLayout(dist);
        GridBagConstraints cons = new GridBagConstraints();
        
        this.Socket.addItem(" ");this.Socket.addItem("s1150");this.Socket.addItem("s1151");
        this.Socket.addItem("s2011");this.Socket.addItem("s2066");this.Socket.addItem("sAM3");
        this.Socket.addItem("sAM4");this.Socket.addItem("sFM2");this.Socket.addItem("sTR4");
        cons.gridx=0;
        cons.gridy=0;
        cons.gridwidth = 1;
        cons.gridheight= 1;
        cons.weightx = 1.0;
        this.add(Socket, cons);
        
        this.confirmacion = new JCheckBox("Es correcto?");
        cons.gridx=0;
        cons.gridy=1;
        cons.gridwidth = 1;
        cons.gridheight= 1;
        cons.weightx = 1.0;
        this.add(confirmacion, cons);
     
}
     
    private void add(JComboBox<String> Socket, GridBagConstraints cons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void add(JCheckBox confirmacion, GridBagConstraints cons) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setLayout(GridBagLayout dist) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
  
   

