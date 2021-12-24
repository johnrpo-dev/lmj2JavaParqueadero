
package lmj2.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import lmj2.modelos.ConsultasTickets;
import lmj2.modelos.ConsultasUsuarios;
import lmj2.modelos.ConsultasVehiculos;
import lmj2.modelos.Ticket;
import lmj2.modelos.Usuarios;
import lmj2.modelos.Vehiculo;
import lmj2.vistas.VistaIngreso;


public class ControladorIngreso implements ActionListener {
    
    VistaIngreso vistaIngreso = new VistaIngreso();
    Usuarios usuario = new Usuarios();
    Vehiculo vehiculo = new Vehiculo();
    Ticket ticket = new Ticket();

    public ControladorIngreso(VistaIngreso vistaIngreso, Usuarios usuario, Vehiculo vehiculo, Ticket ticket) {
        
        this.vistaIngreso = vistaIngreso;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.ticket = ticket;
        
        vistaIngreso.btnRegistrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConsultasUsuarios consultasUsuarios = new ConsultasUsuarios();
        ConsultasVehiculos consultasVehiculos = new ConsultasVehiculos();
        ConsultasTickets consultasTickets = new ConsultasTickets();
        
        
        //registro placa
        ticket.setPlaca_vehiculo(vistaIngreso.cajaPlaca.getText());
        
        //registro de vehiculos
        vehiculo.setPlaca(vistaIngreso.cajaPlaca.getText());
        vehiculo.setMarca(vistaIngreso.cajaMarca.getText());
        
        //registro de usuario
        usuario.setCedula(Integer.parseInt(vistaIngreso.cajaCedula.getText()));
        usuario.setNombres(vistaIngreso.cajaNombreU.getText());
        usuario.setFijo(vistaIngreso.cajaFijo.getText());
        usuario.setMovil(vistaIngreso.cajaCel.getText());
        
        
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada = formato.format(entrada);
        
        ticket.setIngreso(fechaEntrada);
        
        vehiculo.setCc_usuario(Integer.parseInt(vistaIngreso.cajaCedula.getText()));
        
        
        if(consultasUsuarios.insertarUsuario(usuario)&&
            consultasVehiculos.insertarVehiculo(vehiculo)&&
            consultasTickets.insertarTicket(ticket)){
            
            JOptionPane.showMessageDialog(null, "Exito agregando los datos");
            
        }else{
            
            JOptionPane.showMessageDialog(null, "Error agregando los datos");
        }
        
    }
    
    
    
}
