<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3><c:if test="${not empty Errore}">${Errore}</c:if></h3>
    <br>
    <h4>Nuovo fornitore:</h4>
    <br>
    <form name="addF" action="/ma/addFornitore" onsubmit="validateForm()" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <div class="form-group">
        <label>Partita Iva:</label>
        <input type="text" class="form-control" id=piva name="piva" />
    </div>

    <div class="form-group">
        <label>Nominativo</label>
        <input class="form-control" required type="text" name="nome"/>
    </div>
    <button type="submit" class="btn btn-success">Salva</button>   
</form>

<script>
    function validateForm() {
        var x = document.forms["addF"]["piva"].value.length;
        if (x != 11)
            alert("partita iva non valida!")
    }
</script>
