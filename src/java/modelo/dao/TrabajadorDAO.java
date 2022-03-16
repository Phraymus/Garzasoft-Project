/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import modelo.beans.Trabajador;
import java.sql.ResultSet;
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
            String sql = "SELECT c.idtb_ciudad, c.nombre, d.idtb_departamento, d.nombre, p.idtb_pais, p.nombre FROM tb_ciudad AS c JOIN tb_departamento AS d ON c.tb_departamento_id=d.idtb_departamento JOIN tb_pais AS p ON d.tb_pais_id=p.idtb_pais WHERE c.idtb_ciudad = "+id;
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                
                trabajador = new Trabajador();
                Pais pais= new Pais(rs.getInt(5), rs.getString(6));
                Departamento departamento= new Departamento(rs.getInt(3), rs.getString(4), pais);
                ciudad.setIdtb_ciudad(rs.getInt(1));
                ciudad.setNombre(rs.getString(2));
                ciudad.setTb_departamento_id(departamento);
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
            String sql="SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql=(i==ATRIBUTOS.length-1)?sql+ATRIBUTOS[i]+", ":sql+ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s",sql,TABLA));
            while (rs.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setIdtb_trabajador(rs.getInt(1));
                trabajador.setTipo(rs.getString(2));
                trabajador.setTb_persona_id(rs.getInt(3));
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
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{trabajador.getIdtb_trabajador(), trabajador.getTipo(),trabajador.getTb_persona_id()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Trabajador trabajador) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET tipo=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{trabajador.getIdtb_trabajador(), trabajador.getTipo(),trabajador.getTb_persona_id()});
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
