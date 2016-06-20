	application.controller('ApplicationController',['EmployeeService','RoleService',function(EmployeeService,RoleService){
		var self = this;
		self.employee = {
				id:null,
				firstname:'',
				lastname:'',
				middlename:'',
				employed:'',
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
				roles:[{id:0}]
		};
		
		
		
		
		
		self.employees = [];
		self.roles=[];
		self.getAllEmployees = getAllEmployees;
		self.getAllRoles = getAllRoles;
		self.addEmployee = addEmployee;
		self.submit = submitHandler;
		
		/*** EXECUTED ***/
		self.getAllEmployees();
		self.getAllRoles();
		/*** EXECUTED ***/
		
		function submitHandler(){
			self.addEmployee(self.employee);
		}
		
		function getAllEmployees(){
			EmployeeService.getAllEmployees()
			.then(
				function(result){
					self.employees = result;
				},
				function(errorResult){
					console.error("Error on fetching all employees from server.");
				}
			);
		}
		
		
		function addEmployee(employee){
			EmployeeService.addEmployee(employee)
			.then(
				function(){
					alert("ADDED SUCCESS");
				},
				function(errorResult){
					console.error("Error on creating a employee.");
				}
			);
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
