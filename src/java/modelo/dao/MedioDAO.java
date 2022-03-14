/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import modelo.beans.Medio;
import java.sql.ResultSet;
import modelo.interfaces.MedioInterface;

/**
 *
 * @author Brayan Carrasco
 */
public class MedioDAO implements MedioInterface{

    @Override
    public ArrayList<Medio> listar() {
        ArrayList<Medio> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
                Medio medio = new Medio();

                medio.setIdtb_medio(rs.getInt(1));
                medio.setNombre(rs.getString(2));

                listaRetorno.add(medio);
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
    public Medio buscar(int id) {
        Medio medio = null;
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql, TABLA, CLAVE_PRIMARIA, id));
            while (rs.next()) {
                medio.setIdtb_medio(rs.getInt(1));
                medio.setNombre(rs.getString(2));
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return medio;
        }
    }

    @Override
    public boolean insertar(Medio medio) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{medio.getIdtb_medio(), medio.getNombre()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Medio medio) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET ruc=?, nombre_empresa=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{medio.getIdtb_medio(), medio.getNombre()});
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
