angular.module('speedometer', ['ngResource'])
    .controller('SpeedController', ['$scope', '$resource', '$interval', function ($scope, $resource, $interval) {
        var rest = $resource('/api');
        $scope.limit = 20;
        $interval(function () {
            rest.get(function (data) {
                console.log(data);
                $scope.speed = Math.round(data.vehicle_speed.value);
                $scope.limit = Math.round(data.speed_limit.value);
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