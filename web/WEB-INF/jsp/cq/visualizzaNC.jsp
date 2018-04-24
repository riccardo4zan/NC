<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<br>
<div class="divTable visualnc">
    <div class="divTableBody">
        <div class="divTableRow">
            <div class="divTableCell">Codice</div>
            <div class="divTableCell">${NCChiesta.codice}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Descrizione</div>
            <div class="divTableCell">${NCChiesta.descrizione}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Azioni contenimento</div>
            <div class="divTableCell">${NCChiesta.azioniContenimento}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Azioni correttive</div>
            <div class="divTableCell">${NCChiesta.azioniCorrettive}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Azioni preventive</div>
            <div class="divTableCell">${NCChiesta.azioniPreventive}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Data apertura</div>
            <div class="divTableCell">${NCChiesta.dataApertura}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Data chiusura</div>
            <div class="divTableCell">${NCChiesta.dataChiusura}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Cause</div>
            <div class="divTableCell">${NCChiesta.cause}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Gravit&agrave;</div>
            <div class="divTableCell">${NCChiesta.gravita}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Costo</div>
            <div class="divTableCell">${NCChiesta.costo}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Tipo</div>
            <div class="divTableCell">${NCChiesta.tipo.nome}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Fornitore</div>
            <div class="divTableCell">${NCChiesta.fornitore.nome}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Cliente</div>
            <div class="divTableCell">${NCChiesta.cliente.nome}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Reparto</div>
            <div class="divTableCell">${NCChiesta.reparto.nome}</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">Dipendente</div>
            <div class="divTableCell">${NCChiesta.dipendente.matricola} - ${NCChiesta.dipendente.nome}, ${NCChiesta.dipendente.cognome} - ${NCChiesta.dipendente.user.username}</div>
        </div>
        <c:forEach items="${NCChiesta.elaborazioni}" var="item" >
            <div class="divTableRow">
                <div class="divTableCell">Elaborazione</div>
                <div class="divTableCell">
                    Codice: &nbsp; ${item.codice} <br></br>
                    Descrizione: &nbsp; ${item.descrizione}  <br></br>
                    DataInizio: &nbsp; ${item.dataInizio} <br></br>
                    DatFine: &nbsp; ${item.dataFine} <br></br>
                    Dipentente matricola: &nbsp; ${item.dipendente.matricola} <br></br>
                    Dipendente nome: &nbsp; ${item.dipendente.nome} <br></br>
                    Dipendente cognome: &nbsp; ${item.dipendente.cognome} <br></br>
                    Dipendente username: &nbsp; ${item.dipendente.user.username} <br></br>
                </div>
            </div>
        </c:forEach>
        <c:forEach items="${NCChiesta.pezziCorrelati}" var="item" >
            <div class="divTableRow">
                <div class="divTableCell">Pezzo</div>
                <div class="divTableCell">${item.categoria} - ${item.codice}</div>
            </div>
        </c:forEach>
        <c:forEach items="${NCChiesta.team}" var="item" >
            <div class="divTableRow">
                <div class="divTableCell">Dipendente</div>
                <div class="divTableCell">${item.matricola} - ${item.nome}, ${item.cognome} - ${item.username}</div>
            </div>
        </c:forEach>

    </div>
</div>