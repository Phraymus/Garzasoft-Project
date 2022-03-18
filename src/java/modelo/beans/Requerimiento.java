/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

import java.util.Date;

import java.sql.Timestamp;
/**
 *
 * @author Sttefany
 */
public class Requerimiento {
    private Modulo  modulo;
    private int idtb_checklist;
    private String nombre;
    private String estado;
    private Timestamp fecha_inicio;
    private Timestamp fecha_fin;

    public Requerimiento() {
    }

    public Requerimiento(Modulo modulo, int idtb_checklist, String nombre, String estado, Timestamp fecha_inicio, Timestamp fecha_fin) {
        this.modulo = modulo;
        this.idtb_checklist = idtb_checklist;
        this.nombre = nombre;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public int getIdtb_checklist() {
        return idtb_checklist;
    }

    public void setIdtb_checklist(int idtb_checklist) {
        this.idtb_checklist = idtb_checklist;
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

    public Timestamp getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Timestamp getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Timestamp fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    
    
}
