/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Notificacion;
import modelo.beans.Usuario;
import modelo.dao.NotificacionDAO;
import modelo.interfaces.NotificacionInterface;

/**
 *
 * @author phraymus
 */
public class NotificacionLogic implements NotificacionInterface {

    NotificacionDAO notificacionDAO = new NotificacionDAO();

    @Override
    public ArrayList<Notificacion> listarPorUsuario(Usuario usuario) {
        return notificacionDAO.listarPorUsuario(usuario);
    }

    @Override
    public ArrayList<Notificacion> listar() {
        return notificacionDAO.listar();
    }

    @Override
    public Notificacion buscar(int id) {
        return notificacionDAO.buscar(id);
    }

    @Override
    public boolean insertar(Notificacion notificacion) {
        return notificacionDAO.insertar(notificacion);
    }

    @Override
    public boolean editar(Notificacion notificacion) {
        return notificacionDAO.editar(notificacion);
    }

    @Override
    public boolean eliminar(int id) {
        return notificacionDAO.eliminar(id);
    }

}
