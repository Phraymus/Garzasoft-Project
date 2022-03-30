
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Modulo;
import modelo.dao.ModuloDAO;
import modelo.interfaces.ModuloInterface;

/**
 *
 * @author ELIAS
 */
public class ModuloLogic  implements ModuloInterface{
    ModuloDAO moduloDao=new ModuloDAO();
    
    public ArrayList<Modulo> listarPorProyecto(int id) {
        return moduloDao.listarPorProyecto(id);
    }
    @Override
    public ArrayList<Modulo> listar() {
        return moduloDao.listar();
    }

    @Override
    public Modulo buscar(int id) {
        return moduloDao.buscar(id);
    }

    @Override
    public boolean insertar(Modulo modulo) {
        return moduloDao.insertar(modulo);
    }

    @Override
    public boolean editar(Modulo modulo) {
        return moduloDao.editar(modulo);
    }

    @Override
    public boolean eliminar(int id) {
        return moduloDao.eliminar(id);
    }
    
}
