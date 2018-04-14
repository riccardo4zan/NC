<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <meta charset="ISO-8859-15">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload='document.loginForm.username.focus();'>
        <div class="container">
            <form class="form-signin" name='loginForm' action="<c:url value='/' />" method='POST'>
                <center>
                    <br><h2 class="form-signin-heading">Accedi</h2><br>
                </center>
                <div class="form-group">
                    <input name="username" class="form-control" placeholder="Username" required autofocus><br>
                    <input name="password" type="Password" class="form-control" placeholder="Password" required><br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Entra</button>
                </div>        
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </body>
</html>
