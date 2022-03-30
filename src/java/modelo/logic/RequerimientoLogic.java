/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Requerimiento;
import modelo.dao.RequerimientoDAO;
import modelo.interfaces.RequerimientoInterface;

/**
 *
 * @author ELIAS
 */
public class RequerimientoLogic implements RequerimientoInterface{
    RequerimientoDAO requerimientoDao=new RequerimientoDAO();
    
    public ArrayList<Requerimiento> listarPorModulo(int id) {
        return requerimientoDao.listarPorModulo(id);
    }
    
    public boolean editarEstado(Requerimiento requerimiento) {
        return requerimientoDao.editarEstado(requerimiento);
    }
    
    @Override
    public ArrayList<Requerimiento> listar() {
        return requerimientoDao.listar();
    }

    @Override
    public Requerimiento buscar(int id) {
        return requerimientoDao.buscar(id);
    }

    @Override
    public boolean insertar(Requerimiento requerimiento) {
        return requerimientoDao.insertar(requerimiento);
    }

    @Override
    public boolean editar(Requerimiento requerimiento) {
        return requerimientoDao.editar(requerimiento);
    }

    @Override
    public boolean eliminar(int id) {
        return requerimientoDao.eliminar(id);
    }
    
}
