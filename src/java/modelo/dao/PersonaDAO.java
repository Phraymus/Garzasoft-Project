/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.awt.Image;
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
            String sql = "Select * from tb_persona";
            
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Persona persona = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), (Image) rs.getBlob(8), rs.getInt(9));
                
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
            
            String sql = "Select * from tb_persona where idtb_persona = " +id; 
            
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                
                persona = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), (Image) rs.getBlob(8), rs.getInt(9));
                
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
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?,?,?,?,?,?,?)", TABLA), new Object[]
                {null, persona.getNombre(), persona.getApellido_paterno(), persona.getApellido_materno(), persona.getCorreo(), persona.getTipo_identificacion(), persona.getNumero_identificacion() ,persona.getFoto(), persona.getTb_ciudad_id()});
        }
        catch (Exception ex) {
            return false;
        }
    }


    @Override
    public boolean editar(Persona persona) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET idtb_persona= ?, nombre=?, apellido_paterno=?, apellido_materno=?, tipo_identificacion=?, numero_identificacion=?, correo=?, foto=?, tb_ciudad_id=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{persona.getIdtb_persona(), persona.getNombre(), persona.getApellido_paterno(), persona.getApellido_materno(), persona.getCorreo(), persona.getTipo_identificacion(), persona.getNumero_identificacion(), persona.getFoto(), persona.getTb_ciudad_id(), persona.getIdtb_persona()});
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
