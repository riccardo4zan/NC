<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="card text-center">
        <div class="card-header">
            ${segnalazione.titolo}
        </div>
        <div class="card-body">
            <h5 class="card-title">Segnalazione da: ${segnalazione.dipendente.matricola} (${segnalazione.dipendente.nome}, ${segnalazione.dipendente.cognome})</h5>
            <h5 class="card-title">Reparto: ${segnalazione.dipendente.reparto.nome} </h5>
            <p id="descrizione" class="card-text">${segnalazione.descrizione}</p>
        </div>
        <div id="data" class="card-footer text-muted">
            Segnalato in data ${segnalazione.data}
        </div>
        
        <a href="/cq/newNC"><input type="button" value="Apri NC" >Apri non conformita`</a>
    <a href="/cq/rimuoviSegnalazione?id=${segnalazione.codice}"><input type="button" value="Elimina segnalazione">Elimina segnalazione</a>
    </div>
