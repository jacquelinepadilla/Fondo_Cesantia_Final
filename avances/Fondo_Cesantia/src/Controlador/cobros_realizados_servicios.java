package Controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.cobros_realizados;
/**
 *
 * @author BDSistemas
 */
public class cobros_realizados_servicios {
    private final String cobros_realizados = "cobros";  
  
    public void guardar(Connection conexion, cobros_realizados cobros) throws SQLException{
        try{
            PreparedStatement consulta;
            if(cobros.getId_Cobros() != 0){ 
                consulta = conexion.prepareStatement("INSERT INTO " + this.cobros_realizados + "(periodo, importe_total_capital, interes) VALUES(?,?,?,?)");
                consulta.setInt(1, cobros.getId_Cobros());
                consulta.setString(2, cobros.getPeriodo());
                consulta.setInt(3, cobros.getImporte_total_capital());
                consulta.setFloat(4, cobros.getInteres());
                
                //consulta.setFloat(9, cliente.getPrecio());
                
            }else{
                consulta = conexion.prepareStatement("UPDATE " + this.cobros_realizados + " SET  periodo = ?, importe_total_capital = ?, interes = ?,WHERE Id_Cobros = ?");
                consulta.setInt(1,cobros.getId_Cobros());
                consulta.setString(2,cobros.getPeriodo());
                consulta.setInt(3,cobros.getImporte_total_capital());
                consulta.setFloat(4,cobros.getInteres());
               
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public cobros_realizados recuperarPorId(Connection conexion, int Id_Cobros) throws SQLException {
        cobros_realizados cobros1 = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT periodo, importe_total_capital, interes FROM " + this.cobros_realizados+ " WHERE Id_Cobros = ?" );
            consulta.setInt(1, Id_Cobros);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                cobros1 = new cobros_realizados (Id_Cobros, resultado.getString("periodo"), resultado.getInt("importe_total_capital"), resultado.getFloat("interes"));
            
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return cobros1;
        
        
    }
    
    public void eliminar(Connection conexion, cobros_realizados cobros) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.cobros_realizados + " WHERE Id_Cobros = ?");
            consulta.setInt(1, cobros.getId_Cobros());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        } 
    }
    
    public List<cobros_realizados> recuperarTodas(Connection conexion) throws SQLException{
        List<cobros_realizados> cobros1 = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT Id_Cobros, periodo, importe_total_capital, interes  FROM " + this.cobros_realizados + " ORDER BY Id_Cobro");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                cobros1.add(new cobros_realizados(resultado.getInt("Id_Cobros"), resultado.getString("periodo"), resultado.getInt("importe_total_capital"), resultado.getFloat("Interes")));
                             
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return cobros1;
    } 
}
