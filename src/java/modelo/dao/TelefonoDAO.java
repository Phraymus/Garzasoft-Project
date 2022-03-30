/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.awt.Image;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.beans.Ciudad;
import modelo.beans.Departamento;
import modelo.beans.Pais;
import modelo.beans.Persona;
import modelo.beans.Telefono;
import modelo.interfaces.TelefonoInterface;

/**
 *
 * @author Brayan Carrasco
 */
public class TelefonoDAO implements TelefonoInterface {

    @Override
    public ArrayList<Telefono> listar() {
        ArrayList<Telefono> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_telefono";
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Telefono telefono = new Telefono(rs.getInt(1), rs.getString(2), rs.getInt(3));
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
            String sql = "SELECT * FROM tb_telefono WHERE tb_persona_id=" + id;
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                telefono = new Telefono(rs.getInt(1), rs.getString(2), rs.getInt(3));
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
            return conexion.ejecutar(String.format("INSERT INTO %s VALUES(?,?,?)", TABLA), new Object[]{null, telefono.getNumero(), telefono.getTb_persona_id()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Telefono telefono) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET numero=? WHERE tb_persona_id=? ", TABLA, CLAVE_PRIMARIA), new Object[]{telefono.getNumero(), telefono.getTb_persona_id()});
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
