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
    private int tb_persona_id;
    private String tipo;

    public Trabajador() { 
    }

    public Trabajador(int tb_persona_id, String tipo) {
        this.tb_persona_id = tb_persona_id;
        this.tipo = tipo;
    }

    public int getTb_persona_id() {
        return tb_persona_id;
    }

    public void setTb_persona_id(int tb_persona_id) {
        this.tb_persona_id = tb_persona_id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
