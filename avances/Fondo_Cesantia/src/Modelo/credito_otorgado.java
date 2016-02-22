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
public class credito_otorgado implements java.io.Serializable  {
    private String periodo; 
    private String fecha_emision_credito; 
    private int monto_capital_otorgado;

    public credito_otorgado(String periodo, String fecha_emision_credito, int monto_capital_otorgado) {
        this.periodo = periodo;
        this.fecha_emision_credito = fecha_emision_credito;
        this.monto_capital_otorgado = monto_capital_otorgado;
    }
    
    public credito_otorgado()
    {}

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
  
}
