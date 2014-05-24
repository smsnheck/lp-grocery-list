angular.module('groceryListApp', [ 'ngRoute', 'ngDialog' ]).config(
		function($routeProvider) {
			$routeProvider.when('/', {
				controller : 'HomeCtrl',
				templateUrl : 'home.html'
			}).when('/products', {
				controller : 'ProductsCtrl',
				templateUrl : 'Products.html'
			}).when('/units', {
				controller : 'UnitsCtrl',
				templateUrl : 'units.html'
			});;
		});

// Home
angular.module('groceryListApp').controller('HomeCtrl', function($scope) {

});

// Products
angular.module('groceryListApp').controller(
		'ProductsCtrl',
		function($scope, $http, ngDialog) {
			$http.get('/productsEntities').success(function(products) {
				$scope.products = products;
			});
			$http.get('/unitsEntities').success(function(units) {
				$scope.units = units;
			});

			$scope.addProduct = function() {
				ngDialog.open({
					template : 'popupAddProducts.html',
					className : 'ngdialog-theme-default'
				});
			};

			$scope.postProduct = function(newProduct) {
				$http.get(
						'/unitsEntities/search/findByUnit?unit='
								+ newProduct.unit.unit).success(function(productid) {
//					$scope.productid = newProduct.name + ' ' + productid._embedded.unitsEntities[0].units_id;
				
				$http.post();
				
				});
			};
		});

angular.module('groceryListApp').controller('UnitsCtrl', function($scope, $http, ngDialog) {
	$scope.addUnit = function() {
		ngDialog.open({
			template : 'popupAddUnit.html',
			className : 'ngdialog-theme-default'
		});
	};

	$http.get('/unitsEntities').success(function(units) {
		$scope.units = units;
	});
	
	$scope.postUnit = function(newUnit){
		
		$http.post('/unitsEntities', '{ "unit" : "' + newUnit.name + '"}').success(function(data){
			$scope.addedUnitBool = true;
			$http.get('/unitsEntities').success(function(updatedValues){
				$scope$apply(function(){
					$scope.units = updatedValues;
				}); 
			});
			ngDialog.closeAll();		
		});
	};
});