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
    
    private int tb_trabajador_id;
    private int tb_cliente_idc;

    public Usuario() {
    }

    public Usuario(int idtb_usuario, String nombre, String clave, String perfil_usuario, int tb_trabajador_id, int tb_cliente_idc) {
        this.idtb_usuario = idtb_usuario;
        this.nombre = nombre;
        this.clave = clave;
        this.perfil_usuario = perfil_usuario;
        this.tb_trabajador_id = tb_trabajador_id;
        this.tb_cliente_idc = tb_cliente_idc;
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

    public int getTb_trabajador_id() {
        return tb_trabajador_id;
    }

    public void setTb_trabajador_id(int tb_trabajador_id) {
        this.tb_trabajador_id = tb_trabajador_id;
    }

    public int getTb_cliente_idc() {
        return tb_cliente_idc;
    }

    public void setTb_cliente_idc(int tb_cliente_idc) {
        this.tb_cliente_idc = tb_cliente_idc;
    }

    
}
