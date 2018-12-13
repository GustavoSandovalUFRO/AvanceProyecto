/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Pieza;

/**
 *
 * @author User
 */
public class PanelCentralInferior extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private ArrayList<Pieza> piezas;
    
    public PanelCentralInferior() {
        initComponent();
    }

    private void initComponent() {
        this.piezas = new ArrayList<>();
        
        FlowLayout dist = new FlowLayout();
        this.setLayout(dist);
        
        //Agregar Modelo
        this.modelo = new DefaultTableModel();
        this.modelo.addColumn("Pieza");
        this.modelo.addColumn("Voltaje");
        this.modelo.addColumn("Socket");
        
        //Agregar Tabla
        this.tabla = new JTable(modelo);
        this.tabla.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(this.tabla);
        this.add(scroll);
    }
    
    public boolean agregarPieza(Pieza pieza){
        return this.piezas.add(pieza);
    }

    public JTable getTabla() {
        return tabla;
    }

    public ArrayList<Pieza> getPiezas() {
        return piezas;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }
    
}
