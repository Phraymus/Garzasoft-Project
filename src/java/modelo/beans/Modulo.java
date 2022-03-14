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
    public int idtb_modulo;
    public String nombre;
    public char estado;
    public int tb_proyecto_id;

    public Modulo() {
    }

    public Modulo(int idtb_modulo, String nombre, char estado, int tb_proyecto_id) {
        this.idtb_modulo = idtb_modulo;
        this.nombre = nombre;
        this.estado = estado;
        this.tb_proyecto_id = tb_proyecto_id;
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

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getTb_proyecto_id() {
        return tb_proyecto_id;
    }

    public void setTb_proyecto_id(int tb_proyecto_id) {
        this.tb_proyecto_id = tb_proyecto_id;
    }
  
    
}
