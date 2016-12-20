/**
 * author: Nguyen Dong Hung
 * 
 * 
 */
"use strict";

opmApp.controller("HomeController", ['commonService','$rootScope','$scope',
function(commonService,$rootScope,$scope){
	

//	Attach another service .. into this controller
	$scope.commonService = commonService;
	
//	init function, load data and function when load page
	
	$scope.init = function(){
		commonService.getHttpSys('common/endpoint-list',$scope.getAccounts);		
	};
	
	$scope.getAccounts = function(data){
		commonService.setEndPoints(data);		
		commonService.getByName(commonService.endpoints.ACCOUNT_LIST, function(data){
			$scope.accounts = data;
			console.log($scope.commonService.name);
		});		
	}
	
	$scope.init();	
	
}]);

