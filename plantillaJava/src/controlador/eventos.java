/**
 * @author Samuel Acosta Fernandez
 * @date 09/02/2022
 * @version 01
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import modelo.modelo;
import vista.vista;

public class eventos implements ActionListener, ItemListener, FocusListener{

	private modelo modelo;
	private vista vista;

    
    public eventos(vista vista){
        this.vista = vista;
        modelo = new modelo();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        /*
        if(source == vista.getBotonesPrincipal().get(0)) { 
        	
        }
        */
    }
    
	@Override
	public void itemStateChanged(ItemEvent e) {
		/*
    	if(e.getStateChange() == ItemEvent.SELECTED) {
    		if(this.vista.getComboBox().get(0).getSelectedItem().toString().equals(modelo.getTexto()[0])) {
    			
    		}
    	}
    	*/
	}

	@Override
	public void focusGained(FocusEvent e) {
		Object source = e.getSource();
		/*
        if(source == vista.getBotonesPrincipal().get(0)) { 
        	
        }
        */
	}

	@Override
	public void focusLost(FocusEvent e) {
		Object source = e.getSource();
		/*
        if(source == vista.getBotonesPrincipal().get(0)) { 
        	
        }
        */
	}
    

    
}
