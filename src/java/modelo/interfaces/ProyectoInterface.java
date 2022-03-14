/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Proyecto;


/**
 *
 * @author Sttefany
 */
public interface ProyectoInterface {
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_proyecto";
    final String ATRIBUTOS[] = {"idtb_proyecto","nombre", "estado", "fecha_inicio", "fecha_fin", "tarea", 
    "tarea_descripcion", "checklist", "tb_trabajador_id", "tb_cliente_id"};
    final String CLAVE_PRIMARIA = "idtb_proyecto";
    
    public ArrayList<Proyecto> listar();
    public Proyecto buscar(int id);
    public boolean insertar(Proyecto proyecto);
    public boolean editar(Proyecto proyecto);
    public boolean eliminar(int id);
}
