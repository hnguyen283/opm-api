/**
 * author: Nguyen Dong Hung
 * 
 * 
 */
"use strict";
var directiveModule = angular.module('directiveModule', []);

directiveModule.directive('cardV1', function() {
  return {
    restrict: 'E',
    transclude: true,
    scope: {
    	detail:"@detail"
    },
    controller: ['$scope', function($scope) {
    	if(!($scope.detail instanceof Object)){
    		$scope.detail = angular.fromJson($scope.detail);
    	}
    	$scope.imagePath = base_URL + "/resources/images/demo.JPG";
    }],
    templateUrl: base_URL + '/resources/templates/card-overview.jsp'
  };
});