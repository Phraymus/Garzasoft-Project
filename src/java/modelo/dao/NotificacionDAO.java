/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.ArrayList;
import modelo.beans.Notificacion;
import modelo.interfaces.NotificacionInterface;
import java.util.ArrayList;
import java.sql.ResultSet;
import modelo.beans.Usuario;

/**
 *
 * @author phraymus
 */
public class NotificacionDAO implements NotificacionInterface {

    @Override
    public ArrayList<Notificacion> listarPorUsuario(Usuario usuario) {
        ArrayList<Notificacion> listaRetorno = null;
        try {
            String sql = "SELECT * FROM tb_notificacion WHERE tb_usuario_id="+usuario.getIdtb_usuario();

            ResultSet rs = conexion.recuperar(sql);

            while (rs.next()) {
                Notificacion notificacion = new Notificacion(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getTimestamp(8));
                listaRetorno.add(notificacion);
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
    public ArrayList<Notificacion> listar() {
        ArrayList<Notificacion> listaRetorno = null;
        try {
            String sql = "SELECT * FROM tb_notificacion";

            ResultSet rs = conexion.recuperar(sql);

            while (rs.next()) {
                Notificacion notificacion = new Notificacion(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getTimestamp(8));
                listaRetorno.add(notificacion);
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
    public Notificacion buscar(int id) {
        Notificacion notificacion = null;
        try {
            String sql = "SELECT * FROM tb_notificacion WHERE idtb_notificacion=" + id;

            ResultSet rs = conexion.recuperar(sql);

            while (rs.next()) {
                notificacion = new Notificacion(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getTimestamp(8));
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return notificacion;
        }
    }

    @Override
    public boolean insertar(Notificacion notificacion) {
        try {
            return conexion.ejecutar(String.format("INSERT INTO %s VALUES(?,?,?,?,?,?,?,?)", TABLA), new Object[]{null,
                notificacion.getTb_usuario_id(), notificacion.getTitulo(), notificacion.getDescripcion_corta(),
                notificacion.getDescripcion_larga(), notificacion.getTipo(), notificacion.getColor(), notificacion.getFecha()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Notificacion notificacion) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET titulo=?, descripcion_corta=?, descripcion_larga=?, tipo=?, color=?, fecha=? WHERE idtb_notificacion=?", TABLA), new Object[]{
                notificacion.getTitulo(), notificacion.getDescripcion_corta(),
                notificacion.getDescripcion_larga(), notificacion.getTipo(), notificacion.getColor(), notificacion.getFecha(), notificacion.getIdtb_notificacion()});
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
