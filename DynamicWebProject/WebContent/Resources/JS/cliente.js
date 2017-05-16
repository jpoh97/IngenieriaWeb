/**
 * 
 */

var appClient = angular.module('clients', ['ngRoute']);

appClient.service('clients', function($http) {
	this.listClients = function() {
		return $http({
			url: 'http://localhost:8080/DynamicWebProject/jpoh97/client/getAll',
			method: 'GET'
		});
	}
});

appClient.controller('listClients', function($scope, clients) { //clients -> nombre del servcio
	
	clients.listClients().then(
			function success(data) {
				$scope.listClients = data.data.cliente;
			}
	);
	
}); 

appClient.config(['$routeProvider', function($routeProvider){
	
	$routeProvider.when('/' , {
		templateUrl : 'listaClientes.html',
		controller : 'listClients'
	});
	
}]);