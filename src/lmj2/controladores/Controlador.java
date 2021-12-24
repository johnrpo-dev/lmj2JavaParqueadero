
package lmj2.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lmj2.modelos.ModeloDB;
import lmj2.vistas.Vista;


public class Controlador implements ActionListener { //importar clase y todos los metodos
    
    ModeloDB modelo = new ModeloDB();
    Vista vista = new Vista();

    public Controlador(ModeloDB modelo, Vista vista) {
        
        this.modelo = modelo;
        this.vista = vista;
        vista.boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.conectar();
    }
    
    
}
