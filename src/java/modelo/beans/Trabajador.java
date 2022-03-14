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
public class Trabajador {
    private int idtb_trabajador;
    private String tipo;
    private int tb_persona_id;

    public Trabajador() {
    }

    public Trabajador(int idtb_trabajador, String tipo, int tb_persona_id) {
        this.idtb_trabajador = idtb_trabajador;
        this.tipo = tipo;
        this.tb_persona_id = tb_persona_id;
    }

    public int getIdtb_trabajador() {
        return idtb_trabajador;
    }

    public void setIdtb_trabajador(int idtb_trabajador) {
        this.idtb_trabajador = idtb_trabajador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTb_persona_id() {
        return tb_persona_id;
    }

    public void setTb_persona_id(int tb_persona_id) {
        this.tb_persona_id = tb_persona_id;
    }
    
    
    
}
