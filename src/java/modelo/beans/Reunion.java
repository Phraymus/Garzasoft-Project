/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;


import jdk.jfr.Timestamp;

/**
 *
 * @author ELIAS
 */
public class Reunion {
    private int idtb_reuniones;
    private Timestamp fecha;
    private String asunto;
    private String link;
    private Medio medio;

    public Reunion() {
    }

    public Reunion(int idtb_reuniones, Timestamp fecha, String asunto, String link, Medio medio) {
        this.idtb_reuniones = idtb_reuniones;
        this.fecha = fecha;
        this.asunto = asunto;
        this.link = link;
        this.medio = medio;
    }

    public int getIdtb_reuniones() {
        return idtb_reuniones;
    }

    public void setIdtb_reuniones(int idtb_reuniones) {
        this.idtb_reuniones = idtb_reuniones;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Medio getMedio() {
        return medio;
    }

    public void setMedio(Medio medio) {
        this.medio = medio;
    }

    
    
}
