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
import modelo.beans.Identificacion;
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
            String sql = "SELECT p.idtb_persona, p.nombre, p.apellido_paterno, p.apellido_materno, p.correo, p.foto, i.idtb_identificacion, i.tipo, i.numero, c.idtb_ciudad, c.nombre FROM tb_persona AS p JOIN tb_identificacion AS i ON p.tb_identificacion_id=i.idtb_identificacion JOIN tb_ciudad AS c ON p.tb_ciudad_id=c.idtb_ciudad; ";
            
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
                Persona persona = new Persona();
                Identificacion identificacion = new Identificacion(rs.getInt(7), rs.getString(8), rs.getString(9));
                Ciudad ciudad = new Ciudad(rs.getInt(10), rs.getString(11));
                
                persona.setIdtb_persona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido_paterno(rs.getString(3));
                persona.setApellido_materno(rs.getString(4));
                persona.setCorreo(rs.getString(5));
                persona.setFoto((Image) rs.getBlob(6));
                persona.setIdentificacion(identificacion);
                persona.setCiudad(ciudad);

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
            String sql = "SELECT p.idtb_persona, p.nombre, p.apellido_paterno, p.apellido_materno, p.correo, p.foto, i.idtb_identificacion, i.tipo, i.numero, c.idtb_ciudad, c.nombre FROM tb_persona AS p JOIN tb_identificacion AS i ON p.tb_identificacion_id=i.idtb_identificacion JOIN tb_ciudad AS c ON p.tb_ciudad_id=c.idtb_ciudad WHERE p.idtb_persona="+id;
      
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                
                persona = new Persona();
                Identificacion identificacion = new Identificacion(rs.getInt(7), rs.getString(8), rs.getString(9));
                Ciudad ciudad = new Ciudad(rs.getInt(10), rs.getString(11));
                
                persona.setIdtb_persona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido_paterno(rs.getString(3));
                persona.setApellido_materno(rs.getString(4));
                persona.setCorreo(rs.getString(5));
                persona.setFoto((Image) rs.getBlob(6));
                persona.setIdentificacion(identificacion);
                persona.setCiudad(ciudad);
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
                {null, persona.getNombre(), persona.getApellido_paterno(), persona.getApellido_materno(), persona.getCorreo(), persona.getFoto(), persona.getIdentificacion(), persona.getCiudad()});
        }
        catch (Exception ex) {
            return false;
        }
    }


    @Override
    public boolean editar(Persona persona) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, apellido_paterno=?, apellido_materno=?, correo=?, foto=?, identificacion=?, ciudad=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{null, persona.getNombre(), persona.getApellido_paterno(), persona.getApellido_materno(), persona.getCorreo(), persona.getFoto(), persona.getIdentificacion(), persona.getCiudad()});
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
