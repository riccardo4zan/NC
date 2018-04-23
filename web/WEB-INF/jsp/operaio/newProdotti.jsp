<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <h2>Aggiunta lotto produzione</h2>
    <form method="get" action="/op/addProd">
        <div class="form-group">
            <label for="categoria">Seleziona la categoria</label>
            <select name="categoria" >
                <c:forEach items="${categorie}" var="categoria">
                    <option value="${categoria.codice}">${categoria.descrizione}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="numero">Indica il numero di pezzi prodotti</label>
            <input type="number" name="numero" />
        </div>
        <input type="submit" value="Aggiungi" />
    </form>
</div>