<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Employees List</title>
</head>

<body>

	<br>
	<h2>Employees List</h2>

	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Contractor</th>
			<th>Skills</th>
			<th>Designation</th>
			<th>Department</th>
			<th>Address</th>
			<th>Country</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="emp" items="${empList}">
			<tr>
				<td>${emp.name}</td>
				<td>${emp.age}</td>
				<td>${emp.gender}</td>
				<td>${emp.contractor ? "Yes" : "No"}</td>
				<td>${emp.skills}</td>
				<td>${emp.designation}</td>
				<td>${emp.department}</td>
				<td>${emp.address}</td>
				<td>${emp.country}</td>
				<td><a
					href="/SpringMVCEmployeeCRUDEx/employee/update/${emp.id}">Edit</a></td>
				<td><a
					href="/SpringMVCEmployeeCRUDEx/employee/delete/${emp.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="/SpringMVCEmployeeCRUDEx/employee">Add New Employee</a> &nbsp;&nbsp;
	<a href="/SpringMVCEmployeeCRUDEx">Go to home</a>
</body>
</html>
