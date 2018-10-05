/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios.Implementación;

import DAO.JPA.CategoriaJpaRepository;
import DAO.JPA.LibroJpaRepository;
import DTO.Categoria;
import DTO.Libro;
import Servicios.ServicioLibros;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JAVIER
 */
@Service("servicioLibros")
public class ServicioLibrosImpl implements ServicioLibros {
    
    @Autowired(required = true)
    private LibroJpaRepository libroDAO;
    @Autowired
    private CategoriaJpaRepository categoriaDAO;
   
    public ServicioLibrosImpl() {
               
    }

    @Override
    public void actualizarLibro(Libro libro) {
      this.libroDAO.save(libro);
    }

    @Override
    public void borrarLibro(String isbn) {        
        this.libroDAO.deleteById(isbn);
        //this.libroDAO.delete(this.libroDAO.getOne(isbn));
    }

    @Override
    public List<Libro> buscarTodosLosLibros() {
        return this.libroDAO.findAll();
    }

    @Override
    public List<Categoria> buscarCategoriasLibros() {
        return this.categoriaDAO.buscarTodos();
    }
    
    @Override
    public Libro buscarLibroPorISBN(String isbn) {
        return this.libroDAO.buscarPorIsbn(isbn);
    }

    @Override
    public Categoria buscarCategoriaPorId(int id) {
        return this.categoriaDAO.buscarPorId(id);
    }

    @Override
    public List<Libro> buscarLibrosPorCategoria(int id) {
        Categoria categoria = this.categoriaDAO.buscarPorId(id);
        return this.libroDAO.buscarPorCategoria(categoria);
    }

    @Override
    public Libro buscarPorTitulo(String titulo) {
        return this.libroDAO.buscarPorTitulo(titulo);
    }

    @Override
    public Categoria buscarPorDescripcion(String descripcion) {
        return this.categoriaDAO.buscarPorDescripcion(descripcion);
    }

    @Override
    public void insertarLibro(Libro libro) {
        if(this.buscarLibroPorISBN(libro.getIsbn()) == null)           
        this.libroDAO.save(libro);        
    }

    @Override
    public void insertarCategoria(Categoria categoria) {
        if(this.buscarCategoriaPorId(categoria.getId()) == null)
        this.categoriaDAO.save(categoria);
    }

    @Override
    public void actualizarCategoria(Categoria categoria) {
        this.categoriaDAO.save(categoria);
    }

    @Override
    public void borrarCategoria(int id) {
       this.categoriaDAO.deleteById(id);
    }
    
    public void setLibroJpaRepository(LibroJpaRepository libro){
        this.libroDAO = libro;
    }
    
    public void setCategoriaJpaRepository(CategoriaJpaRepository categoria){
        this.categoriaDAO = categoria;
    }
    
    public LibroJpaRepository getLibroJpaRepository(){
        return this.libroDAO;
    }
    
    public CategoriaJpaRepository getCategoriaJpaRepository(){
        return this.categoriaDAO;
    }
}

    

