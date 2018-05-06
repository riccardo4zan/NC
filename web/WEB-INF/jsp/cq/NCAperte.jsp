<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${NCAperte.size()==0}"><h1>Non sono presenti non conformit&agrave; aperte :)</h1></c:if>

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
