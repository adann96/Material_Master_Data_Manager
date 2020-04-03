$(document).ready(function() {
    google.charts.load('current', {packages: ['corechart', 'bar']});
    google.charts.setOnLoadCallback(drawBasic);

    function drawBasic() {

        var data = google.visualization.arrayToDataTable([
            ['User', 'Sessions',],
            ['eu5454 Adam Domanski', 357],
            ['eu6259 Adam Domanski', 338],
            ['eu4578 Adam Domanski', 289],
            ['eu5481 Adam Domanski', 287],
            ['eu5190 Adam Domanski', 226]
        ]);

        var options = {
            title: 'Number of all sessions per user',
            width: '100%',
            height: '250px',
            chartArea: {width: '70%'},
            hAxis: {
                title: 'Total sessions',
                minValue: 0
            },
        };

        var chart = new google.visualization.BarChart(document.getElementById('barChart'));

        chart.draw(data, options);
    }
});