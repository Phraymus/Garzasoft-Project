/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Trabajador;
import modelo.interfaces.DAO;
import java.sql.ResultSet;
import modelo.beans.Cliente;



/**
 *
 * @author ELIAS
 */
public class TrabajadorDAO implements DAO{
     Conexion conexion;

    final String TABLA = "tb_trabajador";
    final String ATRIBUTOS[] = {"tb_persona_id", "tipo"};
    final String CLAVE_PRIMARIA = "tb_persona_id";

    public ArrayList<Object[]> listar(String sql, int numeroAtributos) {
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
        } catch (Exception ex) {
            throw ex;
        } finally {
            return listaRetorno;
        }
    }

    public Trabajador buscar(int id) {
        Trabajador trabajador = null;
        try {
            String sql="SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql=(i==ATRIBUTOS.length-1)?sql+ATRIBUTOS[i]+", ":sql+ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s WHERE %s=%d", sql,TABLA,CLAVE_PRIMARIA,id));
            while (rs.next()) {
                trabajador.setTb_persona_id(rs.getInt(1));
                trabajador.setTipo(rs.getString(1));
                
            }
            rs.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return trabajador;
        }
    }

    @Override
    public ArrayList<Trabajador> listar() {
        ArrayList<Trabajador> listaRetorno = new ArrayList<>();
        try {
            String sql="SELECT ";
            for (int i = 0; i < ATRIBUTOS.length; i++) {
                sql=(i==ATRIBUTOS.length-1)?sql+ATRIBUTOS[i]+", ":sql+ATRIBUTOS[i];
            }
            ResultSet rs = conexion.recuperar(String.format("%s FROM %s",sql,TABLA));
            while (rs.next()) {
                Trabajador trabajador = new Trabajador();

                trabajador.setTb_persona_id(rs.getInt(1));
                trabajador.setTipo(rs.getString(1));

                listaRetorno.add(trabajador);
            }
            rs.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return listaRetorno;
        }
    }
    

    @Override
    public boolean insertar(Trabajador trabajador) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?)", TABLA), new Object[]{trabajador.getTb_persona_id(), trabajador.getTipo()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Trabajador trabajador) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET tipo=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{trabajador.getTipo(), trabajador.getTb_persona_id()});
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

    @Override
    public boolean insertar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
