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
public class TelefonoDAO implements TelefonoInterface{
    /*public ArrayList<Object[]> listar(String sql, int numeroAtributos) {
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
    }*/
    @Override
    public ArrayList<Telefono> listar() {
        ArrayList<Telefono> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT t.idtb_telefono, t.numero,p.idtb_persona, p.nombre, p.apellido_paterno, p.apellido_materno, p.correo, p.foto, p.tipo_identificacion,p.numero_identificacion, ci.idtb_ciudad,ci.nombre, de.idtb_departamento,de.nombre,pa.idtb_pais,pa.nombre FROM tb_telefono AS t JOIN tb_persona AS p ON t.tb_persona_id=p.idtb_persona JOIN tb_ciudad as ci ON ci.idtb_ciudad=p.tb_ciudad_id JOIN tb_departamento AS de ON ci.tb_departamento_id=de.idtb_departamento JOIN tb_pais AS pa ON pa.idtb_pais=de.tb_pais_id;";
            
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
                
                Pais pais= new Pais(rs.getInt(14),rs.getString(15));
                Departamento departamento= new Departamento(rs.getInt(12),rs.getString(13),pais);
                Ciudad ciudad= new Ciudad(rs.getInt(10),rs.getString(11),departamento);
                Persona persona= new Persona(rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), (Image) rs.getBlob(8), rs.getString(9),rs.getString(10), ciudad);
                
                Telefono telefono = new Telefono(rs.getInt(1),rs.getString(2),persona);

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
            String sql = "SELECT t.idtb_telefono, t.numero,p.idtb_persona, p.nombre, p.apellido_paterno, p.apellido_materno, p.correo, p.foto, p.tipo_identificacion,p.numero_identificacion, ci.idtb_ciudad,ci.nombre, de.idtb_departamento,de.nombre,pa.idtb_pais,pa.nombre FROM tb_telefono AS t JOIN tb_persona AS p ON t.tb_persona_id=p.idtb_persona JOIN tb_ciudad as ci ON ci.idtb_ciudad=p.tb_ciudad_id JOIN tb_departamento AS de ON ci.tb_departamento_id=de.idtb_departamento JOIN tb_pais AS pa ON pa.idtb_pais=de.tb_pais_id WHERE t.idtb_telefono="+id;
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql, TABLA, CLAVE_PRIMARIA, id));
            while (rs.next()) {
                Pais pais= new Pais(rs.getInt(14),rs.getString(15));
                Departamento departamento= new Departamento(rs.getInt(12),rs.getString(13),pais);
                Ciudad ciudad= new Ciudad(rs.getInt(10),rs.getString(11),departamento);
                Persona persona= new Persona(rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), (Image) rs.getBlob(8), rs.getString(9),rs.getString(10), ciudad);
                
                telefono = new Telefono(rs.getInt(1),rs.getString(2),persona);
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
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{telefono.getIdtb_telefono(), telefono.getNumero(), telefono.getPersona().getIdtb_persona()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Telefono telefono) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET numero=?, tb_persona_id=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{telefono.getNumero(), telefono.getPersona().getIdtb_persona(), telefono.getIdtb_telefono()});
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
