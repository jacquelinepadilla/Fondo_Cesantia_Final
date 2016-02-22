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
    private String telefono;
    private String tipo_empleado;
    private int ingreso_mensual;
    private int monto_del_prestamo;
    private String duracion_del_prestamo;
    private String destino_del_prestamo;
    
    public cliente()
    {}
    
    public cliente(int Id_Cliente,String apellidos, String nombres, String cedula, String fecha_nacimiento, String direccion, String telefono, String tipo_empleado, int ingreso_mensual, int monto_del_prestamo, String duracion_del_prestamo, String destino_del_prestamo) 
    {
        this.Id_Cliente= Id_Cliente;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.cedula = cedula;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo_empleado = tipo_empleado;
        this.ingreso_mensual = ingreso_mensual;
        this.monto_del_prestamo = monto_del_prestamo;
        this.duracion_del_prestamo = duracion_del_prestamo;
        this.destino_del_prestamo = destino_del_prestamo;
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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipo_empleado(String tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
    }

    public void setIngreso_mensual(int ingreso_mensual) {
        this.ingreso_mensual = ingreso_mensual;
    }

    public void setMonto_del_prestamo(int monto_del_prestamo) {
        this.monto_del_prestamo = monto_del_prestamo;
    }

    public void setDuracion_del_prestamo(String duracion_del_prestamo) {
        this.duracion_del_prestamo = duracion_del_prestamo;
    }

    public void setDestino_del_prestamo(String destino_del_prestamo) {
        this.destino_del_prestamo = destino_del_prestamo;
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

    public String getTelefono() {
        return telefono;
    }

    public String getTipo_empleado() {
        return tipo_empleado;
    }

    public int getIngreso_mensual() {
        return ingreso_mensual;
    }

    public int getMonto_del_prestamo() {
        return monto_del_prestamo;
    }

    public String getDuracion_del_prestamo() {
        return duracion_del_prestamo;
    }

    public String getDestino_del_prestamo() {
        return destino_del_prestamo;
    }
 
}
