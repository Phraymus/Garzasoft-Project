/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

/**
 *
 * @author Marco
 */
public class Departamento {
    private int idtb_departamento;
    private String nombre;
    private int tb_pais_id;

    public Departamento() { 
    }

    public Departamento(int idtb_departamento, String nombre, int tb_pais_id) {
        this.idtb_departamento = idtb_departamento;
        this.nombre = nombre;
        this.tb_pais_id = tb_pais_id;
    }

    public int getIdtb_departamento() {
        return idtb_departamento;
    }

    public void setIdtb_departamento(int idtb_departamento) {
        this.idtb_departamento = idtb_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTb_pais_id() {
        return tb_pais_id;
    }

    public void setTb_pais_id(int tb_pais_id) {
        this.tb_pais_id = tb_pais_id;
    }
    
}
