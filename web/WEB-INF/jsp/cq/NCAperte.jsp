<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Tabella NC -->
<table class="table">
    <thead>
        <tr>
            <th>Codice segnalazione</th>
            <th>Titolo</th>
            <th>Data</th>
            <th>Reparto</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${NCAperte}" var="nc">
        <tr>
            <td> ${nc.codice} </td>
            <td> ${nc.descrizione}</td>
            <td> ${nc.azioniContenimento} </td>
            <td> ${nc.azioniCorrettive}</td>
            <td> ${nc.azioniPreventive}</td>
            <td><a href="/cq/dettaglioSegnalazione?id=${item.codice}"><span class="glyphicon glyphicon-search"></span></a></td>
        </tr>
    </c:forEach>
</tbody>
</table>