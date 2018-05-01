<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>LogIn</title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap-theme.min.css">
        <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../resources/css/loginNew.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
        <script src="../resources/js/loginjs.js" type="text/javascript"></script>

  
    </head>
    <body onload='document.loginForm.username.focus();'>
    <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Site<span>Random</span></div>
		</div>
		<br>
		<div class="login">
                    <form class="form" name='loginForm' action="<c:url value='/' />" method='POST'>
				<input type="text" placeholder="username" id="username" name="username"><br>
				<input type="password" placeholder="password" id="password" name="password"><br>
				<button type="submit">Log in</button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>
		</div>

    
    
    
    
    
        
  
    </body>
</html>
            </form>
      
