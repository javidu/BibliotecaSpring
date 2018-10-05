<%-- 
    Document   : editarLibro
    Created on : 2/04/2018, 06:29:11 PM
    Author     : JAVIER
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="FrontEnd/CSS/formulario.css" rel="stylesheet" type="text/css"/>
        <script src="FrontEnd/JS/validaciones.js" type="text/javascript"></script>
        <title>Editar Libro</title>
    </head>
    <body>
        <h1>Editar Libro</h1>
       
        <form action="ModificarLibro" id="miformulario" onsubmit="return validacion();" method="POST">
            <fieldset>
                <legend>Editar libro</legend>
                <p> <label for="isbn">ISBN:</label>
                    <input type="text" id="isbn" name="isbn" value="${libro.isbn}">
                </p>
                <p><label for="titulo">Titulo:</label>                    
                    <input type="text" id="titulo" name="titulo" value="${libro.titulo}">
                </p>
                <p> <label for="categoria">Categoria:</label>                    

                    <select name="categoria.id" required="true">
                        <option value=""></option>
                        <c:forEach var="categoria" items="${listaDeCategorias}">
                            <c:choose>
                            <c:when test = "${categoria.id eq libro.categoria.id}">
                                <option value="${categoria.id}" selected>${categoria.descripcion}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${categoria.id}">${categoria.descripcion}</option>
                            </c:otherwise>
                        </c:choose> 
                        </c:forEach>
                        
                    </select>
                </p>
                <p>
                    <input type="submit" value="Guardar">
                </p>
            </fieldset>
        </form>
    </body>
</html>
