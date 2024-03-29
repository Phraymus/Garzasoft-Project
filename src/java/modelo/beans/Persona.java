/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.awt.Image;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author ESTUDIANTE
 */
public class Persona {
    private int idtb_persona;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String correo;
    private String tipo_identificacion;
    private String numero_identificacion;
    private InputStream foto;
    
    private int tb_ciudad_id;

    public Persona() {
    }

    public Persona(int idtb_persona, String nombre, String apellido_paterno, String apellido_materno, String correo, String tipo_identificacion, String numero_identificacion, InputStream foto, int tb_ciudad_id) {
        this.idtb_persona = idtb_persona;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.correo = correo;
        this.tipo_identificacion = tipo_identificacion;
        this.numero_identificacion = numero_identificacion;
        this.foto = foto;
        this.tb_ciudad_id = tb_ciudad_id;
    }

    public int getIdtb_persona() {
        return idtb_persona;
    }

    public void setIdtb_persona(int idtb_persona) {
        this.idtb_persona = idtb_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public int getTb_ciudad_id() {
        return tb_ciudad_id;
    }

    public void setTb_ciudad_id(int tb_ciudad_id) {
        this.tb_ciudad_id = tb_ciudad_id;
    }

    

    
}
