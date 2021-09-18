<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>

<h1 style="text-align: center">Artículos</h1>
<div class="row justify-content-end mt-5">
    <a href="./preLogin" class="btn btn-primary col-lg-1">Login</a>
    </div>
        <table class="table table-striped table-hover mx-auto ">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Precio</th>
                </tr>
            </thead>

            <c:forEach var="art" items="${articulos}">
                <tr>
                    <td>${art.nombre}</td>
                    <td>${art.precio}</td>
                </tr>
            </c:forEach>
        </table>

