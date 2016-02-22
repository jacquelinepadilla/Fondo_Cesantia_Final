/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.credito_otorgado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BDSistemas
 */
public class credito_otorgado_servicios {
private final String credito_otorgado = "credito_otorgado";  
  
    public void guardar(Connection conexion, credito_otorgado credito) throws SQLException{
        try{
            PreparedStatement consulta;
            if(credito.getId_Credito() != 0){ 
                consulta = conexion.prepareStatement("INSERT INTO " + this.credito_otorgado + "(Id_Credito, periodo, Fecha_emision_credito, Monto_capital_otorgado) VALUES(?,?,?,?)");
                consulta.setInt(1, credito.getId_Credito());
                consulta.setString(2,credito.getPeriodo());
                consulta.setString(3, credito.getFecha_emision_credito());
                consulta.setInt(4, credito.getMonto_capital_otorgado());
                //consulta.setFloat(9, cliente.getPrecio());
                
            }else{
                consulta = conexion.prepareStatement("UPDATE " + this.credito_otorgado + " SET  periodo = ?, Fecha_emision_credito = ?, Monto_capital_otorgado = ?,WHERE Id_Credito = ?");
                consulta.setInt(1,credito.getId_Credito());
                consulta.setString(2,credito.getPeriodo());
                consulta.setString(3, credito.getFecha_emision_credito());
                consulta.setInt(4, credito.getMonto_capital_otorgado()); 
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    public credito_otorgado recuperarPorId(Connection conexion, int Id_Credito) throws SQLException {
        credito_otorgado credito1 = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT periodo, fecha_emision_credito, monto_capital_otorgado FROM " + this.credito_otorgado+ " WHERE Id_Credito = ?" );
            consulta.setInt(1, Id_Credito);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                credito1 = new credito_otorgado (Id_Credito, resultado.getString("periodo"), resultado.getString("fecha_emision_credito"), resultado.getInt("monto_capital_otorgado"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return credito1;
    }
    
    public void eliminar(Connection conexion, credito_otorgado credito) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.credito_otorgado + " WHERE Id_Credito = ?");
            consulta.setInt(1, credito.getId_Credito());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public List<credito_otorgado> recuperarTodas(Connection conexion) throws SQLException{
        List<credito_otorgado> credito1 = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT Id_Credito, periodo, fecha_emision_credito, monto_capital_otorgado  FROM " + this.credito_otorgado + " ORDER BY Id_Credito");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                credito1.add(new credito_otorgado(resultado.getInt("Id_Credito"), resultado.getString("periodo"), resultado.getString("Fecha_emision_credito"), resultado.getInt("Monto_capital_otorgado")));           
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return credito1;
    } 
}
