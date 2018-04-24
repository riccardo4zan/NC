<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <form method="get" action="/ma/addCat">
        <div class="form-group">
            <label for="area">Descizione nuova categoria di prodotto</label>
            <textarea class="form-control" id="area" name="desc" type="text" rows="3"></textarea>
        </div>
        <input class="bottone btn" type="submit" value="Crea" />
    </form>
</div>