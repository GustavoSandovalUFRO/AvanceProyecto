/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Pieza;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelTablaVoltaje extends JPanel {
    
    private JTable tabla;
    private DefaultTableModel modelo;
    private ArrayList<Pieza> piezas;
    
    public PanelTablaVoltaje(){
        initComponent();
    }
    
    private void initComponent(){
        //this.piezas = new ArrayList<>();
        FlowLayout dist = new FlowLayout();
        this.setLayout(dist);
        
        //Agregar Modelo
        this.modelo = new DefaultTableModel();
        this.modelo.addColumn("Pieza");
        this.modelo.addColumn("Voltaje");
        
        //Agregar Tabla
        this.tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(this.tabla);
        this.add(scroll);
    }
    
    /*
    public boolean agregarPieza(Pieza pieza){
        return this.piezas.add(pieza);
    }
    */
}
