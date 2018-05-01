<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- vedere se ci sono nc aperte   -->
<c:if test="${not empty Vuoto}">${Vuoto}</c:if>

<c:if test="${not empty NCAperte}">
    <table class="table">
        <thead>
            <tr>
                <th>Codice non conformita`</th>
                <th>Descrizione</th>
                <th>Azioni di contenimento</th>
                <th>Data inizio</th>
                <th>Tipo </th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${NCAperte}" var="nc">
                <tr>
                    <td> ${nc.codice} </td>
                    <td> ${nc.descrizione}</td>
                    <td> ${nc.azioniContenimento} </td>
                    <td> ${nc.dataApertura}</td>
                    <td> ${nc.tipo.nome}</td>
                    <td> <a href="/cq/pezziNC?ncc=${nc.codice}">Pezzi correlati</a></td>
                    <td><a href="/cq/editNC?id=${nc.codice}&desc=${nc.descrizione}&azioniContenitive=${nc.azioniContenimento}">Modifica</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
