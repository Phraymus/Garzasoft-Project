/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;


import java.sql.Timestamp;
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
    private String nombre_empresa;
    private String ruc;
    private int tb_trabajador_persona_id;
    private int tb_cliente_persona_id;
    private int tb_trabajador_persona_id1;

    public Proyecto() {
    }

    public Proyecto(int idtb_proyecto, String nombre, String estado, Timestamp fecha_inicio, Timestamp fecha_fin, String tarea, String tarea_descripcion, String checklist, String nombre_empresa, String ruc, int tb_trabajador_persona_id, int tb_cliente_persona_id, int tb_trabajador_persona_id1) {
        this.idtb_proyecto = idtb_proyecto;
        this.nombre = nombre;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.tarea = tarea;
        this.tarea_descripcion = tarea_descripcion;
        this.checklist = checklist;
        this.nombre_empresa = nombre_empresa;
        this.ruc = ruc;
        this.tb_trabajador_persona_id = tb_trabajador_persona_id;
        this.tb_cliente_persona_id = tb_cliente_persona_id;
        this.tb_trabajador_persona_id1 = tb_trabajador_persona_id1;
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

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public int getTb_trabajador_persona_id() {
        return tb_trabajador_persona_id;
    }

    public void setTb_trabajador_persona_id(int tb_trabajador_persona_id) {
        this.tb_trabajador_persona_id = tb_trabajador_persona_id;
    }

    public int getTb_cliente_persona_id() {
        return tb_cliente_persona_id;
    }

    public void setTb_cliente_persona_id(int tb_cliente_persona_id) {
        this.tb_cliente_persona_id = tb_cliente_persona_id;
    }

    public int getTb_trabajador_persona_id1() {
        return tb_trabajador_persona_id1;
    }

    public void setTb_trabajador_persona_id1(int tb_trabajador_persona_id1) {
        this.tb_trabajador_persona_id1 = tb_trabajador_persona_id1;
    }

    

}
