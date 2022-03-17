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
import modelo.beans.Identificacion;
import modelo.beans.Pais;
import modelo.beans.Persona;
import modelo.interfaces.TrabajadorInterface;



/**
 *
 * @author ELIAS
 */
public class TrabajadorDAO implements TrabajadorInterface{

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
    public Trabajador buscar(int id) {
        Trabajador trabajador = null;
        try {
            String sql = "SELECT p.idtb_persona, p.nombre, p.apellido_paterno, p.apellido_materno, p.correo, p.foto, p.tipo_identificacion,p.numero_identificacion, t.tipo, ci.idtb_ciudad,ci.nombre, de.idtb_departamento,de.nombre,pa.idtb_pais,pa.nombre FROM tb_trabajador AS t JOIN tb_persona AS p ON t.tb_persona_id=p.idtb_persona JOIN tb_ciudad as ci ON ci.idtb_ciudad=p.tb_ciudad_id JOIN tb_departamento AS de ON ci.tb_departamento_id=de.idtb_departamento JOIN tb_pais AS pa ON pa.idtb_pais=de.tb_pais_id; ";
            ResultSet rs = conexion.recuperar(sql);                                        
            while (rs.next()) {
                
                trabajador = new Trabajador();
                Identificacion identificacion = new Identificacion(rs.getInt(8), rs.getString(9), rs.getString(10));
                Pais pais =new Pais(rs.getInt(15),rs.getString(16));
                Departamento departamento= new Departamento(rs.getInt(13), rs.getString(14), pais);
                Ciudad ciudad = new Ciudad(rs.getInt(11), rs.getString(12),departamento);
                Persona persona= new Persona(rs.getInt(1), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(5),(Image)rs.getBlob(6),identificacion,ciudad);
                trabajador.setTipo(rs.getString(2));
                
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
            String sql = "SELECT p.idtb_persona, p.nombre, p.apellido_paterno, p.apellido_materno, p.correo, p.foto, p.tipo_identificacion,p.numero_identificacion, t.tipo, ci.idtb_ciudad,ci.nombre, de.idtb_departamento,de.nombre,pa.idtb_pais,pa.nombre FROM tb_trabajador AS t JOIN tb_persona AS p ON t.tb_persona_id=p.idtb_persona JOIN tb_ciudad as ci ON ci.idtb_ciudad=p.tb_ciudad_id JOIN tb_departamento AS de ON ci.tb_departamento_id=de.idtb_departamento JOIN tb_pais AS pa ON pa.idtb_pais=de.tb_pais_id; ";
            
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Trabajador trabajador = new Trabajador();
                
                Identificacion identificacion = new Identificacion(rs.getInt(8), rs.getString(9), rs.getString(10));
                Pais pais =new Pais(rs.getInt(15),rs.getString(16));
                Departamento departamento= new Departamento(rs.getInt(13), rs.getString(14), pais);
                Ciudad ciudad = new Ciudad(rs.getInt(11), rs.getString(12),departamento);
                Persona persona= new Persona(rs.getInt(1), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(5),(Image)rs.getBlob(6),identificacion,ciudad);
                trabajador.setTipo(rs.getString(2));
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
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?)", TABLA), new Object[]{trabajador.getTb_persona_id(), trabajador.getTipo()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Trabajador trabajador) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET tipo=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{trabajador.getTipo()});
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
