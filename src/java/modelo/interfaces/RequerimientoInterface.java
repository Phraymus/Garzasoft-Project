/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Requerimiento;

/**
 *
 * @author Sttefany
 */
public interface RequerimientoInterface {
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_requerimiento";
    final String ATRIBUTOS[] = {"idtb_checklist", "nombre", "estado", "fecha_inicio", "fecha_fin", "modulo_id"};
    final String CLAVE_PRIMARIA = "idtb_checklist";
    
    public ArrayList<Requerimiento> listar();
    public Requerimiento buscar(int id);
    public boolean insertar(Requerimiento requerimiento);
    public boolean editar(Requerimiento requerimiento);
    public boolean eliminar(int id);
}
