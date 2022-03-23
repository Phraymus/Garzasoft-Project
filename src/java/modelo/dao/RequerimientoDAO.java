/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;


import java.awt.Image;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;

import modelo.beans.Ciudad;
import modelo.beans.Cliente;
import modelo.beans.Departamento;
import modelo.beans.Modulo;
import modelo.beans.Pais;
import modelo.beans.Persona;
import modelo.beans.Proyecto;
import modelo.beans.Requerimiento;
import modelo.beans.Trabajador;
import static modelo.interfaces.PersonaInterface.TABLA;
import static modelo.interfaces.PersonaInterface.conexion;
import modelo.interfaces.RequerimientoInterface;
import static modelo.interfaces.RequerimientoInterface.CLAVE_PRIMARIA;
import static modelo.interfaces.RequerimientoInterface.TABLA;
import static modelo.interfaces.RequerimientoInterface.conexion;

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
            String sql = "SELECT r.idtb_checklist , r.nombre, r.estado, r.fecha_inicio, r.fecha_fin, m.idtb_modulo , m.nombre, m.estado "
                    + "FROM tb_requerimiento AS r JOIN  tb_modulo AS m ON r.tb_modulo_id = m.idtb_modulo "+id;
            
             ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            
            while (rs.next()) {
                
            requerimiento = new Requerimiento(rs.getInt(1), rs.getString(2), rs.getString(3), (Timestamp)rs.getTimestamp(4), (Timestamp)rs.getTimestamp(5), rs.getInt(6));
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
            String sql = "SELECT r.idtb_checklist , r.nombre, r.estado, r.fecha_inicio, r.fecha_fin, m.idtb_modulo , m.nombre, m.estado "
                    + "FROM tb_requerimiento AS r JOIN  tb_modulo AS m ON r.tb_modulo_id = m.idtb_modulo ";
            
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {

                Requerimiento requerimiento = new Requerimiento(rs.getInt(1), rs.getString(2), rs.getString(3), (Timestamp)rs.getTimestamp(4), (Timestamp)rs.getTimestamp(5), rs.getInt(6));

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
            requerimiento.getFecha_fin(), requerimiento.getTb_modulo_id()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Requerimiento requerimiento) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET idtb_checklist=?, nombre=?, fecha_inicio=?, fecha_fin=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{
            requerimiento.getNombre(), requerimiento.getEstado() ,requerimiento.getFecha_inicio(),
            requerimiento.getFecha_fin(), requerimiento.getTb_modulo_id()});
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
