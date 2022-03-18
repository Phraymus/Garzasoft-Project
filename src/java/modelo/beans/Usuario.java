/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

/**
 *
 * @author ESTUDIANTE
 */
public class Usuario {
    private int idtb_usuario;
    private String nombre;
    private String clave;
    private String perfil_usuario;
    
    private Trabajador trabajador;
    private Cliente cliente;

    public Usuario() {
    }

    public Usuario(int idtb_usuario, String nombre, String clave, String perfil_usuario, Trabajador trabajador) {
        this.idtb_usuario = idtb_usuario;
        this.nombre = nombre;
        this.clave = clave;
        this.perfil_usuario = perfil_usuario;
        this.trabajador = trabajador;
    }

    public Usuario(int idtb_usuario, String nombre, String clave, String perfil_usuario, Cliente cliente) {
        this.idtb_usuario = idtb_usuario;
        this.nombre = nombre;
        this.clave = clave;
        this.perfil_usuario = perfil_usuario;
        this.cliente = cliente;
    }
    
    

    public Usuario(int idtb_usuario, String nombre, String clave, String perfil_usuario, Trabajador trabajador, Cliente cliente) {
        this.idtb_usuario = idtb_usuario;
        this.nombre = nombre;
        this.clave = clave;
        this.perfil_usuario = perfil_usuario;
        this.trabajador = trabajador;
        this.cliente = cliente;
    }

    

    public int getIdtb_usuario() {
        return idtb_usuario;
    }

    public void setIdtb_usuario(int idtb_usuario) {
        this.idtb_usuario = idtb_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPerfil_usuario() {
        return perfil_usuario;
    }

    public void setPerfil_usuario(String perfil_usuario) {
        this.perfil_usuario = perfil_usuario;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
