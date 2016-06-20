<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html ng-app="Application">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>EMS Employee Management System</title>

<style>
#employees {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#employees td, #employees th {
    border: 1px solid #ddd;
    text-align: left;
    padding: 8px;
}

#employees th {
    padding-top: 12px;
    padding-bottom: 12px;
    background-color: #4CAF50;
    color: white;
}
.error{
	font-size:12px;
	 color: red;
}


</style>

</head>
<body ng-controller="ApplicationController as ac">

	<center><a href="/Logout"><button>LOGOUT</button></a></center>
	
	<fieldset>
		<legend>Employee</legend>
		<form method="post">
		<fieldset>
			<legend>Search Employee</legend>
			<table width="100%">
				<tr>
					<td>First Name :</td>
					<td><input type="text" name="firstname"/></td>
					<td>Last Name :</td>
					<td><input type="text" name="lastname"/></td>
				</tr>
				<tr>
					<td>Middle Name :</td>
					<td><input type="text" name="middlename"/></td>
					<td>Role :</td>
					<td>
						<select name="roleId">
							<option value="">Select Role:</option>
							<option ng-repeat="role in ac.roles" value='{{role.id}}'>{{role.roleName}}</option>
						</select>
						
					</td>
				</tr>
				<tr>
					<td colspan="4"><center><button type="submit">Search</button><center></td>
				</tr>
			</table>
		</fieldset>
		</form>
		
		
		<p style="color:#00b300;"></p>
		<p style="color:red;"></p>
		
		<form method="post" action="ExecuteBatchDeleteEmployee">
		<fieldset>
			<legend>List of Employees</legend>
			<div style="float:right; margin-bottom: 10px;">
			
			 
				<input type="button" onclick="location.href='/';" value="DISPLAY ALL EMPLOYEES" />
					<input type="button" onclick="location.href='AddEmployee';" value="ADD NEW EMPLOYEE" />
					<button type="submit" onclick="return confirm('Are you sure, you want continue?');">BATCH DELETE</button>
				
			</div>
			
			<table width="100%" id="employees">
							<tr>
								<td></td>
								<td>ID</td>
								<td>First Name</td>
								<td>Middle Name</td>
								<td>Last Name</td>
								<td>Gender</td>
								<td>Birth Date</td>
								<td>Employed</td>
								<td>G.W.A</td>
								<td>Role/Roles</td>
								<td>Action</td>
							</tr>
							
								<tr ng-repeat="employee in ac.employees">
									<td></td>
									<td>{{employee.id}}</td>
									<td>{{employee.firstname}}</td>
									<td>{{employee.middlename}}</td>
									<td>{{employee.lastname}}</td>
									<td>{{employee.gender}}</td>
									<td>{{employee.birthDate}}</td>
									<td>{{employee.employed}}</td>
									<td>{{employee.generalWeightedAverage}}</td>
									<td>
										<ul>	
											<li ng-repeat="role in employee.roles">
												{{role.roleName}}
											</li>
										</ul>
									</td>
									<td><a href="UpdateEmployee?id=${employee.id}">Update</a>
									 / <a href="DeleteEmployee?id=${employee.id}" onclick="return confirm('Are you sure you want to delete the record of ${employee.getFullname()}');">Delete</a></td>
								</tr>
							
						</table>
					
			
		</fieldset>
		</form>
	</fieldset>
	
</body>
<script src="/resources/js/lib/angular.min.js"></script>
<script src="/resources/js/module.js"></script>
<script src="/resources/js/controller.js"></script>
<script src="/resources/js/service.js"></script>

</html>