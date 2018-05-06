<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<br></br>
<c:if test="${not empty err}"><h1>${err}</h1></c:if>
<form action="/cq/modNC" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <input type="hidden" class="form-control"  name="codNC" value="${editNC.codice}"/>

    <div class="form-group">
        <label>Descrizione</label>
        <textarea class="form-control" name="desc" rows="3">${desc}</textarea>
    </div>

    <div class="form-group">
        <label>Azioni contenitive</label>
        <textarea class="form-control" name="azioniContenimento" rows="3">${azioniContenitive}</textarea>
    </div>

    <div class="form-group">
        <label>Azioni correttive</label>
        <textarea class="form-control" name="azioniCorrettive" rows="3">${editNC.azioniCorrettive}</textarea>
    </div>

    <div class="form-group">
        <label>Azioni preventive</label>
        <textarea class="form-control" name="azioniPreventive" rows="3">${editNC.azioniPreventive}</textarea>
    </div>

    <div class="row">
        <div class="col-lg-6 col-md-6 form-group">
            <label>Data fine</label>
            <input id="curdate" type="date" class="form-control" name="dataF"/>
        </div>


        <!-- fare controllo inserimento -->
        <div class="col-lg-6 col-md-6 form-group">
            <label>Costo</label>
            <input type="number" min="0.01" step="0.01" max="1000000000" class="form-control"  name="costo"/>
        </div>

        <p>
            <button type="submit" class="btn btn-success">Salva</button>
        </p>
        <p>
            <a href="/cq/showTeam?codice=${editNC.codice}" class="btn btn-primary">Modifica il team</a>
        </p>

</form>

