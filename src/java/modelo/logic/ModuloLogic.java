
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Modulo;
import modelo.beans.Proyecto;
import modelo.dao.ModuloDAO;
import modelo.interfaces.ModuloInterface;

/**
 *
 * @author ELIAS
 */
public class ModuloLogic implements ModuloInterface {

    ModuloDAO moduloDao = new ModuloDAO();
    ProyectoLogic proyectoLogic = new ProyectoLogic();

    public ArrayList<Modulo> listarPorProyecto(int id) {
        return moduloDao.listarPorProyecto(id);
    }

    public boolean editarEstado(Modulo modulo) {
        Proyecto proyecto = proyectoLogic.buscar(modulo.getTb_proyecto_id());
        moduloDao.editarEstado(modulo);
        System.out.println(estaLleno(modulo));
        if (estaLleno(modulo)) {
            proyecto.setEstado("F");
            return proyectoLogic.editarEstado(proyecto);
        } else {
            proyecto.setEstado("E");
            return proyectoLogic.editarEstado(proyecto);
        }
    }

    public boolean estaLleno(Modulo modulo) {
        return moduloDao.estaLleno(modulo);
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
