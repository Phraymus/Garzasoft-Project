/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.beans.Ciudad;
import modelo.beans.Departamento;
import modelo.beans.Pais;
import modelo.interfaces.CiudadInterface;




/**
 *
 * @author Marco
 */
public class CiudadDAO implements CiudadInterface{
    
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

    @Override
    public Ciudad buscar(int id) {
        Ciudad ciudad = null;
        try {
            String sql = "SELECT c.idtb_ciudad, c.nombre, d.idtb_departamento, d.nombre, p.idtb_pais, p.nombre FROM tb_ciudad AS c JOIN tb_departamento AS d ON c.tb_departamento_id=d.idtb_departamento JOIN tb_pais AS p ON d.tb_pais_id=p.idtb_pais WHERE c.idtb_ciudad = "+id;
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                
                ciudad = new Ciudad();
                Pais pais= new Pais(rs.getInt(5), rs.getString(6));
                Departamento departamento= new Departamento(rs.getInt(3), rs.getString(4), pais);
                ciudad.setIdtb_ciudad(rs.getInt(1));
                ciudad.setNombre(rs.getString(2));
                ciudad.setDepartamento(departamento);
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return ciudad;
        }
    }

    @Override
    public ArrayList<Ciudad> listar() {
        ArrayList<Ciudad> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT c.idtb_ciudad, c.nombre, d.idtb_departamento, d.nombre, p.idtb_pais, p.nombre FROM tb_ciudad AS c JOIN tb_departamento AS d ON c.tb_departamento_id=d.idtb_departamento JOIN tb_pais AS p ON d.tb_pais_id=p.idtb_pais";
            
            ResultSet rs = conexion.recuperar(sql);
            
            while (rs.next()) {
                Ciudad ciudad = new Ciudad();
                
                Pais pais= new Pais(rs.getInt(5), rs.getString(6));
                Departamento departamento= new Departamento(rs.getInt(3), rs.getString(4), pais);
                        
                ciudad.setIdtb_ciudad(rs.getInt(1));
                ciudad.setNombre(rs.getString(2));
                ciudad.setDepartamento(departamento);

                listaRetorno.add(ciudad);
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
    public boolean insertar(Ciudad ciudad) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{null, ciudad.getNombre(), ciudad.getDepartamento().getIdtb_departamento()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Ciudad ciudad) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, Tb_departamento_id=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{ciudad.getNombre(), ciudad.getDepartamento().getIdtb_departamento(), ciudad.getIdtb_ciudad()});
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
