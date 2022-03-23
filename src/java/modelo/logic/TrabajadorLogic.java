/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Trabajador;
import modelo.dao.TrabajadorDAO;
import modelo.interfaces.TrabajadorInterface;

/**
 *
 * @author ELIAS
 */
public class TrabajadorLogic implements TrabajadorInterface{
    TrabajadorDAO trabajadorDao=new TrabajadorDAO();
    @Override
    public ArrayList<Trabajador> listar() {
        return trabajadorDao.listar();
    }

    @Override
    public Trabajador buscar(int id) {
        return trabajadorDao.buscar(id);
    }

    @Override
    public boolean insertar(Trabajador trabajador) {
        return trabajadorDao.insertar(trabajador);
    }

    @Override
    public boolean editar(Trabajador trabajador) {
        return trabajadorDao.editar(trabajador);
    }

    @Override
    public boolean eliminar(int id) {
        return trabajadorDao.eliminar(id);
    }
    
}
