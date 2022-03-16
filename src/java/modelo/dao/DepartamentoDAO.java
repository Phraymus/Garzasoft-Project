/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.beans.Departamento;
import modelo.beans.Pais;
import modelo.interfaces.DepartamentoInterface;



/**
 *
 * @author Marco
 */
public class DepartamentoDAO implements DepartamentoInterface{
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
    public Departamento buscar(int id) {
        Departamento  departamento = null;
        try {
            String sql = "SELECT d.idtb_departamento, d.nombre, p.idtb_pais, p.nombre FROM tb_departamento AS d JOIN tb_pais AS p ON d.tb_pais_id=p.idtb_pais WHERE d.idtb_departamento = "+id;
            ResultSet rs = conexion.recuperar(sql);
            
            while (rs.next()) {
                departamento = new Departamento();
                Pais pais= new Pais(rs.getInt(3), rs.getString(4));        
                departamento.setIdtb_departamento(rs.getInt(1));
                departamento.setNombre(rs.getString(2));
                departamento.setPais(pais);
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return departamento;
        }
    }

    @Override
    public ArrayList<Departamento> listar() {
        ArrayList<Departamento> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT d.idtb_departamento, d.nombre, p.idtb_pais, p.nombre FROM tb_departamento AS d JOIN tb_pais AS p ON d.tb_pais_id=p.idtb_pais";
            ResultSet rs = conexion.recuperar(sql);
            
            while (rs.next()) {
                Departamento departamento = new Departamento();
                
                Pais pais= new Pais(rs.getInt(3), rs.getString(4));        
                departamento.setIdtb_departamento(rs.getInt(1));
                departamento.setNombre(rs.getString(2));
                departamento.setPais(pais);
                
                listaRetorno.add(departamento);
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
    public boolean insertar(Departamento departamento) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{null, departamento.getNombre(), departamento.getPais().getIdtb_pais()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Departamento departamento) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, tb_pais_id=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{departamento.getNombre(), departamento.getPais().getIdtb_pais(), departamento.getIdtb_departamento()});
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
