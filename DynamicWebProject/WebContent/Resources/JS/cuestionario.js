var cuestionario = angular.module('modCuestionario', []);

cuestionario.controller('contCuestionario', function($scope) {
	
	$scope.cont = 0;
	$scope.userState = '';
	
	$scope.questions = [ {
		id : 1,
		text : "pregunta 1",
		trueAnswer : 1,
		userAnswer : null,
		state: '',
		answers : [ {
			id : 1,
			text : 'respuesta 1.1'
		}, {
			id : 2,
			text : 'respuesta 1.2'
		}, {
			id : 3,
			text : 'respuesta 1.3'
		} ]
	}, {
		id : 2,
		text : "pregunta 2",
		trueAnswer : 1,
		userAnswer : null,
		state: '',
		answers : [ {
			id : 1,
			text : 'respuesta 2.1'
		}, {
			id : 2,
			text : 'respuesta 2.2'
		}, {
			id : 3,
			text : 'respuesta 2.3'
		} ]
	}, {
		id : 3,
		text : "pregunta 3",
		trueAnswer : 1,
		userAnswer : null,
		state: '',
		answers : [ {
			id : 1,
			text : 'respuesta 3.1'
		}, {
			id : 2,
			text : 'respuesta 3.2'
		}, {
			id : 3,
			text : 'respuesta 3.3'
		} ]
	} ];
	
	function calculate() {
		for (var i = $scope.questions.length-1; i >= 0; i--) {
			if($scope.questions[i].trueAnswer == $scope.questions[i].userAnswer) {
				if($scope.questions[i].state != 'ok') {
					$scope.cont++;	
				}
				$scope.questions[i].state = 'ok';
			} else {
				if($scope.questions[i].state == 'ok' && $scope.cont > 0) {
					$scope.cont--;	
				}
				$scope.questions[i].state = 'err';	
				
			}
			userState();	
		}
	};
	
	function userState() {
		var total = $scope.cont/$scope.questions.length;
		
		if(total == 0) {
			$scope.userState = 'looser';
		} else if(total == 1) {
			$scope.userState = 'guru';
		} else {
			$scope.userState = 'poor';
		}
	}
	
	$scope.verify = function() {
		for (var i = $scope.questions.length-1; i >= 0; i--) {
			if($scope.questions[i].userAnswer == null) {
				alert('Faltan preguntas por responder');
				return;
			}
		}
		calculate();
	}
})