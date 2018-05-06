<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="mt">
    <h3><center>Elaborazioni ancora Aperte </center></h3>
    <div class="navbar-nav destra">
        <li class="nav-item dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ordina per <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Data</a></li>
                <li><a href="#">Codice</a></li>
            </ul>
        </li>
    </div>

<table class="table">
    <thead>
        <tr>
            <th>Codice elaborazione</th>
            <th>Data</th>
            <th>Modifica</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${aperte}" var="item">
        <tr>
            <td> ${item.codice} </td>
            <td> ${item.dataInizio} </td>
            <td><a href="/op/editElaborazione?codice=${item.codice}">Modifica</a></td>
        </tr>
    </c:forEach>
</tbody>
</table>
