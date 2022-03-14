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
    public int idtb_proyecto;
    public String nombre;
    public char estado;
    public Timestamp fecha_inicio;
    public Timestamp fecha_fin;
    public String tarea;
    public String tarea_descripcion;
    public String checklist;
    public int tb_trabjador_id;
    public int tb_cliente_id;

    public Proyecto() {
    }

    public Proyecto(int idtb_proyecto, String nombre, char estado, Timestamp fecha_inicio, Timestamp fecha_fin, String tarea, String tarea_descripcion, String checklist, int tb_trabjador_id, int tb_cliente_id) {
        this.idtb_proyecto = idtb_proyecto;
        this.nombre = nombre;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.tarea = tarea;
        this.tarea_descripcion = tarea_descripcion;
        this.checklist = checklist;
        this.tb_trabjador_id = tb_trabjador_id;
        this.tb_cliente_id = tb_cliente_id;
    }

    public String getTarea_descripcion() {
        return tarea_descripcion;
    }

    public void setTarea_descripcion(String tarea_descripcion) {
        this.tarea_descripcion = tarea_descripcion;
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

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
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

    public String getChecklist() {
        return checklist;
    }

    public void setChecklist(String checklist) {
        this.checklist = checklist;
    }

    public int getTb_trabjador_id() {
        return tb_trabjador_id;
    }

    public void setTb_trabjador_id(int tb_trabjador_id) {
        this.tb_trabjador_id = tb_trabjador_id;
    }

    public int getTb_cliente_id() {
        return tb_cliente_id;
    }

    public void setTb_cliente_id(int tb_cliente_id) {
        this.tb_cliente_id = tb_cliente_id;
    }


}
