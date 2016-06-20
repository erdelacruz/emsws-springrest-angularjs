	application.controller('ApplicationController',['EmployeeService','RoleService','$window','$state','$log',function(EmployeeService,RoleService,$window,$state,$log){
		var self = this;
		self.successMessage='';
		self.errorMessage='';
		
		self.employee = {
				id:null,
				firstname:'',
				lastname:'',
				middlename:'',
				employed:false,
				birthDate:'',
				gender:'',
				generalWeightedAverage:0.0,
				contactType:'',
				contactNumber:'',
				street:'',
				barangay:'',
				city:'',
				houseNumber:'',
				subdivision:'',
				zipCode:'',
				roles:[]
		};
		
		self.searchQuery = {firstname:'',lastname:'',middlename:'',roleId:0};
		self.employees = [];
		self.roles=[];
		self.collectionOfId = [];
		
		self.initialEmployeeValue = self.employee;
		self.initialSearchQueryValue = self.searchQuery;
		 
	    self.reset = function () {
	    	self.employee = self.initialEmployeeValue;
	    	self.searchQuery = self.initialSearchQueryValue;
	    	self.collectionOfId = [];
	    };
		
		/*** FORM HANDLER ***/
		self.submit = submitHandler;
		self.search = searchHandler;
		self.batchDelete = batchDeleteHandler;
		/*** FORM HANDLER ***/
		
		/*** CRUD ***/
		self.getAllEmployees = getAllEmployees;
		self.getEmployeeById = getEmployeeById;
		self.getAllRoles = getAllRoles;
		self.addEmployee = addEmployee;
		self.updateEmployee = updateEmployee;
		self.deleteEmployee = deleteEmployee;
		self.batchDeleteEmployee = batchDeleteEmployee;
		self.searchEmployees = searchEmployees;
		/*** CRUD ***/
		
		/*** EXECUTABLE ***/
		self.getAllEmployees();
		self.getAllRoles();
		/*** EXECUTABLE ***/
		
		self.isSelectedRole = function(id){
			if(self.employee.roles!=null&&self.employee.roles.length>=1){
				for(var i=0;self.employee.roles.length>i;i++){
					if(self.employee.roles[i]!=null){
						if(self.employee.roles[i].id===id){
							return true;
						}
					}
				}
			}
			return false;
		};
		
		
		function submitHandler(){
			if(self.employee.id===null){
				self.addEmployee(self.employee);
			}else{
				self.updateEmployee(self.employee.id,self.employee);
			}
			
			
		}
		
		function searchHandler(){
			self.searchEmployees(self.searchQuery);
		}
		
		function batchDeleteHandler(){
			self.batchDeleteEmployee(self.collectionOfId);
		}	
		
		
		function getAllEmployees(){
			EmployeeService.getAllEmployees()
			.then(
				function(result){
					self.errorMessage='';
					self.employees = result;
				},
				function(errorResult){
					console.error("Error on fetching all employees from server.");
				}
			);
		}
		
		function searchEmployees(searchQuery){
			EmployeeService.searchEmployees(searchQuery)
			.then(
				function(result){
					self.employees = result;
				},
				function(errorResult){
					console.error("Error on searching employees from server.");
				}
			);
		}
		
		function getEmployeeById(id){
			EmployeeService.getEmployeeById(id)
			.then(
				function(result){
					self.employee = result;
					$state.go('AddEmployee');
				},
				function(errorResult){
					console.error("Error on fetching a employee with id "+id);
				}
			);
		}
		
		function addEmployee(employee){
			EmployeeService.addEmployee(employee)
			.then(
				function(){
					self.successMessage = 'New Employee '+employee.firstname+' '+employee.lastname+' has been added.';
					self.getAllEmployees();
					self.employee=angular.copy(self.initialEmployeeValue);
					$state.go('Home');
				},
				function(errorResult){
					self.errorMessage = 'Error on creating a new employee.';
					$state.go('Home');
					console.error("Error on creating a employee.");
				}
			);
		}
		
		function updateEmployee(id,employee){
			EmployeeService.updateEmployee(id,employee)
			.then(
				function(){
					self.successMessage = 'Employee Record of '+employee.firstname+' '+employee.lastname+' has been updated.';
					self.getAllEmployees();
					self.employee=angular.copy(self.initialEmployeeValue);
					$state.go('Home');
				},
				function(errorResult){
					self.errorMessage = 'Error on updating existing employee.';
					$state.go('Home');
					console.error("Error on updating a employee.");
				}
			);
		}
		
		function deleteEmployee(id){
			
			if($window.confirm( "Are you sure you want to delete this employee record with an ID "+id+"?")){
				EmployeeService.deleteEmployee(id)
				.then(
					function(){
						self.getAllEmployees();
						self.successMessage = 'Employee has been deleted.';
					},
					function(errorResult){
						console.error("Error on deleting a employee.");
						self.errorMessage = 'Error on deleting a employee.';
					}
				);
			}
			
		}
		
		
		function batchDeleteEmployee(collectionOfId){
			if(collectionOfId.length>=1){
				if($window.confirm( "Selected records will be deleted, continue?")){
					EmployeeService.batchDeleteEmployee(collectionOfId)
					.then(
						function(){
							self.getAllEmployees();
							self.successMessage = collectionOfId.length+' employee record/s has been deleted.';
						},
						function(errorResult){
							console.error("Error on deleting a employee.");
							self.errorMessage = 'Error on deleting a employee.';
						}
					);
				}
			}else{
				self.errorMessage = 'Kindly select at least 1 employee record.';
			}
			
		}
		
		
		
		function getAllRoles(){
			RoleService.getAllRoles()
			.then(
				function(result){
					self.roles = result;
				},
				function(errorResult){
					console.error("Error on fetching all roles from server.");
				}
			);
		}
		
		
		
		
		
	}]);
