package Controlador;

import java.sql.*;
/**
 *
 * @author Virginia, Erick y Jacqueline
 */
public class Connecion {
 private static Connection cnx = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                //cnx = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=bd_music","sa","admin001");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fondo_Cesantia?zeroDateTimeBehavior=convertToNull","root","");
                //jdbc:mysql://localhost:3306/bd_music?zeroDateTimeBehavior=convertToNull [root on Default schema]
            System.out.println("Conexion Exitosa"); 
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }
    public boolean crearConexion() throws ClassNotFoundException
    {
        try{
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fondo_Cesantia?zeroDateTimeBehavior=convertToNull","root","");
                //jdbc:mysql://localhost:3306/bd_music?zeroDateTimeBehavior=convertToNull [root on Default schema]
                System.out.println("Conexion Exitosa");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false; 
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            return false; 
        }
        
        return true; 
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
   
}
