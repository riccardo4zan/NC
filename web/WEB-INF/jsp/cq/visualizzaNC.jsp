<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<br>
<div>
    
    <p><label>Codice: </label> ${NCChiesta.codice}</p>

    <p><label>Descrizione: </label> ${NCChiesta.descrizione}</p>

    <p><label>Azioni contenimento: </label> ${NCChiesta.azioniContenimento}</p>
    
    <p><label>Azioni correttive: </label> ${NCChiesta.azioniCorrettive}</p>
    
    <p><label>Azioni preventive: </label> ${NCChiesta.azioniPreventive}</p>
    
    <p><label>Data apertura: </label> ${NCChiesta.dataApertura}</p>
    
    <p><label>Data chiusura: </label> ${NCChiesta.dataChiusura}</p>
    
    <p><label>Cause: </label> ${NCChiesta.cause}</p>
    
    <p><label>Gravita: </label> ${NCChiesta.gravita}</p>
    
    <p><label>Costo: </label> ${NCChiesta.costo}</p>
    
    <p><label>Tipo: </label> ${NCChiesta.tipo.nome}</p>
    
    <p><label>Fornitore: </label> ${NCChiesta.fornitore.nome}</p>
    
    <p><label>Cliente: </label> ${NCChiesta.cliente.nome}</p>
    
    <p><label>Reparto: </label> ${NCChiesta.reparto.nome}</p>
    
    <p><label>Dipendente: </label> ${NCChiesta.dipendente.matricola} - ${NCChiesta.dipendente.nome}, ${NCChiesta.dipendente.cognome} - ${NCChiesta.dipendente.user.username}</p>
    
    <c:forEach items="${NCChiesta.elaborazioni}" var="item" >
        <p><label>Elaborazione:</label>
            Codice ${item.codice} 
            Descrizione ${item.descrizione}  
            DataInizio ${item.dataInizio} 
            DatFine ${item.dataFine} 
            Dipentente matricola ${item.dipendente.matricola}
            Dipendente nome ${item.dipendente.nome}
            Dipendente cognome ${item.dipendente.cognome}
            Dipendente username ${item.dipendente.user.username}
        </p>
    </c:forEach>
    
    <c:forEach items="${NCChiesta.pezziCorrelati}" var="item" >
        <p><label>Pezzo:</label>${item.categoria} - ${item.codice}</p>
    </c:forEach>
    
    <c:forEach items="${NCChiesta.team}" var="item" >
        <p><label>Dipendente:</label>${item.matricola} - ${item.nome}, ${item.cognome} - ${item.username}</p>
    </c:forEach>
    
</div>
