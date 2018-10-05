/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.JPA;

import DAO.CategoriaDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import DTO.Categoria;
import DTO.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JAVIER
 */
@Repository
public interface CategoriaJpaRepository extends CategoriaDAO, JpaRepository<Categoria, Integer>{

    @Override
    @Query("select c from Categoria c where c.descripcion = :descripcion")
    public Categoria buscarPorDescripcion(@Param("descripcion")String descripcion);

    @Override
    @Query("select c from Categoria c where c.id = :id")
    public Categoria buscarPorId(@Param("id")int id);

    @Override
    @Query("select c from Categoria c")
    public List<Categoria> buscarTodos();
    
    
}
