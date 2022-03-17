/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Medio;

/**
 *
 * @author bryan
 */
public interface MedioInterface {
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_medio";
    final String ATRIBUTOS[] = {"tbmedio_id", "nombre"};
    final String CLAVE_PRIMARIA = "tb_medio_id";
    
    public ArrayList<Medio> listar();
    public Medio buscar(int id);
    public boolean insertar(Medio medio);
    public boolean editar(Medio medio);
    public boolean eliminar(int id);
}
