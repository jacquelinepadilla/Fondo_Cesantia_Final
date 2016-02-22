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
public class cobros_realizados implements java.io.Serializable  {
    private String periodo; 
    private int importe_total_capital; 
    private float interes;  
    
    public cobros_realizados()
    {}
     
    public cobros_realizados(String periodo, int importe_total_capital, float interes) {
        this.periodo = periodo;
        this.importe_total_capital = importe_total_capital;
        this.interes = interes;
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
