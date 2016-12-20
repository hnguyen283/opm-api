/**
 * author: Nguyen Dong Hung
 * 
 * 
 */
"use strict";
var commonModule =  angular.module('commonModule', []);

commonModule.service('commonService', ['$http','$location','$q', 
function ($http,$location,$q,$scope) {
	this.endpoints = {};
	

	var self = this;
	
	function CommonService(){
		this.name = "commonService";
	};
	
//	This function to call menthod get, using endpoint name
//	@endpointName: The endpoint name//	
//	#return: Doc Object in Json 
	
	CommonService.prototype.getByName = function(endpointName, callback){
		this.getHttpSys('load/byname/' + endpointName, callback );
	}
	
	CommonService.prototype.getHttpSys = function (url,callback) {		
		$http.get(url).success( function(response, status, headers, config) {
			callback(response);
		}).error(function(errResp) {
			console.error('Repos error: ',errResp);
			return;		
		});
	}
	
	CommonService.prototype.setEndPoints = function (data) {
		this.endpoints = data;
	}
	
	return new CommonService();
}]);