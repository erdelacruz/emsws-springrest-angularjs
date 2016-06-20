
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html ng-app="Application">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>EMS Employee Management System</title>
<style>
.error{
	font-size:12px;
	 color: red;
}
</style>
</head>
<body ng-controller="ApplicationController as ac">
	<center><a href="/"><button>BACK</button></a> | <a href="/Logout"><button>LOGOUT</button></a></center>
	
	<form ng-submit="ac.submit()">
	<fieldset>
		<legend>Employee</legend>
		
		<fieldset>
			<legend>General Information</legend>
			<table width="100%">
				<tr>
					<td>First Name* :</td>
					<td><input type="text" ng-model="ac.employee.firstname"/></td>
					<td>Last Name* :</td>
					<td><input type="text" ng-model="ac.employee.lastname"/> </td>
				</tr>
				<tr>
					<td>Middle Name* :</td>
					<td><input type="text" ng-model="ac.employee.middlename"/> </td>
					<td>Gender* :</td>
					<td>
						<input type="radio" ng-model="ac.employee.gender"  value="MALE"/> Male
						<input type="radio" ng-model="ac.employee.gender"  value="FEMALE"/> Female
						
					</td>
				</tr>
				<tr>
					<td>Birth Date* :</td>
					<td><input type="text"  ng-model="ac.employee.birthDate"/> </td>
					<td>Employed* :</td>
					<td>
						<input type="radio" ng-model="ac.employee.employed"  value="true"/> Yes
						<input type="radio" ng-model="ac.employee.employed"  value="false"/> No
					</td>
				</tr>
				<tr>
					<td>G.W.A* :</td>
					<td><input type="text" ng-model="ac.employee.generalWeightedAverage" /> </td>
					<td></td>
					<td></td>
				</tr>
			</table>
			
			<fieldset style="width: 300px;">
				<legend>Role *</legend> 
				
				<div ng-repeat="role in ac.roles track by $index">
			        <input type="checkbox" ng-model="ac.employee.roles[$index].id"/>
			        <label>{{role.roleName}}</label>
			    </div>
			</fieldset>
		</fieldset>
		
		<fieldset>
			<legend>Address</legend>
			
			<table width="100%" >
				<tr>
					<td>Street* :</td>
					<td><input type="text" ng-model="ac.employee.street"/> </td>
					<td>House No.* :</td>
					<td><input type="text" ng-model="ac.employee.houseNumber"/></td>
				</tr>
				<tr>
					<td>Barangay* :</td>
					<td><input type="text" ng-model="ac.employee.barangay"/></td>
					<td>Subdivision :</td>
					<td><input type="text" ng-model="ac.employee.subdivision"/></td>
				</tr>
				<tr>
					<td>City* :</td>
					<td><input type="text" ng-model="ac.employee.city"/> </td>
					<td>Zip Code* :</td>
					<td><input type="text" ng-model="ac.employee.zipCode"/> </td>
				</tr>
				
			</table>
		</fieldset>
		
		<fieldset>
			<legend>Contact</legend>
			
			<table width="100%" >
				<tr>
					<td>Type :</td>
					<td>
						<input type="radio" ng-model="ac.employee.contactType" value="MOBILE"/> Mobile
						
						<input type="radio" ng-model="ac.employee.contactType"  value="PHONE"/> Phone
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Contact Number :</td>
					<td><input ng-model="ac.employee.contactNumber"/></td>
					<td></td>
					<td></td>
				</tr>
				
			</table>
		</fieldset>
		<center><button type="submit"> Submit</button></center>
	</fieldset>
	
	</form>
</body>
<script src="/resources/js/lib/angular.min.js"></script>
<script src="/resources/js/module.js"></script>
<script src="/resources/js/controller.js"></script>
<script src="/resources/js/service.js"></script>
</html>