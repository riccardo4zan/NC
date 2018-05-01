<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<br></br>


<table class="table">
    <thead>
        <tr>
            <th>Matricola</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${tco}" var="tc">
            <tr>
                <td> ${tc.matricola} </td>
                <td> ${tc.nome} </td>
                <td> ${tc.cognome} </td>
                <td><a href="/cq/eliminaDipTeamOp?dip=${tc.matricola}&codice=${NCtm}">Elimina</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

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
    <button type="submit" class="btn btn-success">Assegna</button>
</form>
