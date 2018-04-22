<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../resources/css/logincss.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
        <script src="../resources/js/loginjs.js" type="text/javascript"></script>
    </head>
    <body onload='document.loginForm.username.focus();'>
        <div class="container">
            <form class="box-centro" name='loginForm' action="<c:url value='/' />" method='POST'>
                <div class="group">
                    <input type="text" name="username" required ><span class="highlight"></span><span class="bar"></span>
                    <label>Username</label>
                </div>
                <div class="group">
                    <input name="password" type="Password" required ><span class="highlight"></span><span class="bar"></span>
                    <label>Password</label>
                </div>
                <button type="submit" class="button buttonBlue">Log-In
                    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
                </button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </body>
</html>
