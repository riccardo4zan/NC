<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<br></br>
<form>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <div class="form-group">
        <label>Descriozione</label>
        <textarea class="form-control" name="desc" rows="3">${Descrizione}</textarea>
    </div>
    <div class="form-group">
        <label>Azioni contenitive</label>
        <textarea class="form-control" name="azioniContenimento" rows="3"></textarea>
    </div>
    <div class="form-group">
        <label>Cause</label>
        <textarea class="form-control" name="cause" rows="3"></textarea>
    </div>
    <div class="row">
    <fieldset class="form-group col-lg-4 col-md-4">
        <div class="row">
            <legend class="col-form-label col-sm-3 pt-0">Gravit&agrave;</legend>
            <div class="col-sm-3">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gravita" value="1" checked>
                    <label class="form-check-label" for="gridRadios1">
                        Bassa
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gravita" value="2">
                    <label class="form-check-label" for="gridRadios2">
                        Media
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gravita" value="3">
                    <label class="form-check-label" for="gridRadios3">
                        Alta
                    </label>
                </div>
            </div>
        </div>
    </fieldset>

    <div class="col-lg-4 col-md-4 form-group">
        <label>Tipo</label>
        <select class="form-control" name="tipo">
            <option value="">Nullo</option>
            <c:forEach items="${Tipi}" var="tipo">
                <option value="${tipo.nome}">${tipo.nome}</option>
            </c:forEach>
        </select>
    </div>

    <div class="col-lg-4 col-md-4 form-group">
        <label>Reparto</label>
        <select class="form-control" name="reparto" >
            <option value="">Nullo</option>
            <c:forEach items="${Reparti}" var="reparto">
                <option value="${reparto.id}">${reparto.nome}</option>
            </c:forEach>
        </select>
    </div>
    </div>
        <div class="row">
    <div class="col-lg-4 col-md-4 form-group">
        <label>Fornitore</label>
        <select class="form-control" name="fornitore" >
            <option value="">Nullo</option>
            <c:forEach items="${Fornitori}" var="fornitore">
                <option value="${fornitore.piva}">${fornitore.nome}</option>
            </c:forEach>
        </select>
    </div>

    <div class="col-lg-4 col-md-4 form-group">
        <label>Cliente</label>
        <select class="form-control" name="cliente" >
            <option value="">Nullo</option>
            <c:forEach items="${Clienti}" var="clienti">
                <option value="${clienti.id}">${clienti.nome}</option>
            </c:forEach>
        </select>
    </div>

    <div class="col-lg-4 col-md-4 form-group">
        <label>Data Inizio</label>
        <input type="date" class="form-control"  id="dataInizio"   name="dataInizio"/>
    </div>
        </div>
    <button type="submit" class="btn btn-primary">Salva</button>
</form>