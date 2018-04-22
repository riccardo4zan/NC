<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Tabella segnalazioni da fare -->
<table class="table">
    <thead>
        <tr>
            <th>Codice segnalazione</th>
            <th>Data</th>
            <th>Vedi di pi&ugrave;</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${segnalazioni}" var="item">
        <tr>
            <td> ${item.codice} </td>
            <td> ${item.data} </td>
            <td><a href="editElaborazione.jsp?codice=${item.codice}">Modifica</a></td>
        </tr>
    </c:forEach>
</tbody>
</table>