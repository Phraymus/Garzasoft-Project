/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Persona;

/**
 *
 * @author ESTUDIANTE
 */
public interface PersonaInterface {

    final Conexion conexion = new Conexion();
    final String TABLA = "tb_persona";
    final String ATRIBUTOS[] = {"idtb_persona", "nombre", "apellido_paterno", "apellido_materno", "correo", "foto", "tipo_identificacion", "numero_identificacion", "tb_cuidad_id"};
    final String CLAVE_PRIMARIA = "idtb_persona";

    public ArrayList<Persona> listar();

    public Persona buscar(int id);

    public boolean insertar(Persona persona);

    public boolean editar(Persona persona);

    public boolean eliminar(int id);
}
