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

    @Override
    public Modulo buscar(int id) {
        Modulo modulo = null;
        try {
            String sql = "SELECT * FROM tb_modulo WHERE idtb_modulo =" + id;
            
            ResultSet rs = conexion.recuperar(String.format(sql));
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
            String sql = "SELECT * FROM tb_modulo";

            ResultSet rs = conexion.recuperar(String.format(sql));

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
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?,?)", TABLA), new Object[]{null,
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
