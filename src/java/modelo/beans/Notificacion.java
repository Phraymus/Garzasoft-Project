/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;
import java.sql.Timestamp;

/**
 *
 * @author phraymus
 */
public class Notificacion {
    private int idtb_notificacion;
    private int tb_usuario_id;
    private String titulo;
    private String descripcion_corta;
    private String descripcion_larga;
    private String tipo;
    private String color;
    private Timestamp fecha;

    public Notificacion() {
    }

    public Notificacion(int idtb_notificacion, int tb_usuario_id, String titulo, String descripcion_corta, String descripcion_larga, String tipo, String color, Timestamp fecha) {
        this.idtb_notificacion = idtb_notificacion;
        this.tb_usuario_id = tb_usuario_id;
        this.titulo = titulo;
        this.descripcion_corta = descripcion_corta;
        this.descripcion_larga = descripcion_larga;
        this.tipo = tipo;
        this.color = color;
        this.fecha = fecha;
    }

    public int getIdtb_notificacion() {
        return idtb_notificacion;
    }

    public void setIdtb_notificacion(int idtb_notificacion) {
        this.idtb_notificacion = idtb_notificacion;
    }

    public int getTb_usuario_id() {
        return tb_usuario_id;
    }

    public void setTb_usuario_id(int tb_usuario_id) {
        this.tb_usuario_id = tb_usuario_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion_corta() {
        return descripcion_corta;
    }

    public void setDescripcion_corta(String descripcion_corta) {
        this.descripcion_corta = descripcion_corta;
    }

    public String getDescripcion_larga() {
        return descripcion_larga;
    }

    public void setDescripcion_larga(String descripcion_larga) {
        this.descripcion_larga = descripcion_larga;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
    
}
