/**
 * author: Nguyen Dong Hung
 * 
 * 
 */
"use strict";
var printModule =  angular.module('printModule', ['chart.js','ngMaterial']);
printModule.service('printService', ['$q','$compile',
function ($q,$compile) {
	
	var printService = this;
	this.printService = printService;
	this.scope = undefined;	
	
	function PrintService(){
		this.isDesignMode = false;
		this.headerDefault = '<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.css" /><link type="text/css" rel="stylesheet" href="resources/css/bootstrap-theme.css" /><link type="text/css" rel="stylesheet" href="resources/css/font-awesome.min.css" /><link type="text/css" rel="stylesheet" href="resources/css/custom.css" /><link type="text/css" rel="stylesheet" href="resources/css/app.css" /><script type="text/javascript" src="resources/js/jquery-3.1.1.js"></script><script type="text/javascript" src="resources/js/bootstrap.js"></script><script type="text/javascript" src="resources/js/jspdf.debug.js"></script><script type="text/javascript" src="resources/js/html2canvas.js"></script><script type="text/javascript" src="resources/js/html2canvas.svg.js"></script>';
		this.name = "printService";
	};
	
	PrintService.prototype.printPDF = function(parentIframe, templateURL,data, scope, isDesignMode){
		var self = this;
		var deferred = $q.defer();
		if(isDesignMode)this.isDesignMode = isDesignMode;
		this.scope = scope;
		
//		Update new data
		this.printDataset = data;
		this.parentIframe = parentIframe;
		
		this.prepareIframe(parentIframe,scope).then(function(){
			var html = self.loadPage(templateURL);
			self.importDataIframeHTML(html,scope);
			deferred.resolve(self);
		});
		return  deferred.promise;
	}
	
	PrintService.prototype.prepareIframe = function prepareIframe(parentIframe,scope){
		var self = this;
		var deferred = $q.defer();
		
		var iframe = document.createElement('iframe');
		if(this.isDesignMode){			
			iframe.setAttribute('style','width:' + ($(window).width() -20) +'px; height:780px;top: 10px;left: 10px;position: absolute;');
		}else iframe.setAttribute('style','width:1080px; height:780px;position: absolute;left: 30px;top: 10px;visibility: hidden;');
		iframe.setAttribute('id','iframeHTML');
		parentIframe.appendChild(iframe);
		self.iframeHTML = parentIframe.getElementsByTagName("iframe")[0].contentDocument;
		var $head = angular.element(self.iframeHTML.head),
		headTemplate = $compile(self.headerDefault)(scope);
		$head.append(headTemplate);
		
		window.frames[0].window.angular = angular;
		deferred.resolve(self);
		return  deferred.promise;
	}
	
	PrintService.prototype.importDataIframeHTML = function importDataIframeHTML(page,scope){
		var bodyIframe = this.iframeHTML.body
		while (bodyIframe.hasChildNodes()) {
			bodyIframe.removeChild(bodyIframe.lastChild);
		}
		var $body = angular.element(bodyIframe);
		var template  = $compile('<div class="container" ng-controller="PrintController">' + page + '</div>')(scope);
		$body.append(template);		
	}
	
	PrintService.prototype.loadPage = function loadPage(href){
	    var xmlhttp = new XMLHttpRequest();
	    xmlhttp.open("GET", href, false);
	    xmlhttp.send();
	    return xmlhttp.responseText;
	}
	
	PrintService.prototype.showPDF = function showPDF(pdf){
		var iframe = document.createElement('iframe');
		iframe.setAttribute('style','position: absolute;width:95%; height:780px;left: 30px;top: 10px;');
		iframe.setAttribute('id','iframePDF');
		iframe.src = pdf;
		if(this.parentIframe)this.parentIframe.appendChild(iframe);
		else document.getElementById("parentIframe").appendChild(iframe);
	}
	
	PrintService.prototype.closeIframe = function closeIframe(){
		while (this.parentIframe.hasChildNodes()) {
			this.parentIframe.removeChild(this.parentIframe.lastChild);
		}
	}
	
	return new PrintService();
}]).controller("PrintController", ['$q','$rootScope','$scope','printService',
function($q,$rootScope,$scope,printService){
	
	var printController = this;
	$scope.name = 'PrintController';
	
	$scope.printService = printService;
	
	$scope.dataPrintPDF = {};
	$scope.a4RateHeightWidth = 297/210;
	$scope.streamPDF = undefined;
	$scope.pagesPDF = undefined;
	
	$scope.init = function(){		
		$scope.getDataPrint().then(function(scope) {			
			$scope.importData(scope,function(scope) {
				checkStatus(scope,function(scope) {
					var pdf = new jsPDF('p','pt','a4');
					try{
						pdf.internal.scaleFactor = scope.pagesPDF[0].offsetWidth/pdf.internal.pageSize.width; 
					}catch(e){							
						pdf.internal.scaleFactor = 2; 
					}
					var cursor = 0;	
					$scope.renderPage(scope.pagesPDF,cursor,pdf,function(){
						if(!scope.$parent.isDesignMode){								
							scope.$parent.showPDF(pdf.output('datauristring'));
						}else{
							pdf.save('web.pdf');
						}
					});
				});				
			});            
		});
	};
		
	$scope.getDataPrint = function getDataPrint(){
		var data = $scope.printService.printDataset;
		var self = this;
		var deferred = $q.defer();
		if(Array.isArray(data)){
			$scope.dataPrintPDF = data[0];
		}else{
			$scope.dataPrintPDF = data;
		}
		deferred.resolve(self);
		return  deferred.promise;
	}
	
	function checkStatus(scope,callback){
		setTimeout(function(){
			scope.pagesPDF =  $scope.printService.iframeHTML.getElementsByClassName("page");			
			callback(scope);
		});	
	}
	
	$scope.importData= function importData(scope,callback){
		$scope.items = scope.$parent.contacts;		
		callback(scope);
	}
	
	$scope.renderPage = function renderPage(pages,cursor,pdf,callback){
		if (cursor === (pages.length - 1)){
			var widthPage = pages[cursor].offsetWidth;
			pdf.addHTML(pages[cursor], 0, 0,{
				'width': widthPage,
				'pagesplit':true
			},callback);
		}else{
			var width = pages[cursor].offsetWidth;
			pdf.addHTML(pages[cursor], 0, 0,{
				'width': widthPage,
				'pagesplit':true
			},function(){
				pdf.addPage();
				renderPage(pages,++cursor,pdf,callback);
			});		
		}
	}	
	$scope.init();
}]);