/**
 * 
 */

var appClient = angular.module('clients', ['ngRoute', 'ngCookies']);

appClient.service('clients', function($http) {
	
	this.listClients = function() {
		return $http({
			url: 'http://localhost:8080/DynamicWebProject/jpoh97/client/getAll',
			method: 'GET'
		});
	}
});

appClient.service('saveClient', function($http) {
	this.guardar = function(cliente) {
		return $http({
			url: 'http://localhost:8080/DynamicWebProject/jpoh97/client/save',
			method: 'POST',
			params: {
				id: cliente.cedula,
				name: cliente.nombre,
				lastname: cliente.apellido,
				email: cliente.correo,
				user: "juan"
			}
		});
	}
});

appClient.service('loginService', function($http, $cookies, $location){
	this.logear = function(usuario, contrasena){
		return $http({
			url: 'http://localhost:8080/DynamicWebProject/jpoh97/user/auth',
			method: 'POST',
			params: {
				login: usuario, 
				password: contrasena
			}
		});
	};
	
	this.validarEstado = function(){
		if(typeof($cookies.usuario) == 'undefined' ||
				$cookies.usuario == "") {
			$location.url("/");
			return false;
		}
		return true;
	}
});


appClient.controller('listClients', function($scope, $location, clients, loginService) { //clients -> nombre del servcio
	
	estado = loginService.validarEstado();
	if(estado == false){ return; }
	
	clients.listClients().then(
			function success(data) {
				$scope.listClients = data.data.cliente;
			}
	);
	
	
	$scope.agregar = function() {
		$location.url('/nuevo');
	}
}); 

appClient.controller("login", function($scope, $location, $cookies, loginService){
	$scope.logear = function(){
		loginService.logear($scope.usuario, $scope.contrasena).then(
				function success(data){
					if(data.data != 'Usuario logueado exitosamente'){
						$scope.usuario = '';
						$scope.contrasena = '';
						alert(data.data + " FAIL");
						return;
					}
					alert('Logeado satisfactoriamente');
					$cookies.usuario = $scope.usuario;
					$location.url('/list');
				});
	}
});

appClient.controller('cliente', function($scope, $location, saveClient) {
	
	$scope.cliente = {
			nombre: '',
			apellido: '',
			cedula: '',
			correo: ''
	};
	
	$scope.guardar = function() {
		saveClient.guardar($scope.cliente).then(
				function success(data) {
					alert('Cliente creado');
					$location.url('/list');
				}
		);
	}
});



appClient.config(['$routeProvider', function($routeProvider){
	
	$routeProvider.when('/list' , {
		templateUrl : 'listaClientes.html',
		controller : 'listClients'
	});
	
	$routeProvider.when('/nuevo' , {
		templateUrl : 'cliente.html',
		controller : 'cliente'
	});
	
	$routeProvider.when('/',{
		templateUrl: 'login.html',
		controller: 'login'
	})

}]);

appClient.run(function($rootScope, loginService) {
	$rootScope.$on('$routeChangeStart', function(){
		loginService.validarEstado();
	})
});

