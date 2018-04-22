<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    
    <h3>${segnalazione.titolo}</h3>
    
    <div id="data"><h5>Segnalato in data ${segnalazione.data}</h5></div><br>
    
    <div id="descrizione">
        <h4>${segnalazione.descrizione}</h4>
    </div>
    <br><br>
    <div>
        <h4><b>Segnalazione da:</b> ${segnalazione.dipendente.matricola} (${segnalazione.dipendente.nome}, ${segnalazione.dipendente.cognome})</h4>
        <h4><b>Reparto:</b> ${segnalazione.dipendente.reparto.nome}</h4>
    </div>
    
    <a href="/cq/newNC"><input type="button" value="Apri NC" >Apri non conformita`</a>
    <a href="/cq/rimuoviSegnalazione?id=${segnalazione.codice}"><input type="button" value="Elimina segnalazione">Elimina segnalazione</a>
    
</div>