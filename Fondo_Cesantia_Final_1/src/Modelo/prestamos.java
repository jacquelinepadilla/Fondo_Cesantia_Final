/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class prestamos implements java.io.Serializable  {
    private int Id_Prestamos;
   private int tipo_prestamo ; 
   private String fecha; 
   private int cantidad; 
   private int interes; 
   private String utilidad;
   
    public prestamos() 
    {} 
   
    public prestamos(int Id_Prestamos,int tipo_prestamo, String fecha, int cantidad, int interes, String utilidad) {
        this.Id_Prestamos = Id_Prestamos;
        this.tipo_prestamo = tipo_prestamo;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.interes = interes;
        this.utilidad = utilidad;
    }

    
    public void setId_Prestamos(int Id_Prestamos) {
        this.Id_Prestamos = Id_Prestamos;
    }
    
    public void setTipo_prestamo(int tipo_prestamo) {
        this.tipo_prestamo = tipo_prestamo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    public void setUtilidad(String utilidad) {
        this.utilidad = utilidad;
    }

    
    public int getId_Prestamos() {
        return Id_Prestamos;
    }
    
    public int getTipo_prestamo() {
        return tipo_prestamo;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getInteres() {
        return interes;
    }

    public String getUtilidad() {
        return utilidad;
    }
    
}
