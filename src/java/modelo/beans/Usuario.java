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
    private String tb_perfil_usuario_id;
    private Trabajador tb_trabajador_id;
    private Cliente tb_cliente_id;

    public Usuario() {
    }

    public Usuario(int idtb_usuario, String nombre, String clave, String tb_perfil_usuario_id, Trabajador tb_trabajador_id, Cliente tb_cliente_id) {
        this.idtb_usuario = idtb_usuario;
        this.nombre = nombre;
        this.clave = clave;
        this.tb_perfil_usuario_id = tb_perfil_usuario_id;
        this.tb_trabajador_id = tb_trabajador_id;
        this.tb_cliente_id = tb_cliente_id;
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

    public String getTb_perfil_usuario_id() {
        return tb_perfil_usuario_id;
    }

    public void setTb_perfil_usuario_id(String tb_perfil_usuario_id) {
        this.tb_perfil_usuario_id = tb_perfil_usuario_id;
    }

    public Trabajador getTb_trabajador_id() {
        return tb_trabajador_id;
    }

    public void setTb_trabajador_id(Trabajador tb_trabajador_id) {
        this.tb_trabajador_id = tb_trabajador_id;
    }

    public Cliente getTb_cliente_id() {
        return tb_cliente_id;
    }

    public void setTb_cliente_id(Cliente tb_cliente_id) {
        this.tb_cliente_id = tb_cliente_id;
    }
    
    
}
