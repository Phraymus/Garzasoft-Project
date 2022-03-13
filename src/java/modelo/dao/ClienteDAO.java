/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Cliente;
import modelo.interfaces.DAO;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brayan Carrasco
 */
public class ClienteDAO implements DAO {

    Conexion conexion;

    final String TABLA = "tb_cliente";
    final String ATRIBUTOS[] = {"tb_persona_id", "ruc", "nombre_empresa"};
    final String CLAVE_PRIMARIA = "tb_persona_id";

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
        } catch (Exception ex) {
            throw ex;
        } finally {
            return listaRetorno;
        }
    }

    public Cliente buscar(int id) {
        Cliente cliente = null;
        try {
            String sql="SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql=(i==ATRIBUTOS.length-1)?sql+ATRIBUTOS[i]+", ":sql+ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql,TABLA,CLAVE_PRIMARIA,id));
            while (rs.next()) {
                cliente.setTb_persona_id(rs.getInt(1));
                cliente.setRuc(rs.getString(1));
                cliente.setNombreEmpresa(rs.getString(1));
            }
            rs.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return cliente;
        }
    }

    @Override
    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> listaRetorno = new ArrayList<>();
        try {
            String sql="SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql=(i==ATRIBUTOS.length-1)?sql+ATRIBUTOS[i]+", ":sql+ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s",sql,TABLA));
            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setTb_persona_id(rs.getInt(1));
                cliente.setRuc(rs.getString(1));
                cliente.setNombreEmpresa(rs.getString(1));

                listaRetorno.add(cliente);
            }
            rs.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return listaRetorno;
        }
    }

    @Override
    public boolean insertar(Cliente cliente) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{cliente.getTb_persona_id(), cliente.getRuc(), cliente.getNombreEmpresa()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Cliente cliente) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET ruc=?, nombre_empresa=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{cliente.getRuc(), cliente.getNombreEmpresa(), cliente.getTb_persona_id()});
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
