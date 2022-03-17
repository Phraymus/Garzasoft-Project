/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Telefono;

/**
 *
 * @author Brayan Carrasco
 */
public interface TelefonoInterface {
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_telefono";
    final String ATRIBUTOS[] = {"idtb_telefono", "numero", "tbpersona_id"};
    final String CLAVE_PRIMARIA = "idtb_telefono";
    
    public ArrayList<Telefono> listar();
    public Telefono buscar(int id);
    public boolean insertar(Telefono telefono);
    public boolean editar(Telefono telefono);
    public boolean eliminar(int id);
}
