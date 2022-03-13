/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import config.Conexion;
import java.util.ArrayList;
import modelo.beans.Departamento;

/**
 *
 * @author Marco
 */
public interface DepartamentoInterface {
    final Conexion conexion=new Conexion();
    final String TABLA = "tb_departamento";
    final String ATRIBUTOS[] = {"idtb_departamento", "nombre", "tb_pais_id"};
    final String CLAVE_PRIMARIA = "idtb_departamento";
    
    public ArrayList<Departamento> listar();
    public Departamento buscar(int id);
    public boolean insertar(Departamento departamento);
    public boolean editar(Departamento departamento);
    public boolean eliminar(int id);
}
