/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import jdk.jfr.Timestamp;
import modelo.beans.Medio;
import modelo.beans.Reunion;
import modelo.interfaces.ReunionInterface;

/**
 *
 * @author ELIAS
 */
public class ReunionDAO implements ReunionInterface {
     /*public ArrayList<Object[]> listar(String sql, int numeroAtributos) {
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
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return listaRetorno;
        }
    }*/

     @Override
    public Reunion buscar(int id) {
        Reunion reunion = null;
        try {
            String sql = "SELECT r.idtb_reuniones,r.fecha,r.asunto,r.link,m.idtb_medio,m.nombre FROM tb_reunion AS r JOIN tb_medio AS m ON r.tb_medio_id=m.idtb_medio WHERE r.idtb_reuniones = "+id;
            ResultSet rs = conexion.recuperar(sql); 
            while (rs.next()) {
                
                reunion = new Reunion();
                Medio medio= new Medio(rs.getInt(5), rs.getString(6));
 
                reunion.setIdtb_reuniones(rs.getInt(1));
                reunion.setFecha((Timestamp)rs.getTimestamp(2));
                reunion.setAsunto(rs.getString(3));
                reunion.setLink(rs.getString(4));
                reunion.setMedio(medio);
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return reunion;
        }
    }

    @Override
    public ArrayList<Reunion> listar() {
        ArrayList<Reunion> listaRetorno = new ArrayList<>();
        try {
            String sql = "SELECT r.idtb_reuniones,r.fecha,r.asunto,r.link,m.idtb_medio,m.nombre FROM tb_reunion AS r JOIN tb_medio AS m ON r.tb_medio_id=m.idtb_medio ";
            
            ResultSet rs = conexion.recuperar(sql);
            
            while (rs.next()) {
                Reunion reunion = new Reunion();
               
                Medio medio= new Medio(rs.getInt(5), rs.getString(6));
 
                reunion.setIdtb_reuniones(rs.getInt(1));
                reunion.setFecha((Timestamp)rs.getTimestamp(2));
                reunion.setAsunto(rs.getString(3));
                reunion.setLink(rs.getString(4));
                reunion.setMedio(medio);

                listaRetorno.add( reunion);
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
    public boolean insertar(Reunion reunion) {
        try {
            return conexion.ejecutar(String.format("INSERT IGNORE INTO %s VALUES(?,?,?,?,?)", TABLA), new Object[]{null, reunion.getFecha(),reunion.getAsunto(),reunion.getLink(),reunion.getMedio().getIdtb_medio()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Reunion reunion) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, Tb_departamento_id=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{ reunion.getFecha(),reunion.getAsunto(),reunion.getLink(),reunion.getMedio().getIdtb_medio()});
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
