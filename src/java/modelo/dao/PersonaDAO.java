/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import config.Information;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.Persona;
import modelo.interfaces.PersonaInterface;

/**
 *
 * @author ESTUDIANTE
 */
public class PersonaDAO implements PersonaInterface {

    public void listarImg(int id, HttpServletRequest request, HttpServletResponse response) {
        String sql = "SELECT foto FROM tb_persona WHERE idtb_persona=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");
        try {
            outputStream = response.getOutputStream();
            ResultSet rs = conexion.recuperar(sql);
            if (rs.next()) {
                inputStream = (rs.getString(1).equals("") | rs.getObject(1) == null) ? null : rs.getBinaryStream(1);
            }
            if (inputStream != null) {
                bufferedInputStream = new BufferedInputStream(inputStream);
                bufferedOutputStream = new BufferedOutputStream(outputStream);

                int i = 0;
                while ((i = bufferedInputStream.read()) != -1) {
                    bufferedOutputStream.write(i);
                }
                rs.close();
                conexion.cerrar();
            } else {
                response.sendRedirect((Information.getURL_WEB() + request.getContextPath() + "/img/dashboard/usuario.png"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getUltimoRegistro() {
        int retorno = 0;
        try {

            ResultSet rs = conexion.recuperar(String.format("SELECT max(idtb_persona) FROM %s", TABLA));
            while (rs.next()) {

                retorno = rs.getInt(1);
            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return retorno;
        }
    }

    @Override
    public ArrayList<Persona> listar() {
        ArrayList<Persona> listaRetorno = new ArrayList<>();
        try {
            String sql = "Select * from tb_persona";

            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {
                Persona persona = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBinaryStream(8), rs.getInt(9));

                listaRetorno.add(persona);
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
    public Persona buscar(int id) {
        Persona persona = null;
        try {

            String sql = "Select * from tb_persona where idtb_persona = " + id;

            ResultSet rs = conexion.recuperar(sql);
            while (rs.next()) {

                persona = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBinaryStream(8), rs.getInt(9));

            }
            rs.close();
            conexion.cerrar();
        } catch (Exception ex) {
            throw ex;
        } finally {
            return persona;
        }
    }

    @Override
    public boolean insertar(Persona persona) {

        try {
            return conexion.ejecutar(String.format("INSERT INTO %s VALUES(?,?,?,?,?,?,?,?,?)", TABLA), new Object[]{null, persona.getNombre(), persona.getApellido_paterno(), persona.getApellido_materno(), persona.getCorreo(), persona.getTipo_identificacion(), persona.getNumero_identificacion(), persona.getFoto(), persona.getTb_ciudad_id()});
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean editar(Persona persona) {
        try {
            return conexion.ejecutar(String.format("UPDATE %s SET nombre=?, apellido_paterno=?, apellido_materno=?, correo=?, tipo_identificacion=?, numero_identificacion=?,  foto=?, tb_ciudad_id=? WHERE %s=?", TABLA, CLAVE_PRIMARIA), new Object[]{persona.getNombre(), persona.getApellido_paterno(), persona.getApellido_materno(), persona.getCorreo(), persona.getTipo_identificacion(), persona.getNumero_identificacion(), persona.getFoto(), persona.getTb_ciudad_id(), persona.getIdtb_persona()});
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
