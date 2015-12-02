/* global storeApp */

// CONTROLLERS
storeApp.controller("storeController", ['$scope', 'productService', function ($scope, productService) {

        $scope.products = productService.getProducts();

    }]);

storeApp.controller("productController", ['$scope', '$routeParams', 'productService', 'cardService', function ($scope, $routeParams, productService, cardService) {

        $scope.productId = $routeParams.id;

        $scope.product = productService.getProduct($scope.productId);

        $scope.quantity = 1;

        $scope.addToCard = function () {
            cardService.addOrder($scope.product, $scope.quantity);
        };

    }]);


storeApp.controller("cardController", ['$scope', 'cardService', function ($scope, cardService) {
        $scope.items = [];
        $scope.totalAmount = 0;

        $scope.getItems = function () {
            cardService.cardAPI.query().$promise.then(function (cardItems) {
                $scope.items = cardItems;

                $scope.totalAmount = 0;
                for (var i = 0; i < $scope.items.length; i++) {
                    $scope.totalAmount += $scope.items[i].product.price * $scope.items[i].quantity;
                }
            });
        };

        $scope.getItems();

        $scope.save = function () {
            cardService.saveBatch($scope.items);
        };

        $scope.buy = function () {
            $scope.purchaseStatus = cardService.buy();
            $scope.getItems();
        };

    }]);