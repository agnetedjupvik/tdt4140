var app = angular.module('myApp',['chart.js','ngResource']);

app.controller("ChartController", ["$scope", "$resource", "$interval", "$timeout", function($scope, $resource, $interval, $timeout){


    Chart.defaults.global.scaleOverride = true;
    Chart.defaults.global.beginAtZero = true;
    Chart.defaults.global.animation = false;
    Chart.defaults.global.scaleSteps = 25;
    Chart.defaults.global.scaleStepWidth = 4;
    Chart.defaults.Line.bezierCurve = false;
    var running = true;

    /* Working static implementation
    var rest = $resource("/api/speedhistory");
    $scope.labels = ["", "", "", "", "", "", ""];
    $scope.data = [
        [65, 59, 80, 81, 56, 55, 40]
    ];
    $scope.legend = true;
    $scope.series = ["Speed Data"]
    $scope.onClick = function (points, evt) {
        console.log(points, evt);
    };


    rest.get(function (speeddata) {
        $scope.data = [
            speeddata.speeds
        ];
        $scope.labels = speeddata.times;
    });
    */

    //Dynamic update
    $scope.labels = ["","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""];
    $scope.data  = [
        [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        ];
    $scope.currentspeed = 0;
    $scope.series = ["Speed Data (mph)"];
    var rest = $resource("/api");
    $interval(function () {
        rest.get(function (speedpoint) {
            if (running) {
                if ($scope.data[0].length > 29) {
                    $scope.data[0].shift();
                    $scope.labels.shift();
                }
                var date = new Date(speedpoint.time * 1000);
                $scope.labels.push(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
                $scope.data[0].push(speedpoint.value);
                $scope.currentspeed = speedpoint.value;
            }
        });
    }, 1000);

    $scope.buttonmessage = "Stop";
    $scope.pause = function () {
        if (running) {
            $scope.buttonmessage = "Start";
        } else {
            $scope.buttonmessage = "Stop";
            $scope.labels = ["","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""];
            $scope.data  = [
                [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
            ];
        }
        running = !running;
    };


}]);
