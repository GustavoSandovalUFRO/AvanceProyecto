/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import accesodatos.ArchivoJson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
                
            } else if (((pnlPrncpl.getPnlCntrlSpr().obtenerPieza().equals("Placa Madre")) ||
                    (pnlPrncpl.getPnlCntrlSpr().obtenerPieza().equals("Procesador"))) &&
                    (pnlPrncpl.getPnlCntrlSpr().obtenerSocket().equals("Socket"))) {
                
                    JOptionPane.showMessageDialog(null, "Debe especificar el socket", "Advertencia de Socket", JOptionPane.WARNING_MESSAGE);
                
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
            
            if (this.pnlPrncpl.getPnlCntrlIfr().getPiezas().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                "Debe añadir sus componentes para realizar esta acción",
                "Sin Piezas",
                JOptionPane.ERROR_MESSAGE);
                
            } else {
                
                List<TipoPieza> busquedaTipoPieza = new ArrayList<>();
                this.pnlPrncpl.getPnlCntrlIfr().getPiezas().forEach((p) -> {
                    busquedaTipoPieza.add(p.getTipoPieza());
                });
                
                if (!busquedaTipoPieza.contains(TipoPieza.PlacaMadre)) {
                    JOptionPane.showMessageDialog(null,
                    "En sus componentes debe incluir una placa madre",
                    "Advertencia de Placa Madre",
                    JOptionPane.WARNING_MESSAGE);
                    
                } else if (!busquedaTipoPieza.contains(TipoPieza.Procesador)){
                    JOptionPane.showMessageDialog(null,
                    "En sus componentes debe incluir un procesador",
                    "Advertencia de Procesador",
                    JOptionPane.WARNING_MESSAGE);
                    
                } else if (!busquedaTipoPieza.contains(TipoPieza.FuentePoder)) {  
                    JOptionPane.showMessageDialog(null,
                    "En sus componentes debe incluir una fuente de poder",
                    "Advertencia de Fuente de Poder",
                    JOptionPane.WARNING_MESSAGE);
                    
                } else {
                    Socket socketPlacaMadre = null;
                    Socket socketProcesador = null;
                    
                    for (Pieza p : this.pnlPrncpl.getPnlCntrlIfr().getPiezas()){
                        if (p.getTipoPieza().equals(TipoPieza.PlacaMadre)) {
                            socketPlacaMadre = p.getSocket();
                            
                        } else if (p.getTipoPieza().equals(TipoPieza.Procesador)) {
                            socketProcesador = p.getSocket();
                            
                        }
                        
                    }
                    
                    if (Pieza.validarCompatibilidad(socketPlacaMadre, socketProcesador)) {
                        Pieza.calcularVoltaje(pnlPrncpl.getPnlCntrlIfr().getPiezas());
                        
                    } else {
                        JOptionPane.showMessageDialog(null,
                        "Su Placa Madre no es compatible con su Procesador",
                        "Incompatibilidad Detectada",
                        JOptionPane.ERROR_MESSAGE);
                        
                    }  
                }
            }
            
            
        } else if (e.getSource() == pnlPrncpl.getPnlIfr().getGuardarLista()){
            System.out.println("Guardar Lista");
            
            ArchivoJson.almacenarObjetos(pnlPrncpl.getPnlCntrlIfr().getPiezas(), ArchivoJson.nombrarArchivo());
            
        } else if (e.getSource() == pnlPrncpl.getPnlIfr().getCargarLista()){
            System.out.println("Cargar Lista");
            
            ArchivoJson.recuperarObjetos(ArchivoJson.buscarObjeto());
            
            int filas = this.pnlPrncpl.getPnlCntrlIfr().getModelo().getRowCount();
            for (int i = filas - 1; i >= 0; i--) {
                this.pnlPrncpl.getPnlCntrlIfr().getModelo().removeRow(i);
            }
            
        } else if (e.getSource() == pnlPrncpl.getPnlIfr().getLimpiarLista()){
            System.out.println("Limpiar Tabla");
            
            int filas = this.pnlPrncpl.getPnlCntrlIfr().getModelo().getRowCount();
            for (int i = filas - 1; i >= 0; i--) {
                this.pnlPrncpl.getPnlCntrlIfr().getModelo().removeRow(i);
            }
            
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