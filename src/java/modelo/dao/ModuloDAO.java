/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.ArrayList;
import modelo.interfaces.ModuloInterface;
import java.sql.ResultSet;
import modelo.beans.Modulo;
/**
 *
 * @author Sttefany
 */
public class ModuloDAO  implements ModuloInterface{
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
    public Modulo buscar(int id) {
        Modulo  modulo = null;
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql, TABLA, CLAVE_PRIMARIA, id));
            while (rs.next()) {
                modulo.setIdtb_modulo(rs.getInt(1));
                modulo.setNombre(rs.getString(2));
                modulo.setEstado(String.valueOf(rs.getString(3)).charAt(0));
                modulo.setTb_proyecto_id(rs.getInt(4));               

            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return modulo;
        }
    }

    @Override
    public ArrayList<Modulo> listar() {
        ArrayList<Modulo> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
                Modulo  modulo = new Modulo();

                modulo.setIdtb_modulo(rs.getInt(1));
                modulo.setNombre(rs.getString(2));
                modulo.setEstado(String.valueOf(rs.getString(3)).charAt(0));
                modulo.setTb_proyecto_id(rs.getInt(4));

                listaRetorno.add(modulo);
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
    public boolean insertar(Modulo modulo) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{null,  
            modulo.getNombre(), modulo.getEstado() ,modulo.getTb_proyecto_id()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Modulo modulo) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, tb_pais_id()=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{
            modulo.getNombre(), modulo.getEstado() ,modulo.getTb_proyecto_id()});
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
