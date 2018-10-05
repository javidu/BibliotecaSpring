<%-- 
    Document   : formInsertarLibro
    Created on : 27/03/2018, 10:44:37 PM
    Author     : JAVIER
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="FrontEnd/CSS/formulario.css" rel="stylesheet" type="text/css"/>
        <script src="FrontEnd/JS/validaciones.js" type="text/javascript"></script>
        
        <title>Formulario Libro</title>
    </head>
    <body>
        <h1>Formulario alta Libro</h1>
        <form action="InsertarLibro" method="POST" id="miformulario" onclick="validacion();">
            <fieldset>
                <legend>Formulario alta libro</legend>
                <p> <label for="isbn">ISBN:</label>
                    <input type="text" id="isbn" name="isbn">
                </p>
                <p><label for="titulo">Titulo:</label>                    
                    <input type="text" id="titulo" name="titulo">
                </p>
                <p> <label for="categoria">Categoria:</label>                    

                    <select name="categoria.id">
                        <option value="Seleccionar">---</option>
                        <c:forEach var="categoria" items="${listaDeCategorias}">
                            <option value="${categoria.id}">${categoria.descripcion}</option>
                        </c:forEach>                        
                    </select>
                </p>
                <p>
                    <input type="submit" value="Insertar">
                </p>
            </fieldset>
        </form>          
    </body>
</html>
