/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.Controlador;
import vista.editar;
import vista.nuevo;
import vista.vista;

/**
 *
 * @author JUNIOR VASQUEZ G
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        vista v = new vista();
        nuevo n = new nuevo();
        editar e = new editar();
        
        Controlador ctrl = new Controlador(v);
        
        v.setVisible(true);
    }
    
}
