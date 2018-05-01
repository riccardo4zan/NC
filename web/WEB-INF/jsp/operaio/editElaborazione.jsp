<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2> Elaborazione numero: ${elaborazione.codice} </h2>
<form:form action="/op/modEla" method="POST" modelAttribute="elaborazione">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <form:input type="hidden" path="codice" id="id"/>
    <form:input type="hidden" path="dipendente.matricola" />
    <form:input type="hidden" path="nonConformita.codice" />

    <div class="form-group">
        <label>Descrizione</label>
        <form:textarea class="form-control" rows="3" path="descrizione" />
    </div>

    <div class="form-group">
        <label>Data inizio</label>
        <form:input class="form-control" path="dataInizio" type="date" />
    </div>

    <div class="form-group">
        <label>Data fine</label>
        <form:input class="form-control" path="dataFine" type="date" />
    </div>

    <button type="submit" class="btn btn-success">Salva</button>
</form:form>