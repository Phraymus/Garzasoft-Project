/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Pais;
import modelo.dao.PaisDAO;
import modelo.interfaces.PaisInterface;

/**
 *
 * @author Brayan Carrasco
 */
public class PaisLogic implements PaisInterface{
    
    PaisDAO paisDao= new PaisDAO();
    @Override
    public ArrayList<Pais> listar() {
        return paisDao.listar();
    }

    @Override
    public Pais buscar(int id) {
        return paisDao.buscar(id);
    }

    @Override
    public boolean insertar(Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean editar(Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
