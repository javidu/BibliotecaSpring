/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author JAVIER
 * @param <T>
 * @param <Id>
 */
public interface GenericDAO<T, Id extends Serializable> {
    
    void insertar(T objeto);

    void actualizar(T objeto);

    void borrar(T objeto);
    
    List<T> buscarTodos();
    
}
