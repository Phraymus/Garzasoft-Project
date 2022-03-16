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
    private Departamento departamento;

    public Ciudad() { 
    }

    public Ciudad(int idtb_ciudad, String nombre) {
        this.idtb_ciudad = idtb_ciudad;
        this.nombre = nombre;
    }

    public Ciudad(int idtb_ciudad, String nombre, Departamento departamento) {
        this.idtb_ciudad = idtb_ciudad;
        this.nombre = nombre;
        this.departamento = departamento;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
