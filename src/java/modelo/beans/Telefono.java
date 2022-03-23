/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

/**
 *
 * @author Brayan Carrasco
 */
public class Telefono {
    private int idtb_telefono;
    private String numero;
    private int tb_persona_id;

    public Telefono() {
    }

    public Telefono(int idtb_telefono, String numero, int tb_persona_id) {
        this.idtb_telefono = idtb_telefono;
        this.numero = numero;
        this.tb_persona_id = tb_persona_id;
    }

    public int getIdtb_telefono() {
        return idtb_telefono;
    }

    public void setIdtb_telefono(int idtb_telefono) {
        this.idtb_telefono = idtb_telefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTb_persona_id() {
        return tb_persona_id;
    }

    public void setTb_persona_id(int tb_persona_id) {
        this.tb_persona_id = tb_persona_id;
    }

    
}
