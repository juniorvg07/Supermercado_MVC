
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
import vista.editar;
import vista.vista;

/**
 *
 * @author JUNIOR VASQUEZ G
 */
public class ControladorEditar implements ActionListener, KeyListener{
    clientesDAO dao = new clientesDAO();
    clientes c = new clientes();
    vista v = new vista();
    editar ed = new editar();
    public static int id = 0;
    
    public ControladorEditar(editar editar){
        this.ed = editar;
        this.ed.btnVolver.addActionListener(this);
        this.ed.btnEnviar.addActionListener(this);
        this.ed.txtDocumento.addKeyListener(this);
        setear();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ed.btnVolver){
            volver();
        }
        if(e.getSource() == ed.btnEnviar){
            edit();
            volver();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void volver(){               
        v.setVisible(true);
        Controlador ctrl = new Controlador(v);
        
        Window w = SwingUtilities.getWindowAncestor(ed);
        w.setVisible(false);
    }
    
    void setear(){
        c = dao.encontrar(id);
        
        ed.lblId.setText(String.valueOf(c.getId()));
        ed.txtDocumento.setText(String.valueOf(c.getDocumento()));
        ed.txtNombre.setText(c.getNombre());
        ed.txtTelefono.setText(c.getTelefono());
        ed.txtEmail.setText(c.getEmail());
    }
    
    void edit(){
        c.setDocumento(Integer.parseInt(ed.txtDocumento.getText()));
        c.setNombre(ed.txtNombre.getText());
        c.setTelefono(ed.txtTelefono.getText());
        c.setEmail(ed.txtEmail.getText());
        
        dao.actualizar(c);
        
        JOptionPane.showMessageDialog(null, "Información actualizada");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == ed.txtDocumento){
            int key = e.getKeyChar();

            boolean numeros = key >= 48 && key <= 57;

            if (!numeros) {
                e.consume();
            }

            if (ed.txtDocumento.getText().trim().length() == 15) {
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
