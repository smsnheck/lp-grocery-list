function getProducts($scope, $http){
	$http.get('http://localhost:8080/productsEntities').success(function(products){
		$scope.products = products;
	});
}

function getCategories($scope, $http) {
	$http.get('http://localhost:8080/groceryCategoriesEntities').success(function(categories){
		$scope = categories;
	});
}

function getUnits($scope, $http){
	$http.get('http://localhost:8080/unitsEntities').success(function(units){
		$scope = units;
	});
}

function postProduct($scope, $http){
	alert($scope);
}