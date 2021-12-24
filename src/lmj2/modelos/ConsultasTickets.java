
package lmj2.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConsultasTickets extends ModeloDB {
    
    private PreparedStatement consultaSQL;
    private ResultSet resultadoSQL;

    public ConsultasTickets() {
    }
    
    public boolean insertarTicket(Ticket ticket){
        
        Connection conexion = conectar();
        
        String query = "INSERT INTO tickets(id, placa_vehiculo, ingreso, salida) "
                + "VALUES (?, ?, ?, ?)";
        
        
        try{
            
            consultaSQL = conexion.prepareStatement(query);
            
            consultaSQL.setInt(1, ticket.getId());
            consultaSQL.setString(2, ticket.getPlaca_vehiculo());
            consultaSQL.setString(3, ticket.getIngreso());
            consultaSQL.setString(4, ticket.getSalida());
            
            
            int resultado = consultaSQL.executeUpdate();
            
            //validar el resultado
            if(resultado > 0 ){
                return true;
            }else{
                return false;
            }
        }catch(Exception err){
            
            System.out.println("Error" + err);
            return false;
        }
    }
    
    public Ticket buscarTicket (int id){
        
        Connection conexion = conectar();        
        String query = "SELECT * FROM tickets WHERE id = ?";
        
        try{
            
            consultaSQL = conexion.prepareStatement(query);
            
            consultaSQL.setInt(1, id);
            
            resultadoSQL = consultaSQL.executeQuery();
            
            Ticket ticket = new Ticket();
            if(resultadoSQL.next()){
                
                ticket.setId(resultadoSQL.getInt("id"));
                ticket.setPlaca_vehiculo(resultadoSQL.getString("placa_vehiculo"));
                ticket.setIngreso(resultadoSQL.getString("ingreso"));
                ticket.setSalida(resultadoSQL.getString("salida"));
                
                return ticket;
                
            }else{
                
                return null;
            }
            
        }catch(Exception err){
            
            System.out.println("Error" + err);
            return null;
        }
    }
    
    public boolean actualizarTicket(Ticket ticket){
        
        Connection conexion = conectar();
        String query = "UPDATE tickets SET salida = ? WHERE id = ?";
        
        try{
            
            consultaSQL = conexion.prepareStatement(query);
            
            consultaSQL.setString(1, ticket.getSalida());
            consultaSQL.setInt(2, ticket.getId());
            
            int resultado = consultaSQL.executeUpdate();
            
            //validar el resultado
            if(resultado > 0 ){
                return true;
            }else{
                return false;
            }
        }catch(Exception err){
            
            System.out.println("Error" + err);
            return false;
        }
        
    }
    
}
