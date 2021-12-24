
package lmj2;

import lmj2.controladores.ControladorHome;
import lmj2.modelos.Ticket;
import lmj2.modelos.Usuarios;
import lmj2.modelos.Vehiculo;

import lmj2.vistas.VistaHome;


public class Lmj2 {

  
    public static void main(String[] args) {
        
        VistaHome vistaHome = new VistaHome();
        vistaHome.setVisible(true);
        Usuarios usuario = new Usuarios();
        Vehiculo vehiculo = new Vehiculo();
        Ticket ticket = new Ticket();
        
        ControladorHome controladorHome = new ControladorHome(vistaHome, usuario, vehiculo, ticket);
        
    }
    
}
