/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.beans.Ciudad;
import modelo.interfaces.CiudadInterface;

/**
 *
 * @author Marco
 */
public class CiudadDAO implements CiudadInterface{
    
    /*public ArrayList<Object[]> listar(String sql, int numeroAtributos) {
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
    }*/
    
    public ArrayList<Ciudad> listarPorDepartamento(String departamento) {
        ArrayList<Ciudad> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_ciudad WHERE tb_departamento_id="+departamento+" ORDER BY nombre";
            ResultSet rs = conexion.recuperar(sql);
            
            while (rs.next()) {
                Ciudad ciudad = new Ciudad(rs.getInt(1), rs.getString(2), rs.getInt(3));
              
                listaRetorno.add(ciudad);
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
    public Ciudad buscar(int id) {
        Ciudad ciudad = null;
        try {
            String sql = "SELECT * FROM tb_ciudad where idtb_ciudad="+id;
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {             
                ciudad = new Ciudad(rs.getInt(1), rs.getString(2), rs.getInt(3));         
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return ciudad;
        }
    }

    @Override
    public ArrayList<Ciudad> listar() {
        ArrayList<Ciudad> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_ciudad";
            ResultSet rs = conexion.recuperar(sql);
            
            while (rs.next()) {
                Ciudad ciudad = new Ciudad(rs.getInt(1), rs.getString(2), rs.getInt(3));
              
                listaRetorno.add(ciudad);
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
    public boolean insertar(Ciudad ciudad) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{null, ciudad.getNombre(), ciudad.getIdtb_ciudad()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Ciudad ciudad) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, Tb_departamento_id=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{ciudad.getNombre(), ciudad.getIdtb_ciudad(), ciudad.getIdtb_ciudad()});
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
