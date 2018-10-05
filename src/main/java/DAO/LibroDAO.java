/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Categoria;
import DTO.Libro;
import java.util.List;

/**
 *
 * @author JAVIER
 */
public interface LibroDAO {

    public abstract List<Libro> buscarTodos();

    public abstract Libro buscarPorIsbn(String isbn);

    public abstract Libro buscarPorTitulo(String titulo);

    public abstract List<Libro> buscarPorCategoria(Categoria categoria);
}
