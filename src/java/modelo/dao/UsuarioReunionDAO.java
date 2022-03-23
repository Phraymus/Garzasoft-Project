/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.awt.Image;
import java.sql.ResultSet;
import java.util.ArrayList;
import jdk.jfr.Timestamp;
import modelo.beans.Ciudad;
import modelo.beans.Cliente;
import modelo.beans.Departamento;
import modelo.beans.Medio;
import modelo.beans.Pais;
import modelo.beans.Persona;
import modelo.beans.Reunion;
import modelo.beans.Trabajador;
import modelo.beans.Usuario;
import modelo.beans.UsuarioReunion;
import static modelo.interfaces.ReunionInterface.CLAVE_PRIMARIA;
import modelo.interfaces.UsuarioReunionInterface;

/**
 *
 * @author ELIAS
 */
public class UsuarioReunionDAO implements UsuarioReunionInterface{
    
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
    public UsuarioReunion buscar(int id) {
        UsuarioReunion usuarioreunion = null;
        try {
            String sql = "SELECT ur.tb_reunion_id,ur.tb_usuario_id, FROM tb_ciudad AS c JOIN tb_departamento AS d ON c.tb_departamento_id=d.idtb_departamento JOIN tb_pais AS p ON d.tb_pais_id=p.idtb_pais WHERE c.idtb_ciudad = "+id;
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
//                Pais pais1 = new Pais(rs.getInt(20), rs.getString(21));
//                Departamento departamento1 = new Departamento(rs.getInt(18), rs.getString(19),pais1);
//                Ciudad ciudad1 = new Ciudad(rs.getInt(16), rs.getString(17), departamento1);
//                Persona persona1 = new Persona(rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), (Image) rs.getBlob(13),rs.getString(14), rs.getString(15),  ciudad1);
//                Trabajador trabajador = new Trabajador(persona1, rs.getString(7));  
//                
//                Pais pais2 = new Pais(rs.getInt(30), rs.getString(31));
//                Departamento departamento2 = new Departamento(rs.getInt(16), rs.getString(17),pais2);
//                Ciudad ciudad2 = new Ciudad(rs.getInt(14), rs.getString(15), departamento2);
//                Persona persona2 = new Persona(rs.getInt(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), (Image)  rs.getBlob(27), rs.getString(28), rs.getString(29),  ciudad2);
//                Cliente cliente = new Cliente(persona2, rs.getString(20), rs.getString(21));
//                Reunion reunion=new Reunion();
//                Usuario usuario=new Usuario();
//                usuarioreunion = new UsuarioReunion(reunion,usuario);
 
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return usuarioreunion;
        }
    }

    @Override
    public ArrayList<UsuarioReunion> listar() {
        ArrayList<UsuarioReunion> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT r.idtb_reuniones,r.fecha,r.asunto,r.link,m.idtb_medio,m.nombre,u.idtb_usuario, u.nombre, u.clave, u.perfil_usuario, t.tipo, p1.idtb_persona, p1.nombre, p1.apellido_paterno, p1.apellido_materno, p1.correo, p1.tipo_identificacion, p1.numero_identificacion, p1.foto, c1.idtb_ciudad, c1.nombre, d1.idtb_departamento, d1.nombre, pa1.idtb_pais, pa1.nombre, cl.tb_persona_id, cl.ruc, cl.nombre_empresa, p2.idtb_persona, p2.nombre, p2.apellido_paterno, p2.apellido_materno, p2.correo, p2.tipo_identificacion, p2.numero_identificacion, p2.foto, c2.idtb_ciudad, c2.nombre, d2.idtb_departamento, d2.nombre, pa2.idtb_pais, pa2.nombre FROM tb_usuarioreunion AS ur JOIN tb_reunion AS r ON r.tb_reunion_id=ur.idtb_medio JOIN tb_usuario AS u ON u.tb_usuario_id=ur.idtb_usuario JOIN tb_trabajador AS t ON u.tb_persona_id=t.tb_persona_id JOIN tb_persona AS p1 ON t.tb_persona_id=p1.idtb_persona JOIN tb_ciudad AS c1 ON p1.tb_ciudad_id=c1.idtb_ciudad JOIN tb_departamento AS d1 ON c1.tb_departamento_id=d1.idtb_departamento JOIN tb_pais AS pa1 ON d1.tb_pais_id=pa1.idtb_pais JOIN tb_cliente AS cl ON u.tb_persona_id=cl.tb_persona_id JOIN tb_persona AS p2 ON t.tb_persona_id=p2.idtb_persona JOIN tb_ciudad AS c2 ON p2.tb_ciudad_id=c2.idtb_ciudad JOIN tb_departamento AS d2 ON c2.tb_departamento_id=d2.idtb_departamento JOIN tb_pais AS pa2 ON d2.tb_pais_id=pa2.idtb_pais";
            
            ResultSet rs = conexion.recuperar(sql);
            
            while (rs.next()) {
                
//                UsuarioReunion usuarioreunion = new UsuarioReunion();
//
//                Pais pais1 = new Pais(rs.getInt(20), rs.getString(21));
//                Departamento departamento1 = new Departamento(rs.getInt(18), rs.getString(19),pais1);
//                Ciudad ciudad1 = new Ciudad(rs.getInt(16), rs.getString(17), departamento1);
//                Persona persona1 = new Persona(rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), (Image) rs.getBlob(13),rs.getString(14), rs.getString(15),  ciudad1);
//                Trabajador trabajador = new Trabajador(persona1, rs.getString(7));  
//                
//                Pais pais2 = new Pais(rs.getInt(30), rs.getString(31));
//                Departamento departamento2 = new Departamento(rs.getInt(16), rs.getString(17),pais2);
//                Ciudad ciudad2 = new Ciudad(rs.getInt(14), rs.getString(15), departamento2);
//                Persona persona2 = new Persona(rs.getInt(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), (Image)  rs.getBlob(27), rs.getString(28), rs.getString(29),  ciudad2);
//                Cliente cliente = new Cliente(persona2, rs.getString(20), rs.getString(21));
//                Reunion reunion=new Reunion();
//                Usuario usuario=new Usuario();
//                usuarioreunion = new UsuarioReunion(reunion,usuario);
//
//                listaRetorno.add(usuarioreunion);
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
    public boolean insertar(UsuarioReunion usuarioreunion) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?)", TABLA), new Object[]{usuarioreunion.getTb_reunion_id(),usuarioreunion.getTb_usuario_id()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(UsuarioReunion usuarioreunion) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, Tb_departamento_id=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{usuarioreunion.getTb_reunion_id(),usuarioreunion.getTb_usuario_id()});
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
