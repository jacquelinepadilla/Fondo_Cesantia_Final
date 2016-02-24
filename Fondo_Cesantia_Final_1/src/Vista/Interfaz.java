/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Connecion;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Interfaz {
     public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connecion cnx = new Connecion();
        Connection c = cnx.obtener();
     } 
}
