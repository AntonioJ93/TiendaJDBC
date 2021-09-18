<%-- 
    Document   : registro
    Created on : 25 ago. 2021, 18:34:45
    Author     : Antonio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
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
    <body class="container col-lg-4">
        <h1>Registro</h1>
        <form action="controladorRegistro" method="POST">
            <div class="mb-3">
                <input type="text" name="nombre" placeholder="Nombre" required value="${nombre}" class="form-control">
            </div>
            <div class="mb-3">
                <input type="text" name="apell1" placeholder="Primer apellido" required value="${apell1}" class="form-control">
            </div>
            <div class="mb-3">
                <input type="text" name="apell2" placeholder="Segundo apellido" value="${apell2}" class="form-control">
            </div>
            <div class="mb-3">
                <input type="text" name="tlf" placeholder="Telefono" value="${telefono}" class="form-control">
            </div>
            <div class="mb-3">
                <input type="email" name="correo" placeholder="e-mail" required value="${email}" class="form-control">
            </div>
            <div class="mb-3">
                <input type="password" name="pass" placeholder="Contraseña" required class="form-control">
            </div>
            <div class="mb-3">
                <input type="password" name="confPass" placeholder="Confirmar contraseña" required class="form-control">
            </div>
            <input type="submit" value="Enviar" class="btn btn-primary">
            <a href="./preArticulos" class="btn btn-primary">Ver Artículos</a>
        </form>
        Tiene cuenta <a href="./preLogin">inicie sesión</a><br>
        <c:if test="${errorRegistro!=null}">
            <p class="alert alert-danger" role="alert">${errorRegistro}</p>
        </c:if>
        <footer class="footer mt-auto py-3 bg-light">
            <div class="container" style="text-align: center">
                <span class="text-muted">Antonio Prieto 2021 &COPY;</span>
            </div>
        </footer>
    </body>
</html>
