/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Notificacion;
import modelo.beans.Usuario;

/**
 *
 * @author phraymus
 */
public interface NotificacionInterface {
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_notificacion";
    final String ATRIBUTOS[] = {"idtb_notificacion","tb_usuario_id", "titulo", "descripcion_corta", "descripcion_larga","tipo","color","fecha"};
    final String CLAVE_PRIMARIA = "idtb_modulo";
    
    public ArrayList<Notificacion> listarPorUsuario(Usuario usuario);
    public ArrayList<Notificacion> listar();
    public Notificacion buscar(int id);
    public boolean insertar(Notificacion notificacion);
    public boolean editar(Notificacion notificacion);
    public boolean eliminar(int id);
}
