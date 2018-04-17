<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Gestione NC</title>
        <!-- Bootstrap core CSS -->
        <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Custom styles for this template -->
        <link href="/resources/css/navbar.css" rel="stylesheet">
    <body>
        <div class="container">

            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="/operaio/">Home</a></li>
                            <li><a href="/operaio/old">Elaborazioni completate</a></li>
                            <li><a href="/operaio/news">Invia una segnalazione</a>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${matricola}<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">I miei dati</a></li>
                                    <li><a href="/logout">Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <!-- operazioni da svolgere-->
            <c:if test="${not empty aperte}">
                <c:set var="aperte" value="${aperte}" scope="request"/>
                <c:import url="/WEB-INF/jsp/operaio/elaborazioniAperte.jsp"/>
            </c:if>

            <c:if test="${not empty chiuse}">
                <c:set var="chiuse" value="${chiuse}" scope="request"/>
                <c:import url="/WEB-INF/jsp/operaio/elaborazioniChiuse.jsp"/>
            </c:if>

            <c:if test="${not empty segnalazione}">
                <jsp:include page="/WEB-INF/jsp/segnalazione.jsp" />
            </c:if>

            <c:if test="${not empty idElaborazione}">
                <jsp:include page="/WEB-INF/jsp/operaio/editElaborazione.jsp">
                    <jsp:param name="idElaborazione" value="${idElaborazione}"/>
                </jsp:include>
            </c:if> 


        </div> <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="/resources/js/jquery-slim.min.js"><\/script>')</script>
        <script src="/resources/js/bootstrap.min.js"></script>
    </body>
</html>