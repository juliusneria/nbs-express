angular
    .module('App')
    .controller('managerCtrl',managerCtrl);
managerCtrl.$inject = ['$scope','$timeout','RestServices'];
function managerCtrl($scope, $timeout, RestServices) {
    $scope.managers = [];
    $scope.editManager = {};
    $scope.addManager = {};
    readManager();

    $scope.set = function(book){
        $scope.editManager = book;
    };

    $scope.update = function(){
        $scope.editManager.salary = parseFloat($scope.editManager.salary);
        RestServices.updateManager($scope.editManager).then(function (res) {
            console.log(res);
        });
    };

    $scope.save = function(){
        $scope.addManager.salary = parseFloat($scope.addManager.salary);
        RestServices.createManager($scope.addManager).then(function (res) {
            $scope.managers.push(res);
        });
    };

    $scope.delete = function(manager, index){

        RestServices.deleteManager(manager).then(function (res) {
            console.log('enter', res);
            if(res != null)
                findAndRemove(index);
            else
                console.log('Failed');
        });
    };

    function readManager(){
        RestServices.getAllManagers().then(function (res) {
            $scope.managers = res;
            console.log($scope.managers);
        });
    }

    function findAndRemove(index) {
        console.log(index);
        $scope.managers.splice(index,1);
    }
}