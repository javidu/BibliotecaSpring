/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Categoria;
import java.util.List;

/**
 *
 * @author JAVIER
 */
public interface CategoriaDAO {
    
    public List<Categoria> buscarTodos();

    public Categoria buscarPorId(int id);
    
    public Categoria buscarPorDescripcion(String descripcion);    
     
}
