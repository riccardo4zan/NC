<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Gestione NC</title>
        <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="/resources/css/navbar.css" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <body >
        <div style="line-height:-20px !important; " class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
            <header class="sfondo mdl-layout__header">
                <div class="mdl-layout__header-row">
                    <span class="mdl-layout-title">Impostazioni</span>
                    <div class="mdl-layout-spacer"></div>
                    <nav class="mdl-navigation mdl-layout--large-screen-only">
                        <a class="mdl-navigation__link" href="/operaio/">Home</a>
                        <a class="mdl-navigation__link" href="/operaio/old">Elaborazioni completate</a>
                        <a class="mdl-navigation__link" href="/operaio/news">Invia una segnalazione</a>
                    </nav>
                </div>
            </header>
            <div class="mdl-layout__drawer">
                <span class="mdl-layout-title">Title</span>
                <nav class="mdl-navigation">
                    <a class="mdl-navigation__link" href="#">I miei dati</a>
                    <a class="mdl-navigation__link"  href="/logout">Logout</a>
                </nav>
            </div>
            <main class="mdl-layout__content">
                <div class="page-content">
                    <c:if test="${not empty aperte}">
                        <c:set var="aperte" value="${aperte}" scope="request"/>
                        <c:import url="/WEB-INF/jsp/operaio/elaborazioniAperte.jsp"/>
                    </c:if>

                    <c:if test="${not empty chiuse}">
                        <c:set var="chiuse" value="${chiuse}" scope="request"/>
                        <c:import url="/WEB-INF/jsp/operaio/elaborazioniChiuse.jsp"/>
                    </c:if>

                    <c:if test="${not empty segnalazione}">
                        <jsp:include page="/WEB-INF/jsp/operaio/segnalazione.jsp" />
                    </c:if>


                    <c:if test="${not empty idElaborazione}">
                        <jsp:include page="/WEB-INF/jsp/operaio/editElaborazione.jsp">
                            <jsp:param name="idElaborazione" value="${idElaborazione}"/>
                        </jsp:include>
                    </c:if> 
                </div>
            </main>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="/resources/js/jquery-slim.min.js"><\/script>')</script>
        <script src="/resources/js/bootstrap.min.js"></script>
    </body>
</html>