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
public class Pais {
    private int idtb_pais;
    private String nombre;

    public Pais() { 
    }

    public Pais(int idtb_pais, String nombre) {
        this.idtb_pais = idtb_pais;
        this.nombre = nombre;
    } 

    public int getIdtb_pais() {
        return idtb_pais;
    }

    public void setIdtb_pais(int idtb_pais) {
        this.idtb_pais = idtb_pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
