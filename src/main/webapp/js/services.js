/* global storeApp */

// SERVICES

storeApp.service('productService', ['$resource', function ($resource) {

        var productAPI = $resource('rest/products/:productId', {productId: '@id'});

        this.getProducts = function () {
            return productAPI.query();
        };

        this.getProduct = function (productId) {
            return productAPI.get({productId: productId});
        };

    }]);

storeApp.service('cardService', ['$resource', '$location', function ($resource, $location) {

        this.cardAPI = $resource('rest/card/', null, {'update': {method: 'PUT'}});
        var self = this;

        this.addOrder = function (product, quantity) {
            self.cardAPI.save({product: product, quantity: quantity}, function () {
                $location.path("/card");
            });
        };

        this.saveBatch = function (cardItems) {
            self.cardAPI.update(cardItems, function () {
                $location.path("/card");
            });
        };

        this.buy = function () {
            return $resource('rest/card/buy').get();
        };

    }]);