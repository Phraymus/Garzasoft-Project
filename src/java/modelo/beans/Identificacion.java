/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

/**
 *
 * @author ESTUDIANTE
 */
public class Identificacion {
    private int idtb_identificacion;
    private String tipo;
    private String numero;

    public Identificacion() {
    }

    public Identificacion(int idtb_identificacion, String tipo, String numero) {
        this.idtb_identificacion = idtb_identificacion;
        this.tipo = tipo;
        this.numero = numero;
    }

    public int getIdtb_identificacion() {
        return idtb_identificacion;
    }

    public void setIdtb_identificacion(int idtb_identificacion) {
        this.idtb_identificacion = idtb_identificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}
