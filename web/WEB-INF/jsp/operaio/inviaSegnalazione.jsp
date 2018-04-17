<form:form name="addSegnalazione" modelAttribute="segnalazione" action="/addS" method="post">
    <div class="form-group">
        <label> Descrizione </label>
        <<form:input textarea class="form-control" path="descrizione"  id="descrizione" name="descrizione"> </textarea>
    </div>
    <div class="form-group">
        <label> Data  </label>
        <form:input type="date" class="form-control" path="data" id="data" readonly="true" value="funzionePerData" name="data"/>
    </div>
    <div class="form-group">
        <label> Matricola </label>
        <form:input type="date" class="form-control"  path="dipendente" id="dipendente" readonly="true" value="${matricola}" name="matricola"/>
    </div>
   <button type="submit" class="btn btn-primary">Salva</button>
</form:form>