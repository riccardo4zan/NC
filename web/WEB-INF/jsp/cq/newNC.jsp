<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<form name="addNCInterna" action="/cq/addNCInterna" method="get">
    <div class="form-group">
        <label> Descrizione  </label>
        <textarea class="form-control" name="desc"> </textarea> 
    </div>
     <div class="form-group">
        <label> Azione contenitive  </label>
        <textarea class="form-control" name="azioniContenimento"> </textarea> 
    </div>
        <div class="form-group">
        <label> Cause  </label>
        <textarea class="form-control" name="cause"> </textarea> 
    </div>
     <div class="form-group">
        <label> Gravità  </label>
        <br>
        <input type="radio" name="gravita" value="1"> bassa<br>
        <input type="radio" name="gravita" value="2"> media<br>
        <input type="radio" name="gravita" value="3"> alta
     </div>
    <div class="form-group">
        <div class="form-group">
            <label> Tipo </label>
            <select id="tipo" name="tipo" >
                <option value="">Nullo</option>
                <c:forEach items="${Tipi}" var="tipo">
                    <option value="${tipo.nome}">${tipo.nome}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label> Reparto </label>
           <select id="reparto" name="reparto" >
               <option value="">Nullo</option>
                <c:forEach items="${Reparti}" var="reparto">
                    <option value="${reparto.id}">${reparto.nome}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label> Fornitore </label>
           <select id="fornitore" name="fornitori" >
               <option value="">Nullo</option>
                <c:forEach items="${Fornitori}" var="fornitore">
                    <option value="${fornitore.piva}">${fornitore.nome}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label> Cliente </label>
           <select id="cliente" name="reparto" >
               <option value="">Nullo</option>
                <c:forEach items="${Clienti}" var="clienti">
                    <option value="${clienti.id}">${clienti.nome}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label> Data Inizio  </label>
            <input type="date" class="form-control"  id="dataInizio"   name="dataInizio"/>
        </div>

        <button type="submit" class="btn btn-primary">Salva</button>
</form>

