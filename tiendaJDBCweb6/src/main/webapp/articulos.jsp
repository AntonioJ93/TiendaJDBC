<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="false" %>
<%@page autoFlush="true" %>
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
        <div class="container col-lg-6">


            <div class="col align-self-center">
                <c:if test="${pageContext.request.getSession(false)!=null}">
                    <jsp:include page="logado.jsp" />

                </c:if>
                <c:if test="${pageContext.request.getSession(false)==null}">
                    <jsp:include page="noLogado.jsp" />

                </c:if> 
            </div>

        </div>

        <footer class="footer mt-auto py-3 bg-light">
            <div class="container" style="text-align: center">
                <span class="text-muted">Antonio Prieto 2021 &COPY;</span>
            </div>
        </footer>


    </body>
</html>