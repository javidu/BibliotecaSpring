/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.JPA;

import DAO.GenericDAO;
import DAO.LibroDAO;
import java.io.Serializable;

import DTO.Libro;
import DTO.Categoria;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 *
 * @author JAVIER
 */
@Repository
public interface LibroJpaRepository extends LibroDAO,JpaRepository<Libro, String>{

    @Override
    @Query("select l from Libro l where l.categoria = :categoria")
    public List<Libro> buscarPorCategoria(@Param("categoria")Categoria categoria);

    @Override
    @Query("select l from Libro l where l.titulo = :titulo")
    public Libro buscarPorTitulo(@Param("titulo")String titulo);

    @Override
    @Query("select l from Libro l where l.isbn = :isbn")
    public Libro buscarPorIsbn(@Param("isbn")String isbn);

    @Override
    @Query("select l from Libro l join fetch l.categoria")
    public List<Libro> buscarTodos();
    
    
}
