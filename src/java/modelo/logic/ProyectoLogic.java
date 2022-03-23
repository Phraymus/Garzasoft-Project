/*
<<<<<<< HEAD
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
=======
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
>>>>>>> 7a390d6eba9475fbd816364f97e64589a8276843
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Proyecto;
<<<<<<< HEAD
=======
import modelo.dao.ProyectoDAO;
>>>>>>> 7a390d6eba9475fbd816364f97e64589a8276843
import modelo.interfaces.ProyectoInterface;

/**
 *
<<<<<<< HEAD
 * @author Windows10
 */
public class ProyectoLogic implements ProyectoInterface {

    @Override
    public ArrayList<Proyecto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
=======
 * @author ESTUDIANTE
 */
public class ProyectoLogic implements ProyectoInterface{
    
    ProyectoDAO proyectoDAO = new ProyectoDAO();

    @Override
    public ArrayList<Proyecto> listar() {
        return proyectoDAO.listar();
>>>>>>> 7a390d6eba9475fbd816364f97e64589a8276843
    }

    @Override
    public Proyecto buscar(int id) {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
=======
        return proyectoDAO.buscar(id);
>>>>>>> 7a390d6eba9475fbd816364f97e64589a8276843
    }

    @Override
    public boolean insertar(Proyecto proyecto) {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
=======
        return proyectoDAO.insertar(proyecto);
>>>>>>> 7a390d6eba9475fbd816364f97e64589a8276843
    }

    @Override
    public boolean editar(Proyecto proyecto) {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
=======
        return proyectoDAO.editar(proyecto);
>>>>>>> 7a390d6eba9475fbd816364f97e64589a8276843
    }

    @Override
    public boolean eliminar(int id) {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
=======
        return proyectoDAO.eliminar(id);
>>>>>>> 7a390d6eba9475fbd816364f97e64589a8276843
    }
    
}
