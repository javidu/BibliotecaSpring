/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Validar que se haga las funciones cuando se cargue la pagina.
window.onload;


//Validar entrada de datos validos en formulario

function validacion() {
    var isbn = document.getElementById("isbn");
    var miformulario = document.getElementById("miformulario");
    
    if (isbn.value === "") {
        alert("datos no validos");
        return false;
    } //else
        //miformulario.submit();
}



