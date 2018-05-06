<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function check(){
    var p1 = document.getElementById("name1").value;
    var p2 = document.getElementById("name2").value;
    if(p1 === p2 && p1 !== "") {
        document.getElementById("form").submit();
    } else {
        document.getElementById("err").style.display = "block";
    }
}
</script>

<form id="form" class="pass-form" action="/cq/saveNewPasswd" method="POST">
    <div id="err" style="display:none; color:red;">Le password non coincidono!</div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    
    <div class="form-group">
        <label>Nuova password</label>
        <input type="password" class="form-control" id="name1" name="psswd1" placeholder="Password"/>
    </div>
    <div class="form-group">
        <label>Ripeti password</label>
        <input type="password" class="form-control" id="name2" name="psswd2" placeholder="Password"/>
    </div>

</form>

<button class="btn btn-success "  onclick="check();">Salva</button>


