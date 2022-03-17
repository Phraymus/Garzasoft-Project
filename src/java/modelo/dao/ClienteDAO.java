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

//    public ArrayList<Object[]> listar(String sql, int numeroAtributos) {
//        ArrayList<Object[]> listaRetorno = new ArrayList<>();
//        try {
//            ResultSet rs = conexion.recuperar(sql);
//            while (rs.next()) {
//                Object atributos[] = new Object[numeroAtributos];
//                for (int i = 0; i < numeroAtributos; i++) {
//                    atributos[i] = rs.getObject(i + 1);
//                }
//                listaRetorno.add(atributos);
//            }
//            rs.close();
//            conexion.cerrar();
//
//        } catch (Exception ex) {
//            throw ex;
//        } finally {
//            return listaRetorno;
//        }
//    }

    @Override
    public Cliente buscar(int id) {
        Cliente cliente = null;
        try {
            String sql = "SELECT p.idtb_persona, p.nombre, p.apellido_paterno, p.apellido_materno, p.correo, p.foto, p.tipo_identificacion,p.numero_identificacion, c.ruc, c.nombre_empresa, ci.idtb_ciudad,ci.nombre, de.idtb_departamento,de.nombre,pa.idtb_pais,pa.nombre FROM tb_cliente AS c JOIN tb_persona AS p ON c.tb_persona_id=p.idtb_persona JOIN tb_ciudad as ci ON ci.idtb_ciudad=p.tb_ciudad_id JOIN tb_departamento AS de ON ci.tb_departamento_id=de.idtb_departamento JOIN tb_pais AS pa ON pa.idtb_pais=de.tb_pais_id WHERE p.idtb_persona="+id;
            
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Pais pais= new Pais(rs.getInt(15),rs.getString(16));
                Departamento departamento= new Departamento(rs.getInt(13),rs.getString(14),pais);
                Ciudad ciudad= new Ciudad(rs.getInt(11),rs.getString(12),departamento);
                Persona persona= new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), (Image) rs.getBlob(6), rs.getString(7),rs.getString(8), ciudad);
                cliente = new Cliente(persona, rs.getString(9), rs.getString(10));
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
            String sql = "SELECT p.idtb_persona, p.nombre, p.apellido_paterno, p.apellido_materno, p.correo, p.foto, p.tipo_identificacion,p.numero_identificacion, c.ruc, c.nombre_empresa, ci.idtb_ciudad,ci.nombre, de.idtb_departamento,de.nombre,pa.idtb_pais,pa.nombre FROM tb_cliente AS c JOIN tb_persona AS p ON c.tb_persona_id=p.idtb_persona JOIN tb_ciudad as ci ON ci.idtb_ciudad=p.tb_ciudad_id JOIN tb_departamento AS de ON ci.tb_departamento_id=de.idtb_departamento JOIN tb_pais AS pa ON pa.idtb_pais=de.tb_pais_id;";
            
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Pais pais= new Pais(rs.getInt(15),rs.getString(16));
                Departamento departamento= new Departamento(rs.getInt(13),rs.getString(14),pais);
                Ciudad ciudad= new Ciudad(rs.getInt(11),rs.getString(12),departamento);
                Persona persona= new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), (Image) rs.getBlob(6), rs.getString(7),rs.getString(8), ciudad);
                Cliente cliente = new Cliente(persona, rs.getString(9), rs.getString(10));
                
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
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{cliente.getPersona().getIdtb_persona(), cliente.getRuc(), cliente.getNombreEmpresa()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Cliente cliente) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET ruc=?, nombre_empresa=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{cliente.getRuc(), cliente.getNombreEmpresa(), cliente.getPersona().getIdtb_persona()});
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
