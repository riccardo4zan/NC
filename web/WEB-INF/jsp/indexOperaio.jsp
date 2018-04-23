<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Gestione NC</title>
        <link href="../resources/css/main.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <body >
        <div>
            <nav class="custom navbar navbar-expand-lg navbar-dark">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/op/">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/op/old">Elaborazioni completate</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/op/news">Invia una segnalazione</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/op/prod">Aggiungi prodotti</a>
                        </li>
                    </ul>
                    <div class="navbar-nav destra">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Impostazioni
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/op/dati">I miei dati</a>
                                <a class="dropdown-item" href="/logout">LogOut</a>
                            </div>
                        </li>
                    </div>
                </div>
            </nav>
            <c:if test="${not empty cat}">
                <script>
                    window.open("http://localhost:8084/op/report?min=${min}&max=${max}&cat=${cat}", '_blank');
                </script>
            </c:if>
            <main class="row">
                <div class="col-lg-3 col-md-3"></div>
                <div class="col-lg-6 col-md-6">

                    <c:if test="${not empty aperte}">
                        <c:import url="/WEB-INF/jsp/operaio/elaborazioniAperte.jsp"/>
                    </c:if>

                    <c:if test="${not empty chiuse}">
                        <c:import url="/WEB-INF/jsp/operaio/elaborazioniChiuse.jsp"/>
                    </c:if>

                    <c:if test="${not empty segnalazione}">
                        <jsp:include page="/WEB-INF/jsp/operaio/segnalazione.jsp" />
                    </c:if>
                    <c:if test="${not empty idElaborazione}">

                    </c:if> 

                    <!-- Visualizzazione dei dati personali e cambio della password --> 
                    <c:if test="${not empty datiPersonali}">
                        <c:set var="datiPersonali" value="${datiPersonali}" scope="request"/>
                        <c:import url="/WEB-INF/jsp/common/datiPersonali.jsp"/>
                    </c:if>

                    <c:if test="${changePassword}">
                        <c:import url="/WEB-INF/jsp/common/changePsswd.jsp"/>
                    </c:if>

                    <c:if test="${not empty categorie}">
                        <c:import url="/WEB-INF/jsp/operaio/newProdotti.jsp" />
                    </c:if> 

                </div>
                <div class="col-lg-3 col-md-3"></div>
            </main>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>