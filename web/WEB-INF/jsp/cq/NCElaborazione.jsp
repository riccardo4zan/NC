<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${NCElaborazione.size()==0}"><h1>Non sono presenti non conformit&agrave; in elaborazione</h1></c:if>

<c:if test="${not empty NCElaborazione}">
    <table class="table">
        <thead>
            <tr>
                <th>Codice non conformita`</th>
                <th>Descrizione</th>
                <th>Azioni di contenimento</th>
                <th>Azioni correttive</th>
                <th>Data apertura</th>
                <th>Tipo </th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
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
                    <td> ${nc.tipo.nome}</td>
                    <td><a href="/cq/editNC?id=${nc.codice}&desc=${nc.descrizione}&azioniContenitive=${nc.azioniContenimento}">Modifica</a></td>
                    <td><a href="/cq/newElaborazione?id=${nc.codice}">Assegna elaborazione</a></td>
                    <td><a href="/cq/showTeam?codice=${nc.codice}">Assegna team operativo </a></td>
                    <td> <a href="/cq/pezziNC?ncc=${nc.codice}">Pezzi correlati</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table></c:if>
