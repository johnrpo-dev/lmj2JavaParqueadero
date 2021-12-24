
package lmj2.modelos;

import java.sql.Connection;
import java.sql.DriverManager;


public class ModeloDB {
    
    private String servidorDB = "jdbc:mysql://localhost/lmj2prueba";
    private String usuarioDB = "root";
    private String passwordDB = "";

    public ModeloDB() {
    }
    
    public Connection conectar(){
        
        Connection conexion = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(servidorDB, usuarioDB, passwordDB);
            System.out.println("Exito conectado con MySQL");
            return conexion;
        }catch(Exception err){
            System.out.println("Upssss... " + err);
            return null;
        }
    }
    
}
