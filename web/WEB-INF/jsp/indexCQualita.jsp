<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Gestione NC</title>
        <script src="../resources/js/loginjs.js" type="text/javascript"></script>
        <link href="../resources/css/main.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <body>
        <div>
            <nav class="custom navbar navbar-expand-lg navbar-dark">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/cq/">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/cq/segnalazioni">Lista segnalazioni</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/cq/apriNC">Apri non conformit&agrave;</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/cq/NCElaborazione">Non conformit&agrave; in elaborazione</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/cq/NCChiuse">Non conformit&agrave; chiuse</a>
                        </li>
                    </ul>
                    <div class="navbar-nav destra">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Impostazioni
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/cq/dati">I miei dati</a>
                                <a class="dropdown-item" href="/logout">LogOut</a>
                            </div>
                        </li>
                    </div>
                </div>
            </nav>
            <div class="row">
                <div class="col-lg-2 col-md-2"></div>
                <div class="col-lg-8 col-md-8">
                    
                    <c:if test="${not empty NC}">
                        <c:set var="Tipi" value="${Tipi}" scope="request"/>
                        <c:set var="Reparti" value="${Reparti}" scope="request"/>
                        <c:set var="Fornitori" value="${Fornitori}" scope="request"/>
                        <c:set var="Clienti" value="${Clienti}" scope="request"/>
                        <c:set var="Descrizione" value="${Descrizione}" scope="request"/>
                        <c:import url="/WEB-INF/jsp/cq/newNC.jsp"/>
                    </c:if>

                    <c:if test="${not empty NCAperte}">
                        <c:set var="NCAperte" value="${NCAperte}" scope="request"/>
                        <c:import url="/WEB-INF/jsp/cq/NCAperte.jsp" />
                    </c:if>

                    <c:if test="${not empty NCChiuse}">
                        <jsp:include page="/WEB-INF/jsp/cq/NCChiuse.jsp" />
                    </c:if>

                    <c:if test="${not empty NCElaborazione}">
                        <jsp:include page="/WEB-INF/jsp/cq/NCElaborazione.jsp" />
                    </c:if>

                    <c:if test="${not empty apriElaborazione}">
                        <c:set var="apriElaborazione" value="${apriElaborazione}" scope="request"/>
                        <c:set var="ncPassata" value="${ncPassata}" scope="request"/>
                        <c:import url="/WEB-INF/jsp/cq/newElaborazione.jsp"/>
                    </c:if>

                    <c:if test="${not empty segnalazioni}">
                        <c:set var="segnalazioni" value="${segnalazioni}" scope="request"/>
                        <c:import url="/WEB-INF/jsp/cq/listSegnalazioni.jsp"/>
                    </c:if>

                    <c:if test="${not empty segnalazione}">
                        <c:set var="segnalazione" value="${segnalazione}" scope="request"/>
                        <c:import url="/WEB-INF/jsp/cq/dettaglioSegnalazione.jsp"/>
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
                <div class="col-lg-2 col-md-2"></div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
