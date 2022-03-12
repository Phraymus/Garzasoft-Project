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
public class Cliente {

    private int tb_persona_id;
    private String ruc;
    private String nombreEmpresa;

    public Cliente() {
    }

    public Cliente(int tb_persona_id, String ruc, String nombreEmpresa) {
        this.tb_persona_id = tb_persona_id;
        this.ruc = ruc;
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getTb_persona_id() {
        return tb_persona_id;
    }

    public void setTb_persona_id(int tb_persona_id) {
        this.tb_persona_id = tb_persona_id;
    }

}
