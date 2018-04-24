<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<br></br>
<form action="/cq/addElaborazione" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <input type="hidden" class="form-control" name="codNC" value="${ncPassata}">
    
    <div class="form-group">
        <label>Descrizione</label>
        <textarea class="form-control" name="desc" rows="3"></textarea>
    </div>
    <div class="row">
    <div class="col-lg-4 col-md-4 form-group">
        <label>Data Inizio</label>
        <input type="date" class="form-control"  name="dataInizio"/>
    </div>

    
    <div class="col-lg-4 col-md-4 form-group">
        <label>Codice Non Conformit&agrave;</label>
        <input type="text" class="form-control"  readonly name="codNC" value="${ncPassata}">
    </div>
    


    <div class="col-lg-4 col-md-4 form-group">
        <label>Dipendente</label>
        <select class="form-control" name="dipendente">
            <option value=""></option>
            <c:forEach items="${apriElaborazione}" var="dip">
                <option value="${dip.matricola}">${dip.matricola} - ${dip.nome} , ${dip.cognome}</option>
            </c:forEach>
        </select>
    </div>
    </div>
    <button type="submit" class="btn btn-primary">Assegna</button>
</form>
