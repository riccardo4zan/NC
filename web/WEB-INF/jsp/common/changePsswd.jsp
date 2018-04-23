<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function check(){
    var p1 = document.getElementById("name1").value;
    var p2 = document.getElementById("name2").value;
    if(p1 === p2) document.getElementById("form").submit();
    else document.getElementById("err").style.display = "block";
}
</script>
<div id="err" style="display:none; color:red;">Le password non coincidono!</div>
<form id="form" class="pass-form" action="/cq/saveNewPasswd" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <div class="form-group">
        <input type="text" class="form-control" id="name1" name="psswd1" placeholder="Password"/>
    </div>
    <div class="form-group">
        <input type="text" class="form-control" id="name2" name="psswd2" placeholder="Ripeti la Password"/>
    </div>

    <button onclick="check();" class="btn btn-lg bottone">Salva</button>
</form>