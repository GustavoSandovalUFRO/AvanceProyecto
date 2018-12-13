/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class PanelCentralSuperior extends JPanel {

    private JComboBox<String> pieza;
    private JTextField voltaje;
    private JButton ingPieza;
    private JButton elimSelecc;
    private JComboBox<String> socket;
    
    public PanelCentralSuperior() {
        initComponent();
    }

    private void initComponent() {
        FlowLayout dist = new FlowLayout();
        dist.setHgap(10);
        this.setLayout(dist);
        
        //JComboBox Pieza
        this.pieza = new JComboBox<>();
        this.pieza.addItem("Pieza");
        this.pieza.addItem("Placa Madre");
        this.pieza.addItem("Procesador");
        this.pieza.addItem("Tarjeta de Video");
        this.pieza.addItem("RAM");
        this.pieza.addItem("HDD");
        this.pieza.addItem("SSD");
        this.pieza.addItem("Fuente de Poder");

        this.add(pieza);
        
        //Ingreso Voltaje
        Label texto = new Label("Voltaje");
        this.add(texto);
        
        this.voltaje = new JTextField(6);
        this.add(voltaje);
        
        //JComboBox Socket
        this.socket = new JComboBox<>();
        this.socket.addItem("Socket");
        this.socket.addItem("s1150");
        this.socket.addItem("s1151");
        this.socket.addItem("s2011");
        this.socket.addItem("s2066");
        this.socket.addItem("sAM3+");
        this.socket.addItem("sAM4");
        this.socket.addItem("sFM2");
        this.socket.addItem("sTR4");

        this.add(socket);
        this.socket.setVisible(false);
        
        //Botones
        this.ingPieza = new JButton("Añadir");
        this.add(ingPieza);
        
        this.elimSelecc = new JButton("Eliminar Seleccionado");
        this.add(elimSelecc);
        
        
    }
    
    public JButton getIngPieza() {
        return ingPieza;
    }

    public JButton getElimSelecc() {
        return elimSelecc;
    }
    
    public String obtenerPieza(){
        return pieza.getSelectedItem()+"";
    }

    public String obtenerSocket(){
        return socket.getSelectedItem()+"";
    }

    public JComboBox<String> getSocket() {
        return socket;
    }

    public JComboBox<String> getPieza() {
        return pieza;
    }

    public JTextField getVoltaje() {
        return voltaje;
    }
    
}
