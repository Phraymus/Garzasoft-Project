/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.UsuarioReunion;
import modelo.dao.UsuarioReunionDAO;
import modelo.interfaces.UsuarioReunionInterface;

/**
 *
 * @author ELIAS
 */
public class UsuarioReunionLogic implements UsuarioReunionInterface{
    UsuarioReunionDAO usuarioreunionDao=new UsuarioReunionDAO();
    @Override
    public ArrayList<UsuarioReunion> listar() {
        return usuarioreunionDao.listar();
    }

    @Override
    public UsuarioReunion buscar(int id) {
        return usuarioreunionDao.buscar(id);
    }

    @Override
    public boolean insertar(UsuarioReunion usuarioreunion) {
        return usuarioreunionDao.insertar(usuarioreunion);
    }

    @Override
    public boolean editar(UsuarioReunion usuarioreunion) {
        return usuarioreunionDao.editar(usuarioreunion);
    }

    @Override
    public boolean eliminar(int id) {
        return usuarioreunionDao.eliminar(id);
    }
    
}
