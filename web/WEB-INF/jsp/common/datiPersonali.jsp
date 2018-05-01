<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div >
    <div class="margin-t row">
        <div class="divTable imieidati">
            <div class="divTableBody">
                <div class="divTableRow">
                    <div class="divTableCell">Matricola</div>
                    <div class="divTableCell">${datiPersonali.matricola}</div>
                </div>
                <div class="divTableRow">
                    <div class="divTableCell">Username</div>
                    <div class="divTableCell">${datiPersonali.user.username}</div>
                </div>
                <div class="divTableRow">
                    <div class="divTableCell">Nome</div>
                    <div class="divTableCell">${datiPersonali.nome}</div>
                </div>
                <div class="divTableRow">
                    <div class="divTableCell">Cognome</div>
                    <div class="divTableCell">${datiPersonali.cognome}</div>
                </div>
                <div class="divTableRow">
                    <div class="divTableCell">Id del Reparto</div>
                    <div class="divTableCell">${datiPersonali.reparto.id}</div>
                </div>
                <div class="divTableRow">
                    <div class="divTableCell">Reparto</div>
                    <div class="divTableCell">${datiPersonali.reparto.nome}</div>
                </div>
            </div>
        </div>

    </div>
    <div class="cambia-pass">
        <a href="./cambiaPassword"><button class="btn btn-success">Cambia password</button></a>
    </div>