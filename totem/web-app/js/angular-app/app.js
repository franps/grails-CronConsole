angular.module('grailsCronApp', [
  'grailsCron.services',
  'grailsCron.controllers',
  'ngRoute',
  'ui.bootstrap'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.
	when("/editor", {templateUrl: "../sublime.html", controller: "croncontroller"}).
	when("/editor/:id", {templateUrl: "../sublime.html", controller: "croncontroller"}).
	otherwise({redirectTo: '/editor'});
}]);