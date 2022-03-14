/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Modulo;

/**
 *
 * @author Windows10
 */
public interface ModuloInterface {
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_modulo";
    final String ATRIBUTOS[] = {"idtb_modulo", "nombre", "estado", "tb_proyecto_id"};
    final String CLAVE_PRIMARIA = "idtb_modulo";
    
    public ArrayList<Modulo> listar();
    public Modulo buscar(int id);
    public boolean insertar(Modulo modulo);
    public boolean editar(Modulo modulo);
    public boolean eliminar(int id);
}
