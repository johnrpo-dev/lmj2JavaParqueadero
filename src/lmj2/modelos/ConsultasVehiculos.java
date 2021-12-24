package lmj2.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author johns
 */
public class ConsultasVehiculos extends ModeloDB {
    
    private PreparedStatement consultaSQL;
    private ResultSet resultadoSQL;

    public ConsultasVehiculos() {
    }
    
    public boolean insertarVehiculo (Vehiculo vehiculo){
        
        Connection conexion = conectar();
        
        String query = "INSERT INTO vehiculos (placa, marca, cc_usuario) "
                + "VALUES (?, ?, ?)";
        
        try{
            consultaSQL = conexion.prepareStatement(query);
            
            consultaSQL.setString(1, vehiculo.getPlaca());
            consultaSQL.setString(2, vehiculo.getMarca());
            consultaSQL.setInt(3, vehiculo.getCc_usuario());
            
            int resultado = consultaSQL.executeUpdate();
            
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
    
    public Vehiculo buscarVehiculo (String placa) {
        
        Vehiculo vehiculo = new Vehiculo();
        
        Connection conexion = conectar();
        
        String query = "SELECT * FROM vehiculos WHERE placa = ?";
        
        try{
            
            consultaSQL = conexion.prepareStatement(query);
            
            consultaSQL.setString(1, placa);
            
            resultadoSQL = consultaSQL.executeQuery();
            
            if( resultadoSQL.next() ){
                vehiculo.setPlaca(resultadoSQL.getString("placa"));
                vehiculo.setMarca(resultadoSQL.getString("marca"));
                vehiculo.setCc_usuario(resultadoSQL.getInt("cc_usuario"));
                
                return vehiculo;
                
            }else{
                return null;
            }
      
        }catch(Exception err){
            System.out.println("Error!" + err);
            return null;
        }
    }
}