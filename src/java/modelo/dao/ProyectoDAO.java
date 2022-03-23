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
            String sql = "SELECT * FROM tb_proyecto ="+id; 
            
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
                
                proyecto = new Proyecto();
                proyecto = null;
                if(rs.getString(6)==null && rs.getString(7)==null){
                
                proyecto = new Proyecto(rs.getInt(1), rs.getString(2), rs.getString(3), (Timestamp)rs.getTimestamp(4), 
                (Timestamp)rs.getTimestamp(5), null ,null ,rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11) ); 
                
              }
                else {
                
                proyecto = new Proyecto(rs.getInt(1), rs.getString(2), rs.getString(3), (Timestamp)rs.getTimestamp(4), 
                (Timestamp)rs.getTimestamp(5), rs.getString(6) ,rs.getString(7),null, rs.getInt(9), rs.getInt(10), rs.getInt(11) );
                 
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
            String sql = "SELECT * FROM tb_proyecto ";
            
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
               
                Proyecto proyecto = new Proyecto();
                proyecto = null;
                 if(rs.getString(6)==null && rs.getString(7)==null){
                
                proyecto = new Proyecto(rs.getInt(1), rs.getString(2), rs.getString(3), (Timestamp)rs.getTimestamp(4), 
                (Timestamp)rs.getTimestamp(5), null ,null ,rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11) ); 
                
              }
                else {
                
                proyecto = new Proyecto(rs.getInt(1), rs.getString(2), rs.getString(3), (Timestamp)rs.getTimestamp(4), 
                (Timestamp)rs.getTimestamp(5), rs.getString(6) ,rs.getString(7),null, rs.getInt(9), rs.getInt(10), rs.getInt(11) );
                 
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
            proyecto.getChecklist(), proyecto.getTb_trabajador_persona_id(), proyecto.getTb_cliente_persona_id(), proyecto.getTb_trabajador_persona_id1()});
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
            proyecto.getChecklist(),  proyecto.getTb_trabajador_persona_id(), proyecto.getTb_cliente_persona_id(), proyecto.getTb_trabajador_persona_id1()});
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
