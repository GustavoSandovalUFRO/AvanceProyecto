/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class PanelInferior extends JPanel {

    private JButton calcularVolt;
    private JButton guardarLista;
    private JButton cargarLista;
    private JButton limpiarLista;
    
    public PanelInferior() {
        initComponent();
    }

    private void initComponent() {
        FlowLayout dis = new FlowLayout();
        dis.setHgap(10);
        this.setLayout(dis);
        
        this.calcularVolt = new JButton("Calcular Voltaje");
        this.add(calcularVolt);
        
        this.guardarLista = new JButton("Guardar Lista");
        this.add(guardarLista);
        
        this.cargarLista = new JButton("Cargar Lista");
        this.add(cargarLista);
        
        this.limpiarLista = new JButton("Limpiar Lista");
        this.add(limpiarLista);
    }

    public JButton getCalcularVolt() {
        return calcularVolt;
    }

    public JButton getGuardarLista() {
        return guardarLista;
    }

    public JButton getCargarLista() {
        return cargarLista;
    }

    public JButton getLimpiarLista() {
        return limpiarLista;
    }
    
    
    
}
