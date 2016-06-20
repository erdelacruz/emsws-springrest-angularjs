'use strict';	

application.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/Home');
    
    $stateProvider
        
        .state('Home', {
            url: '/Home',
            templateUrl: 'EmployeeManagementPage.html',
            controller:'ApplicationController'
        })
        
        .state('AddEmployee', {
        	 url: '/AddEmployee',
             templateUrl: 'AddAndUpdateEmployeePage.html',
             controller:'ApplicationController'
        });
        
});
