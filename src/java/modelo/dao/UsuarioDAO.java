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
public class UsuarioDAO implements UsuarioInterface {

    public Usuario autentificar(String nombre, String clave) {
        Usuario retorno = null;
        try {
            String sql = String.format("SELECT idtb_usuario, nombre, perfil_usuario, tb_persona_id, tb_persona_idc FROM %s WHERE nombre='%s' AND clave='%s'", TABLA, nombre,clave);
            
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                retorno= new Usuario();
                
                retorno.setIdtb_usuario(rs.getInt(1));
                retorno.setNombre(rs.getString(2));
                retorno.setPerfil_usuario(rs.getString(3));
                retorno.setTb_trabajador_id(rs.getInt(4));
                retorno.setTb_cliente_idc(rs.getInt(5));
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return retorno;
        }
    }

    public ArrayList<Usuario> listarUsuariosTrabajadores() {
        ArrayList<Usuario> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT * from tb_usuario WHERE perfil_usuario='T'";
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), (rs.getString(5) != null) ? rs.getInt(5) : 0, (rs.getString(6) != null) ? rs.getInt(6) : 0);
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
    
    public ArrayList<Usuario> listarUsuariosClientes() {
        ArrayList<Usuario> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT * from tb_usuario WHERE perfil_usuario='C'";
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), (rs.getString(5) != null) ? rs.getInt(5) : 0, (rs.getString(6) != null) ? rs.getInt(6) : 0);
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

    public int buscar(String nombre) {
        int retorno = -1;
        try {
            String sql = String.format("SELECT idtb_usuario FROM %s WHERE nombre='%s'", TABLA, nombre);

            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                retorno = rs.getInt(1);
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return retorno;
        }
    }
    
    public Usuario buscarTrabajador(int id) {
        Usuario usuario = null;
        try {
            String sql = "Select * from tb_usuario where tb_persona_id=" + id;
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
    
    public Usuario buscarCliente(int id) {
        Usuario usuario = null;
        try {
            String sql = "Select * from tb_usuario where tb_persona_idc=" + id;
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
            String sql = "Select * from tb_usuario where idtb_usuario =" + id;
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
        try {
            return conexion.ejecutar(String.format("INSERT INTO %s VALUES(?,?,?,?,?,?)", TABLA), new Object[]{null, usuario.getNombre(), usuario.getClave(), usuario.getPerfil_usuario(), (usuario.getTb_trabajador_id() != 0) ? usuario.getTb_trabajador_id() : null, (usuario.getTb_cliente_idc() != 0) ? usuario.getTb_cliente_idc() : null});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Usuario usuario) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET idtb_usuario=?, nombre=? clave=?, perfil_usuario=?, tb_persona_id=? , tb_persona_idc=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{usuario.getIdtb_usuario(), usuario.getNombre(), usuario.getClave(), usuario.getPerfil_usuario(), usuario.getTb_trabajador_id(), usuario.getTb_cliente_idc(), usuario.getIdtb_usuario()});
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
