/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Reunion;
import modelo.dao.ReunionDAO;
import modelo.interfaces.ReunionInterface;

/**
 *
 * @author ELIAS
 */
public class ReunionLogic implements  ReunionInterface{
    ReunionDAO reunionDao=new ReunionDAO();
    @Override
    public ArrayList<Reunion> listar() {
        return reunionDao.listar();
    }

    @Override
    public Reunion buscar(int id) {
        return reunionDao.buscar(id);
    }

    @Override
    public boolean insertar(Reunion reunion) {
        return reunionDao.insertar(reunion);
    }

    @Override
    public boolean editar(Reunion reunion) {
        return reunionDao.editar(reunion);
    }

    @Override
    public boolean eliminar(int id) {
        return reunionDao.eliminar(id);
    }
    
}
