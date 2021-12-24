/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmj2.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import lmj2.modelos.ConsultasTickets;
import lmj2.modelos.ConsultasUsuarios;
import lmj2.modelos.ConsultasVehiculos;
import lmj2.modelos.Ticket;
import lmj2.modelos.Usuarios;
import lmj2.modelos.Vehiculo;
import lmj2.vistas.VistaSalida;

/**
 *
 * @author johns
 */
public class ControladorSalida implements ActionListener {
    
    VistaSalida vistaSalida = new VistaSalida();
    Usuarios usuario = new Usuarios();
    Vehiculo vehiculo = new Vehiculo();
    Ticket ticket = new Ticket();

    public ControladorSalida(VistaSalida vistaSalida, Usuarios usuario, Vehiculo vehiculo, Ticket ticket) {
        
        this.vistaSalida = vistaSalida;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.ticket = ticket;
        
        vistaSalida.btnSalir.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConsultasVehiculos consultasVehiculos = new ConsultasVehiculos();
        ConsultasUsuarios consultasUsuarios = new ConsultasUsuarios();
        ConsultasTickets consultasTickets = new ConsultasTickets();
        
        ticket = consultasTickets.buscarTicket(Integer.parseInt(vistaSalida.cajaID.getText()));
        
        String fechaEntrada = ticket.getIngreso();
        
        try{
            
            Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada);
            
            Date salida = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaSalida = formato.format(salida);
            
            long tiempoEstadia = salida.getTime() - entrada.getTime();
            TimeUnit unidadTiempo = TimeUnit.MINUTES;
            long tiempodelVehiculo = unidadTiempo.convert(tiempoEstadia, TimeUnit.MILLISECONDS);
            
            ticket.setSalida(fechaSalida);
            
            long precioPagar = tiempodelVehiculo * 150;
            
            if(consultasTickets.actualizarTicket(ticket)){
                
                JOptionPane.showMessageDialog(null, "El precio a pagar es de: $" + precioPagar);
            }else{
                
                JOptionPane.showMessageDialog(null, "Error retirando");
            }
            
        }catch(ParseException err){
            
            System.out.println("Upsss... error" + err);
            
        }
    }
    
    
}
