'use strict';	

application.service('EmployeeService',['$http','$q',function($http,$q){
		var self = this;

		self.getAllEmployees = function(){
					return $http.get('http://localhost:8080/employee/')
					    .then(
						    function(response){
								return response.data;
						    }, 
						    function(errResponse){
								console.error('Error while fetching employees');
								return $q.reject(errResponse);
						    }
					    );
		};
		
		self.addEmployee = function(employee){
			return $http.post('http://localhost:8080/employee/',employee)
            .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while creating employee');
                        return $q.reject(errResponse);
                    }
            );
		};
		
		self.updateEmployee = function(employee,id){
			return $http.put('http://localhost:8080/employee/'+id,employee)
            .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while updating employee');
                        return $q.reject(errResponse);
                    }
            );
		};
		
		self.deleteEmployee = function(id){
			return $http.delete('http://localhost:8080/employee/'+id)
            .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while deleting employee');
                        return $q.reject(errResponse);
                    }
            );
		};
		
}]);
	
application.service('RoleService',['$http','$q',function($http,$q){
		var self = this;

		self.getAllRoles = function(){
					return $http.get('http://localhost:8080/roles/')
					    .then(
						    function(response){
								return response.data;
						    }, 
						    function(errResponse){
								console.error('Error while fetching existing roles');
								return $q.reject(errResponse);
						    }
					    );
		};
		
}]);