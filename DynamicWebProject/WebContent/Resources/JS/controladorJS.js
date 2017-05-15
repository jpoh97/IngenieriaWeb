var module = angular.module('myModule', []);

module.controller('myController', ['$scope', function($scope) {
	$scope.list = [{
		text: "prueba1",
		checked: true
	}, 
	{
		text: "prueba2",
		checked: false
	}];
	
	$scope.myText = '';
	$scope.agregar = function() {		
		if($scope.myText == '') {
			alert("No puede ser vacio");
			return;
		}
		$scope.list.push({text: $scope.myText, checked:false});
		$scope.myText = '';
	}
	
	$scope.eliminar = function() {
		var list = $scope.list;
		$scope.list = [];
		
		angular.forEach(list, function(item) {
			if(!item.checked) {
				$scope.list.push(item);
			}
		});
	}
}]);