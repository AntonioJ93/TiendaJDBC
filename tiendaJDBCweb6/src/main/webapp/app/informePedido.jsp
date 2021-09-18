<%-- 
    Document   : informePedido
    Created on : 29-ago-2021, 9:59:29
    Author     : Antonio
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    </head>
    <body>
        <div class="container col-lg-8">


            <h1>Informe del pedido</h1>
            <div class="row justify-content-end ">
                <h3 style="text-align: right">${cliente.nombre}</h3>
                <!-- Example split danger button -->
                <div class="btn-group col-lg-2">

                    <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
                        Perfil de usuario
                    </button>
                    <ul class="dropdown-menu">

                        <li><a href="./controladorCerrarSesion" class="dropdown-item">Cerrar Sesión</a></li>

                    </ul>
                </div>
            </div>
            <h3>Datos personales</h3>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Primer apellido</th>
                        <th>Segundo apellido</th>
                        <th>Teléfono</th>
                        <th>Correo</th>
                        <th>Fecha pedido</th>
                    </tr>
                </thead>
                <tr>
                    <td>${informe.cDTO.nombre}</td>
                    <td>${informe.cDTO.apell1}</td>
                    <td>${informe.cDTO.apell2}</td>
                    <td>${informe.cDTO.telefono}</td>
                    <td>${informe.cDTO.email}</td>
                    <td>${informe.lista.get(0).getFecha()}</td>
                </tr>
            </table>

            <h3>Datos del pedido</h3>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Precio Unitario</th>
                        <th>Cantidad</th>
                        <th>Subtotal</th>

                    </tr>
                </thead>
                <c:set var = "total" value = "0"/>

                <c:forEach var="art" items="${informe.lista}">
                    <tr>
                        <td>${art.nombre}</td>
                        <td>${art.precio}</td>
                        <td>${art.cantidad}</td>
                        <td>${art.precio*art.cantidad}</td>

                        <c:set var = "total" value = "${total+(art.precio*art.cantidad)}"/>
                    </tr>
                </c:forEach>
                <tr>
                    <th>Total</th>
                    <th></th>
                    <th></th>
                    <th>${total}</th>

                </tr>

            </table>
            <a href="./preArticulos" class="btn btn-primary">Seguir comprando</a>
        </div>
        <footer class="footer mt-auto py-3 bg-light">
            <div class="container" style="text-align: center">
                <span class="text-muted">Antonio Prieto 2021 &COPY;</span>
            </div>
        </footer>
    </body>
</html>
