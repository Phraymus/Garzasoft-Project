/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Reunion;


/**
 *
 * @author ELIAS
 */
public interface ReunionInterface {
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_reunion";
    final String ATRIBUTOS[] = {"idtb_reuniones","fecha", "asunto","link","tb_medio_id"};
    final String CLAVE_PRIMARIA = "idtb_reuniones";
    
    public ArrayList<Reunion> listar();
    public Reunion buscar(int id);
    public boolean insertar(Reunion reunion);
    public boolean editar(Reunion reunion);
    public boolean eliminar(int id);
}
