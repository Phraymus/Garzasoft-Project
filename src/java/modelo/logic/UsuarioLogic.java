/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logic;

import java.util.ArrayList;
import modelo.beans.Persona;
import modelo.beans.Usuario;
import modelo.dao.UsuarioDAO;
import modelo.interfaces.UsuarioInterface;

/**
 *
 * @author ESTUDIANTE
 */
public class UsuarioLogic implements UsuarioInterface {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public String[] generarUsuario(Usuario usuario) {

        PersonaLogic personaLogic = new PersonaLogic();
        Persona persona = (!usuario.getPerfil_usuario().equals("C")) ? personaLogic.buscar(usuario.getTb_trabajador_id()) : personaLogic.buscar(usuario.getTb_cliente_idc());
        
        StringBuilder nombreUsuario = new StringBuilder(usuario.getPerfil_usuario() + persona.getApellido_paterno() + persona.getNumero_identificacion().substring(persona.getNumero_identificacion().length() - 3, persona.getNumero_identificacion().length()) + Math.round(Math.random() * 20 + 1));

        String clave = "";

        for (int i = 0; i < 5; i++) {
            int caracter1 = (int) Math.round(Math.random() * 26 + 97);
            int caracter2 = (int) Math.round(Math.random() * 10);
            clave += String.valueOf((char) caracter1) + caracter2;
        }

        while (nombreUsuario.lastIndexOf(" ") != -1) {
            nombreUsuario.replace(nombreUsuario.lastIndexOf(" "), nombreUsuario.lastIndexOf(" ") + 1, "");
        }

        int adicional = 1;
        while (this.buscar(String.valueOf(nombreUsuario) + String.valueOf(adicional)) != -1) {
            adicional++;
        }
        nombreUsuario.append(String.valueOf(adicional));

        usuario.setNombre(String.valueOf(nombreUsuario));
        usuario.setClave(clave);

        if (this.insertar(usuario)) {
            return new String[]{String.valueOf(nombreUsuario), clave};
        } else {
            return new String[]{"Error", "Error"};
        }
    }
    
    public Usuario autentificar(String nombre, String clave) {
        return usuarioDAO.autentificar(nombre,clave);
    }

    public ArrayList<Usuario> listarUsuariosTrabajadores() {
        return usuarioDAO.listarUsuariosTrabajadores();
    }
    
    public ArrayList<Usuario> listarUsuariosClientes() {
        return usuarioDAO.listarUsuariosClientes();
    }

    public int buscar(String nombre) {
        return usuarioDAO.buscar(nombre);
    }

    @Override
    public ArrayList<Usuario> listar() {
        return usuarioDAO.listar();
    }

    @Override
    public Usuario buscar(int id) {
        return usuarioDAO.buscar(id);
    }

    @Override
    public boolean insertar(Usuario usuario) {
        return usuarioDAO.insertar(usuario);
    }

    @Override
    public boolean editar(Usuario usuario) {
        return usuarioDAO.editar(usuario);
    }

    @Override
    public boolean eliminar(int id) {
        return usuarioDAO.eliminar(id);
    }

}
