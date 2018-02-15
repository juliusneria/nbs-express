angular
    .module("App")
    .controller("navCtrl", navCtrl);
navCtrl.$inject = ['$scope', '$state'];
function navCtrl($scope, $state) {

    $scope.click = function(state){
        console.log(state);
        if(state == 'store'){
            $state.transitionTo('home');
        } else if(state == 'books'){
            $state.transitionTo('books');
        } else if(state == 'managers'){
            $state.transitionTo('managers');
        }
    }
}