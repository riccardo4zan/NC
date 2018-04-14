<!-- Dropdown per ordinare -->
<ul class="nav navbar-nav navbar-right">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ordina per <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="#">Data</a></li>
            <li><a href="#">Codice</a></li>
        </ul>
    </li>
</ul>

<!-- Tabella elaborazioni da fare -->
<table class="table">
    <thead>
        <tr>
            <th>Codice elaborazione</th>
            <th>Data</th>
            <th>Modifica</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${elaborazioniAperte}" var="item">

        <tr>
            <td> <c:out value ="${item.Codice}"/> </td>
        <td> <c:out value ="${item.DataInizio}"/> </td>
        <td><a href="editElaborazione.jsp?codice=${item.codice}">Modifica</a></td>
        </tr>
    </c:forEach>
</tbody>
</table>
