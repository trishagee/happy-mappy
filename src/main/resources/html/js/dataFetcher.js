(function () {

    var app = angular.module('happyMongo', []);

    app.controller('dataFetcher', ['$scope', '$http', '$timeout', 'maps', function ($scope, $http, $timeout, maps) {
        $scope.caca = "culo";
        $scope.intervalFunction = function () {
            $timeout(function () {
                $http.get('http://localhost:8080/service/sentiment/sentiments').success(function (data) {
                    maps.addSentiment(data);
                }).
                    error(function () {
                        console.log('error retrieving thoughts');
                    });
//                maps.addSentiment([ {feeling: 'happy', location:[37.3772, -5.9869]},
//                    {feeling:'sad', location:[37.3872, -5.9869]},
//                    {feeling:'fdsf', location:[37.3172, -5.9869]} ]);
                console.log("elo");
                $scope.intervalFunction();
            }, 2500);
        };
        $scope.intervalFunction();

        $scope.meh = maps.meh;

    }]);
})();