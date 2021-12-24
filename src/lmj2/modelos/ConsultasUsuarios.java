
package lmj2.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConsultasUsuarios extends ModeloDB {
    
        private PreparedStatement consultaSQL;
        private ResultSet resultadoSQL;

    public ConsultasUsuarios() {
    }
        
        
    public boolean insertarUsuario (Usuarios usuario){
        
        //conexion DB
        Connection conexion = conectar();
        
        //armar consulta sql
        String query = "INSERT INTO usuarios(cedula, nombres, fijo, movil) "
                + "VALUES (?, ?, ?, ?)";
        
        //ejecutar la consulta
        try{
            //preparar consulta en la DB
            consultaSQL = conexion.prepareStatement(query);
            
            //organizar los datos que estan en ---> ????
            consultaSQL.setInt(1, usuario.getCedula());
            consultaSQL.setString(2, usuario.getNombres());
            consultaSQL.setString(3, usuario.getFijo());
            consultaSQL.setString(4, usuario.getMovil());
            
            //ejecutar la consulta preparada
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
    
    public Usuarios buscarUsuario(int cedula){
        
        //crear objeto de tipo usuario
        Usuarios usuario = new Usuarios();
        
        //almacenar en la DB
        Connection conexion = conectar();
        
        //queery de SQL
        String query = "SELECT * FROM usuarios WHERE cedula = ?";
        
        try{
             //preparar consulta en la DB
            consultaSQL = conexion.prepareStatement(query);
            
            //organizar datos a buscar
            consultaSQL.setInt(1, cedula);
            
            //ejecutar la consulta
            resultadoSQL = consultaSQL.executeQuery();
            
            //organizar los datos de entrada
            if(resultadoSQL.next()){
                
                usuario.setCedula(resultadoSQL.getInt("cedula"));
                usuario.setNombres(resultadoSQL.getString("nombres"));
                usuario.setFijo(resultadoSQL.getString("fijo"));
                usuario.setFijo(resultadoSQL.getString("movil"));
                return usuario;
                
            }else{
                
                return null;
            }
            
        }catch(Exception err){
            
            System.out.println("Error!" + err);
            return null;
        }
    }
    
    public boolean actualizarUsuario(Ticket ticket){
        
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
