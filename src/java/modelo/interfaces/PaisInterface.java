/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Pais;

/**
 *
 * @author Marco
 */
public interface PaisInterface {
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_pais";
    final String ATRIBUTOS[] = {"idtb_pais", "nombre"};
    final String CLAVE_PRIMARIA = "idtb_pais";
    
    public ArrayList<Pais> listar();
    public Pais buscar(int id);
    public boolean insertar(Pais pais);
    public boolean editar(Pais pais);
    public boolean eliminar(int id);
}
