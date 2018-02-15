angular
    .module('App')
    .config(configure);
configure.$inject = ['$stateProvider', '$urlRouterProvider'];
function configure ($stateProvider, $urlRouterProvider) {

    $stateProvider
        .state('home', {
            url: '/home',
            templateUrl: 'app/components/views/home.html',
            controller: 'homeCtrl'
        })
        .state('books', {
            url: '/books',
            templateUrl: 'app/components/views/book.html',
            controller: 'bookCtrl'
        })
        .state('managers', {
            url: '/managers',
            templateUrl: 'app/components/views/manager.html',
            controller: 'managerCtrl'
        });

    $urlRouterProvider.otherwise("/home");
}