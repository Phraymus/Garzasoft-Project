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
    private Reunion tb_reunion_id;
    private Usuario tb_usuario_id;

    public UsuarioReunion() {
    }

    public UsuarioReunion(Reunion tb_reunion_id, Usuario tb_usuario_id) {
        this.tb_reunion_id = tb_reunion_id;
        this.tb_usuario_id = tb_usuario_id;
    }

    public Reunion getTb_reunion_id() {
        return tb_reunion_id;
    }

    public void setTb_reunion_id(Reunion tb_reunion_id) {
        this.tb_reunion_id = tb_reunion_id;
    }

    public Usuario getTb_usuario_id() {
        return tb_usuario_id;
    }

    public void setTb_usuario_id(Usuario tb_usuario_id) {
        this.tb_usuario_id = tb_usuario_id;
    }

    
    
}
