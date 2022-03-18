/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

/**
 *
 * @author Sttefany
 */
public class Modulo {
    private int idtb_modulo;
    private String nombre;
    private String estado;
    private Proyecto proyecto;

    public Modulo() {
    }

    public Modulo(int idtb_modulo, String nombre, String estado, Proyecto proyecto) {
        this.idtb_modulo = idtb_modulo;
        this.nombre = nombre;
        this.estado = estado;
        this.proyecto = proyecto;
    }

    public int getIdtb_modulo() {
        return idtb_modulo;
    }

    public void setIdtb_modulo(int idtb_modulo) {
        this.idtb_modulo = idtb_modulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    
    
}
