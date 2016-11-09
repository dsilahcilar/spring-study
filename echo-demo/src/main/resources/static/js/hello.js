angular.module('turbine', []).controller('turbineCtrl', function($http) {

	
	var turbineList = this;
	turbineList.send = function(data) {

		$http.post('/turbine/config/', data).then(function(response) {
			turbine.result = response.data;
		})
	};

	turbineList.create = function () {
		requestModel = {
			name : this.name,
			pace : {
				first : this.firstPace,
				last : this.lastPace
			},
			pressure : {
				first : this.firstPressure,
				last : this.lastPressure
			},
			prodFactor : {
				first : this.firstProdFactor,
				last : this.lastProdFactor
			}
		};
		strRequest = JSON.stringify(requestModel);
		this.send(strRequest);
	}
	
	
	
	
});