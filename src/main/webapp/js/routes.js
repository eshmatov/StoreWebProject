/* global storeApp */

// ROUTES
storeApp.config(function ($routeProvider) {

    $routeProvider

            .when('/', {
                templateUrl: 'pages/product_list.html',
                controller: 'storeController'
            })

            .when('/product/:id', {
                templateUrl: 'pages/product.html',
                controller: 'productController'
            })

            .when('/card', {
                templateUrl: 'pages/card.html',
                controller: 'cardController'
            })

            .when('/card_edit', {
                templateUrl: 'pages/card_edit.html',
                controller: 'cardController'
            });
});