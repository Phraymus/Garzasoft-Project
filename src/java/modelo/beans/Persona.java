/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.awt.Image;

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
    private Image foto;
    
    private Identificacion identificacion;
    private Ciudad ciudad;

    public Persona() {
    }

    public Persona(int idtb_persona, String nombre, String apellido_paterno, String apellido_materno, String correo, Image foto, Identificacion identificacion, Ciudad ciudad) {
        this.idtb_persona = idtb_persona;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.correo = correo;
        this.foto = foto;
        this.identificacion = identificacion;
        this.ciudad = ciudad;
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

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    
    
}
