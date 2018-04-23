<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h2> Elaborazione numero: ${codice} </h2>
<form:form name="editElaborazione" modelAttribute="elaborazione" action="/editElaborazione" method="post">
    <div class="form-group">
        <form:label path="descrizione"> Descrizione </form:label>>
        <form:input type="text" path="descrizione" class="form-control" name="descrizione"> ${descrizione} />
    </div>
    <div class="form-group">
        <form:label path="dataInizio"> Data Inizio </form:label>>
        <form:input type="date" path="dataInizio" class="form-control" readonly="true" value="${dataInizio}" name="dataInizio"/>
    </div>
    <div class="form-group">
        <form:label path="dataFine"> Data Fine </form:label>>
        <form:input type="date"  path="dataFine" class="form-control"  placeholder="data fine" name="dataFine"/>
    </div>
    <div class="form-group">
        <form:label path="nonConformita"> Non conformita  </form:label>
        <form:input type="text"  path="nonConformita" class="form-control" readonly="true" value="${nonConformita.getCodice()}" name="nonConformita"/>
    </div>
   <button type="submit" class="btn btn-primary">Salva</button>
</form:form>