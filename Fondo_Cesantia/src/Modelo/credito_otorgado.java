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
public class credito_otorgado implements java.io.Serializable  {
    private int Id_Credito;
    private String periodo; 
    private String fecha_emision_credito; 
    private int monto_capital_otorgado;

    public credito_otorgado(int Id_Credito,String periodo, String fecha_emision_credito, int monto_capital_otorgado) {
        this.Id_Credito = Id_Credito;
        this.periodo = periodo;
        this.fecha_emision_credito = fecha_emision_credito;
        this.monto_capital_otorgado = monto_capital_otorgado;
    }
    
    public credito_otorgado()
    {}

    public void setId_Credito(int Id_Credito) {
        this.Id_Credito = Id_Credito;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setFecha_emision_credito(String fecha_emision_credito) {
        this.fecha_emision_credito = fecha_emision_credito;
    }

    public void setMonto_capital_otorgado(int monto_capital_otorgado) {
        this.monto_capital_otorgado = monto_capital_otorgado;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getFecha_emision_credito() {
        return fecha_emision_credito;
    }

    public int getMonto_capital_otorgado() {
        return monto_capital_otorgado;
    }
  
    public int getId_Credito() {
        return Id_Credito;
    }
}
