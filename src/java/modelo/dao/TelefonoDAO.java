/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.beans.Telefono;
import modelo.interfaces.TelefonoInterface;

/**
 *
 * @author Brayan Carrasco
 */
public class TelefonoDAO implements TelefonoInterface{

    @Override
    public ArrayList<Telefono> listar() {
        ArrayList<Telefono> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
                Telefono telefono = new Telefono();

                telefono.setIdtb_telefono(rs.getInt(1));
                telefono.setNumero(rs.getString(2));
                telefono.setTb_persona_id(rs.getInt(3));
                telefono.setTb_persona_idt(rs.getInt(4));

                listaRetorno.add(telefono);
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
    public Telefono buscar(int id) {
        Telefono telefono = null;
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql, TABLA, CLAVE_PRIMARIA, id));
            while (rs.next()) {
                telefono.setIdtb_telefono(rs.getInt(1));
                telefono.setNumero(rs.getString(2));
                telefono.setTb_persona_id(rs.getInt(3));
                telefono.setTb_persona_idt(rs.getInt(4));
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return telefono;
        }
    }

    @Override
    public boolean insertar(Telefono telefono) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?,?)", TABLA), new Object[]{telefono.getIdtb_telefono(), telefono.getNumero(), telefono.getTb_persona_id(), telefono.getTb_persona_idt()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Telefono telefono) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET ruc=?, nombre_empresa=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{telefono.getIdtb_telefono(), telefono.getNumero(), telefono.getTb_persona_id(), telefono.getTb_persona_idt()});
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
