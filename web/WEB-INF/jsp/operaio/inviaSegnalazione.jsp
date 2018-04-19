<form:form name="addSegnalazione" modelAttribute="segnalazione" action="/addS" method="post">
    <div class="form-group">
        <form:label  path="descrizione"> Descrizione  </form:label>
        <form:input type="text" class="form-control" path="descrizione" id="descrizione" name="descrizione"/> 
    </div>
    <div class="form-group">
        <form:label  path="data"> Data   </form:label>
        <form:input type="date" class="form-control" path="data" id="data" readonly="true"  name="data"/>
    </div>
    <div class="form-group">
       <form:label path="dipendente"> Matricola </form:label>
       <form:input type="text" class="form-control"  path="dipendente" id="dipendente" readonly="true" value="${matricola}" name="matricola"/>
    </div>
   <button type="submit" class="btn btn-primary">Salva</button>
</form:form>
    