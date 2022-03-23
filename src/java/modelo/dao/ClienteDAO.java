/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.awt.Image;
import java.util.ArrayList;
import modelo.beans.Cliente;
import java.sql.ResultSet;
import modelo.beans.Ciudad;
import modelo.beans.Departamento;
import modelo.beans.Pais;
import modelo.beans.Persona;
import modelo.interfaces.ClienteInterface;

/**
 *
 * @author Brayan Carrasco
 */
public class ClienteDAO implements ClienteInterface {
    
    @Override
    public Cliente buscar(int id) {
        Cliente cliente = null;
        try {
            String sql = "SELECT * FROM tb_cliente WHERE tb_persona_id="+id;
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                cliente = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
            rs.close();
            conexion.cerrar();
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
            String sql = "SELECT * FROM tb_cliente";
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3));
                listaRetorno.add(cliente);
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
