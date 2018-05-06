<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty NCChiuse}"><h1>Non sono presenti non conformit&agrave; chiuse</h1></c:if>

<c:if test="${not empty NCChiuse}">
    <table class="table">
        <thead>
            <tr>
                <th>Codice non conformit&agrave;</th>
                <th>Descrizione</th>
                <th>Azioni di contenimento</th>
                <th>Azioni correttive</th>
                <th>Tipo </th>
                <th>Data inizio</th>
                <th>Data fine</th>
                <th>Costo </th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${NCChiuse}" var="nc">
                <tr>
                    <td> ${nc.codice} </td>
                    <td> ${nc.descrizione}</td>
                    <td> ${nc.azioniContenimento} </td>
                    <td> ${nc.azioniCorrettive}</td>
                    <td> ${nc.tipo.nome}</td>
                    <td> ${nc.dataApertura}</td>
                    <td> ${nc.dataChiusura}</td>
                    <td> ${nc.costo}</td>
                     <td> <a href="/cq/pezziNC?ncc=${nc.codice}">Pezzi correlati</a></td>
                    <td><a href="/cq/visualizzaNC?id=${nc.codice}">Visualizza</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <script>
        setTimeout(function () {
            location.reload();
        }, 30000);
    </script>
</c:if>
