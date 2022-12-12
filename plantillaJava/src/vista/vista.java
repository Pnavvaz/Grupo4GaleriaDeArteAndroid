/**
 * @author Samuel Acosta Fernandez
 * @date 09/02/2022
 * @version 01
 */
package vista;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import modelo.modelo;

public class vista extends JFrame{
    
    private modelo modelo;
    private ArrayList<JPanel> paneles = new ArrayList<JPanel>();

    public vista(){
    	modelo = new modelo();
        propiedadesVentana();
    }
    
    /*
     * Configuración de Ventana Principal
     */
    private void propiedadesVentana() {
        this.setTitle(modelo.getTextoVentanaPrincipal()[0]);
        this.setLayout(new BorderLayout());
        this.setSize(520, 300);
        this.requestFocus();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(100, 100);
    }
    
    private void ordenarPaneles(){
    	/*
        this.add(panelesPrincipal.get(0), BorderLayout.NORTH);
        this.add(panelesPrincipal.get(1), BorderLayout.CENTER);
        */
    }
    
    public void mostrarVentana() {
    	this.setVisible(true);
    }
    
    public void crearPaneles(int i){
        paneles.add(new JPanel());
        paneles.get(i).setLayout(new FlowLayout(FlowLayout.RIGHT));
        paneles.get(i).setBackground(Color.WHITE);
        paneles.get(i).setVisible(true);
        this.add(paneles.get(i));
    }
    
    public ArrayList<JPanel> getPaneles(){
        return paneles;
    }
    
}
