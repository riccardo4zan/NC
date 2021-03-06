<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty allnc}">
    <table class="table">
        <thead>
            <tr>
                <th>Codice non conformit&agrave;</th>
                <th>Descrizione</th>
                <th>Azioni di contenimento</th>
                <th>Azioni correttive</th>
                <th>Tipo</th>
                <th>Data inizio</th>
                <th>Data fine</th>
                <th>Costo</th>
                <th>Pezzi difettosi</th>
                <th>Reparto</th>
                <th>Stato</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allnc}" var="nc">
                <tr>
                    <td> ${nc.codice} </td>
                    <td> ${nc.descrizione}</td>
                    <td> ${nc.azioniContenimento} </td>
                    <td> ${nc.azioniCorrettive}</td>
                    <td> ${nc.tipo.nome}</td>
                    <td> ${nc.dataApertura}</td>
                    <td> ${nc.dataChiusura}</td>
                    <td> ${nc.costo}</td>
                    <td> ${nc.pezziCorrelati.size()}</td>
                    <td> ${nc.reparto.nome}</td>
                    <td>
                    <c:choose>
                        <c:when test = "${nc.dataChiusura == null && nc.azioniCorrettive == null}">
                            Aperta
                        </c:when>
                        <c:when test = "${nc.dataChiusura == null && nc.azioniCorrettive != null}">
                            Elaborazione
                        </c:when>
                        <c:when test = "${nc.dataChiusura != null && nc.azioniCorrettive != null}">
                            Chiusa
                        </c:when>
                    </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
