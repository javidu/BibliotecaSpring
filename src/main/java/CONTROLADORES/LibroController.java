/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;

import DTO.Categoria;
import DTO.Libro;
import Servicios.ServicioLibros;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author JAVIER
 */
@Controller
public class LibroController {
    
    @Autowired
    ServicioLibros servicio;
    
    @RequestMapping("/")
    public String mostrarLibros(Model model,@ModelAttribute("listaDeLibrosFiltrado")ArrayList<Libro> librosFiltrados){
        //obtenemos la lista de categorias
        List<Categoria> listaDeCategorias = this.servicio.buscarCategoriasLibros();                 
        List<Libro> listaDeLibros = !librosFiltrados.isEmpty()?librosFiltrados:this.servicio.buscarTodosLosLibros();
                               
        model.addAttribute("listaDeCategorias", listaDeCategorias);
        model.addAttribute("listaDeLibros", listaDeLibros);
        
        return "mostrarLibros";
    }
    
    @GetMapping("/FormularioInsertarLibro")
    public String vistaInsertarLibro(Model model){
        List<Categoria> listaDeCategorias = this.servicio.buscarCategoriasLibros();
        model.addAttribute("listaDeCategorias", listaDeCategorias);
        return "formInsertarLibro";
    }
    
    @PostMapping("/InsertarLibro")
    public String insertarLibro(Libro libro){
        this.servicio.insertarLibro(libro);
        return "redirect:/";
    }
    
    @GetMapping("/FormularioEditarLibro")
    public String editarLibro(@RequestParam("isbn") String isbn, Model model){
        Libro libro = this.servicio.buscarLibroPorISBN(isbn);
        List<Categoria> listaDeCategorias = this.servicio.buscarCategoriasLibros();
        model.addAttribute("libro", libro);
        model.addAttribute("listaDeCategorias", listaDeCategorias);
        return "formEditarLibro";
    }
    
    @PostMapping("/ModificarLibro")
    public String modificarLibro(Libro libro){
        this.servicio.actualizarLibro(libro);
        return "redirect:/";
    }
    
    @GetMapping("/BorrarLibro")
    public String borrarLibro(@RequestParam("isbn") String isbn){
        this.servicio.borrarLibro(isbn);
        return "redirect:/";
    }
    
    @PostMapping("/FiltrarLibrosPorCategoria")
    public String filtrarLibro(@RequestParam("categoria.id")int id, RedirectAttributes ra){
        List<Libro> listaDeLibrosFiltrado;
        if(id == 0)
            return "redirect:/";
        
        listaDeLibrosFiltrado = this.servicio.buscarLibrosPorCategoria(id);
        ra.addFlashAttribute("listaDeLibrosFiltrado", listaDeLibrosFiltrado);
        return "redirect:/";
    }
}
