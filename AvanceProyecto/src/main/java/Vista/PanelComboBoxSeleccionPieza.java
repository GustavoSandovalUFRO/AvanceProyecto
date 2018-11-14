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

public class PanelComboBoxSeleccionPieza extends JPanel{
    private JComboBox<String> Pieza;
    private JCheckBox confirmacion;
    public JButton confirmar;

    public PanelComboBoxSeleccionPieza() {
            initComponent();
    }

    private void initComponent(){
       GridBagLayout dist = new GridBagLayout();
       this.setLayout(dist);
       GridBagConstraints cons = new GridBagConstraints();

       this.Pieza = new JComboBox<>();
       this.Pieza.addItem(" ");
       this.Pieza.addItem("Placa Madre");
       this.Pieza.addItem("Procesador");
       this.Pieza.addItem("Tarjeta De Video");
       this.Pieza.addItem("Ram");
       this.Pieza.addItem("SSD");
       this.Pieza.addItem("HDD");

       cons.gridx=0;
       cons.gridy=0;
       cons.gridwidth = 1;
       cons.gridheight= 1;
       cons.weightx = 1.0;
       this.add(Pieza, cons);

       this.confirmacion = new JCheckBox("Es correcto?");
       cons.gridx=0;
       cons.gridy=1;
       cons.gridwidth = 1;
       cons.gridheight= 1;
       cons.weightx = 1.0;
       this.add(confirmacion, cons);
     
        
    }
    public String obtenerPieza(){
       return Pieza.getSelectedItem()+"";
    }
}

