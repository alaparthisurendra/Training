<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Employee Management App</title>
</head>
<body>
	<h1>Welcome to Employee Management App!</h1>
	<p> Current Time: ${serverTime} </p>
	<!-- <p> <a href="/login">Login</a> -->
	<p> <a href="/employee/list">View Employees</a>
</body>
</html>
