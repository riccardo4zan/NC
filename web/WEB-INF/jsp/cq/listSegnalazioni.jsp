<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Tabella segnalazioni da fare -->
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
    <c:forEach items="${segnalazioni}" var="item">
        <tr>
            <td> ${item.codice} </td>
            <td> ${item.titolo}</td>
            <td> ${item.data} </td>
            <td> ${item.dipendente.reparto.nome}</td>
            <td><a href="/cq/dettaglioSegnalazione?id=${item.codice}"><span class="glyphicon glyphicon-search"></span>Visualizza </a></td>
        </tr>
    </c:forEach>
</tbody>
</table>