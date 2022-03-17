/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

/**
 *
 * @author Brayan Carrasco
 */
public class Telefono {
    private int idtb_telefono;
    private String numero;
    private Persona persona;

    public Telefono() {
    }

    public Telefono(int idtb_telefono, String numero, Persona persona) {
        this.idtb_telefono = idtb_telefono;
        this.numero = numero;
        this.persona = persona;
    }

    public int getIdtb_telefono() {
        return idtb_telefono;
    }

    public void setIdtb_telefono(int idtb_telefono) {
        this.idtb_telefono = idtb_telefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
