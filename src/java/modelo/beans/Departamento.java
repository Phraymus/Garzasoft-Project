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
    private Pais pais;

    public Departamento() { 
    }

    public Departamento(int idtb_departamento, String nombre, Pais pais) {
        this.idtb_departamento = idtb_departamento;
        this.nombre = nombre;
        this.pais = pais;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }


}
