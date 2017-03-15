var app = angular.module("CountryManagement", []);

// Controller Part
app.controller("CountryController", function($scope, $http) {

	$scope.countries = [];
	$scope.countryForm = {
		id : -1,
		countryName : "",
		population : ""
	};

	// Now load the data from server
	_refreshCountryData();

	// HTTP POST/PUT methods for add/edit country
	// with the help of id, we are going to find out whether it is put or post
	// operation

	$scope.submitCountry = function() {

		var method = "";
		var url = "";
		if ($scope.countryForm.id == -1) {
			// Id is absent in form data, it is create new country operation
			method = "POST";
			url = 'webapi/countries';
		} else {
			// Id is present in form data, it is edit country operation
			method = "PUT";
			url = 'webapi/countries';
		}

		console.info('$scope.countryForm');
		console.log($scope.countryForm);
		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.countryForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(_success, _error);
	};

	// HTTP DELETE- delete country by Id
	$scope.deleteCountry = function(country) {
		$http({
			method : 'DELETE',
			url : 'webapi/countries/' + country.id
		}).then(_success, _error);
	};

	// In case of edit, populate form fields and assign form.id with country id
	$scope.editCountry = function(country) {

		$scope.countryForm.countryName = country.countryName;
		$scope.countryForm.population = country.population;
		$scope.countryForm.id = country.id;
	};

	/* Private Methods */
	// HTTP GET- get all countries collection
	function _refreshCountryData() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/messenger/webapi/countries'
		}).then(function successCallback(response) {
			$scope.countries = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}

	function _success(response) {
		_refreshCountryData();
		_clearFormData();
	}

	function _error(response) {
		console.log(response.statusText);
	}

	// Clear the form
	function _clearFormData() {
		$scope.countryForm.id = -1;
		$scope.countryForm.countryName = "";
		$scope.countryForm.population = "";

	};

	/* Example :  @Consumes(MediaType.APPLICATION_JSON) */	
	$scope._testConsumesData = function() {
		$scope.countryForm = {
				id : -1,
				countryName : "USA",
				population : "234587"
			};

		$http({
			method : 'POST',
			url : 'webapi/WebServiceControllerTwo/Consumes',
			data : angular.toJson($scope.countryForm),
			headers : {
				'Content-Type' : 'application/json'
			} 
		}).then(function successCallback(response) {
			//console.log(response);
			console.log(response.data);
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};

	/* Example :  JAX-RS @Path, @GET and @PathParam Annotations */	
	$scope._testPathParamData = function() {
		$scope.countryForm = {
				id : 234,
				countryName : "India",
				population : "234587"
			};

		$http({
			method : 'GET',
			url : 'webapi/WebServiceControllerTwo/' + $scope.countryForm.id
		}).then(function successCallback(response) {
			console.log(response.data);
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};

	/* Example :  @QueryParam */
	$scope._testQueryParamData = function() {
		$scope.formData = {
				nameKey : "John",
				countryKey : "USA"
			};

		$http({
			method : 'GET',
			url : 'webapi/WebServiceControllerTwo',
			params    : {
				nameKey: $scope.formData.nameKey,
				countryKey: $scope.formData.countryKey
				},  // pass in data as strings

			// set the headers so angular passing info as form data (not request payload)
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  
		}).then(function successCallback(response) {
			//console.log(response);
			console.log(response.data);
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};
	
	/* Example :  @HeaderParam */
	$scope._testHeaderParamData = function() {
		$scope.formData = {
				nameKey : "Johnson",
				countryKey : "India"
			};

		$http({
			method : 'GET',
			url : 'webapi/WebServiceControllerTwo/query',
			params    : {
				nameKey: $scope.formData.nameKey,
				countryKey: $scope.formData.countryKey
				},  // pass in data as strings

			// set the headers so angular passing info as form data (not request payload)
			headers : { 
				'Content-Type': 'application/x-www-form-urlencoded',
				'My-Header' : 'value',
				'My-Value' : 'helloworld'
					}  
		}).then(function successCallback(response) {
			// console.log(response);
			console.log(response.data);
			$scope.respData = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};
	
});