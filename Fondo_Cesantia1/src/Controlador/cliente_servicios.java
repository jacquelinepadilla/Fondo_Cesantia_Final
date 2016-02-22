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
 * @author USUARIO
 */
public class cliente_servicios {
  private final String clientee = "cliente";  
  
    public void guardar(Connection conexion, cliente cliente) throws SQLException{
        try{
            PreparedStatement consulta;
            if(cliente.getId_Cliente() != 0){ 
                consulta = conexion.prepareStatement("INSERT INTO " + this.clientee + "(Id_Cliente,apellidos, nombres, cedula, fecha_nacimiento,direccion,telefono,tipo_empleado, ingreso_mensual,monto_del_prestamo, duracion_del_prestamo, destino_del_prestamo) VALUES(?, ?, ?, ?, ?, ?, ?,?,?,?,?)");
                consulta.setInt(1, cliente.getId_Cliente());
                consulta.setString(2, cliente.getApellidos());
                consulta.setString(3,cliente.getNombres());
                consulta.setString(4,cliente.getCedula());
                consulta.setString(5,cliente.getFecha_nacimiento());
                consulta.setString(6,cliente.getDireccion());
                consulta.setString(7,cliente.getTelefono());
                consulta.setString(8,cliente.getTipo_empleado());
                consulta.setInt(9, cliente.getIngreso_mensual());
                consulta.setInt(10, cliente.getMonto_del_prestamo());
                consulta.setString(11,cliente.getDuracion_del_prestamo());
                consulta.setString(12,cliente.getDestino_del_prestamo());
                
                //consulta.setFloat(9, cliente.getPrecio());
                
            }else{
                consulta = conexion.prepareStatement("UPDATE " + this.clientee + " SET  apellidos = ?, nombres = ?, cedula = ?, fecha_nacimiento = ?, direccion = ?, telefono = ? tipo_empleado = ?, ingreso_mensual = ? ,monto_del_prestamo = ?, duracion_del_prestamo = ?, destino_del_prestamo = ? WHERE Id_Cliente = ?");
                consulta.setString(1, cliente.getApellidos());
                consulta.setString(2,cliente.getNombres());
                consulta.setString(3,cliente.getCedula());
                consulta.setString(4,cliente.getFecha_nacimiento());
                consulta.setString(5,cliente.getDireccion());
                consulta.setString(6,cliente.getTelefono());
                consulta.setString(7,cliente.getTipo_empleado());
                consulta.setInt(8, cliente.getIngreso_mensual());
                consulta.setInt(9, cliente.getMonto_del_prestamo());
                consulta.setString(10,cliente.getDuracion_del_prestamo());
                consulta.setString(11,cliente.getDestino_del_prestamo());
                consulta.setInt(12, cliente.getId_Cliente());
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public cliente recuperarPorId(Connection conexion, int Id_Cliente) throws SQLException {
        cliente clientee = null;
        try{ 
            PreparedStatement consulta = conexion.prepareStatement("SELECT apellidos, nombres, cedula, direccion, telefono ,tipo_empleado, ingreso_mensual,monto_del_prestamo, duracion_del_prestamo, destino_del_prestamo FROM " + this.clientee + " WHERE Id_Cliente = ?" );
            consulta.setInt(1, Id_Cliente);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                clientee = new cliente(Id_Cliente, resultado.getString("apellidos"), resultado.getString(" nombres"), resultado.getString("cedula"), resultado.getString("direccion"), resultado.getString("telefono"), resultado.getString("tipo_empleado"), resultado.getInt("ingreso_mensual"), resultado.getInt("monto_del_prestamo"),resultado.getString("duracion_del_prestamo"), resultado.getString("destino_del_prestamo"));
            
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return clientee;
    }
    
    public void eliminar(Connection conexion, cliente clientee) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.clientee + " WHERE Id_vehiculo = ?");
            consulta.setInt(1, clientee.getId_Cliente());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public List<cliente> recuperarTodas(Connection conexion) throws SQLException{
        List<cliente> clientes = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT Id_Cliente, apellidos, nombres,cedula, fecha_nacimiento,direccion,telefono,tipo_empleado,ingreso_mensual,monto_del_prestamo,duracion_del_prestamo,destino_del_prestamo FROM " + this.clientee + " ORDER BY apellidos");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                clientes.add(new cliente(resultado.getInt("Id_Cliente"), resultado.getString("apellidos"), resultado.getString("nombres"), resultado.getString("cedula"), resultado.getString("fecha_nacimiento"), resultado.getString("direccion"), resultado.getString("telefono"),resultado.getString("tipo_empleado"), resultado.getInt("ingreso_mensual"), resultado.getFloat("Precio")));             
            
            }
        } catch(SQLException ex){
            throw new SQLException(ex);
        }
        return clientes;
    } 
}
