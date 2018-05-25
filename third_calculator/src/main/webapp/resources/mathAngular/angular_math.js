var mathApp = angular.module('calculator_module', []);
mathApp.controller('calculatorController', function($scope, $location, $http) {
    //Init of the home
    $scope.user = {};
    $scope.mathOperForm = {};
    $scope.sessionCalcHistory = [];
    $scope.isAnyCalculation = false;

    $http.get(window.location.origin + window.location.pathname + 'init').then(function(response) {
        $scope.user = response.data.user;
        console.log($scope.user);
        $scope.mathOperForm = response.data.mathOperForm;
    });

    $scope.sendCalc = function() {
        var dataForCalc = $scope.mathOperForm;
        console.log(dataForCalc);
        var cHeader = {};
        cHeader[csrfHeader] = csrfToken;
        $http.post(window.location.origin + window.location.pathname + 'calc/' + $scope.user.id, dataForCalc,
            { headers: cHeader})
            .then(function(response) {
                console.log("calculator were sent");
                console.log(response);
                $scope.sessionCalcHistory = response.data.history;
                if ($scope.sessionCalcHistory.length > 0) {
                    $scope.isAnyCalculation = true;
                }
            }, function(response) {
                console.log(response)
            });
    }
});