/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import modelo.beans.Ciudad;
import modelo.beans.Cliente;
import modelo.beans.Departamento;
import modelo.beans.Modulo;
import modelo.beans.Pais;
import modelo.beans.Persona;
import modelo.beans.Proyecto;
import modelo.beans.Trabajador;
import modelo.interfaces.ProyectoInterface;
import static modelo.interfaces.ProyectoInterface.CLAVE_PRIMARIA;
import static modelo.interfaces.ProyectoInterface.TABLA;
import static modelo.interfaces.ProyectoInterface.conexion;
import static modelo.interfaces.RequerimientoInterface.TABLA;
import static modelo.interfaces.RequerimientoInterface.conexion;

/**
 *
 * @author Sttefany
 */
public class ProyectoDAO implements ProyectoInterface {
//   

    public ArrayList<Proyecto> listarProyectoCliente(int id) {
        ArrayList<Proyecto> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_proyecto WHERE tb_cliente_tb_persona_id=" + id;

            ResultSet rs = conexion.recuperar(String.format(sql));
            while (rs.next()) {
                Proyecto proyecto = new Proyecto(rs.getInt(1), rs.getString(2),
                        rs.getString(3), (Timestamp) rs.getTimestamp(4),
                        (Timestamp) rs.getTimestamp(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getInt(11), rs.getInt(12),
                        rs.getInt(13));
                listaRetorno.add(proyecto);
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return listaRetorno;
        }
    }

    public boolean editarEstado(Proyecto proyecto) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET estado=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{
                proyecto.getEstado(), proyecto.getIdtb_proyecto()});
        } catch (Exception ex) {
            return false;
        }
    }

    public int porcentajeAvance(Proyecto proyecto) {
        int resultado = 0;
        try {
            String sql = "SELECT ((SELECT count(*) FROM tb_modulo WHERE estado='F' AND tb_proyecto_id=%s)/(SELECT count(*) FROM tb_modulo WHERE tb_proyecto_id=%s))*100 FROM tb_proyecto WHERE idtb_proyecto=%s;";

            ResultSet rs = conexion.recuperar(String.format(sql, proyecto.getIdtb_proyecto(), proyecto.getIdtb_proyecto(),proyecto.getIdtb_proyecto()));

            while (rs.next()) {
                resultado = (int)Math.round(rs.getDouble(1));
                System.out.println(resultado);
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return resultado ;
        }
    }

    public ArrayList<Proyecto> listarProyectoTrabajador(int id) {
        ArrayList<Proyecto> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_proyecto WHERE tb_trabajador_tb_persona_id1=" + id;

            ResultSet rs = conexion.recuperar(String.format(sql));
            while (rs.next()) {
                Proyecto proyecto = new Proyecto(rs.getInt(1), rs.getString(2),
                        rs.getString(3), (Timestamp) rs.getTimestamp(4),
                        (Timestamp) rs.getTimestamp(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getInt(11), rs.getInt(12),
                        rs.getInt(13));
                listaRetorno.add(proyecto);
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
    public Proyecto buscar(int id) {
        Proyecto proyecto = null;
        try {
            String sql = "SELECT * FROM tb_proyecto WHERE idtb_proyecto = " + id;

            ResultSet rs = conexion.recuperar(String.format(sql));
            while (rs.next()) {

                proyecto = new Proyecto(rs.getInt(1), rs.getString(2),
                        rs.getString(3), (Timestamp) rs.getTimestamp(4),
                        (Timestamp) rs.getTimestamp(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getInt(11), rs.getInt(12),
                        rs.getInt(13));
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return proyecto;
        }
    }

    @Override
    public ArrayList<Proyecto> listar() {
        ArrayList<Proyecto> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_proyecto ";

            ResultSet rs = conexion.recuperar(String.format(sql));
            while (rs.next()) {

                Proyecto proyecto = new Proyecto(rs.getInt(1), rs.getString(2),
                        rs.getString(3), (Timestamp) rs.getTimestamp(4),
                        (Timestamp) rs.getTimestamp(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getInt(11), rs.getInt(12),
                        rs.getInt(13));

                listaRetorno.add(proyecto);
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
    public boolean insertar(Proyecto proyecto) {
        try {
            return conexion.ejecutar(String.format("INSERT INTO %s VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)", TABLA), new Object[]{null,
                proyecto.getNombre(), proyecto.getEstado(), proyecto.getFecha_inicio(),
                proyecto.getFecha_fin(), proyecto.getTarea(), proyecto.getTarea_descripcion(),
                proyecto.getChecklist(), proyecto.getNombre_empresa(), proyecto.getRuc(), proyecto.getTb_trabajador_persona_id(), proyecto.getTb_cliente_persona_id(), proyecto.getTb_trabajador_persona_id1()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Proyecto proyecto) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, estado=?, fecha_inicio=?, fecha_fin=?,tarea=?, tarea_descripcion=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{
                proyecto.getNombre(), proyecto.getEstado(), proyecto.getFecha_inicio(),
                proyecto.getFecha_fin(), proyecto.getTarea(), proyecto.getTarea_descripcion(), proyecto.getIdtb_proyecto()});
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
