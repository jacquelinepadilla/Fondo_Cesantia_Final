/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 
import Modelo.cliente;
/**
 *
 * @author Virginia
 */
public class cliente_servicios {
  private final String cliente = "cliente";  
  
    public void guardar(Connection conexion, cliente cliente) throws SQLException{
        try{
            PreparedStatement consulta;
            if(cliente.getId_Cliente() != 0){ 
                consulta = conexion.prepareStatement("INSERT INTO " + this.cliente + "(Id_Cliente, apellidos, nombres, cedula, fecha_nacimiento, direccion) VALUES(?, ?, ?, ?, ?, ?)");
                consulta.setInt(1, cliente.getId_Cliente());
                consulta.setString(2, cliente.getApellidos());
                consulta.setString(3,cliente.getNombres());
                consulta.setString(4,cliente.getCedula());
                consulta.setString(5,cliente.getFecha_nacimiento());
                consulta.setString(6,cliente.getDireccion());
                
                
            }else{
                consulta = conexion.prepareStatement("UPDATE " + this.cliente + " SET  apellidos = ?, nombres = ?, cedula = ?, fecha_nacimiento = ?, direccion = ? WHERE Id_Cliente = ?");
                consulta.setString(1, cliente.getApellidos());
                consulta.setString(2,cliente.getNombres());
                consulta.setString(3,cliente.getCedula());
                consulta.setString(4,cliente.getFecha_nacimiento());
                consulta.setString(5,cliente.getDireccion());
                consulta.setInt(6, cliente.getId_Cliente());
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public cliente recuperarPorId(Connection conexion, int Id_Cliente) throws SQLException {
        cliente cliente = null;
        try{ 
            PreparedStatement consulta = conexion.prepareStatement("SELECT apellidos, nombres, cedula, fecha_nacimiento, direccion  FROM " + this.cliente + " WHERE Id_Cliente = ?" );
            consulta.setInt(1, Id_Cliente);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                cliente = new cliente (Id_Cliente, resultado.getString("apellidos"), resultado.getString("nombres"), resultado.getString("cedula"), resultado.getString("fecha_nacimiento"), resultado.getString("direccion"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return cliente;
    }
    
    public void eliminar(Connection conexion, cliente cliente1) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.cliente + " WHERE Id_Cliente = ?");
            consulta.setInt(1, cliente1.getId_Cliente());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public List<cliente> recuperarTodas(Connection conexion) throws SQLException{
        List<cliente> cliente1 = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT Id_Cliente, apellidos, nombres,cedula, fecha_nacimiento,direccion FROM " + this.cliente + " ORDER BY apellidos");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                cliente1.add(new cliente(resultado.getInt("Id_Cliente"), resultado.getString("apellidos"), resultado.getString("nombres"), resultado.getString("cedula"), resultado.getString("fecha_nacimiento"), resultado.getString("direccion")));             
            }
        } catch(SQLException ex){
            throw new SQLException(ex);
        }
        return cliente1;
    } 
}
