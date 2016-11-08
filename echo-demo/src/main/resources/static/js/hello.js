angular.module('turbine', []).controller('turbineCtrl', function($http) {
	var self = this;
	$http.get('resource/').then(function(response) {
		self.greeting = response.data;
	})
	
	var self = this;
	var data;
	this.add = function() {
		
		$http.post('/turbine/config/', data).then(function(response) {
			self.greeting = response.data;
		})
	};
	
	
	
	
});