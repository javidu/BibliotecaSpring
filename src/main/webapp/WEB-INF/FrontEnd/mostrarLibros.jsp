<%-- 
    Document   : mostrarLibros
    Created on : 27/03/2018, 10:29:58 PM
    Author     : JAVIER
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="FrontEnd/CSS/formulario.css" rel="stylesheet" type="text/css"/>
        <title>Mostrar Libros</title>
    </head>
    <body>
        <div>            
            <form action="FiltrarLibrosPorCategoria" method="POST">
                <select name="categoria.id">
                    <option value="0">seleccionar</option>

                    <c:forEach var="categoria" items="${listaDeCategorias}">                        
                        <c:choose>
                            <c:when test = "${categoria.id eq param.categoria}">
                                <option value="${categoria.id}" selected>${categoria.descripcion}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${categoria.id}">${categoria.descripcion}</option>
                            </c:otherwise>
                        </c:choose>    
                    </c:forEach>
                
                </select>
                <input type="submit" value="Filtrar">
            </form>

            <table>
                <tr>                
                    <th>ISBN</th>
                    <th>TITULO</th>
                    <th>CATEGORÍA</th>
                    <th colspan="2">ACCIONES</th>
                </tr>  

                <c:forEach var="libro" items="${listaDeLibros}">
                    <tr>
                        <td>${libro.isbn}</td>
                        <td>${libro.titulo}</td>
                        <td>${libro.categoria.descripcion}</td>            
                        <td><a href="FormularioEditarLibro?isbn=${libro.isbn}">Editar</a></td>
                        <td><a href="BorrarLibro?isbn=${libro.isbn}">Borrar</a></td>
                    </tr>   
                </c:forEach>
            </table>  
        </div>
        <h2 id="insertar"><a href="FormularioInsertarLibro">Insertar Libro</a></h2>
    </body>
</html>
