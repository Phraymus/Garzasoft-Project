/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.beans.Usuario;
import modelo.interfaces.UsuarioInterface;

/**
 *
 * @author ESTUDIANTE
 */
public class UsuarioDAO implements UsuarioInterface{

    @Override
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> listaRetorno = new ArrayList<>();
        try {
            String sql = "Select * from tb_usuario";
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                listaRetorno.add(usuario);
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return listaRetorno;
        }
    }

    @Override
    public Usuario buscar(int id) {
        Usuario usuario = null;
        try {
            String sql = "Select * from tb_usuario where idtb_ususario ="+id;
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return usuario;
        }
    }

    @Override
    public boolean insertar(Usuario usuario) {
        try{
            return conexion.ejecutar(String.format("INSERT INTO %s VALUES(?,?,?,?,?,?)", TABLA), new Object[]
                {null, usuario.getNombre(), usuario.getClave(), usuario.getPerfil_usuario(), usuario.getTb_trabajador_id(), usuario.getTb_cliente_id()});
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Usuario usuario) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET idtb_usuario=?, nombre=? clave=?, perfil_usuario=?, tb_persona_id=? , tb_persona_idc=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{usuario.getIdtb_usuario() ,usuario.getNombre(), usuario.getClave(), usuario.getPerfil_usuario(), usuario.getTb_trabajador_id(), usuario.getTb_cliente_id(), usuario.getIdtb_usuario()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        try {
            return conexion.ejecutar(String.format("DELETE FROM %s WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{id});
        } catch (Exception ex) {
            return false;
        }
    }
    
}
