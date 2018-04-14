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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet">
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