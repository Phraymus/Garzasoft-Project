/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Trabajador;

/**
 *
 * @author Brayan
 */
public interface TrabajadorInterface {
    
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_trabajador";
    final String ATRIBUTOS[] = {"tb_persona_id", "tipo"};
    final String CLAVE_PRIMARIA = "tb_persona_id";
    
    public ArrayList<Trabajador> listar();
    public Trabajador buscar(int id);
    public boolean insertar(Trabajador cliente);
    public boolean editar(Trabajador cliente);
    public boolean eliminar(int id);
}
