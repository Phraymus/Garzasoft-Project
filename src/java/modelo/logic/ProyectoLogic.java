/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Proyecto;
import modelo.dao.ProyectoDAO;
import modelo.interfaces.ProyectoInterface;

/**
 *
 * @author ESTUDIANTE
 */
public class ProyectoLogic implements ProyectoInterface{
    
    ProyectoDAO proyectoDAO = new ProyectoDAO();

    @Override
    public ArrayList<Proyecto> listar() {
        return proyectoDAO.listar();
    }

    @Override
    public Proyecto buscar(int id) {
        return proyectoDAO.buscar(id);
    }

    @Override
    public boolean insertar(Proyecto proyecto) {
        return proyectoDAO.insertar(proyecto);
    }

    @Override
    public boolean editar(Proyecto proyecto) {
        return proyectoDAO.editar(proyecto);
    }

    @Override
    public boolean eliminar(int id) {
        return proyectoDAO.eliminar(id);
    }
    
}
