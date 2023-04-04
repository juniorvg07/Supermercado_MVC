
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author JUNIOR VASQUEZ G
 */
public class clientesDAO {
    String sentencia = "";
    ResultSet rs = null;
    
    public ArrayList consulta(){
        Conexion con = new Conexion();
        ArrayList<clientes> lista = new ArrayList();
        sentencia = "SELECT * FROM clientes"; 
        rs = con.consulta(sentencia);
                
        try {          
            while(rs.next()){
                clientes cliente = new clientes();
                cliente.setId(rs.getInt("id"));
                cliente.setDocumento(rs.getInt("documento"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                lista.add(cliente);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public clientes encontrar(int id){
        Conexion con = new Conexion();
        sentencia = "SELECT * FROM clientes WHERE id LIKE " + id + ""; 
        rs = con.consulta(sentencia);
        clientes cliente = new clientes();
        
        try {
            cliente.setId(rs.getInt("id"));
            cliente.setDocumento(rs.getInt("documento"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setEmail(rs.getString("email"));
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.cerrar();
        return cliente;
    }
    
    public boolean agregar(clientes c){
        Conexion con = new Conexion();
        sentencia = "INSERT INTO clientes(documento,nombre,telefono,email)"
                + " VALUES(" + c.getDocumento() + ",'" + c.getNombre() + "','" + c.getTelefono() + "','" + c.getEmail() + "');";
        
        con.ejecutar(sentencia);
        con.cerrar();
        return true;
    }
    
    public boolean actualizar(clientes c){
        Conexion con = new Conexion();
        sentencia = "UPDATE clientes SET documento=" + c.getDocumento() + ",nombre='" + c.getNombre() + "',telefono='" + c.getTelefono() 
                + "',email='"+ c.getEmail() + "' WHERE id=" + c.getId() + ";";
        con.ejecutar(sentencia);
        con.cerrar();
           
        return true;
    }
    
    public boolean borrar(int id){
        Conexion con = new Conexion();
        sentencia = "DELETE FROM clientes WHERE id=" + id + ";";
        
        con.ejecutar(sentencia);
        con.cerrar();
        
        return true;
    }
    
}
