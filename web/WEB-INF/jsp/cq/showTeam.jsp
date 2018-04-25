<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<br></br>


<c:forEach items="${tco}" var="tc">
    <p>${tc.matricola}-${tc.nome}, ${tc.cognome}</p>
    <a href="/cq/eliminaDipTeamOp?dip=${tc.matricola}&codice=${NCtm}">Elimina</a>
</c:forEach>

<h1>Aggiungi membro</h1>
<form action="/cq/addOperaioTeamNC" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="hidden" name="codice" value="${NCtm}"/>
        <div class="col-lg-4 col-md-4 form-group">
        <select class="form-control" name="dipendente">
            <option value=""></option>
            <c:forEach items="${Dipendenti}" var="dip">
                <option value="${dip.matricola}">${dip.matricola} - ${dip.nome}, ${dip.cognome}</option>
            </c:forEach>
        </select>
    </div>
        <button type="submit" class="btn btn-primary">Assegna</button>
</form>
