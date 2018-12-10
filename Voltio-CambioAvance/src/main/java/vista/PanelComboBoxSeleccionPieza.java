/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelComboBoxSeleccionPieza extends JPanel{
    private JComboBox<String> Pieza;

    public PanelComboBoxSeleccionPieza() {
        initComponent();
    }

    private void initComponent(){
        FlowLayout dist = new FlowLayout();
        this.setLayout(dist);

        this.Pieza = new JComboBox<>();
        this.Pieza.addItem("Tipo de Pieza");
        this.Pieza.addItem("Placa Madre");
        this.Pieza.addItem("Procesador");
        this.Pieza.addItem("Tarjeta De Video");
        this.Pieza.addItem("RAM");
        this.Pieza.addItem("HDD");
        this.Pieza.addItem("SSD");
        this.Pieza.addItem("Fuente de Poder");

        this.add(Pieza);
        
    }
    public String obtenerPieza(){
        return Pieza.getSelectedItem()+"";
    }
}

