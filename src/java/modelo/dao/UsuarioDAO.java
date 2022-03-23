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
import modelo.beans.Cliente;
import modelo.beans.Departamento;
import modelo.beans.Pais;
import modelo.beans.Persona;
import modelo.beans.Trabajador;
import modelo.beans.Usuario;
import modelo.interfaces.UsuarioInterface;

/**
 *
 * @author ESTUDIANTE
 */
public class UsuarioDAO implements UsuarioInterface{

    @Override
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> listaRetorno = new ArrayList<>();
        try {
            String sql = "select u.idtb_usuario, u.nombre, u.clave, u.perfil_usuario, t.tipo, p1.idtb_persona, p1.nombre, p1.apellido_paterno, p1.apellido_materno, p1.correo, p1.foto, p1.tipo_identificacion, p1.numero_identificacion, c1.idtb_ciudad, c1.nombre, d1.idtb_departamento, d1.nombre, pa1.idtb_pais, pa1.nombre, cl.tb_persona_id, cl.ruc, cl.nombre_empresa, p2.nombre, p2.apellido_paterno, p2.apellido_materno, p2.correo, p2.foto, p2.tipo_identificacion, p2.numero_identificacion, c2.idtb_ciudad, c2.nombre, d2.idtb_departamento, d2.nombre, pa2.idtb_pais, pa2.nombre FROM tb_usuario AS u LEFT JOIN tb_trabajador AS t ON u.tb_persona_id=t.tb_persona_id LEFT JOIN tb_persona AS p1 ON t.tb_persona_id=p1.idtb_persona LEFT JOIN tb_ciudad AS c1 ON p1.tb_ciudad_id=c1.idtb_ciudad LEFT JOIN tb_departamento AS d1 ON c1.tb_departamento_id=d1.idtb_departamento LEFT JOIN tb_pais AS pa1 ON d1.tb_pais_id=pa1.idtb_pais LEFT JOIN tb_cliente AS cl ON u.tb_persona_id=cl.tb_persona_id LEFT JOIN tb_persona AS p2 ON t.tb_persona_id=p2.idtb_persona LEFT JOIN tb_ciudad AS c2 ON p2.tb_ciudad_id=c2.idtb_ciudad LEFT JOIN tb_departamento AS d2 ON c2.tb_departamento_id=d2.idtb_departamento LEFT JOIN tb_pais AS pa2 ON d2.tb_pais_id=pa2.idtb_pais";
//            
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Pais pais1 = new Pais(rs.getInt(18), rs.getString(19));
                Departamento departamento1 = new Departamento(rs.getInt(16), rs.getString(17),pais1);
                Ciudad ciudad1 = new Ciudad(rs.getInt(14), rs.getString(15), departamento1);
                Persona persona1 = new Persona(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), (Image) rs.getBlob(11), rs.getString(12), rs.getString(13),  ciudad1);
                Trabajador trabajador = new Trabajador(persona1, rs.getString(5));  
                
                Pais pais2 = new Pais(rs.getInt(34), rs.getString(35));
                Departamento departamento2 = new Departamento(rs.getInt(32), rs.getString(33),pais2);
                Ciudad ciudad2 = new Ciudad(rs.getInt(30), rs.getString(31), departamento2);
                Persona persona2 = new Persona(rs.getInt(20), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), (Image) rs.getBlob(27), rs.getString(28), rs.getString(29),  ciudad2);
                Cliente cliente = new Cliente(persona2, rs.getString(21), rs.getString(22));

                Usuario  usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), trabajador, cliente);
           

                listaRetorno.add(usuario);
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
    public Usuario buscar(int id) {
        Usuario usuario = null;
        try {
            String sql = "select u.idtb_usuario, u.nombre, u.clave, u.perfil_usuario, t.tipo, p1.idtb_persona, p1.nombre, p1.apellido_paterno, p1.apellido_materno, p1.correo, p1.tipo_identificacion, p1.numero_identificacion, p1.foto, c1.idtb_ciudad, c1.nombre, d1.idtb_departamento, d1.nombre, pa1.idtb_pais, pa1.nombre, cl.tb_persona_id, cl.ruc, cl.nombre_empresa, p2.idtb_persona, p2.nombre, p2.apellido_paterno, p2.apellido_materno, p2.correo, p2.tipo_identificacion, p2.numero_identificacion, p2.foto, c2.idtb_ciudad, c2.nombre, d2.idtb_departamento, d2.nombre, pa2.idtb_pais, pa2.nombre FROM tb_usuario AS u JOIN tb_trabajador AS t ON u.tb_persona_id=t.tb_persona_id JOIN tb_persona AS p1 ON t.tb_persona_id=p1.idtb_persona JOIN tb_ciudad AS c1 ON p1.tb_ciudad_id=c1.idtb_ciudad JOIN tb_departamento AS d1 ON c1.tb_departamento_id=d1.idtb_departamento JOIN tb_pais AS pa1 ON d1.tb_pais_id=pa1.idtb_pais JOIN tb_cliente AS cl ON u.tb_persona_id=cl.tb_persona_id JOIN tb_persona AS p2 ON t.tb_persona_id=p2.idtb_persona JOIN tb_ciudad AS c2 ON p2.tb_ciudad_id=c2.idtb_ciudad JOIN tb_departamento AS d2 ON c2.tb_departamento_id=d2.idtb_departamento JOIN tb_pais AS pa2 ON d2.tb_pais_id=pa2.idtb_pais WHERE u.idtb_usuario="+id;
        
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                usuario = new Usuario();
                
                Pais pais1 = new Pais(rs.getInt(18), rs.getString(19));
                Departamento departamento1 = new Departamento(rs.getInt(16), rs.getString(17),pais1);
                Ciudad ciudad1 = new Ciudad(rs.getInt(14), rs.getString(15), departamento1);
                Persona persona1 = new Persona(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), (Image) rs.getBlob(11),rs.getString(12), rs.getString(13),  ciudad1);
                Trabajador trabajador = new Trabajador(persona1, rs.getString(5));
                
                Pais pais2 = new Pais(rs.getInt(30), rs.getString(31));
                Departamento departamento2 = new Departamento(rs.getInt(16), rs.getString(17),pais2);
                Ciudad ciudad2 = new Ciudad(rs.getInt(14), rs.getString(15), departamento2);
                Persona persona2 = new Persona(rs.getInt(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), (Image)  rs.getBlob(27), rs.getString(28), rs.getString(29),  ciudad2);
                Cliente cliente = new Cliente(persona2, rs.getString(20), rs.getString(21));
                
                usuario.setIdtb_usuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setClave(rs.getString(3));
                usuario.setPerfil_usuario(rs.getString(4));
                usuario.setTrabajador((trabajador));
                usuario.setCliente((cliente));
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return usuario;
        }
    }

    @Override
    public boolean insertar(Usuario usuario) {
        try{
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?,?,?,?,?)", TABLA), new Object[]
                {null, usuario.getNombre(), usuario.getClave(), usuario.getPerfil_usuario(), usuario.getTrabajador(), usuario.getTrabajador().getTipo(), usuario.getCliente().getPersona().getIdtb_persona()});
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Usuario usuario) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, clave=?, perfil_usuario=?, tb_persona_id=? , tb_persona_idc=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{usuario.getNombre(), usuario.getClave(), usuario.getPerfil_usuario(), usuario.getTrabajador(), usuario.getCliente().getPersona().getIdtb_persona(), usuario.getIdtb_usuario()});
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
