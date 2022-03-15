/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.beans.Persona;
import modelo.interfaces.PersonaInterface;

/**
 *
 * @author ESTUDIANTE
 */
public class PersonaDAO implements PersonaInterface{
    

    @Override
    public ArrayList<Persona> listar() {
        ArrayList<Persona> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
                Persona  persona = new Persona();

                persona.setIdtb_persona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido_paterno(rs.getString(3));
                persona.setApellido_materno(rs.getString(4));
                persona.setCorreo(rs.getString(5));
                persona.setFoto(rs.get(6));
                persona.setTb_identificacion_id(rs.getInt(7));
                persona.setTb_cuidad_id(rs.getInt(8));

                listaRetorno.add(persona);
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
    public Persona buscar(int id) {
        Persona persona = null;
        try {
            String sql = "SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql = (i == ATRIBUTOS.length - 1) ? sql + ATRIBUTOS[i] + ", " : sql + ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql, TABLA, CLAVE_PRIMARIA, id));
            while (rs.next()) {
                persona.setIdtb_persona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido_paterno(rs.getString(3));
                persona.setApellido_materno(rs.getString(4));
                persona.setCorreo(rs.getString(5));
                persona.setFoto(rs.get(6));
                persona.setTb_identificacion_id(rs.getInt(7));
                persona.setTb_cuidad_id(rs.getInt(8));
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return persona;
        }
    }

    @Override
    public boolean insertar(Persona persona) {
        
        try{
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?,?,?,?,?,?)", TABLA), new Object[]
                {null, persona.getNombre(), persona.getApellido_paterno(), persona.getApellido_materno(), persona.getCorreo(), persona.getFoto(), persona.getTb_identificacion_id(), persona.getTb_cuidad_id()});
        }
        catch (Exception ex) {
            return false;
        }
    }


    @Override
    public boolean editar(Persona persona) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{null, persona.getNombre(), persona.getApellido_paterno(), persona.getApellido_materno(), persona.getCorreo(), persona.getFoto(), persona.getTb_identificacion_id(), persona.getTb_cuidad_id()});
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
