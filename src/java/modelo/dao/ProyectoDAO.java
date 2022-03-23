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

/**
 *
 * @author Sttefany
 */
public class ProyectoDAO implements ProyectoInterface{
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
    public Proyecto buscar(int id) {
        Proyecto  proyecto = null;
        try {
            String sql = "SELECT pr.idtb_proyecto, pr.nombre, pr.estado, pr.fecha_inicio, pr.fecha_fin, pr.tarea, pr.tarea_descripcion, pr.checklist, t.tipo, pe.idtb_persona, pe.nombre ,pe.apellido_paterno ,pe.apellido_materno, pe.correo, pe.foto, pe.tipo_identificacion, pe.numero_identificacion, ciudad.idtb_ciudad, ciudad.nombre, d.idtb_departamento, d.nombre, pais.idtb_pais, pais.nombre, cl.ruc, cl.nombre_empresa, pe1.idtb_persona, pe1.nombre, pe1.apellido_paterno, pe1.apellido_materno, pe1.correo, pe1.foto, pe1.tipo_identificacion, pe1.numero_identificacion, c1.idtb_ciudad ,c1.nombre, d1.idtb_departamento, d1.nombre, p1.idtb_pais, p1.nombre, t2.tipo, pe2.idtb_persona, pe2.nombre, pe2.apellido_paterno ,pe2.apellido_materno, pe2.correo, pe2.foto, pe2.tipo_identificacion, pe2.numero_identificacion, ciudad2.idtb_ciudad, ciudad2.nombre, d2.idtb_departamento, d2.nombre, pais2.idtb_pais, pais2.nombre FROM tb_proyecto AS pr JOIN tb_trabajador AS t ON pr.tb_trabajador_tb_persona_id = t.tb_persona_id JOIN tb_persona AS pe ON t.tb_persona_id = pe.idtb_persona JOIN tb_ciudad AS ciudad ON pe.tb_ciudad_id = ciudad.idtb_ciudad JOIN tb_departamento AS d ON ciudad.tb_departamento_id = d.idtb_departamento JOIN tb_pais AS pais ON d.tb_pais_id = pais.idtb_pais JOIN tb_cliente AS cl ON pr.tb_cliente_tb_persona_id = cl.tb_persona_id JOIN tb_persona AS pe1 ON cl.tb_persona_id = pe1.idtb_persona JOIN tb_ciudad AS c1 ON pe1.tb_ciudad_id = c1.idtb_ciudad JOIN tb_departamento AS d1 ON c1.tb_departamento_id = d1.idtb_departamento JOIN tb_pais AS p1 ON d1.tb_pais_id = p1.idtb_pais JOIN tb_trabajador AS t2 ON pr.tb_trabajador_tb_persona_id1 = t2.tb_persona_id JOIN tb_persona AS pe2 ON t2.tb_persona_id = pe2.idtb_persona JOIN tb_ciudad AS ciudad2 ON pe2.tb_ciudad_id = ciudad2.idtb_ciudad JOIN tb_departamento AS d2 ON ciudad2.tb_departamento_id = d2.idtb_departamento JOIN tb_pais AS pais2 ON d2.tb_pais_id = pais2.idtb_pais WHERE pr.idtb_proyecto="+id; 
            
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Pais pais1;
                Departamento departamento1;
                Ciudad ciudad1 ;
                Persona persona1;
                Cliente cliente;               
                Pais pais ;
                Departamento departamento;
                Ciudad ciudad;
                Persona persona;
                Pais pais2;
                Trabajador administrador;
                Departamento departamento2;
                Ciudad ciudad2;
                Persona persona2;
                Trabajador programador;

              
                proyecto = new Proyecto();
                proyecto = null;
                if(rs.getString(6)==null && rs.getString(7)==null){
                  pais1 = new  Pais(rs.getInt(38), rs.getString(39));
                departamento1 = new  Departamento(rs.getInt(36), rs.getString(37), pais1);
                ciudad1 = new Ciudad(rs.getInt(34), rs.getString(35), departamento1);
                persona1 = new Persona(rs.getInt(26), rs.getString(27), rs.getString(28),
                rs.getString(29), rs.getString(30), (Image) rs.getBlob(31), rs.getString(32), rs.getString(33), ciudad1 );

                cliente = new Cliente(persona1, rs.getString(24), rs.getString(25));
                
                pais = new Pais(rs.getInt(22), rs.getString(23));
                departamento = new Departamento( rs.getInt(20), rs.getString(21), pais);
                ciudad = new Ciudad(rs.getInt(18), rs.getString(19), departamento);
                persona = new Persona(rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), 
                rs.getString(14), (Image) rs.getBlob(15), rs.getString(16), rs.getString(17), ciudad );
                administrador = new Trabajador( persona, rs.getString(9));
                
                pais2 = new Pais(rs.getInt(53), rs.getString(54));
                departamento2 = new Departamento( rs.getInt(51), rs.getString(52), pais2);
                ciudad2 = new Ciudad(rs.getInt(49), rs.getString(50), departamento2);
                persona2 = new Persona(rs.getInt(41), rs.getString(42), rs.getString(43), 
                rs.getString(44), rs.getString(45), (Image) rs.getBlob(46), rs.getString(47), rs.getString(48), ciudad2 );
                programador = new Trabajador(persona2, rs.getString(40));

                proyecto = new Proyecto(rs.getInt(1), rs.getString(2), rs.getString(3), (Timestamp)rs.getTimestamp(4), 
                (Timestamp)rs.getTimestamp(5), null ,null ,rs.getString(8), administrador, cliente, programador );
                
              }
                else {
                     pais1 = new  Pais(rs.getInt(38), rs.getString(39));
                departamento1 = new  Departamento(rs.getInt(36), rs.getString(37), pais1);
                ciudad1 = new Ciudad(rs.getInt(34), rs.getString(35), departamento1);
                persona1 = new Persona(rs.getInt(26), rs.getString(27), rs.getString(28),
                rs.getString(29), rs.getString(30), (Image) rs.getBlob(31), rs.getString(32), rs.getString(33), ciudad1 );

                cliente = new Cliente(persona1, rs.getString(24), rs.getString(25));
                
                pais = new Pais(rs.getInt(22), rs.getString(23));
                departamento = new Departamento( rs.getInt(20), rs.getString(21), pais);
                ciudad = new Ciudad(rs.getInt(18), rs.getString(19), departamento);
                persona = new Persona(rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), 
                rs.getString(14), (Image) rs.getBlob(15), rs.getString(16), rs.getString(17), ciudad );
                administrador = new Trabajador( persona, rs.getString(9));
                
                pais2 = new Pais(rs.getInt(53), rs.getString(54));
                departamento2 = new Departamento( rs.getInt(51), rs.getString(52), pais2);
                ciudad2 = new Ciudad(rs.getInt(49), rs.getString(50), departamento2);
                persona2 = new Persona(rs.getInt(41), rs.getString(42), rs.getString(43), 
                rs.getString(44), rs.getString(45), (Image) rs.getBlob(46), rs.getString(47), rs.getString(48), ciudad2 );
                programador = new Trabajador(persona2, rs.getString(40));

                proyecto = new Proyecto(rs.getInt(1), rs.getString(2), rs.getString(3), (Timestamp)rs.getTimestamp(4), 
                (Timestamp)rs.getTimestamp(5), rs.getString(6) ,rs.getString(7),null, administrador, cliente, programador );
                 
                }
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
            String sql = "SELECT pr.idtb_proyecto, pr.nombre, pr.estado, pr.fecha_inicio, pr.fecha_fin, pr.tarea, pr.tarea_descripcion, pr.checklist, t.tipo, pe.idtb_persona, pe.nombre ,pe.apellido_paterno ,pe.apellido_materno, pe.correo, pe.foto, pe.tipo_identificacion, pe.numero_identificacion, ciudad.idtb_ciudad, ciudad.nombre, d.idtb_departamento, d.nombre, pais.idtb_pais, pais.nombre, cl.ruc, cl.nombre_empresa, pe1.idtb_persona, pe1.nombre, pe1.apellido_materno, pe1.apellido_materno, pe1.correo, pe1.foto, pe1.tipo_identificacion, pe1.numero_identificacion, c1.idtb_ciudad ,c1.nombre, d1.idtb_departamento, d1.nombre, p1.idtb_pais, p1.nombre, t2.tipo, pe2.idtb_persona, pe2.nombre, pe2.apellido_paterno ,pe2.apellido_materno, pe2.correo, pe2.foto, pe2.tipo_identificacion, pe2.numero_identificacion, ciudad2.idtb_ciudad, ciudad2.nombre, d2.idtb_departamento, d2.nombre, pais2.idtb_pais, pais2.nombre FROM tb_proyecto AS pr JOIN tb_trabajador AS t ON pr.tb_trabajador_tb_persona_id = t.tb_persona_id JOIN tb_persona AS pe ON t.tb_persona_id = pe.idtb_persona JOIN tb_ciudad AS ciudad ON pe.tb_ciudad_id = ciudad.idtb_ciudad JOIN tb_departamento AS d ON ciudad.tb_departamento_id = d.idtb_departamento JOIN tb_pais AS pais ON d.tb_pais_id = pais.idtb_pais JOIN tb_cliente AS cl ON pr.tb_cliente_tb_persona_id = cl.tb_persona_id JOIN tb_persona AS pe1 ON cl.tb_persona_id = pe1.idtb_persona JOIN tb_ciudad AS c1 ON pe1.tb_ciudad_id = c1.idtb_ciudad JOIN tb_departamento AS d1 ON c1.tb_departamento_id = d1.idtb_departamento JOIN tb_pais AS p1 ON d1.tb_pais_id = p1.idtb_pais JOIN tb_trabajador AS t2 ON pr.tb_trabajador_tb_persona_id1 = t2.tb_persona_id JOIN tb_persona AS pe2 ON t2.tb_persona_id = pe2.idtb_persona JOIN tb_ciudad AS ciudad2 ON pe2.tb_ciudad_id = ciudad2.idtb_ciudad JOIN tb_departamento AS d2 ON ciudad2.tb_departamento_id = d2.idtb_departamento JOIN tb_pais AS pais2 ON d2.tb_pais_id = pais2.idtb_pais WHERE pr.idtb_proyecto ";
            
            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                
                Pais pais1;
                Departamento departamento1;
                Ciudad ciudad1 ;
                Persona persona1;
                Cliente cliente;               
                Pais pais ;
                Departamento departamento;
                Ciudad ciudad;
                Persona persona;
                Pais pais2;
                Trabajador administrador;
                Departamento departamento2;
                Ciudad ciudad2;
                Persona persona2;
                Trabajador programador;

              
                Proyecto proyecto = new Proyecto();
                proyecto = null;
                if(rs.getString(6)==null && rs.getString(7)==null){
                  pais1 = new  Pais(rs.getInt(38), rs.getString(39));
                departamento1 = new  Departamento(rs.getInt(36), rs.getString(37), pais1);
                ciudad1 = new Ciudad(rs.getInt(34), rs.getString(35), departamento1);
                persona1 = new Persona(rs.getInt(26), rs.getString(27), rs.getString(28),
                rs.getString(29), rs.getString(30), (Image) rs.getBlob(31), rs.getString(32), rs.getString(33), ciudad1 );

                cliente = new Cliente(persona1, rs.getString(24), rs.getString(25));
                
                pais = new Pais(rs.getInt(22), rs.getString(23));
                departamento = new Departamento( rs.getInt(20), rs.getString(21), pais);
                ciudad = new Ciudad(rs.getInt(18), rs.getString(19), departamento);
                persona = new Persona(rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), 
                rs.getString(14), (Image) rs.getBlob(15), rs.getString(16), rs.getString(17), ciudad );
                administrador = new Trabajador( persona, rs.getString(9));
                
                pais2 = new Pais(rs.getInt(53), rs.getString(54));
                departamento2 = new Departamento( rs.getInt(51), rs.getString(52), pais2);
                ciudad2 = new Ciudad(rs.getInt(49), rs.getString(50), departamento2);
                persona2 = new Persona(rs.getInt(41), rs.getString(42), rs.getString(43), 
                rs.getString(44), rs.getString(45), (Image) rs.getBlob(46), rs.getString(47), rs.getString(48), ciudad2 );
                programador = new Trabajador(persona2, rs.getString(40));

                proyecto = new Proyecto(rs.getInt(1), rs.getString(2), rs.getString(3), (Timestamp)rs.getTimestamp(4), 
                (Timestamp)rs.getTimestamp(5), null ,null ,rs.getString(8), administrador, cliente, programador );
                
              }
                else {
                     pais1 = new  Pais(rs.getInt(38), rs.getString(39));
                departamento1 = new  Departamento(rs.getInt(36), rs.getString(37), pais1);
                ciudad1 = new Ciudad(rs.getInt(34), rs.getString(35), departamento1);
                persona1 = new Persona(rs.getInt(26), rs.getString(27), rs.getString(28),
                rs.getString(29), rs.getString(30), (Image) rs.getBlob(31), rs.getString(32), rs.getString(33), ciudad1 );

                cliente = new Cliente(persona1, rs.getString(24), rs.getString(25));
                
                pais = new Pais(rs.getInt(22), rs.getString(23));
                departamento = new Departamento( rs.getInt(20), rs.getString(21), pais);
                ciudad = new Ciudad(rs.getInt(18), rs.getString(19), departamento);
                persona = new Persona(rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), 
                rs.getString(14), (Image) rs.getBlob(15), rs.getString(16), rs.getString(17), ciudad );
                administrador = new Trabajador( persona, rs.getString(9));
                
                pais2 = new Pais(rs.getInt(53), rs.getString(54));
                departamento2 = new Departamento( rs.getInt(51), rs.getString(52), pais2);
                ciudad2 = new Ciudad(rs.getInt(49), rs.getString(50), departamento2);
                persona2 = new Persona(rs.getInt(41), rs.getString(42), rs.getString(43), 
                rs.getString(44), rs.getString(45), (Image) rs.getBlob(46), rs.getString(47), rs.getString(48), ciudad2 );
                programador = new Trabajador(persona2, rs.getString(40));

                proyecto = new Proyecto(rs.getInt(1), rs.getString(2), rs.getString(3), (Timestamp)rs.getTimestamp(4), 
                (Timestamp)rs.getTimestamp(5), rs.getString(6) ,rs.getString(7),null, administrador, cliente, programador );
                 
                }
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
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?)", TABLA), new Object[]{null,  
            proyecto.getNombre(), proyecto.getEstado(), proyecto.getFecha_inicio(),
            proyecto.getFecha_fin(), proyecto.getTarea(), proyecto.getTarea_descripcion(),
            proyecto.getChecklist(), proyecto.getAdministrador(), proyecto.getCliente(), proyecto.getProgramador()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Proyecto proyecto) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET idtb_proyecto=?, nombre=?, estado=?, fecha_inicio=?, fecha_fin=?,tarea=?, tarea_descripcion=?,  checklist=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{
            proyecto.getNombre(), proyecto.getEstado(), proyecto.getFecha_inicio(),
            proyecto.getFecha_fin(), proyecto.getTarea(), proyecto.getTarea_descripcion(),
            proyecto.getChecklist(),  proyecto.getAdministrador(), proyecto.getCliente(), proyecto.getProgramador()});
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
