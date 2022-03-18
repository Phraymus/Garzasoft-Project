/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Usuario;

/**
 *
 * @author ESTUDIANTE
 */
public interface UsuarioInterface {
    final Conexion conexion = new Conexion();
    final String TABLA = "tb_usuario";
    final String ATRIBUTOS[] = {"idtb_usuario", "nombre", "clave", "perfil_usuario_id", "tb_persona_id", "tb_persona_idc"};
    final String CLAVE_PRIMARIA = "idtb_usuario";
    
    public ArrayList<Usuario> listar();
    public Usuario buscar(int id);
    public boolean insertar(Usuario usuario);
    public boolean editar(Usuario usuario);
    public boolean eliminar(int id);
}
