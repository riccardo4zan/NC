<form name="addNCInterna" action="/addNCInterna" method="get">
    <div class="form-group">
        <label> Descrizione  </label>
        <textarea class="form-control"  id="desc" name="desc"> </textarea> 
    </div>
    <div class="form-group">
        <div class="form-group">
            <label> Tipo </label>
            <select id="tipo" name="tipo" >   
                <c:forEach items="${Tipi}" var="tipo">
                    <option value="${tipo.nome}">${tipo.nome}</option>
                </c:foreach>
            </select>
        </div>
        <div class="form-group">
            <label> Reparto </label>
           <select id="tipo" name="tipo" >   
                <c:forEach items="${Reparti}" var="reparti">
                    <option value="${reparti.codice}">${reparti.nome}</option>
                </c:foreach>
            </select>
        </div>
        <div class="form-group">
            <label> Data Inizio  </label>
            <input type="date" class="form-control"  id="dataInizio"   name="dataInizio"/>
        </div>

        <button type="submit" class="btn btn-primary">Salva</button>
</form>

