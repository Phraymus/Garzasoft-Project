/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.awt.Image;
import java.util.ArrayList;
import modelo.beans.Trabajador;
import java.sql.ResultSet;
import modelo.beans.Ciudad;
import modelo.beans.Departamento;
import modelo.beans.Pais;
import modelo.beans.Persona;
import modelo.interfaces.TrabajadorInterface;

/**
 *
 * @author ELIAS
 */
public class TrabajadorDAO implements TrabajadorInterface {

    @Override
    public Trabajador buscar(int id) {
        Trabajador trabajador = null;
        try {
            String sql = "SELECT * FROM tb_trabajador WHERE tb_persona_id=" + id;
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                trabajador = new Trabajador(rs.getInt(1), rs.getString(2));
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return trabajador;
        }
    }

    @Override
    public ArrayList<Trabajador> listar() {
        ArrayList<Trabajador> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_trabajador";
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Trabajador trabajador = new Trabajador(rs.getInt(1), rs.getString(2));
                listaRetorno.add(trabajador);
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
    public boolean insertar(Trabajador trabajador) {
        try {
            return conexion.ejecutar(String.format("INSERT INTO %s VALUES(?,?)", TABLA), new Object[]{trabajador.getTb_persona_id(), trabajador.getTipo()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Trabajador trabajador) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET tipo=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{trabajador.getTipo(), trabajador.getTb_persona_id()});
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
