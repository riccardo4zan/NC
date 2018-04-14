<!-- Tabella elaborazioni fatte -->
<h1>Elaborazioni concluse </h1>

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

<table class="table">
    <thead>
        <tr>
            <th>Codice elaborazione</th>
            <th>Data</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${elaborazioniChiuse}" var="item">

        <tr>
            <td> <c:out value ="${item.Codice}"/> </td>
        <td> <c:out value ="${item.DataInizio}"/> </td>
        <td><a href="elaborazioneConclusa.jsp?codice=${item.codice}">Visualizza elaborazione</a></td>
        </tr>
    </c:forEach>
</tbody>
</table>