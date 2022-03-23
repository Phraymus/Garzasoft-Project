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
import static modelo.interfaces.PersonaInterface.TABLA;
import static modelo.interfaces.PersonaInterface.conexion;

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
            String sql = "SELECT m.idtb_modulo, m.nombre, m.estado,pr.idtb_proyecto, pr.nombre, "
                    + "pr.estado, pr.fecha_inicio, pr.fecha_fin, pr.tarea, pr.tarea_descripcion, pr.checklist "
                    + "FROM tb_modulo AS m JOIN tb_proyecto AS pr ON m.tb_proyecto_id = pr.idtb_proyecto" + id;
            
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));
            while (rs.next()) {
                  modulo = new Modulo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));

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
            String sql = "SELECT m.idtb_modulo, m.nombre, m.estado,pr.idtb_proyecto, pr.nombre, "
                    + "pr.estado, pr.fecha_inicio, pr.fecha_fin, pr.tarea, pr.tarea_descripcion, pr.checklist "
                    + "FROM tb_modulo AS m JOIN tb_proyecto AS pr ON m.tb_proyecto_id = pr.idtb_proyecto";

            ResultSet rs = conexion.recuperar(String.format("%s FROM %s", sql, TABLA));

            while (rs.next()) {
                Modulo modulo = new Modulo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
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
                modulo.getNombre(), modulo.getEstado(), modulo.getTb_proyecto_id()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Modulo modulo) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET idtb_modulo=?, nombre=? , estado=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{
                modulo.getNombre(), modulo.getEstado(), modulo.getTb_proyecto_id()});
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
