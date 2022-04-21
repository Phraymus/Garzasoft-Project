/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Modulo;
import modelo.beans.Requerimiento;
import modelo.dao.ModuloDAO;
import modelo.dao.RequerimientoDAO;
import modelo.interfaces.RequerimientoInterface;

/**
 *
 * @author ELIAS
 */
public class RequerimientoLogic implements RequerimientoInterface {

    RequerimientoDAO requerimientoDao = new RequerimientoDAO();
    ModuloLogic moduloLogic = new ModuloLogic();

    public ArrayList<Requerimiento> listarPorModulo(int id) {
        return requerimientoDao.listarPorModulo(id);
    }

    public boolean editarEstado(Requerimiento requerimiento) {
        Modulo modulo = moduloLogic.buscar(requerimiento.getTb_modulo_id());
        requerimientoDao.editarEstado(requerimiento);
        System.out.println(estaLleno(requerimiento));

        if (estaLleno(requerimiento)) {
            modulo.setEstado("F");
            return moduloLogic.editarEstado(modulo);
        } else {
            modulo.setEstado("E");
            return moduloLogic.editarEstado(modulo);
        }
    }

    public boolean estaLleno(Requerimiento requerimiento) {
        return requerimientoDao.estaLleno(requerimiento);
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
