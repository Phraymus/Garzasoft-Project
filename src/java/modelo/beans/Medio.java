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
public class Medio {
    private int idtb_medio;
    private String nombre;

    public Medio() {
    }
    
    public Medio(int idtb_medio, String nombre) {
        this.idtb_medio = idtb_medio;
        this.nombre = nombre;
    }

    public int getIdtb_medio() {
        return idtb_medio;
    }

    public void setIdtb_medio(int idtb_medio) {
        this.idtb_medio = idtb_medio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
