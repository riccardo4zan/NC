<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="mt">
    <h2>Aggiunta lotto di produzione</h2>
    <form method="get" action="/op/addProd">
        <div class="form-group">
            <label for="categoria">Seleziona la categoria</label>
            <select name="categoria" class="form-control">
                <c:forEach items="${categorie}" var="categoria">
                    <option value="${categoria.codice}">${categoria.descrizione}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="numero">Numero di pezzi prodotti</label>
            <input type="number" min="1" class="form-control" name="numero">
        </div>
        <input class="btn btn-success" type="submit" value="Aggiungi" />
    </form>
</div>