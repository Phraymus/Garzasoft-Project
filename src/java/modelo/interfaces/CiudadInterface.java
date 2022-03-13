/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Ciudad;

/**
 *
 * @author Marco
 */
public interface CiudadInterface {
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_ciudad";
    final String ATRIBUTOS[] = {"idtb_ciudad", "nombre", "tb_departamento_id"};
    final String CLAVE_PRIMARIA = "idtb_ciudad";
    
    public ArrayList<Ciudad> listar();
    public Ciudad buscar(int id);
    public boolean insertar(Ciudad ciudad);
    public boolean editar(Ciudad ciudad);
    public boolean eliminar(int id);
}
