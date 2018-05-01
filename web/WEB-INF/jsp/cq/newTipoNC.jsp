<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<br></br>
<form action="/cq/addTipo" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <div class="form-group">
        <label>Nome</label>
        <textarea class="form-control" name="nome"></textarea>
        <label>Descrizione</label>
        <textarea class="form-control" name="descrizione"></textarea>
    </div>
    <button type="submit" class="btn btn-success">Salva</button>
</form>
