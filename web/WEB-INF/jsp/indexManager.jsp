<%@page import="nc.model.Fornitore"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Custom styles for this template -->
        <link href="/resources/css/navbar.css" rel="stylesheet">
    <body>
        <div class="contenuto">
            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="#">Home</a></li>
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
            <!-- cards -->
            <br><br>
            <div class="row">
                <div class="col-lg-4 col-md-4 center">
                    <div class="card p-30">
                        <div class="media">
                            <div class="media-left meida media-middle">
                                <span><i class="fa fa-usd f-s-40 color-primary"></i></span>
                            </div>
                            <div class="media-body media-text-right">
                                <h2>123</h2>
                                <p class="m-b-0">Ordini questo mese</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 center">
                    <div class="card p-30">
                        <div class="media">
                            <div class="media-left meida media-middle">
                                <span><i class="fa fa-usd f-s-40 color-primary"></i></span>
                            </div>
                            <div class="media-body media-text-right">
                                <h2>123</h2>
                                <p class="m-b-0">Guadagnati questo mese</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 center">
                    <div class="card p-30">
                        <div class="media">
                            <div class="media-left meida media-middle">
                                <span><i class="fa fa-usd f-s-40 color-primary"></i></span>
                            </div>
                            <div class="media-body media-text-right">
                                <h2>123</h2>
                                <p class="m-b-0">Clienti attuali</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- /cards -->

            <!-- istogramma -->
            <br><br><br><br>
            <div class="row">
                <h3>Costo Non Conformità per mese</h3><br><br>
                <div class="col-lg-12 col-md-12" >
                    <div class="istogramma" id="istogramma"></div>
                </div>
            </div>

            <!-- grafici torta -->
            <br><br><br><br>
            <div class="row contenuto">
                <h3>Grafici a torta</h3><br><br>
                <div class="childs col-lg-4 col-md-4" style="height: 400px; width: 400px;">
                    <div id="reparti" ></div>
                </div>
                <div class="childs col-lg-4 col-md-4" style="height: 400px; width: 400px;">
                    <div id="prodotti" ></div>
                </div>
                <div class="childs col-lg-4 col-md-4" style="height: 400px; width: 400px;">
                    <div id="fornitori"></div>
                </div>
            </div>

            sponi<br>
            <c:forEach items="${sponi}" var="i">
                ${i.nome}
            </c:forEach><br><br>
            triplo<br>
            <c:forEach items="${triplo}" var="i">
                ${i.nome}
            </c:forEach><br><br>
            rete<br>
            <c:forEach items="${rete}" var="i">
                ${i.nome}
            </c:forEach><br><br>


            fornitore<br>
            <c:forEach items="${fornitoriData}" var="i">
                ["${i.etichetta}","${i.valD}"],
            </c:forEach>
            <br>reparto<BR>
            <c:forEach items="${repartiData}" var="i">
                ["${i.etichetta}","${i.valD}"],
            </c:forEach>
            <BR> tipi<BR>
            <c:forEach items="${tipiData}" var="i">
                ["${i.etichetta}","${item.valD}"],
            </c:forEach>

        </div> <!-- /container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script>window.jQuery || document.write('<script src="/resources/js/jquery-slim.min.js"><\/script>')</script>
        <script src="/resources/js/bootstrap.min.js"></script>

        <!-- Grafici manager -->
        <script type="text/javascript" src="/resources/js/util.js"></script>
        <script type="text/javascript" src="/resources/js/chart-loader.js"></script>
        <script type="text/javascript">
            // colori che sarebbe meglio mettere https://canvasjs.com/javascript-charts/animated-chart/
            var colors = ["#5DA5DA", "#FAA43A", "#60BD68", "#F17CB0", "#B2912F", "#B276B2", "#DECF3F", "#F15854"];
            google.charts.load("current", {packages: ["corechart"]});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ["Clienti", "Vendite"],

                    ["404", 200]
                ]);
                var options = {
                    colors: colors,
                    width: 300,
                    height: 300,
                    chartArea: {'width': '90%', 'height': '90%'},
                    legend: {position: 'none'},
                    pieHole: 0.4,
                    pieSliceTextStyle: {
                        color: 'white',
                        fontSize: 16
                    }
                };
                var chart = new google.visualization.PieChart(document.getElementById('fornitori'));
                chart.draw(data, options);
            }
        </script>
        <script type="text/javascript">
            google.charts.load("current", {packages: ["corechart"]});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ["Clienti", "Vendite"],
                    ["404", 200],
                    ["non mi ", 250],
                    ["bello", 300],
                    ["Ciao", 350]
                ]);
                var options = {
                    colors: colors,
                    width: 300,
                    height: 300,
                    chartArea: {'width': '90%', 'height': '90%'},
                    legend: {position: 'none'},
                    pieHole: 0.4,
                    pieSliceTextStyle: {
                        color: 'white',
                        fontSize: 16
                    }
                };
                var chart = new google.visualization.PieChart(document.getElementById('prodotti'));
                chart.draw(data, options);
            }
        </script>
        <script type="text/javascript">
            google.charts.load("current", {packages: ["corechart"]});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ["Clienti", "Vendite"],
                    ["404", 200],
                    ["non mi ", 250],
                    ["bello", 300],
                    ["Ciao", 350]
                ]);
                var options = {
                    colors: colors,
                    width: 300,
                    height: 300,
                    chartArea: {'width': '90%', 'height': '90%'},
                    legend: {position: 'none'},
                    pieHole: 0.4,
                    pieSliceTextStyle: {
                        color: 'white',
                        fontSize: 16
                    }
                };
                var chart = new google.visualization.PieChart(document.getElementById('reparti'));
                chart.draw(data, options);
            }

        </script>

        <script type="text/javascript">
            google.charts.load('current', {'packages': ['bar']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['', 'Sales'],
                    ['2014', 1000],
                    ['2015', 1170],
                    ['2016', 660],
                    ['2016', 660],
                    ['2016', 660],
                    ['2016', 660],
                    ['2017', 1030]
                ]);

                var options = {
                    legend: {position: 'none'},
                    colors: "#81C784"
                };

                var div = document.getElementById("istogramma");
                var chart = new google.charts.Bar(document.getElementById('istogramma'));

                chart.draw(data, google.charts.Bar.convertOptions(options));
            }
        </script>

        <!--DEBUG FOX-->
        <c:out value="${out1}"></c:out>

    </body>
</html>
