
package Controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.prestamos;

public class prestamos_servicios {
  private final String prestamos = "prestamos";  // este es el nombre con letras rojas de la tabla de la base de Datos
  public void guardar(Connection conexion, prestamos prestamo) throws SQLException{
        try{
            PreparedStatement consulta;
            if(prestamo.getId_Prestamos() != 0){ 
                consulta = conexion.prepareStatement("INSERT INTO " + this.prestamos + "(Id_Prestamos,tipo_prestamo, fecha, cantidad,interes,utilidad) VALUES(?,?,?,?,?,?)");
                consulta.setInt(1, prestamo.getId_Prestamos());
                consulta.setInt(2, prestamo.getTipo_prestamo());
                consulta.setString(3, prestamo.getFecha());
                consulta.setInt(4, prestamo.getCantidad());
                consulta.setInt(5, prestamo.getInteres());
                consulta.setString(6, prestamo.getUtilidad());
              
                
            }else{
                consulta = conexion.prepareStatement("UPDATE " + this.prestamos + " SET  tipo_prestamo = ?, fecha = ?, cantidad= ?, interes = ?,utilidad= ?, WHERE Id_Prestamos = ?");
                consulta.setInt(1,prestamo.getId_Prestamos());
                consulta.setInt(2,prestamo.getTipo_prestamo());
                consulta.setString(3,prestamo.getFecha());
                consulta.setInt(4,prestamo.getCantidad());
                consulta.setInt(5,prestamo.getInteres());
                consulta.setString(6,prestamo.getUtilidad());
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public prestamos recuperarPorId(Connection conexion, int Id_Prestamos) throws SQLException {
        prestamos prestamos1 = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT tipo_prestamo, fecha, cantidad,interes,utilidad FROM " + this.prestamos+ " WHERE Id_Prestamos = ?" );
            consulta.setInt(1, Id_Prestamos);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                prestamos1 = new prestamos (Id_Prestamos, resultado.getInt("tipo_prestamo"), resultado.getString("fecha"), resultado.getInt("cantidad"), resultado.getInt("interes"), resultado.getString("utilidad"));
            
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return prestamos1;
        
        
    }
    
    public void eliminar(Connection conexion, prestamos prestamo) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.prestamos + " WHERE Id_Prestamos = ?");
            consulta.setInt(1, prestamo.getId_Prestamos());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public List<prestamos> recuperarTodas(Connection conexion) throws SQLException{
        List<prestamos> prestamos1 = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT Id_Prestamos, tipo_prestamo, fecha, cantidad,interes,utilidad  FROM " + this.prestamos + " ORDER BY Id_Prestamos");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                prestamos1.add(new prestamos(resultado.getInt("Id_Prestamos"), resultado.getInt("tipo_prestamo"), resultado.getString("fecha"), resultado.getInt("cantidad"), resultado.getInt("interes"), resultado.getString("utilidad")));
                             
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return prestamos1;
    } 
}

