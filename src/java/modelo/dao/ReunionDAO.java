/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.beans.Reunion;
import modelo.interfaces.ReunionInterface;

/**
 *
 * @author ELIAS
 */
public class ReunionDAO implements ReunionInterface {
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

    public Reunion buscar(int id) {
        Reunion reunion = null;
        try {
            String sql="SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql=(i==ATRIBUTOS.length-1)?sql+ATRIBUTOS[i]+", ":sql+ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql,TABLA,CLAVE_PRIMARIA,id));
            while (rs.next()) {
                reunion.setIdtb_reuniones(rs.getInt(1));
                reunion.setFecha(rs.getDate(2));
                reunion.setAsunto(rs.getString(3));
                reunion.setLink(rs.getString(4));
                reunion.setTb_medio_id(rs.getInt(5));
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return reunion;
        }
    }

    @Override
    public ArrayList<Reunion> listar() {
        ArrayList<Reunion> listaRetorno = new ArrayList<>();
        try {
            String sql="SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql=(i==ATRIBUTOS.length-1)?sql+ATRIBUTOS[i]+", ":sql+ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s",sql,TABLA));
            while (rs.next()) {
                Reunion reunion = new Reunion();
                 reunion.setIdtb_reuniones(rs.getInt(1));
                reunion.setFecha(rs.getDate(2));
                reunion.setAsunto(rs.getString(3));
                reunion.setLink(rs.getString(4));
                reunion.setTb_medio_id(rs.getInt(5));
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
    public boolean insertar(Reunion reunion) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?,?,?)", TABLA), new Object[]{
                reunion.getIdtb_reuniones(), reunion.getFecha(),reunion.getAsunto(),reunion.getLink(),reunion.getTb_medio_id()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Reunion reunion) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET tipo=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{
                reunion.getIdtb_reuniones(), reunion.getFecha(),reunion.getAsunto(),reunion.getLink(),reunion.getTb_medio_id()});
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
