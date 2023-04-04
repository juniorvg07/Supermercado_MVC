
package modelo;

/**
 *
 * @author JUNIOR VASQUEZ G
 */
public class clientes {
    //Atributos de la clase
    private int id;
    private int documento;
    private String nombre;
    private String telefono;
    private String email;

    //Contructores
    public clientes() {
    }
    
    public clientes(int id, int documento, String nombre, String telefono, String email) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
    
    
    //Métodos Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
