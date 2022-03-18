 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.awt.Image;
import java.util.ArrayList;
import modelo.interfaces.ModuloInterface;
import java.sql.ResultSet;
import java.sql.Timestamp;

import modelo.beans.Ciudad;
import modelo.beans.Cliente;
import modelo.beans.Departamento;
import modelo.beans.Modulo;
import modelo.beans.Pais;
import modelo.beans.Persona;
import modelo.beans.Proyecto;
import modelo.beans.Trabajador;
import static modelo.interfaces.ModuloInterface.CLAVE_PRIMARIA;
import static modelo.interfaces.ModuloInterface.TABLA;
import static modelo.interfaces.ModuloInterface.conexion;

/**
 *
 * @author Sttefany
 */


public class ModuloDAO implements ModuloInterface {

//    public ArrayList<Object[]> listar(String sql, int numeroAtributos) {
//        ArrayList<Object[]> listaRetorno = new ArrayList<>();
//        try {
//            ResultSet rset = conexion.recuperar(sql);
//            while (rset.next()) {
//                Object atributos[] = new Object[numeroAtributos];
//                for (int i = 0; i < numeroAtributos; i++) {
//                    atributos[i] = rset.getObject(i + 1);
//                }
//                listaRetorno.add(atributos);
//            }
//            rset.close();
//            conexion.cerrar();
//
//        } catch (Exception ex) {
//            throw ex;
//        } finally {
//            return listaRetorno;
//        }
//    }
    @Override
    public Modulo buscar(int id) {
        Modulo modulo = null;
        try {
            String sql = "SELECT m.idtb_modulo, m.nombre, m.estado, pr.idtb_proyecto, pr.nombre, pr.estado, pr.fecha_inicio, pr.fecha_fin, pr.tarea, pr.tarea_descripcion, pr.checklist, t.tipo, pe.idtb_persona, pe.nombre ,pe.apellido_paterno ,pe.apellido_materno, pe.correo, pe.foto, pe.tipo_identificacion, pe.numero_identificacion, ciudad.idtb_ciudad, ciudad.nombre, d.idtb_departamento, d.nombre, pais.idtb_pais, pais.nombre, cl.ruc, cl.nombre_empresa, pe1.idtb_persona, pe1.nombre, pe1.apellido_paterno, pe1.apellido_materno, pe1.correo, pe1.foto, pe1.tipo_identificacion, pe1.numero_identificacion, c1.idtb_ciudad ,c1.nombre, d1.idtb_departamento, d1.nombre, p1.idtb_pais, p1.nombre, t2.tipo, pe2.idtb_persona, pe2.nombre, pe2.apellido_paterno ,pe2.apellido_materno, pe2.correo, pe2.foto, pe2.tipo_identificacion, pe2.numero_identificacion, ciudad2.idtb_ciudad, ciudad2.nombre, d2.idtb_departamento, d2.nombre, pais2.idtb_pais, pais2.nombre FROM tb_modulo AS m JOIN tb_proyecto AS pr ON m.tb_proyecto_id = pr.idtb_proyecto JOIN tb_trabajador AS t ON pr.tb_trabajador_tb_persona_id = t.tb_persona_id JOIN tb_persona AS pe ON t.tb_persona_id = pe.idtb_persona JOIN tb_ciudad AS ciudad ON pe.tb_ciudad_id = ciudad.idtb_ciudad JOIN tb_departamento AS d ON ciudad.tb_departamento_id = d.idtb_departamento JOIN tb_pais AS pais ON d.tb_pais_id = pais.idtb_pais JOIN tb_cliente AS cl ON pr.tb_cliente_tb_persona_id = cl.tb_persona_id JOIN tb_persona AS pe1 ON cl.tb_persona_id = pe1.idtb_persona JOIN tb_ciudad AS c1 ON pe1.tb_ciudad_id = c1.idtb_ciudad JOIN tb_departamento AS d1 ON c1.tb_departamento_id = d1.idtb_departamento JOIN tb_pais AS p1 ON d1.tb_pais_id = p1.idtb_pais JOIN tb_trabajador AS t2 ON pr.tb_trabajador_tb_persona_id1 = t2.tb_persona_id JOIN tb_persona AS pe2 ON t2.tb_persona_id = pe2.idtb_persona JOIN tb_ciudad AS ciudad2 ON pe2.tb_ciudad_id = ciudad2.idtb_ciudad JOIN tb_departamento AS d2 ON ciudad2.tb_departamento_id = d2.idtb_departamento JOIN tb_pais AS pais2 ON d2.tb_pais_id = pais2.idtb_pais WHERE m.idtb_modulo =" + id;
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Pais pais1 = new Pais(rs.getInt(41), rs.getString(42));
                Departamento departamento1 = new Departamento(rs.getInt(39), rs.getString(40), pais1);
                Ciudad ciudad1 = new Ciudad(rs.getInt(37), rs.getString(38), departamento1);
                Persona persona1 = new Persona(rs.getInt(29), rs.getString(30), rs.getString(31), rs.getString(32), rs.getString(33), (Image) rs.getBlob(34), rs.getString(35), rs.getString(36), ciudad1);
                Cliente cliente = new Cliente(persona1, rs.getString(27), rs.getString(28));

                Pais pais = new Pais(rs.getInt(25), rs.getString(26));
                Departamento departamento = new Departamento(rs.getInt(23), rs.getString(24), pais);
                Ciudad ciudad = new Ciudad(rs.getInt(21), rs.getString(22), departamento);
                Persona persona = new Persona(rs.getInt(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), (Image) rs.getBlob(18), rs.getString(19), rs.getString(20), ciudad);
                Trabajador administrador = new Trabajador(persona, rs.getString(12));

                Pais pais2 = new Pais(rs.getInt(56), rs.getString(57));
                Departamento departamento2 = new Departamento(rs.getInt(54), rs.getString(55), pais2);
                Ciudad ciudad2 = new Ciudad(rs.getInt(52), rs.getString(53), departamento2);
                Persona persona2 = new Persona(rs.getInt(44), rs.getString(45), rs.getString(46), rs.getString(47), rs.getString(48), (Image) rs.getBlob(49), rs.getString(50), rs.getString(51), ciudad2);
                Trabajador programador = new Trabajador(persona2, rs.getString(43));

                Proyecto proyecto = new Proyecto(rs.getInt(4), rs.getString(5), rs.getString(6), (Timestamp) rs.getTimestamp(7), (Timestamp) rs.getTimestamp(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), administrador, cliente, administrador);
                modulo = new Modulo(rs.getInt(1), rs.getString(2), rs.getString(3), proyecto);

            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return modulo;
        }
    }

    @Override
    public ArrayList<Modulo> listar() {
        ArrayList<Modulo> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT m.idtb_modulo, m.nombre, m.estado, pr.idtb_proyecto, pr.nombre, pr.estado, pr.fecha_inicio, pr.fecha_fin, pr.tarea, pr.tarea_descripcion, pr.checklist, t.tipo, pe.idtb_persona, pe.nombre ,pe.apellido_paterno ,pe.apellido_materno, pe.correo, pe.foto, pe.tipo_identificacion, pe.numero_identificacion, ciudad.idtb_ciudad, ciudad.nombre, d.idtb_departamento, d.nombre, pais.idtb_pais, pais.nombre, cl.ruc, cl.nombre_empresa, pe1.idtb_persona, pe1.nombre, pe1.apellido_materno, pe1.apellido_materno, pe1.correo, pe1.foto, pe1.tipo_identificacion, pe1.numero_identificacion, c1.idtb_ciudad ,c1.nombre, d1.idtb_departamento, d1.nombre, p1.idtb_pais, p1.nombre, t2.tipo, pe2.idtb_persona, pe2.nombre, pe2.apellido_paterno ,pe2.apellido_materno, pe2.correo, pe2.foto, pe2.tipo_identificacion, pe2.numero_identificacion, ciudad2.idtb_ciudad, ciudad2.nombre, d2.idtb_departamento, d2.nombre, pais2.idtb_pais, pais2.nombre FROM tb_modulo AS m JOIN tb_proyecto AS pr ON m.tb_proyecto_id = pr.idtb_proyecto JOIN tb_trabajador AS t ON pr.tb_trabajador_tb_persona_id = t.tb_persona_id JOIN tb_persona AS pe ON t.tb_persona_id = pe.idtb_persona JOIN tb_ciudad AS ciudad ON pe.tb_ciudad_id = ciudad.idtb_ciudad JOIN tb_departamento AS d ON ciudad.tb_departamento_id = d.idtb_departamento JOIN tb_pais AS pais ON d.tb_pais_id = pais.idtb_pais JOIN tb_cliente AS cl ON pr.tb_cliente_tb_persona_id = cl.tb_persona_id JOIN tb_persona AS pe1 ON cl.tb_persona_id = pe1.idtb_persona JOIN tb_ciudad AS c1 ON pe1.tb_ciudad_id = c1.idtb_ciudad JOIN tb_departamento AS d1 ON c1.tb_departamento_id = d1.idtb_departamento JOIN tb_pais AS p1 ON d1.tb_pais_id = p1.idtb_pais JOIN tb_trabajador AS t2 ON pr.tb_trabajador_tb_persona_id1 = t2.tb_persona_id JOIN tb_persona AS pe2 ON t2.tb_persona_id = pe2.idtb_persona JOIN tb_ciudad AS ciudad2 ON pe2.tb_ciudad_id = ciudad2.idtb_ciudad JOIN tb_departamento AS d2 ON ciudad2.tb_departamento_id = d2.idtb_departamento JOIN tb_pais AS pais2 ON d2.tb_pais_id = pais2.idtb_pais WHERE m.idtb_modulo; ";

            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));

            while (rs.next()) {
                Pais pais1 = new Pais(rs.getInt(41), rs.getString(42));
                Departamento departamento1 = new Departamento(rs.getInt(39), rs.getString(40), pais1);
                Ciudad ciudad1 = new Ciudad(rs.getInt(37), rs.getString(38), departamento1);
                Persona persona1 = new Persona(rs.getInt(29), rs.getString(30), rs.getString(31), rs.getString(32), rs.getString(33), (Image) rs.getBlob(34), rs.getString(35), rs.getString(36), ciudad1);
                Cliente cliente = new Cliente(persona1, rs.getString(27), rs.getString(28));

                Pais pais = new Pais(rs.getInt(25), rs.getString(26));
                Departamento departamento = new Departamento(rs.getInt(23), rs.getString(24), pais);
                Ciudad ciudad = new Ciudad(rs.getInt(21), rs.getString(22), departamento);
                Persona persona = new Persona(rs.getInt(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), (Image) rs.getBlob(18), rs.getString(19), rs.getString(20), ciudad);
                Trabajador administrador = new Trabajador(persona, rs.getString(12));

                Pais pais2 = new Pais(rs.getInt(56), rs.getString(57));
                Departamento departamento2 = new Departamento(rs.getInt(54), rs.getString(55), pais2);
                Ciudad ciudad2 = new Ciudad(rs.getInt(52), rs.getString(53), departamento2);
                Persona persona2 = new Persona(rs.getInt(44), rs.getString(45), rs.getString(46), rs.getString(47), rs.getString(48), (Image) rs.getBlob(49), rs.getString(50), rs.getString(51), ciudad2);
                Trabajador programador = new Trabajador(persona2, rs.getString(43));

                Proyecto proyecto = new Proyecto(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getTimestamp(7), rs.getTimestamp(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        administrador, cliente, programador);
                Modulo modulo = new Modulo(rs.getInt(1), rs.getString(2), rs.getString(3), proyecto);
                listaRetorno.add(modulo);
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
    public boolean insertar(Modulo modulo) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{null,
                modulo.getNombre(), modulo.getEstado(), modulo.getProyecto()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Modulo modulo) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, tb_pais_id()=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{
                modulo.getNombre(), modulo.getEstado(), modulo.getProyecto()});
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
