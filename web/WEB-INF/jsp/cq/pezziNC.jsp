<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br>
<h4>  Codice non conformita:${codNc}</h4>
<br>
<table class="table">
    <thead>
        <tr>
            <th>Codice pezzo</th>
             <th>Categoria</th>
        </tr>
    </thead>     
    <tbody>

        <c:forEach items="${visualPezzi}" var="p">
            <tr>
                <td> ${p.codice} </td>
                <td> ${p.categoria.descrizione} </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

