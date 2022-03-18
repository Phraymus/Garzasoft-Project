/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

import jdk.jfr.Timestamp;

/**
 *
 * @author Sttefany
 */
public class Proyecto {
    private int idtb_proyecto;
    private String nombre;
    private String estado;
    private Timestamp fecha_inicio;
    private Timestamp fecha_fin;
    private String tarea;
    private String tarea_descripcion;
    private String checklist;
    private  Persona administrador;
    private  Cliente cliente;
    private  Persona programador;

    public Proyecto() {
    }

    public Proyecto(int idtb_proyecto, String nombre, String estado, Timestamp fecha_inicio, Timestamp fecha_fin, String tarea, String tarea_descripcion, String checklist, Persona administrador, Cliente cliente, Persona programador) {
        this.idtb_proyecto = idtb_proyecto;
        this.nombre = nombre;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.tarea = tarea;
        this.tarea_descripcion = tarea_descripcion;
        this.checklist = checklist;
        this.administrador = administrador;
        this.cliente = cliente;
        this.programador = programador;
    }

    public int getIdtb_proyecto() {
        return idtb_proyecto;
    }

    public void setIdtb_proyecto(int idtb_proyecto) {
        this.idtb_proyecto = idtb_proyecto;
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

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getTarea_descripcion() {
        return tarea_descripcion;
    }

    public void setTarea_descripcion(String tarea_descripcion) {
        this.tarea_descripcion = tarea_descripcion;
    }

    public String getChecklist() {
        return checklist;
    }

    public void setChecklist(String checklist) {
        this.checklist = checklist;
    }

    public Persona getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Persona administrador) {
        this.administrador = administrador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Persona getProgramador() {
        return programador;
    }

    public void setProgramador(Persona programador) {
        this.programador = programador;
    }

   

    

}
