/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.awt.Image;
import java.sql.ResultSet;
import java.util.ArrayList;
import jdk.jfr.Timestamp;
import modelo.beans.Ciudad;
import modelo.beans.Cliente;
import modelo.beans.Departamento;
import modelo.beans.Modulo;
import modelo.beans.Pais;
import modelo.beans.Persona;
import modelo.beans.Proyecto;
import modelo.beans.Requerimiento;
import modelo.beans.Trabajador;
import modelo.interfaces.RequerimientoInterface;

/**
 *
 * @author Windows10
 */
public class RequerimientoDAO implements RequerimientoInterface{

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
    public Requerimiento buscar(int id) {
        Requerimiento  requerimiento = null;
        try {
            String sql = "SELECT r.idtb_checklist , r.nombre, r.estado, r.fecha_inicio, r.fecha_fin, m.idtb_modulo, m.nombre, m.estado, pr.idtb_proyecto, pr.nombre, pr.estado, pr.fecha_inicio, pr.fecha_fin, pr.tarea, pr.tarea_descripcion, pr.checklist, t.tipo, pe.idtb_persona, pe.nombre ,pe.apellido_paterno ,pe.apellido_materno, pe.correo, pe.foto, pe.tipo_identificacion, pe.numero_identificacion, ciudad.idtb_ciudad, ciudad.nombre, d.idtb_departamento, d.nombre, pais.idtb_pais, pais.nombre, cl.ruc, cl.nombre_empresa, pe1.idtb_persona, pe1.nombre, pe1.apellido_materno, pe1.apellido_materno, pe1.correo, pe1.foto, pe1.tipo_identificacion, pe1.numero_identificacion, c1.idtb_ciudad ,c1.nombre, d1.idtb_departamento, d1.nombre, p1.idtb_pais, p1.nombre, t2.tipo, pe2.idtb_persona, pe2.nombre, pe2.apellido_paterno ,pe2.apellido_materno, pe2.correo, pe2.foto, pe2.tipo_identificacion, pe2.numero_identificacion, ciudad2.idtb_ciudad, ciudad2.nombre, d2.idtb_departamento, d2.nombre, pais2.idtb_pais, pais2.nombre FROM tb_requerimiento AS r JOIN  tb_modulo AS m ON r.tb_modulo_id = m.idtb_modulo JOIN tb_proyecto AS pr ON m.tb_proyecto_id = pr.idtb_proyecto JOIN tb_trabajador AS t ON pr.tb_trabajador_tb_persona_id = t.tb_persona_id JOIN tb_persona AS pe ON t.tb_persona_id = pe.idtb_persona JOIN tb_ciudad AS ciudad ON pe.tb_ciudad_id = ciudad.idtb_ciudad JOIN tb_departamento AS d ON ciudad.tb_departamento_id = d.idtb_departamento JOIN tb_pais AS pais ON d.tb_pais_id = pais.idtb_pais JOIN tb_cliente AS cl ON pr.tb_cliente_tb_persona_id = cl.tb_persona_id JOIN tb_persona AS pe1 ON cl.tb_persona_id = pe1.idtb_persona JOIN tb_ciudad AS c1 ON pe1.tb_ciudad_id = c1.idtb_ciudad JOIN tb_departamento AS d1 ON c1.tb_departamento_id = d1.idtb_departamento JOIN tb_pais AS p1 ON d1.tb_pais_id = p1.idtb_pais JOIN tb_trabajador AS t2 ON pr.tb_trabajador_tb_persona_id1 = t2.tb_persona_id JOIN tb_persona AS pe2 ON t2.tb_persona_id = pe2.idtb_persona JOIN tb_ciudad AS ciudad2 ON pe2.tb_ciudad_id = ciudad2.idtb_ciudad JOIN tb_departamento AS d2 ON ciudad2.tb_departamento_id = d2.idtb_departamento JOIN tb_pais AS pais2 ON d2.tb_pais_id = pais2.idtb_pais WHERE m.idtb_modulo "+id;
            
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql, TABLA, CLAVE_PRIMARIA, id));
            
            while (rs.next()) {
                Pais pais1 = new  Pais(rs.getInt(46), rs.getString(47));
                Departamento departamento1 = new  Departamento(rs.getInt(44), rs.getString(45), pais);
                Ciudad ciudad1 = new Ciudad(rs.getInt(42), rs.getString(43), departamento1);
                Persona persona1 = new Persona(rs.getInt(34), rs.getString(35), rs.getString(36), rs.getString(37), rs.getString(38), (Image) rs.getBlob(39), rs.getString(40), rs.getString(41), ciudad1 );
                Cliente cliente = new Cliente(persona1, rs.getString(32), rs.getString(33));

               
                Pais pais = new Pais(rs.getInt(30), rs.getString(31));
                Departamento departamento = new Departamento( rs.getInt(28), rs.getString(29), pais);
                Ciudad ciudad = new Ciudad(rs.getInt(26), rs.getString(27), departamento);
                Persona persona = new Persona(rs.getInt(18), rs.getString(19), rs.getString(20), 
                rs.getString(21), rs.getString(22), (Image) rs.getBlob(23), rs.getString(24), rs.getString(25), ciudad );
                Trabajador administrador = new Trabajador( persona, rs.getString(17));
                
                Pais pais2 = new Pais(rs.getInt(61), rs.getString(62));
                Departamento departamento2 = new Departamento( rs.getInt(59), rs.getString(60), pais2);
                Ciudad ciudad2 = new Ciudad(rs.getInt(57), rs.getString(58), departamento2);
                Persona persona2 = new Persona(rs.getInt(49), rs.getString(50), rs.getString(51), rs.getString(52), rs.getString(53),
                (Image) rs.getBlob(54), rs.getString(55), rs.getString(56), ciudad2 );
                Trabajador programador = new Trabajador(persona2, rs.getString(48));


                Proyecto proyecto = new Proyecto(rs.getInt(9), rs.getString(10), rs.getString(11), (Timestamp)rs.getTimestamp(12), (Timestamp)rs.getTimestamp(13), 
                rs.getString(14),rs.getString(15),rs.getString(16), programador, administrador, cliente );
                Modulo modulo = new Modulo(rs.getInt(6), rs.getString(7), rs.getString(8), proyecto);
                requerimiento = new Requerimiento(modulo, rs.getInt(1), rs.getString(2), rs.getString(3), (Timestamp)rs.getTimestamp(4), (Timestamp)rs.getTimestamp(5));

               
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return requerimiento;
        }
    }

    @Override
    public ArrayList<Requerimiento> listar() {
        ArrayList<Requerimiento> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT r.idtb_checklist , r.nombre, r.estado, r.fecha_inicio, r.fecha_fin, m.idtb_modulo, m.nombre, m.estado, pr.idtb_proyecto, pr.nombre, pr.estado, pr.fecha_inicio, pr.fecha_fin, pr.tarea, pr.tarea_descripcion, pr.checklist, t.tipo, pe.idtb_persona, pe.nombre ,pe.apellido_paterno ,pe.apellido_materno, pe.correo, pe.foto, pe.tipo_identificacion, pe.numero_identificacion, ciudad.idtb_ciudad, ciudad.nombre, d.idtb_departamento, d.nombre, pais.idtb_pais, pais.nombre, cl.ruc, cl.nombre_empresa, pe1.idtb_persona, pe1.nombre, pe1.apellido_materno, pe1.apellido_materno, pe1.correo, pe1.foto, pe1.tipo_identificacion, pe1.numero_identificacion, c1.idtb_ciudad ,c1.nombre, d1.idtb_departamento, d1.nombre, p1.idtb_pais, p1.nombre, t2.tipo, pe2.idtb_persona, pe2.nombre, pe2.apellido_paterno ,pe2.apellido_materno, pe2.correo, pe2.foto, pe2.tipo_identificacion, pe2.numero_identificacion, ciudad2.idtb_ciudad, ciudad2.nombre, d2.idtb_departamento, d2.nombre, pais2.idtb_pais, pais2.nombre FROM tb_requerimiento AS r JOIN  tb_modulo AS m ON r.tb_modulo_id = m.idtb_modulo JOIN tb_proyecto AS pr ON m.tb_proyecto_id = pr.idtb_proyecto JOIN tb_trabajador AS t ON pr.tb_trabajador_tb_persona_id = t.tb_persona_id JOIN tb_persona AS pe ON t.tb_persona_id = pe.idtb_persona JOIN tb_ciudad AS ciudad ON pe.tb_ciudad_id = ciudad.idtb_ciudad JOIN tb_departamento AS d ON ciudad.tb_departamento_id = d.idtb_departamento JOIN tb_pais AS pais ON d.tb_pais_id = pais.idtb_pais JOIN tb_cliente AS cl ON pr.tb_cliente_tb_persona_id = cl.tb_persona_id JOIN tb_persona AS pe1 ON cl.tb_persona_id = pe1.idtb_persona JOIN tb_ciudad AS c1 ON pe1.tb_ciudad_id = c1.idtb_ciudad JOIN tb_departamento AS d1 ON c1.tb_departamento_id = d1.idtb_departamento JOIN tb_pais AS p1 ON d1.tb_pais_id = p1.idtb_pais JOIN tb_trabajador AS t2 ON pr.tb_trabajador_tb_persona_id1 = t2.tb_persona_id JOIN tb_persona AS pe2 ON t2.tb_persona_id = pe2.idtb_persona JOIN tb_ciudad AS ciudad2 ON pe2.tb_ciudad_id = ciudad2.idtb_ciudad JOIN tb_departamento AS d2 ON ciudad2.tb_departamento_id = d2.idtb_departamento JOIN tb_pais AS pais2 ON d2.tb_pais_id = pais2.idtb_pais WHERE m.idtb_modulo;";
            
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {

                
               Pais pais1 = new  Pais(rs.getInt(46), rs.getString(47));
                Departamento departamento1 = new  Departamento(rs.getInt(44), rs.getString(45), pais);
                Ciudad ciudad1 = new Ciudad(rs.getInt(42), rs.getString(43), departamento1);
                Persona persona1 = new Persona(rs.getInt(34), rs.getString(35), rs.getString(36), rs.getString(37), rs.getString(38), (Image) rs.getBlob(39), rs.getString(40), rs.getString(41), ciudad1 );
                Cliente cliente = new Cliente(persona1, rs.getString(32), rs.getString(33));

               
                Pais pais = new Pais(rs.getInt(30), rs.getString(31));
                Departamento departamento = new Departamento( rs.getInt(28), rs.getString(29), pais);
                Ciudad ciudad = new Ciudad(rs.getInt(26), rs.getString(27), departamento);
                Persona persona = new Persona(rs.getInt(18), rs.getString(19), rs.getString(20), 
                rs.getString(21), rs.getString(22), (Image) rs.getBlob(23), rs.getString(24), rs.getString(25), ciudad );
                Trabajador administrador = new Trabajador( persona, rs.getString(17));
                
                Pais pais2 = new Pais(rs.getInt(61), rs.getString(62));
                Departamento departamento2 = new Departamento( rs.getInt(59), rs.getString(60), pais2);
                Ciudad ciudad2 = new Ciudad(rs.getInt(57), rs.getString(58), departamento2);
                Persona persona2 = new Persona(rs.getInt(49), rs.getString(50), rs.getString(51), rs.getString(52), rs.getString(53),
                (Image) rs.getBlob(54), rs.getString(55), rs.getString(56), ciudad2 );
                Trabajador programador = new Trabajador(persona2, rs.getString(48));


                Proyecto proyecto = new Proyecto(rs.getInt(9), rs.getString(10), rs.getString(11), (Timestamp)rs.getTimestamp(12), (Timestamp)rs.getTimestamp(13), 
                rs.getString(14),rs.getString(15),rs.getString(16), programador, administrador, cliente );
                Modulo modulo = new Modulo(rs.getInt(6), rs.getString(7), rs.getString(8), proyecto);
                Requerimiento requerimiento = new Requerimiento(modulo, rs.getInt(1), rs.getString(2), rs.getString(3), (Timestamp)rs.getTimestamp(4), (Timestamp)rs.getTimestamp(5));

               

                listaRetorno.add(requerimiento);
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
    public boolean insertar(Requerimiento requerimiento) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{null,  
            requerimiento.getNombre(), requerimiento.getEstado() ,requerimiento.getFecha_inicio(),
            requerimiento.getFecha_fin(), requerimiento.getModulo_id()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Requerimiento requerimiento) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, tb_pais_id()=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{
            requerimiento.getNombre(), requerimiento.getEstado() ,requerimiento.getFecha_inicio(),
            requerimiento.getFecha_fin(), requerimiento.getModulo_id()});
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
