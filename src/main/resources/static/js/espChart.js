var app = angular.module('myApp', ['chart.js', 'ngResource']);

app.controller("ChartController", ["$scope", "$resource", "$interval", function ($scope, $resource, $interval) {


    Chart.defaults.global.scaleOverride = true;
    Chart.defaults.global.scaleSteps = 2;
    Chart.defaults.global.scaleStepWidth = 1;
    Chart.defaults.global.scaleStartValue = 0;
    Chart.defaults.global.animation = false;
    Chart.defaults.global.scaleLabel = "<%=getlabel(value)%>";
    Chart.defaults.Line.bezierCurve = false;
    Chart.defaults.Line.datasetFill = false;
    var running = true;

    $scope.labels = ["", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""];
    $scope.data = [
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    ];
    $scope.current = 0;
    $scope.series = ["Turning Lights"];
    var rest = $resource("/api");
    $interval(function () {
        rest.get(function (datapoints) {
            var abs = datapoints.abs;
            if (abs == null) abs = 0;
            if (running) {

                if ($scope.data[0].length > 29) {
                    $scope.data[0].shift();
                    $scope.labels.shift();
                }

                var date = new Date(abs.timestamp * 1000);

                $scope.data[0].push(abs.value);
                $scope.labels.push(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
                $scope.current = abs.value;

            }
        });
    }, 1000);

}]);

function getlabel(value) {
    if(value!=0)return value==1?'left':'right'
    return '';
}
