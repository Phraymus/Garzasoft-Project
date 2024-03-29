/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Proyecto;
import modelo.dao.ProyectoDAO;
import modelo.interfaces.ProyectoInterface;

/**
 *
 * @author phraymus
 */
public class ProyectoLogic implements ProyectoInterface{

    ProyectoDAO proyectoDao= new ProyectoDAO();
    
    public ArrayList<Proyecto> listarProyectoCliente(int id) {
        return proyectoDao.listarProyectoCliente(id);
    }
    public ArrayList<Proyecto> listarProyectoTrabajador(int id) {
        return proyectoDao.listarProyectoTrabajador(id);
    }
    
    public boolean editarEstado(Proyecto proyecto){
        return proyectoDao.editarEstado(proyecto);
    }
    
    public int porcentajeAvance(Proyecto proyecto){
        return proyectoDao.porcentajeAvance(proyecto);
    }
    @Override
    public ArrayList<Proyecto> listar() {
        return proyectoDao.listar();
    }

    @Override
    public Proyecto buscar(int id) {
        return proyectoDao.buscar(id);
    }

    @Override
    public boolean insertar(Proyecto proyecto) {
        return proyectoDao.insertar(proyecto);
    }

    @Override
    public boolean editar(Proyecto proyecto) {
        return proyectoDao.editar(proyecto);
    }

    @Override
    public boolean eliminar(int id) {
        return proyectoDao.eliminar(id);
    }
    
}
