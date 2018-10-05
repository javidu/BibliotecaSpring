/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.CategoriaDAO;
import DAO.LibroDAO;
import DTO.Categoria;
import DTO.Libro;
import java.util.List;

/**
 *
 * @author JAVIER
 */
public interface ServicioLibros {

    //--------------LIBROS------------------//
    public void insertarLibro(Libro libro);

    public void actualizarLibro(Libro libro);

    public void borrarLibro(String isbn);

    public List<Libro> buscarTodosLosLibros();

    public Libro buscarLibroPorISBN(String isbn);

    public List<Libro> buscarLibrosPorCategoria(int categoria);

    public Libro buscarPorTitulo(String titulo);   


    //--------------CATEGORIAS------------------//
    public void insertarCategoria(Categoria categoria);

    public void actualizarCategoria(Categoria categoria);

    public void borrarCategoria(int id);

    public Categoria buscarCategoriaPorId(int id);

    public Categoria buscarPorDescripcion(String descripcion);

    public List<Categoria> buscarCategoriasLibros();

}
