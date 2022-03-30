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

    private int idtb_requerimiento;
    private String nombre;
    private String estado;
    private Timestamp fecha_inicio;
    private Timestamp fecha_fin;
    private int tb_modulo_id;

    public Requerimiento() {
    }

    public Requerimiento(int idtb_requerimiento, String nombre, String estado, Timestamp fecha_inicio, Timestamp fecha_fin, int tb_modulo_id) {
        this.idtb_requerimiento = idtb_requerimiento;
        this.nombre = nombre;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.tb_modulo_id = tb_modulo_id;
    }

    public int getIdtb_requerimiento() {
        return idtb_requerimiento;
    }

    public void setIdtb_requerimiento(int idtb_requerimiento) {
        this.idtb_requerimiento = idtb_requerimiento;
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

    public int getTb_modulo_id() {
        return tb_modulo_id;
    }

    public void setTb_modulo_id(int tb_modulo_id) {
        this.tb_modulo_id = tb_modulo_id;
    }

    
    
}
