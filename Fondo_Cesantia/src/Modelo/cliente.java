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
public class cliente  implements java.io.Serializable {
    private int Id_Cliente; 
    private String apellidos; 
    private String nombres; 
    private String cedula; 
    private String fecha_nacimiento;
    private String direccion; 
   
    
    public cliente()
    {}
    
    public cliente( int Id_Cliente, String apellidos, String nombres, String cedula, String fecha_nacimiento, String direccion) 
    {
         this.Id_Cliente= Id_Cliente;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.cedula = cedula;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   

    public int getId_Cliente() {
        return Id_Cliente;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    
}
