/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTCONTROLADORES;

import DTO.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import DTO.Libro;
import Servicios.ServicioLibros;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JAVIER
 */

@RestController
@RequestMapping("/webservices/libro")
public class LibroRestController {
    
    @Autowired
    ServicioLibros service;

    @GetMapping("/all")
    public List<Libro> getLibros(){
        return this.service.buscarTodosLosLibros();        
    }
    
    @GetMapping("/find")
    public Libro getLibro(@RequestParam("isbn") String isbn){
        return service.buscarLibroPorISBN(isbn);
    }
    
    @PostMapping("/update")
    public boolean updateLibro(@RequestBody Libro libro){
        try{
            service.actualizarLibro(libro);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    @GetMapping("/findByCat")
    public List<Libro> findByCatId(@RequestParam("id") int id){
        return service.buscarLibrosPorCategoria(id);
    }
    
    @PutMapping("/add")
    public boolean addLibro(@RequestBody Libro libro){
        try{
         service.insertarLibro(libro);
        return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    @DeleteMapping("/delete")
    public boolean deleteLibro(@RequestParam("isbn") String isbn){
        try{
            service.borrarLibro(isbn);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    @GetMapping("/cat")
    public List<Categoria> obtenerCategorias(){
        return this.service.buscarCategoriasLibros();
    } 
}
