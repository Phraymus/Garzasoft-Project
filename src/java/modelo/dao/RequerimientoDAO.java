/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import jdk.jfr.Timestamp;
import modelo.beans.Requerimiento;
import modelo.interfaces.RequerimientoInterface;

/**
 *
 * @author Windows10
 */
public class RequerimientoDAO implements RequerimientoInterface{

    public ArrayList<Object[]> listar(String sql, int numeroAtributos) {
        ArrayList<Object[]> listaRetorno = new ArrayList<>();
        try {
            ResultSet rset = conexion.recuperar(sql);
            while (rset.next()) {
                Object atributos[] = new Object[numeroAtributos];
                for (int i = 0; i < numeroAtributos; i++) {
                    atributos[i] = rset.getObject(i + 1);
                }
                listaRetorno.add(atributos);
            }
            rset.close();
            conexion.cerrar();

        } catch (Exception ex) {
            throw ex;
        } finally {
            return listaRetorno;
        }
    }

    @Override
    public Requerimiento buscar(int id) {
        Requerimiento  requerimiento = null;
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql, TABLA, CLAVE_PRIMARIA, id));
            while (rs.next()) {
                requerimiento.setIdtb_checklist(rs.getInt(1));
                requerimiento.setNombre(rs.getString(2));
                requerimiento.setEstado(String.valueOf(rs.getString(3)).charAt(0));
                requerimiento.setFecha_inicio((Timestamp) rs.getTimestamp(4));
                requerimiento.setFecha_fin((Timestamp) rs.getTimestamp(5));
                requerimiento.setModulo_id(rs.getInt(6));               

            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return requerimiento;
        }
    }

    @Override
    public ArrayList<Requerimiento> listar() {
        ArrayList<Requerimiento> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
                Requerimiento  requerimiento = new Requerimiento();

                requerimiento.setIdtb_checklist(rs.getInt(1));
                requerimiento.setNombre(rs.getString(2));
                requerimiento.setEstado(String.valueOf(rs.getString(3)).charAt(0));
                requerimiento.setFecha_inicio((Timestamp) rs.getTimestamp(4));
                requerimiento.setFecha_fin((Timestamp) rs.getTimestamp(5));
                requerimiento.setModulo_id(rs.getInt(6));

                listaRetorno.add(requerimiento);
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
    public boolean insertar(Requerimiento requerimiento) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{null,  
            requerimiento.getNombre(), requerimiento.getEstado() ,requerimiento.getFecha_inicio(),
            requerimiento.getFecha_fin(), requerimiento.getModulo_id()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Requerimiento requerimiento) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, tb_pais_id()=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{
            requerimiento.getNombre(), requerimiento.getEstado() ,requerimiento.getFecha_inicio(),
            requerimiento.getFecha_fin(), requerimiento.getModulo_id()});
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
