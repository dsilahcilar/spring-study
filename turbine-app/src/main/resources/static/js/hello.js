angular.module('turbine', []).controller('turbineCtrl', function($http) {

	
	var turbineList = this;
	turbineList.send = function(data) {
		$http.get('/turbine/', data).then(function(response) {
			turbineList.result = response.data;
		})
	};

	turbineList.list = function () {
		this.send(strRequest);
	}
	
	
	
	
});