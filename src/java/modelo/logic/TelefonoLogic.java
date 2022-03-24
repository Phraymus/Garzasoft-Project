/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Telefono;
import modelo.dao.TelefonoDAO;
import modelo.interfaces.TelefonoInterface;

/**
 *
 * @author Brayan Carrasco
 */
public class TelefonoLogic implements TelefonoInterface{
    
    TelefonoDAO telefonoDao = new TelefonoDAO();
    
    @Override
    public ArrayList<Telefono> listar() {
        return telefonoDao.listar();
    }

    @Override
    public Telefono buscar(int id) {
        return telefonoDao.buscar(id);
    }

    @Override
    public boolean insertar(Telefono telefono) {
        return telefonoDao.insertar(telefono);
    }

    @Override
    public boolean editar(Telefono telefono) {
        return telefonoDao.editar(telefono);
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
