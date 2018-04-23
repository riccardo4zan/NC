<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/cq/saveNewPasswd" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    
    <div class="form-group">
        <label>Password</label>
        <input type="text" class="form-control" name="psswd1"/>
    </div>
    <div class="form-group">
        <label>Ripeti password</label>
        <input type="text" class="form-control" name="psswd2"/>
    </div>
        
    <button type="submit" class="btn btn-lg btn-primary">Salva</button>
</form>