/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Trabajador;
import modelo.beans.UsuarioReunion;

/**
 *
 * @author ELIAS
 */
public interface UsuarioReunionInterface {
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_usuarioreunion";
    final String ATRIBUTOS[] = {"tb_reunion_id","tb_usuario_id"};
    final String CLAVE_PRIMARIA = "tb_reunion_id","tb_usuario_id";
    
    public ArrayList<UsuarioReunion> listar();
    public UsuarioReunion buscar(int id);
    public boolean insertar(UsuarioReunion usuarioreunion);
    public boolean editar(UsuarioReunion usuarioreunion);
    public boolean eliminar(int id);
}
