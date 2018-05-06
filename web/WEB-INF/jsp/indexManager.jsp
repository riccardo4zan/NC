<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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
    <body>
        <div>
            <nav class="navbar navbar-expand-lg navbar-dark bg-success">
                <a class="navbar-brand" href="#">IFS</a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/ma/">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/ma/creaCategoria">Aggiungi categoria di prodotto</a></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/ma/nuovoCliente">Aggiungi nuovo cliente</a>
                        <li class="nav-item">
                            <a class="nav-link" href="/ma/nuovoFornitore">Aggiungi nuovo fornitore</a>
                        </li>
                    </ul>
                    <div class="navbar-nav destra">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Impostazioni
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/ma/dati">I miei dati</a>
                                <a class="dropdown-item" href="/logout">LogOut</a>
                            </div>
                        </li>
                    </div>
                </div>
            </nav>
            <div class="mt row">
                <div class="col-lg-2 col-md-2 col-sm-2"></div>
                <div class="col-lg-8 col-md-8 col-sm-8">
                    <c:if test="${not empty istogramma}">
                        <c:import url="/WEB-INF/jsp/manager/index.jsp"/>
                    </c:if>
                    <c:if test="${categoria}">
                        <c:import url="/WEB-INF/jsp/manager/creaCategoria.jsp" />
                    </c:if>

                    <c:if test="${cliente}">
                        <c:import url="/WEB-INF/jsp/manager/creaCliente.jsp" />
                    </c:if>

                    <c:if test="${cliente} && ${not empty Errore}" >
                        <c:set var="Errore" value="${Errore}" scope="request"/>
                        <c:import url="/WEB-INF/jsp/manager/creaCliente.jsp" />
                    </c:if>

                    <c:if test="${fornitore}">
                        <c:import url="/WEB-INF/jsp/manager/creaFornitore.jsp" />
                    </c:if>

                    <c:if test="${fornitore} &&  ${not empty Errore}">
                        <c:set var="Errore" value="${Errore}" scope="request"/>
                        <c:import url="/WEB-INF/jsp/manager/creaFornitore.jsp" />
                    </c:if>

                    <!-- Visualizzazione dei dati personali e cambio della password --> 
                    <c:if test="${not empty datiPersonali}">
                        <c:set var="datiPersonali" value="${datiPersonali}" scope="request"/>
                        <c:import url="/WEB-INF/jsp/common/datiPersonali.jsp"/>
                    </c:if>
                    <c:if test="${changePassword}">
                        <c:import url="/WEB-INF/jsp/common/changePsswd.jsp"/>
                    </c:if>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2"></div>
            </div>

        </div> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
