/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Persona;
import modelo.dao.PersonaDAO;
import modelo.interfaces.PersonaInterface;

/**
 *
 * @author Brayan
 */
public class PersonaLogic implements PersonaInterface{

    PersonaDAO personaDao= new PersonaDAO();
    
    public int getUltimoRegistro(){
        return personaDao.getUltimoRegistro();
    }
    
    @Override
    public ArrayList<Persona> listar() {
        return personaDao.listar();
    }

    @Override
    public Persona buscar(int id) {
        return personaDao.buscar(id);
    }

    @Override
    public boolean insertar(Persona persona) {
        return personaDao.insertar(persona);
    }

    @Override
    public boolean editar(Persona persona) {
        return personaDao.editar(persona);
    }

    @Override
    public boolean eliminar(int id) {
        return personaDao.eliminar(id);
    }
    
}
