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
    
    public ArrayList<Object[]> listar(String sql, int numeroAtributos) {
        return personaDao.listar(sql, numeroAtributos);
    }
    @Override
    public ArrayList<Persona> listar() {
        return personaDao.listar();
    }

    @Override
    public Persona buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
