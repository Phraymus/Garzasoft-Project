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
    
     public ArrayList<Object[]> listar(String sql, int numeroAtributos) {
        ArrayList<Object[]> listaRetorno = new ArrayList<>();
        try {
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Object atributos[] = new Object[numeroAtributos];
                for (int i = 0; i < numeroAtributos; i++) {
                    atributos[i] = rs.getObject(i + 1);
                }
                listaRetorno.add(atributos);
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
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
                Usuario  usuario = new Usuario();

                usuario.setIdtb_usuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setClave(rs.getString(3));
                usuario.setTb_perfil_usuario_id(rs.getInt(4));
                usuario.setTb_trabajador_id(rs.getInt(5));
                usuario.setTb_cliente_id(rs.getInt(6));

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
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql, TABLA, CLAVE_PRIMARIA, id));
            while (rs.next()) {
                usuario.setIdtb_usuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setClave(rs.getString(3));
                usuario.setTb_perfil_usuario_id(rs.getInt(4));
                usuario.setTb_trabajador_id(rs.getInt(5));
                usuario.setTb_cliente_id(rs.getInt(6));
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
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?,?,?,?)", TABLA), new Object[]
                {null, usuario.getNombre(), usuario.getClave(), usuario.getTb_perfil_usuario_id(), usuario.getTb_trabajador_id(), usuario.getTb_cliente_id()});
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Usuario usuario) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{null, usuario.getNombre(), usuario.getClave(), usuario.getTb_perfil_usuario_id(), usuario.getTb_trabajador_id(), usuario.getTb_cliente_id()});
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
