<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<br></br>
<form action="/cq/modNC" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    
    <input type="hidden" class="form-control"  name="codNC" value="${editNC}">
    
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
        <textarea class="form-control" name="azioniCorrettive" rows="3"></textarea>
    </div>
    
    <div class="form-group">
        <label>Azioni preventive</label>
        <textarea class="form-control" name="azioniPreventive" rows="3"></textarea>
    </div>
    
      <div class="col-lg-4 col-md-4 form-group">
        <label>Data fine</label>
        <input type="date" class="form-control"   name="dataF"/>
    </div>
    
    <!-- fare controllo inserimento -->
    
    <div class="col-lg-4 col-md-4 form-group">
        <label>Costo</label>
        <input type="text" class="form-control"  name="costo"/>
    </div>
    
      <button type="submit" class="btn btn-primary">Salva</button>
</form>
    
