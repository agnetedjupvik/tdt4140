angular.module('speedometer', ['ngResource'])
    .controller('SpeedController', ['$scope', '$resource', '$interval', function ($scope, $resource, $interval) {
        var rest = $resource('/api');
        $scope.speed = 0;
        $scope.limit = 0;
        $interval(function () {
            rest.get(function (data) {
                console.log(data);
                $scope.speed = Math.round(data.vehicle_speed?data.vehicle_speed.value:0);
                $scope.limit = Math.round(data.speed_limit?data.speed_limit.value:0);
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