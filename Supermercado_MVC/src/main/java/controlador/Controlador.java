
package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.clientes;
import modelo.clientesDAO;
import vista.editar;
import vista.nuevo;
import vista.vista;

/**
 *
 * @author JUNIOR VASQUEZ G
 */
public class Controlador implements ActionListener{
    
    clientesDAO dao = new clientesDAO();
    clientes c = new clientes();
    vista v = new vista();
    nuevo n = new nuevo();
    editar ed = new editar();
    DefaultTableModel modelo = (DefaultTableModel) v.tblClientes.getModel();
    int id = 0;

    public Controlador(vista vista){
        this.v = vista;
        this.v.btnNuevo.addActionListener(this);
        this.v.btnEditar.addActionListener(this);
        this.v.btnEliminar.addActionListener(this);
        listar(v.tblClientes);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == v.btnNuevo){
            nuevo();
        }
        if(e.getSource() == v.btnEditar){
            int select = v.tblClientes.getSelectedRow();
            if(select == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente primero", "AVISO", JOptionPane.WARNING_MESSAGE);
            }else{
                id = (int) modelo.getValueAt(v.tblClientes.getSelectedRow(), 0);

                ControladorEditar.id = id;
                editar();
            }
        }
        if(e.getSource() == v.btnEliminar){
            eliminar();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void listar(JTable tabla){
        ArrayList<clientes> list = dao.consulta();
                      
        for(int i = 0; i < list.size(); i++){
            Object row[] = {list.get(i).getId(), list.get(i).getDocumento(), list.get(i).getNombre(), list.get(i).getTelefono(), list.get(i).getEmail()};
            modelo.addRow(row);
        }
        tabla.setModel(modelo);
    }
    
    void nuevo(){
        nuevo n = new nuevo();
        n.setSize(700, 470);
        n.setLocation(0,0);
        
        ControladorNuevo ctrl = new ControladorNuevo(n);
        
        v.panel.removeAll();
        v.panel.add(n, BorderLayout.CENTER);
        v.panel.revalidate();
        v.panel.repaint();
    }
    
    void editar(){
        editar e = new editar();
        e.setSize(700, 470);
        e.setLocation(0,0);
        
        ControladorEditar ctrl = new ControladorEditar(e);
        
        v.panel.removeAll();
        v.panel.add(e, BorderLayout.CENTER);
        v.panel.revalidate();
        v.panel.repaint();
    }
    
    void volver(){
        v.panel.removeAll();
        v.setVisible(true);
    }
    
    void eliminar(){
        int select = v.tblClientes.getSelectedRow();
        if(select == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente primero", "AVISO", JOptionPane.WARNING_MESSAGE);
        }else{
            int opcion = JOptionPane.showConfirmDialog(null, "¿Confirma eliminar este Cliente?", "ELIMINAR CLIENTE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(opcion == 0){
                int value = (int) modelo.getValueAt(v.tblClientes.getSelectedRow(), 0);
                
                dao.borrar(value);

                modelo.removeRow(v.tblClientes.getSelectedRow());
                
                JOptionPane.showMessageDialog(null, "Cliente eliminado del registro", "",JOptionPane.PLAIN_MESSAGE); 
            }
        }
    }
    
}
