/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

/**
 *
 * @author ELIAS
 */
public class UsuarioReunion {
    private Reunion reunion;
    private Usuario usuario;

    public UsuarioReunion() {
    }

    public UsuarioReunion(Reunion reunion, Usuario usuario) {
        this.reunion = reunion;
        this.usuario = usuario;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
