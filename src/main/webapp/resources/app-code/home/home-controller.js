/**
 * author: Nguyen Dong Hung
 * 
 * 
 */
"use strict";

opmApp.controller("HomeController", ['commonService','printService','$rootScope','$scope','$mdSidenav','$compile','$q',
function(commonService,printService,$rootScope,$scope,$mdSidenav,$compile,$q){	
	
	var homeController = this;
	$scope.name = 'HomeController';
	$scope.commonService = commonService;
	$scope.printService = printService;
	
	$scope.imagePath = 'resources/images/';
	$scope.iframeHTML = undefined;
	$scope.isDesignMode = false;	
	
	$scope.init = function(){
		commonService.getByName('contact').then(function(data){
			$scope.contacts = data;
		});		
	};	
	
	$scope.processPDF = function processPDF(){			
//		$scope.prepareIframe().then(function(){
//			var html = loadPage('resources/templates/demo.html');
//			$scope.importDataIframeHTML(html);
//		});
		
		$scope.printService.printPDF(document.getElementById("parentIframe"),'resources/templates/demo.html',$scope.contacts, $scope);
		
	}
	
	$scope.closeIframe = function closeIframe(){			
		$scope.printService.closeIframe();
	}
	
	$scope.prepareIframe = function prepareIframe(){
		var self = this;
		var deferred = $q.defer();
		
		if($("iframe#iframeHTML").length == 0){			
			var iframe = document.createElement('iframe');
			if($scope.isDesignMode){			
				iframe.setAttribute('style','width:' + ($(window).width() -20) +'px; height:780px;top: 10px;left: 10px;position: absolute;');
			}else iframe.setAttribute('style','width:1080px; height:780px;visibility: hidden;');
			iframe.setAttribute('id','iframeHTML');
			document.getElementById("parentIframe").appendChild(iframe);
			$scope.iframeHTML = $("iframe#iframeHTML")[0].contentDocument;
			var $head = angular.element($scope.iframeHTML.head),
			headTemplate = $compile('<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.css" /><link type="text/css" rel="stylesheet" href="resources/css/bootstrap-theme.css" /><link type="text/css" rel="stylesheet" href="resources/css/font-awesome.min.css" /><link type="text/css" rel="stylesheet" href="resources/css/custom.css" /><link type="text/css" rel="stylesheet" href="resources/css/app.css" /><script type="text/javascript" src="resources/js/jquery-3.1.1.js"></script><script type="text/javascript" src="resources/js/bootstrap.js"></script><script type="text/javascript" src="resources/js/jspdf.debug.js"></script><script type="text/javascript" src="resources/js/html2canvas.js"></script><script type="text/javascript" src="resources/js/html2canvas.svg.js"></script>')($scope);
			$head.append(headTemplate);
		}
		
		window.frames[0].window.angular = angular;
		deferred.resolve(self);
		return  deferred.promise;
	}
	
	$scope.showPDF = function showPDF(pdf){
		var iframe = document.createElement('iframe');
		iframe.setAttribute('style','position: absolute;width:95%; height:780px;left: 30px;top: 10px;');
		iframe.setAttribute('id','iframePDF');
		iframe.src = pdf;
		document.getElementById("parentIframe").appendChild(iframe);
	}
	
	$scope.importDataIframeHTML = function importDataIframeHTML(page){
		var bodyIframe = $scope.iframeHTML.body
		while (bodyIframe.hasChildNodes()) {
			bodyIframe.removeChild(bodyIframe.lastChild);
		}
		var $body = angular.element(bodyIframe);
		var template  = $compile('<div class="container" ng-controller="PrintController">' + page + '</div>')($scope);
		$body.append(template);		
	}
	
	function loadPage(href){
	    var xmlhttp = new XMLHttpRequest();
	    xmlhttp.open("GET", href, false);
	    xmlhttp.send();
	    return xmlhttp.responseText;
	}	
	
	$scope.labels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
	$scope.series = ['Series A', 'Series B'];
	
	$scope.data = [
	    [65, 59, 80, 81, 56, 55, 40],
	    [28, 48, 40, 19, 86, 27, 90]
	];
	
	$scope.init();	
	
	
	
}]);

