angular
    .module('App')
    .controller('homeCtrl',homeCtrl);
homeCtrl.$inject = ['$scope','$timeout','$state', 'RestServices'];
function homeCtrl($scope, $timeout, $state, RestServices) {

    $scope.stores = [];
    RestServices.getAllStore().then(function (res) {
        $scope.stores = res;
        console.log($scope.stores);
    });


}