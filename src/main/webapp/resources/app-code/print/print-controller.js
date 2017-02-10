/**
 * author: Nguyen Dong Hung
 * 
 * 
 */
"use strict";
//
//opmApp.controller("PrintController", ['$q','commonService','$rootScope','$scope',
//function($q,commonService,$rootScope,$scope){
//	
//	var printController = this;
//	$scope.name = 'PrintController';	
//	$scope.commonService = commonService;
//	
//	$scope.dataPrintPDF = {};
//	$scope.a4RateHeightWidth = 297/210;
//	$scope.streamPDF = undefined;
//	$scope.pagesPDF = undefined;
//	
//	$scope.init = function(){		
//		commonService.getByName('case').then(function(data){
//			$scope.getDataPrint(data).then(function(scope) {			
//				$scope.importData(scope,function(scope) {
//					checkStatus(scope,function(scope) {
//						var pdf = new jsPDF('p','pt','a4');
//						try{
//							pdf.internal.scaleFactor = scope.pagesPDF[0].offsetWidth/pdf.internal.pageSize.width; 
//						}catch(e){							
//							pdf.internal.scaleFactor = 2; 
//						}
//						var cursor = 0;	
//						$scope.renderPage(scope.pagesPDF,cursor,pdf,function(){
//							if(!scope.$parent.isDesignMode){								
//								scope.$parent.showPDF(pdf.output('datauristring'));
//							}else{
//								pdf.save('web.pdf');
//							}
//						});
//					});				
//				});            
//			});
//		});
//	};
//		
//	$scope.getDataPrint = function getDataPrint(data){
//		var self = this;
//		var deferred = $q.defer();
//		if(Array.isArray(data)){
//			$scope.dataPrintPDF = data[0];
//		}else{
//			$scope.dataPrintPDF = data;
//		}
//		deferred.resolve(self);
//		return  deferred.promise;
//	}
//	
//	function checkStatus(scope,callback){
//		setTimeout(function(){
//			scope.pagesPDF =  scope.$parent.iframeHTML.getElementsByClassName("page");			
//			callback(scope);
//		});	
//	}
//	
//	$scope.importData= function importData(scope,callback){
//		$scope.items = scope.$parent.contacts;		
//		callback(scope);
//	}
//	
//	$scope.renderPage = function renderPage(pages,cursor,pdf,callback){
//		if (cursor === (pages.length - 1)){
//			var widthPage = pages[cursor].offsetWidth;
//			pdf.addHTML(pages[cursor], 0, 0,{
//				'width': widthPage,
//				'pagesplit':true
//			},callback);
//		}else{
//			var width = pages[cursor].offsetWidth;
//			pdf.addHTML(pages[cursor], 0, 0,{
//				'width': widthPage,
//				'pagesplit':true
//			},function(){
//				pdf.addPage();
//				renderPage(pages,++cursor,pdf,callback);
//			});		
//		}
//	}
//	$scope.labels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
//	$scope.series = ['Series A', 'Series B'];
//	
//	$scope.data = [
//	    [65, 59, 80, 81, 56, 55, 40],
//	    [28, 48, 40, 19, 86, 27, 90]
//	];
//	
//	$scope.init();
//}]);
//
