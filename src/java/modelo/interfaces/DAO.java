/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import java.util.ArrayList;
import modelo.beans.Cliente;

/**
 *
 * @author bryan
 */
public interface DAO {
    public ArrayList listar();
    public boolean insertar(Cliente cliente);
    public boolean editar(Cliente cliente);
    public boolean eliminar(int id);
}
