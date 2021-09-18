<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>


 <h1>Artículos</h1>
        <div class="row justify-content-end ">
            <h3 style="text-align: right">${cDTO.nombre}</h3>
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



<form action="agregarAlCarrito" method="POST">

    <table class="table table-striped table-hover">
        <thead>
            <tr>

                <th>Selección</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Opciones</th>

            </tr>
        </thead>
        <c:forEach var="art" items="${articulos}">
            <tr>

                <td><input type="checkbox" name="id" value="${art.getId()}" class="form-check-input"></td>
                <td>${art.getNombre()}</td>
                <td>${art.getPrecio()}</td>
                <td>
                    <a href="./agregarAlCarrito?id=${art.getId()}" class="btn btn-success">Añadir al carrito</a>
                </td>

            </tr>
        </c:forEach>
    </table>

    <input type="submit" value="Añadir seleccionados" name="add" class="btn btn-primary">
    <a href="./verCarrito" class="btn btn-primary">Ver carrito</a>
</form>

