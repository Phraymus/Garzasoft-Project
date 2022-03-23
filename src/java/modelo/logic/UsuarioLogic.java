/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Usuario;
import modelo.dao.UsuarioDAO;
import modelo.interfaces.UsuarioInterface;

/**
 *
 * @author ESTUDIANTE
 */
public class UsuarioLogic implements UsuarioInterface{
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    public ArrayList<Usuario> listar() {
        return usuarioDAO.listar();
    }

    @Override
    public Usuario buscar(int id) {
        return usuarioDAO.buscar(id);
    }

    @Override
    public boolean insertar(Usuario usuario) {
        return usuarioDAO.insertar(usuario);
    }

    @Override
    public boolean editar(Usuario usuario) {
        return usuarioDAO.editar(usuario);
    }

    @Override
    public boolean eliminar(int id) {
        return usuarioDAO.eliminar(id);
    }
    
}
