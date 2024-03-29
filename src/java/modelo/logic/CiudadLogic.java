/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Ciudad;
import modelo.dao.CiudadDAO;
import modelo.interfaces.CiudadInterface;

/**
 *
 * @author phraymus
 */
public class CiudadLogic implements CiudadInterface{
    
    CiudadDAO ciudadDao= new CiudadDAO();
    
    
    public ArrayList<Ciudad> listarPorDepartamento(String departamento) {
        return ciudadDao.listarPorDepartamento(departamento);
    }
    
    @Override
    public ArrayList<Ciudad> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ciudad buscar(int id) {
        return ciudadDao.buscar(id);
    }

    @Override
    public boolean insertar(Ciudad ciudad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean editar(Ciudad ciudad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
