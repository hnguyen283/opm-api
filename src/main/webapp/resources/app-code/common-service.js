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
	

	var commonService = this;
	
	function CommonService(){
		this.name = "commonService";
	};
	
//	This function to call menthod get, using endpoint name
//	@endpointName: The endpoint name//	
//	#return: Doc Object in Json 
	
	CommonService.prototype.getByName = function(endpointName){
		var self = this;
		var deferred = $q.defer();			
		this.getHttpSys('load/byName/' + endpointName).then(function(response){
			deferred.resolve(response);
		});
		return deferred.promise;
	}
	
	CommonService.prototype.getHttpSys = function(url) {	
		var self = this;
		var deferred = $q.defer();			
		$http.get(url).success( function(response, status, headers, config) {
			deferred.resolve(response);
		}).error(function(errResp) {
			console.error('Repos error: ',errResp);
			deferred.resolve(self);
		});
		return deferred.promise;
	}
	
	CommonService.prototype.setEndPoints = function (data) {
		this.endpoints = data;
	}
	
	CommonService.prototype.findElementInObject = function (object,elementName) {
		if (object === undefined) return undefined;
		if($.isarray(object)){
			for(var i = 0; i < object.length; i++){
				return self.findElementInObject();
			}
		}else{
			for(var element in object){
				console.error('element: ',element);
			}
		}
	}
	
	CommonService.prototype.loadPage = function (href) {
		var xmlhttp = new XMLHttpRequest();
	    xmlhttp.open("GET", href, false);
	    xmlhttp.send();
	    return xmlhttp.responseText;
	}
	
	return new CommonService();
}]);