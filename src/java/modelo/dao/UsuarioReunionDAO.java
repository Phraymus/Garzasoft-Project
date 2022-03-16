/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.beans.Medio;
import modelo.beans.Reunion;
import modelo.beans.Usuario;
import modelo.beans.UsuarioReunion;
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
            String sql = "SELECT r.idtb_reuniones,r.fecha,r.asunto,r.link,m.idtb_medio,m.nombre FROM tb_ciudad AS c JOIN tb_departamento AS d ON c.tb_departamento_id=d.idtb_departamento JOIN tb_pais AS p ON d.tb_pais_id=p.idtb_pais WHERE c.idtb_ciudad = "+id;
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                
                usuarioreunion = new UsuarioReunion();
                Medio medio=new Medio(rs.getInt(5),rs.getString(6));
                Reunion reunion= new Reunion(rs.getInt(1),rs.getTimestamp(2),rs.getString(3),rs.getString(4),medio);
                
                Usuario usuario= new Usuario(rs.getInt(7), rs.getString(8), rs.getString(9),rs.getString(10),persona,personac);
                
                usuarioreunion.setTb_reunion_id(reunion);
                usuarioreunion.setTb_usuario_id(usuario);
                
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
    public boolean insertar(UsuarioReunion usuarioreunion) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{null, ciudad.getNombre(), ciudad.getDepartamento().getIdtb_departamento()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(UsuarioReunion usuarioreunion) {
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
