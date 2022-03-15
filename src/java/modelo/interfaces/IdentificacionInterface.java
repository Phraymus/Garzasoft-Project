/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Identificacion;

/**
 *
 * @author ESTUDIANTE
 */
public interface IdentificacionInterface {
    final Conexion conexion = new Conexion();
    final String TABLA = "tb_identificacion";
    final String ATRIBUTOS[] = {"idtb_identifiacion", "tipo", "numero"};
    final String CLAVE_PRIMARIA = "idtb_identifiacion";
    
    public ArrayList<Identificacion> listar();
    public Identificacion buscar(int id);
    public boolean insertar(Identificacion identificacion);
    public boolean editar(Identificacion identificacion);
    public boolean eliminar(int id);
}
