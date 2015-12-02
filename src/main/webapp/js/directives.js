/* global storeApp */

// DIRECTIVES
storeApp.directive('productThumbnail', function() {
    return {
        restrict: 'E',
        templateUrl: 'directives/product_thumbnail.html',
        replace: false,
        scope: {
            product: "="
        }
    };
});