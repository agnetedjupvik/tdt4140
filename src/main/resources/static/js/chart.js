var app = angular.module('myApp',['chart.js','ngResource']);
/**
app.controller('MainController', function($scope){
  $scope.labels = ["January", "February", "March", "April", "May", "June", "July", "August", "September"];
  $scope.series = ['Series A'];
  $scope.data = [
    [65, 59, 80, 81, 56, 55, 40, 100, 100]
  ];;
  $scope.onClick = function (points, evt) {
    console.log(points, evt);
  };
});

app.controller('SpeedController', ['$scope', '$resource', '$interval', function ($scope, $resource, $interval) {
    var rest = $resource('/api');
    $scope.limit = 20;
    $interval(function () {
        rest.get(function (data) {
            $scope.speed = Math.round(data.value);
            if ($scope.speed > $scope.limit + 5) {
                $scope.status = 'bad';
            } else if ($scope.speed > $scope.limit) {
                $scope.status = 'okay';
            } else {
                $scope.status = 'good';
            }
        });
    }, 200);
}]);
**/
app.controller("ChartController", ["$scope", "$resource", "$interval", "$timeout", function($scope, $resource, $interval, $timeout){


    Chart.defaults.global.scaleOverride = true;
    Chart.defaults.global.beginAtZero = true;
    Chart.defaults.global.animation = false;
    Chart.defaults.global.scaleSteps = 25;
    Chart.defaults.global.scaleStepWidth = 4;


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
    $scope.labels = [];
    $scope.data  = [
        []
        ];
    $scope.series = ["Speed Data"]
    var rest = $resource("/api");
    $interval(function () {
        rest.get(function (speedpoint) {
            console.log("Adding data point...")
            if ($scope.data[0].length > 30) {
                $scope.data[0].shift();
                $scope.labels.shift();
            }
            $scope.labels.push(new Date(speedpoint.time));
            $scope.data[0].push(speedpoint.value);
        });
    }, 100);



}]);
