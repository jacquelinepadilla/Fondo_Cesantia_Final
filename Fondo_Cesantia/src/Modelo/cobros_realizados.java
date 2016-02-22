/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Virginia Tapia
 */
public class cobros_realizados implements java.io.Serializable  {
    private int Id_Cobros;
    private String periodo; 
    private int importe_total_capital; 
    private float interes;  
    
    public cobros_realizados()
    {}
     
    public cobros_realizados(int Id_Cobros, String periodo, int importe_total_capital, float interes) {
        this.Id_Cobros = Id_Cobros;
        this.periodo = periodo;
        this.importe_total_capital = importe_total_capital;
        this.interes = interes;
    }
    
   public void setIdCobros(int Id_Cobros) {
        this.Id_Cobros = Id_Cobros;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setImporte_total_capital(int importe_total_capital) {
        this.importe_total_capital = importe_total_capital;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }

    public int getId_Cobros() {
        return Id_Cobros;
    }
    
    public String getPeriodo() {
        return periodo;
    }

    public int getImporte_total_capital() {
        return importe_total_capital;
    }

    public float getInteres() {
        return interes;
    } 
}
