<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <p><label>Matricola: </label>${datiPersonali.matricola}</p>
    <p><label>Username: </label>${datiPersonali.user.username}</p>
    <p><label>Nome: </label>${datiPersonali.nome}</p>
    <p><label>Cognome: </label>${datiPersonali.cognome}</p>    
    <p><label>Id del Reparto: </label>${datiPersonali.reparto.id}</p>
    <p><label>Reparto: </label>${datiPersonali.reparto.nome}</p>    
    <a href="/cq/cambiaPassword"><button class="btn btn-lg btn-primary">Cambia password</button></a>
</div>

