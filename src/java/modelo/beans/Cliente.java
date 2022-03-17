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
public class Cliente {

    private Persona persona;
    private String ruc;
    private String nombreEmpresa;

    public Cliente() {
    }

    public Cliente(Persona persona, String ruc, String nombreEmpresa) {
        this.persona = persona;
        this.ruc = ruc;
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
