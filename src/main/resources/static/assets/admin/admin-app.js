


var app = angular.module("app", [ "ngRoute" ]);

		app.config(function($routeProvider) {
			$routeProvider.when("/product", {
				templateUrl : "/assets/admin/product/index.html",
				controller : "product-ctrl"
			}).when("/authorize", {
				templateUrl : "/assets/admin/authority/index.html",
				controller : "authority-ctrl"
			}).when("/unauthorized", {
				templateUrl : "/assets/admin/authority/unauthorized.html",
				controller : "authority-ctrl"
			}).otherwise({
				template : "<h2 class='text-center'>Adminstration</h2>"
			})
		});