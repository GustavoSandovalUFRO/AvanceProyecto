/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import accesodatos.ArchivoJson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Pieza;
import modelo.Socket;
import modelo.TipoPieza;

public class VentanaPrincipal extends JFrame implements ActionListener{
    private PanelPrincipal pnlPrncpl;

    public VentanaPrincipal() {
        initComponent();
    }
    
    private void initComponent(){
        this.setSize(800, 600);
        this.setTitle("Voltio-Cambio");

        this.pnlPrncpl = new PanelPrincipal();
        this.getContentPane().add(pnlPrncpl);
        
        this.pnlPrncpl.getPnlCntrlSpr().getIngPieza().addActionListener(this);
        this.pnlPrncpl.getPnlCntrlSpr().getElimSelecc().addActionListener(this);
        
        this.pnlPrncpl.getPnlIfr().getCalcularVolt().addActionListener(this);
        this.pnlPrncpl.getPnlIfr().getGuardarLista().addActionListener(this);
        this.pnlPrncpl.getPnlIfr().getCargarLista().addActionListener(this);
        this.pnlPrncpl.getPnlIfr().getLimpiarLista().addActionListener(this);

        this.pnlPrncpl.getPnlCntrlSpr().getPieza().addActionListener(this);
        
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pnlPrncpl.getPnlCntrlSpr().getIngPieza()){
            System.out.println("Añadir Pieza");
            
            if (pnlPrncpl.getPnlCntrlSpr().obtenerPieza().equals("Pieza")) {
                JOptionPane.showMessageDialog(null, "Debe especificar el tipo de Pieza", "Advertencia de Pieza", JOptionPane.WARNING_MESSAGE);
                
            } else if (pnlPrncpl.getPnlCntrlSpr().getVoltaje().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe especificar el Voltaje", "Advertencia de Voltaje", JOptionPane.WARNING_MESSAGE);
                
            } else if (pnlPrncpl.getPnlCntrlSpr().obtenerPieza().equals("Placa Madre") || pnlPrncpl.getPnlCntrlSpr().obtenerPieza().equals("Procesador")) {
                if (pnlPrncpl.getPnlCntrlSpr().obtenerSocket().equals("Socket")) {
                    JOptionPane.showMessageDialog(null, "Debe especificar el socket", "Advertencia de Socket", JOptionPane.WARNING_MESSAGE);
                }
                
            } else {
                
                TipoPieza tipo = null;
                switch (pnlPrncpl.getPnlCntrlSpr().obtenerPieza()) {
                    case "Placa Madre":
                        tipo = TipoPieza.PlacaMadre;
                        break;
                    case "Procesador":
                        tipo = TipoPieza.Procesador;
                        break;
                    case "Tarjeta de Video":
                        tipo = TipoPieza.TarjetaVideo;
                        break;
                    case "RAM":
                        tipo = TipoPieza.RAM;
                        break;
                    case "HDD":
                        tipo = TipoPieza.HDD;
                        break;
                    case "SDD":
                        tipo = TipoPieza.SDD;
                        break;
                    case "Fuente de Poder":
                        tipo = TipoPieza.FuentePoder;
                        break;
                    default:
                        break;
                }
                
                System.out.println(tipo);
                
                Object[] datosPieza;
                
                try {
                    
                    if (tipo == TipoPieza.PlacaMadre || tipo == TipoPieza.Procesador) {
                        
                        Socket socket = null;
                        switch (pnlPrncpl.getPnlCntrlSpr().obtenerSocket()){
                            case "s1150":
                                socket = Socket.s1150;
                                break;
                            case "s1151":
                                socket = Socket.s1151;
                                break;
                            case "s2011":
                                socket = Socket.s2011;
                                break;
                            case "s2066":
                                socket = Socket.s2066;
                                break;
                            case "sAM3+":
                                socket = Socket.sAM3;
                                break;
                            case "sAM4":
                                socket = Socket.sAM4;
                                break;
                            case "sFM2":
                                socket = Socket.sFM2;
                                break;
                            case "sTR$":
                                socket = Socket.sTR4;
                                break;
                            default:
                                break;
                        }
                        
                        pnlPrncpl.getPnlCntrlIfr().agregarPieza(new Pieza(tipo,Double.parseDouble(pnlPrncpl.getPnlCntrlSpr().getVoltaje().getText()), socket));
                        
                        datosPieza = new Object[]{pnlPrncpl.getPnlCntrlSpr().obtenerPieza(), pnlPrncpl.getPnlCntrlSpr().getVoltaje().getText(), pnlPrncpl.getPnlCntrlSpr().obtenerSocket()};
                        pnlPrncpl.getPnlCntrlIfr().getModelo().addRow(datosPieza);
                        
                    } else {
                        
                        pnlPrncpl.getPnlCntrlIfr().agregarPieza(new Pieza(tipo,Double.parseDouble(pnlPrncpl.getPnlCntrlSpr().getVoltaje().getText())));
                        
                        datosPieza = new Object[]{pnlPrncpl.getPnlCntrlSpr().obtenerPieza(), pnlPrncpl.getPnlCntrlSpr().getVoltaje().getText(), "No se aplica"};
                        pnlPrncpl.getPnlCntrlIfr().getModelo().addRow(datosPieza);
                        
                    }                    
                    
                    
                    
                } catch (NumberFormatException nfe){
                    
                    System.out.println(nfe.getMessage());
                    
                } catch (Exception ex) {
                    
                    System.out.println(ex.getMessage());
                    
                }
                
            }
            
        } else if (e.getSource() == pnlPrncpl.getPnlCntrlSpr().getElimSelecc()){
            System.out.println("Eliminar Selección");
            
            int seleccion = this.pnlPrncpl.getPnlCntrlIfr().getTabla().getSelectedRow();
            this.pnlPrncpl.getPnlCntrlIfr().getModelo().removeRow(seleccion);
            
        } else if (e.getSource() == pnlPrncpl.getPnlIfr().getCalcularVolt()){
            System.out.println("Calcular Voltaje");
            
        } else if (e.getSource() == pnlPrncpl.getPnlIfr().getGuardarLista()){
            System.out.println("Guardar Lista");
            
            ArchivoJson.almacenarObjetos(pnlPrncpl.getPnlCntrlIfr().getPiezas(), ArchivoJson.nombreArchivo());
            
        } else if (e.getSource() == pnlPrncpl.getPnlIfr().getCargarLista()){
            System.out.println("Cargar Lista");
            
        } else if (e.getSource() == pnlPrncpl.getPnlIfr().getLimpiarLista()){
            System.out.println("Limpiar Tabla");
            
            this.pnlPrncpl.getPnlCntrlIfr().getTabla().removeAll();
            
        } else if (e.getSource() == pnlPrncpl.getPnlCntrlSpr().getPieza()){
            
            //Ocultar/Mostrar Socket segun pieza
            if (pnlPrncpl.getPnlCntrlSpr().obtenerPieza().equals("Placa Madre") || pnlPrncpl.getPnlCntrlSpr().obtenerPieza().equals("Procesador")) {
                pnlPrncpl.getPnlCntrlSpr().getSocket().setVisible(true);
            } else {
                pnlPrncpl.getPnlCntrlSpr().getSocket().setVisible(false);
            }
        }
    }
}