angular
    .module('App')
    .directive('navDir',navDir);
function navDir(){
    return {
        restrict: 'E',
        templateUrl: 'app/directives/nav/views/navs.html',
        controller: 'navCtrl'
    }
}