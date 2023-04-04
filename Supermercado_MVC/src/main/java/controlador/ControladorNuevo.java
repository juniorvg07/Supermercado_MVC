
package controlador;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.clientes;
import modelo.clientesDAO;
import vista.nuevo;
import vista.vista;

/**
 *
 * @author JUNIOR VASQUEZ G
 */
public class ControladorNuevo implements ActionListener, KeyListener{
    clientesDAO dao = new clientesDAO();
    clientes c = new clientes();
    vista v = new vista();
    nuevo n = new nuevo();
    
    public ControladorNuevo(nuevo nuevo){
        this.n = nuevo;
        this.n.btnVolver.addActionListener(this);
        this.n.btnEnviar.addActionListener(this);
        this.n.txtDocumento.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == n.btnVolver){
            volver();
        }
        if(e.getSource() == n.btnEnviar){
            nuevo();
            volver();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void volver(){               
        v.setVisible(true);
        Controlador ctrl = new Controlador(v);
        
        Window w = SwingUtilities.getWindowAncestor(n);
        w.setVisible(false);
    }
    
    void nuevo(){
        c.setDocumento(Integer.parseInt(n.txtDocumento.getText()));
        c.setNombre(n.txtNombre.getText());
        c.setTelefono(n.txtTelefono.getText());
        c.setEmail(n.txtEmail.getText());
        
        dao.agregar(c);
        
        JOptionPane.showMessageDialog(null, "Nuevo cliente agregado");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == n.txtDocumento){
            int key = e.getKeyChar();

            boolean numeros = key >= 48 && key <= 57;

            if (!numeros) {
                e.consume();
            }

            if (n.txtDocumento.getText().trim().length() == 15) {
                e.consume();
            }
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
