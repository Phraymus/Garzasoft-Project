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
public class Ciudad {
    private int idtb_ciudad;
    private String nombre;
    private int tb_departamento_id;

    public Ciudad() { 
    }

    public Ciudad(int idtb_ciudad, String nombre, int tb_departamento_id) {
        this.idtb_ciudad = idtb_ciudad;
        this.nombre = nombre;
        this.tb_departamento_id = tb_departamento_id;
    }

    public int getIdtb_ciudad() {
        return idtb_ciudad;
    }

    public void setIdtb_ciudad(int idtb_ciudad) {
        this.idtb_ciudad = idtb_ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTb_departamento_id() {
        return tb_departamento_id;
    }

    public void setTb_departamento_id(int tb_departamento_id) {
        this.tb_departamento_id = tb_departamento_id;
    }



}
