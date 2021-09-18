<%-- 
    Document   : login
    Created on : 25 ago. 2021, 18:26:24
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
    <body>
        <div class="container col-lg-4">
        <h1>Login</h1>

        <form action="controladorLogin" method="POST" >
            <div class="mb-3">
                <input type="email" name="correo" placeholder="e-mail" class="form-control" aria-describedby="emailHelp" required>
            </div>
            <div class="mb-3">
                <input type="password" name="pass" placeholder="Contraseña" class="form-control" required>
            </div>

            <input type="submit" value="Enviar" class="btn btn-primary">
            <a href="./preArticulos" class="btn btn-primary">Ver Artículos</a>
        </form>
        No tiene cuenta <a href="./preRegistro">registrese</a>

        <c:if test="${errorLogin!=null}">
            <p class="alert alert-danger" role="alert">${errorLogin}</p> 
        </c:if>
    </div>
        <footer class="footer mt-auto py-3 bg-light">
            <div class="container" style="text-align: center">
                <span class="text-muted">Antonio Prieto 2021 &COPY;</span>
            </div>
        </footer>

    </body>
</html>


