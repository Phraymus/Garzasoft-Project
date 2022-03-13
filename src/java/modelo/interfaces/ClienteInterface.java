/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Cliente;

/**
 *
 * @author Brayan Carrasco
 */
public interface ClienteInterface {
    
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_cliente";
    final String ATRIBUTOS[] = {"tb_persona_id", "ruc", "nombre_empresa"};
    final String CLAVE_PRIMARIA = "tb_persona_id";
    
    public ArrayList<Cliente> listar();
    public Cliente buscar(int id);
    public boolean insertar(Cliente cliente);
    public boolean editar(Cliente cliente);
    public boolean eliminar(int id);
}
