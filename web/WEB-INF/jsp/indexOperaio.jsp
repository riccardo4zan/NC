<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gestione NC</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>


    <!-- Custom styles for this template -->
    <link href="resources/css/navbar.css" rel="stylesheet">

  <body>

    <div class="container">

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="#">Home</a></li>
              <li><a href="#">Segnala</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Matricola qui <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">I miei dati</a></li>
                  <li><a href="/logout">Logout</a></li>
                </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
      
          <!-- Dropdown per ordinare -->
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ordina per <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Data</a></li>
                        <li><a href="#">Codice</a></li>
                    </ul>
                </li>
            </ul>
            
            <!-- Tabella elaborazioni da fare -->
            <table class="table">
                <thead>
                <tr>
                    <th>Codice elaborazione</th>
                    <th>Data</th>
                    <th>Modifica</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ArrayDiElaborazioni}" var="item">
                    
                    <tr>
                        <td> <c:out value ="${item.Codice}"/> </td>
                        <td> <c:out value ="${item.DataInizio}"/> </td>
                        <td><a href="editElaborazione.jsp?codice=${item.codice}">Modifica</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            
            <!-- Tabella elaborazioni fatte -->
            
            <h1>Elaborazioni concluse </h1>
            
             <table class="table">
                <thead>
                <tr>
                    <th>Codice elaborazione</th>
                    <th>Data</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ArrayDiElaborazioni}" var="item">
                    
                    <tr>
                        <td> <c:out value ="${item.Codice}"/> </td>
                        <td> <c:out value ="${item.DataInizio}"/> </td>
                        <td><a href="elaborazioneConclusa.jsp?codice=${item.codice}">Visualizza elaborazione</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="resources/js/jquery-slim.min.js"><\/script>')</script>
    <script src="resources/js/bootstrap.min.js"></script>
  </body>
</html>