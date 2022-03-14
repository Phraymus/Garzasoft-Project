/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.beans.UsuarioReunion;
import modelo.interfaces.UsuarioReunionInterface;

/**
 *
 * @author ELIAS
 */
public class UsuarioReunionDAO implements UsuarioReunionInterface{
    
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

    public UsuarioReunion buscar(int id) {
        UsuarioReunion usuarioreunion = null;
        try {
            String sql="SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql=(i==ATRIBUTOS.length-1)?sql+ATRIBUTOS[i]+", ":sql+ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql,TABLA,CLAVE_PRIMARIA,id));
            while (rs.next()) {
                usuarioreunion.setTb_reunion_id(rs.getInt(1));
                usuarioreunion.setTb_usuario_id(rs.getInt(2));
               
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return usuarioreunion;
        }
    }
     @Override
    public ArrayList<UsuarioReunion> listar() {
        ArrayList<UsuarioReunion> listaRetorno = new ArrayList<>();
        try {
            String sql="SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql=(i==ATRIBUTOS.length-1)?sql+ATRIBUTOS[i]+", ":sql+ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s",sql,TABLA));
            while (rs.next()) {
                UsuarioReunion usuarioreunion = new UsuarioReunion();
                usuarioreunion.setTb_reunion_id(rs.getInt(1));
                usuarioreunion.setTb_usuario_id(rs.getInt(2));
                
                listaRetorno.add(usuarioreunion);
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
    public boolean insertar(UsuarioReunion usuarioreunion) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?)", TABLA), new Object[]{usuarioreunion.getTb_reunion_id(), usuarioreunion.getTb_usuario_id()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(UsuarioReunion usuarioreunion) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET tipo=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{usuarioreunion.getTb_reunion_id(), usuarioreunion.getTb_usuario_id()});
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
