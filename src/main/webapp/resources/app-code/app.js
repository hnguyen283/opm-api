/**
 * author: Nguyen Dong Hung
 * 
 * 
 */
"use strict";
var opmApp = angular.module('opmApp', ['ngRoute','ngMaterial','lazy-scroll','directiveModule','commonModule','printModule','chart.js']);

opmApp.config(['$routeProvider',
                    function($routeProvider) {
                      $routeProvider.
                        when('/', {
                          templateUrl: 'jsp/home/index.jsp',
                          controller: 'HomeController'
                        })
                        .otherwise({
                          redirectTo: '/'
                        });
                    }]);