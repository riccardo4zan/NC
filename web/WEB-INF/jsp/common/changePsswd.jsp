<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="pass-form" action="/cq/saveNewPasswd" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    
    <div class="form-group">
        <input type="text" class="form-control" name="psswd1" placeholder="Password"/>
    </div>
    <div class="form-group">
        <input type="text" class="form-control" name="psswd2" placeholder="Ripeti la Password"/>
    </div>
        
    <button type="submit" class="btn btn-lg bottone">Salva</button>
</form>