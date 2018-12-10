/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Pieza;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        initComponents();
        tabla.addMouseListener(new MouseAdapter(){
        public void mousePressed(MouseEvent Mouse_evt){
            
            JTable table = (JTable) Mouse_evt.getSource();
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            if (Mouse_evt.getClickCount()== 1) {
                modelo.setText(tabla.getValueAt(tabla.getSelectedRow(),0),toString());
                piezas.setText(tabla.getValueAt(tabla.getSelectedRow(),0),toString());
                
            }
            
          
    
    
  
        
        
        }
        
        }
    }
    
    /*
    public boolean agregarPieza(Pieza pieza){
        return this.piezas.add(pieza);
    }
    */

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
