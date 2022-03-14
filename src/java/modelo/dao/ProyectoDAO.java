/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import jdk.jfr.Timestamp;
import modelo.beans.Proyecto;
import modelo.interfaces.ProyectoInterface;

/**
 *
 * @author Sttefany
 */
public class ProyectoDAO implements ProyectoInterface{
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
    public Proyecto buscar(int id) {
        Proyecto  proyecto = null;
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql, TABLA, CLAVE_PRIMARIA, id));
            while (rs.next()) {
                proyecto.setIdtb_proyecto(rs.getInt(1));
                proyecto.setNombre(rs.getString(2));
                proyecto.setEstado(String.valueOf(rs.getString(3)).charAt(0));
                proyecto.setFecha_inicio((Timestamp) rs.getTimestamp(4));
                proyecto.setFecha_fin((Timestamp) rs.getTimestamp(5));
                proyecto.setTarea(rs.getString(6));
                proyecto.setTarea_descripcion(rs.getString(7));
                proyecto.setChecklist(rs.getString(8));
                proyecto.setTb_trabjador_id(rs.getInt(9));
                proyecto.setTb_cliente_id(rs.getInt(10));

            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return proyecto;
        }
    }

    @Override
    public ArrayList<Proyecto> listar() {
        ArrayList<Proyecto> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
                Proyecto  proyecto = new Proyecto();

                proyecto.setIdtb_proyecto(rs.getInt(1));
                proyecto.setNombre(rs.getString(2));
                proyecto.setEstado(String.valueOf(rs.getString(3)).charAt(0));
                proyecto.setFecha_inicio((Timestamp) rs.getTimestamp(4));
                proyecto.setFecha_fin((Timestamp) rs.getTimestamp(5));
                proyecto.setTarea(rs.getString(6));
                proyecto.setTarea_descripcion(rs.getString(7));
                proyecto.setChecklist(rs.getString(8));
                proyecto.setTb_trabjador_id(rs.getInt(9));
                proyecto.setTb_cliente_id(rs.getInt(10));

                listaRetorno.add(proyecto);
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
    public boolean insertar(Proyecto proyecto) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{null,  
            proyecto.getNombre(), proyecto.getEstado(), proyecto.getFecha_inicio(),
            proyecto.getFecha_fin(), proyecto.getTarea(), proyecto.getTarea_descripcion(),
            proyecto.getChecklist(), proyecto.getTb_trabjador_id(), proyecto.getTb_cliente_id()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Proyecto proyecto) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, tb_pais_id()=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{
            proyecto.getNombre(), proyecto.getEstado(), proyecto.getFecha_inicio(),
            proyecto.getFecha_fin(), proyecto.getTarea(), proyecto.getTarea_descripcion(),
            proyecto.getChecklist(), proyecto.getTb_trabjador_id(), proyecto.getTb_cliente_id()});
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
