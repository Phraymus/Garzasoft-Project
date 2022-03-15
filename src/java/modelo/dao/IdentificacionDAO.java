/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.beans.Identificacion;
import modelo.interfaces.IdentificacionInterface;

/**
 *
 * @author ESTUDIANTE
 */
public class IdentificacionDAO implements IdentificacionInterface{
    
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
    public Identificacion buscar(int id) {
        Identificacion identificacion = null;
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql, TABLA, CLAVE_PRIMARIA, id));
            while (rs.next()) {
                identificacion.setIdtb_identificacion(rs.getInt(1));
                identificacion.setNumero(rs.getString(2));
                identificacion.setTipo(rs.getString(3));
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return identificacion;
        }
    }
    
    @Override
    public ArrayList<Identificacion> listar() {
        ArrayList<Identificacion> listaRetorno = new ArrayList<>();
        
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
                Identificacion  identificacion = new Identificacion();

                identificacion.setIdtb_identificacion(rs.getInt(1));
                identificacion.setNumero(rs.getString(2));
                identificacion.setTipo(rs.getInt(3));

                listaRetorno.add(identificacion);
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        }finally {
            return listaRetorno;
        }
        
    }

    @Override
    public boolean insertar(Identificacion identificacion) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{null, identificacion.getNumero(), identificacion.getTipo()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Identificacion identificacion) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET tipo=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{identificacion.getIdtb_identificacion(), identificacion.getNumero(), identificacion.getTipo()});
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
