<%-- 
    Document   : carrito
    Created on : 27-ago-2021, 1:19:24
    Author     : Antonio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    </head>
    <body>
        <div class="container col-lg-8">


            <h1>Carrito</h1>
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


            <form action="actualizarArticuloCarrito">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Precio Unitario</th>
                            <th>Cantidad</th>

                            <th>Subtotal</th>

                            <th>Opciones</th>
                        </tr>
                    </thead>
                    <c:set var = "total" value = "0"/>

                    <c:forEach var="art" items="${listaCarrito}">
                        <tr>
                            <td>${art.nombreArticulo}</td>
                            <td>${art.precio}</td>
                            <c:if test="${idEditar!=(Integer.parseInt(art.idArticulo))}">
                                <td>${art.cantidad}</td>

                                <td>${art.precio*art.cantidad}</td>
                                <td>
                                    <a href="./editarArticuloCarrito?id=${art.idArticulo}" class="btn btn-warning">Editar</a>
                                    <a href="./eliminarArticuloCarrito?id=${art.idArticulo}" class="btn btn-danger">Eliminar</a>
                                </td>

                            </c:if>
                            <c:if test="${idEditar==(Integer.parseInt(art.idArticulo))}">

                                <td><input type="number" min="1" value="${art.cantidad}" name="cantidad" style="max-width: 50px"></td>
                                <td></td>
                                <td>
                                    <input type="hidden" value="${art.idArticulo}" name="id">
                                    <input type="submit" value="Guardar" class="btn btn-primary">

                                    <a href="./eliminarArticuloCarrito?id=${art.idArticulo}" class="btn btn-danger">Eliminar</a>
                                </td>

                            </c:if>


                            <c:set var = "total" value = "${total+(art.precio*art.cantidad)}"/>
                        </tr>
                    </c:forEach>
                    <tr>

                        <th>Total</th>

                        <th></th>


                        <th></th>
                        <th>
                            <c:if test="${idEditar==null}">

                                ${total}
                            </c:if>
                        </th>
                        <th></th>
                    </tr>

                </table>
            </form>
            <a href="./preArticulos" class="btn btn-primary">Seguir comprando</a>
            <a href="./comprar" class="btn btn-primary">Comprar</a>
            <a href="./vaciarCarrito" class="btn btn-danger">Vaciar carrito</a>
            <c:if test="${msgCompra!=null}">
                <p class="alert alert-danger" role="alert">${msgCompra}</p> 
            </c:if>
        </div>
        <footer class="footer mt-auto py-3 bg-light">
            <div class="container" style="text-align: center">
                <span class="text-muted">Antonio Prieto 2021 &COPY;</span>
            </div>
        </footer>
    </body>
</html>
