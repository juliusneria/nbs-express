angular
    .module('App')
    .controller('bookCtrl',bookCtrl);
bookCtrl.$inject = ['$scope','$state', 'RestServices', '$http'];
function bookCtrl($scope, $state, RestServices, $http) {
    $scope.books = [];
    $scope.editBook = {};
    $scope.addBook = {};
    readBook();

    $scope.set = function(book){
        $scope.editBook = book;
    };

    $scope.update = function(){
        RestServices.updateBook($scope.editBook).then(function (res) {
            console.log(res);
        });
    };

    $scope.save = function(){
        RestServices.createBook($scope.addBook).then(function (res) {
            $scope.books.push(res);
        });
    };

    $scope.delete = function(book){
        RestServices.deleteBook(book).then(function (res) {
            findAndRemove($scope.books, 'id', res.id);
        });
    };

    function readBook(){
        RestServices.getAllBooks().then(function (res) {
            console.log(res);
            $scope.books = res;
        });
    }

    function findAndRemove(array, property, value) {
        array.forEach(function(result, index) {
            if(result[property] === value) {
                //Remove from array
                array.splice(index, 1);
            }
        });
    }
}