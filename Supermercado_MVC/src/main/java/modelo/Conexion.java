
package modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUNIOR VASQUEZ G
 */
public class Conexion {
    //Atributos para la conexión a la base de datos
    private String url = ""; //Base de datos a llamar
    public Connection con = null; //Objeto: Estado de la conexión
    private Statement stmt = null;
    private ResultSet rs = null;
    
    //Constructor
    public Conexion(){
        
        url = "jdbc:sqlite:databaseSupermercado.db";//ruta del archivo de bse de datos
        
        try {
            con = DriverManager.getConnection(url); //Obtener el estado de la conexión
            
            if(con != null){
                
                DatabaseMetaData meta = con.getMetaData(); //No está vacío, entonces, meta va a guardar los metadatos  
            }   
        }catch (SQLException error){
            System.out.println(error.getMessage());
        }  
    }
    
    //Metodo que retorna la conexión
    public Connection conectar(){
        return con;
    }
    
    //Método para cerrar la conexión
    public void cerrar(){
        if(con != null){
            try{
                con.close();
            } catch(SQLException error){
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, error);
            }
        }
    }
    
    public boolean ejecutar(String sentencia){
        try {
            stmt = con.createStatement();
            stmt.execute(sentencia);
            
        } catch (SQLException | RuntimeException error) {
            return false;
        }
        return true;
    }
    
    // Metodo que devuelve un ResultSet de una consulta (tratamiento de SELECT)
    public ResultSet consulta(String sentencia) {
        try {
            stmt= con.createStatement();
            rs= stmt.executeQuery(sentencia);
        } catch (SQLException sqlex) {
            System.out.println(sqlex.getMessage());
        } catch (RuntimeException rex) {
            System.out.println(rex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
}
