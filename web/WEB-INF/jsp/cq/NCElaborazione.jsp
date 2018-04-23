<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- vedere se ci sono nc in elaborazione   -->
<c:if test="${not empty Vuoto}">${Vuoto}</c:if>
    
<!-- Tabella NC -->
<table class="table">
    <thead>
        <tr>
            <th>Codice non conformita`</th>
            <th>Descrizione</th>
            <th>Azioni di contenimento</th>
            <th>Azioni correttive</th>
            <th>Tipo </th>
            <th>Modifica</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${NCElaborazione}" var="nc">
            <tr>
                <td> ${nc.codice} </td>
                <td> ${nc.descrizione}</td>
                <td> ${nc.azioniContenimento} </td>
                <td> ${nc.azioniCorrettive}</td>
                <td> ${nc.dataApertura}</td>
                <td> ${nc.tipo}</td>
                <td><a href="/cq/editNC?id=${nc.codice}">Modifica</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>