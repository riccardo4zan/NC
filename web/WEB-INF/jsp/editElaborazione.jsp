<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
                                    <li><a href="#">Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <h1> Elaborazione numero: ${codice} </h1>
            <form  name="" action="">
                <div class="form-group">
                    <label> Descrizione </label>
                    <textarea class="form-control" name="descrizione"> ${descrizione} </textarea>
                </div>
                <div class="form-group">
                    <label> Data Inizio </label>
                    <input type="date" class="form-control" readonly="true" value="${DataInizio}" name="dataInizio"/>
                </div>
                <div class="form-group">
                    <label> Data Fine </label>
                   <input type="date" class="form-control"  placeholder="data fine" name="dataFine"/>
                </div>
                 <div class="form-group">
                    <label> Non conformita </label>
                   <input type="text" class="form-control" readonly="true" value="${nonConformita}" name="nonConformita"/>
                </div>
                <input type="submit" class="form-control"  name="submit">Salva
            </form>

        </div> <!-- /container -->
        <!-- Bootstrap core JavaScript
               ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="resources/js/jquery-slim.min.js"><\/script>')</script>
        <script src="resources/js/bootstrap.min.js"></script>
    </body>
</html>
