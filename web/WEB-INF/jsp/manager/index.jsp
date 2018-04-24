<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br><br>
<!-- cards -->
    <div class="row">
        <div class="col-lg-4 col-md-4 center">
            <div class="card p-30 mh">
                <div class="media">
                    <div class="media-left meida media-middle">
                        <span><i class="fa fa-usd f-s-40 color-primary"></i></span>
                    </div>
                    <div class="media-body media-text-right">
                        <h2><center>${totale}&euro;</center></h2>
                        <p class="m-b-0"><center>Costo non conformità quest'anno</center></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-md-4 center">
            <div class="card p-30 mh">
                <div class="media">
                    <div class="media-left meida media-middle">
                        <span><i class="fa fa-usd f-s-40 color-primary"></i></span>
                    </div>
                    <div class="media-body media-text-right">
                        <h2><center>${ncAnno}</center></h2>
                        <p class="m-b-0"><center>Non Conformità riscontrate quest'anno</center></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-md-4 center">
            <div class="card p-30 mh">
                <div class="media">
                    <div class="media-left meida media-middle">
                        <span><i class="fa fa-usd f-s-40 color-primary"></i></span>
                    </div>
                    <div class="media-body media-text-right">
                        <h2 class="<c:if test="${differenza<=0}">pos</c:if><c:if test="${differenza>0}">neg</c:if>"><center>${differenza}&percnt;</center></h2>
                            <p class="m-b-0"><center>Differenza percentuale costi NC rispetto allo scorso anno</center></p>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- /cards -->

        <!-- istogramma -->
        <br><br><br><br>
        <div class="row">
            <h3>Costo Non Conformità per mese</h3>
            <div class="col-lg-12 col-md-12" >
                <div class="istogramma" id="istogramma"></div>
            </div>
        </div>

        <!-- grafici torta -->
        <br><br><br><br>
        <div class="row contenuto">
            <div class="row"><h3>Grafici a torta</h3></div>
            <div class="row col-lg-12 col-md-12">
            <div class="childs col-lg-4 col-md-4" style="height: 300px; width: 300px;">
                <div id="reparti" ></div>
            </div>
            <div class="childs col-lg-4 col-md-4" style="height: 300px; width: 300px;">
                <div id="prodotti" ></div>
            </div>
            <div class="childs col-lg-4 col-md-4" style="height: 300px; width: 300px;">
                <div id="fornitori"></div>
            </div>
                
            </div>
        </div>
</div>

    <!-- Grafici manager -->
    <script type="text/javascript" src="/resources/js/chart-loader.js"></script>

    <!-- grafici a torta -->
    <script type="text/javascript">
        // colori che sarebbe meglio mettere https://canvasjs.com/javascript-charts/animated-chart/
        var colors = ["#5DA5DA", "#FAA43A", "#60BD68", "#F17CB0", "#B2912F", "#B276B2", "#DECF3F", "#F15854"];
        google.charts.load("current", {packages: ["corechart"]});
        google.charts.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ["Fornitore", "Costo"]
    <c:forEach items="${fornitoriData}" var="i">
                , ["${i.etichetta}", "${i.valD}"]
    </c:forEach>
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
            ["Prodotto", "Costo"],
    <c:forEach items="${tipiData}" var="i">
            ["${i.etichetta}", "${i.valD}"],
    </c:forEach>
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
            ["Reparto", "Costo"]
    <c:forEach items="${repartiData}" var="i">
            , ["${i.etichetta}", "${i.valD}"]
    </c:forEach>
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

<!-- /grafici a torta -->

<!-- istogramma -->
<script type="text/javascript">
    google.charts.load('current', {'packages': ['bar']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['', 'Sales']
    <c:forEach items="${istogramma}" var="i">
            , ["${i.etichetta}", "${i.valD}"]
    </c:forEach>
        ]);
        var options = {
            legend: {position: 'none'},
            colors: "#81C784",
        };
        var div = document.getElementById("istogramma");
        var chart = new google.charts.Bar(document.getElementById('istogramma'));
        chart.draw(data, google.charts.Bar.convertOptions(options));

    }
</script>
<!-- /istogramma -->