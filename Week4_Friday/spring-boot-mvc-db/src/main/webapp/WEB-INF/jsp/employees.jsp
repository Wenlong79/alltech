<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<link rel="stylesheet" type="text/css"
		  href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<%--	<c:url value="/css/main.css" var="jstlCss" />--%>
	<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
<%--<c:url var="addLink" value="/h1"></c:url>--%>
<%--<div><a href="${addLink}">Add</a></div>--%>
<div class="container">
	<header>
		<h1>Employee Management System</h1>
	</header>
	<div class="starter-template">
		<h2 style="color: burlywood">Employees</h2>
		<table
				class="table table-striped table-hover table-condensed table-bordered">
			<tr>
				<th>employee_id</th>
				<th>employee_name</th>
				<th>employee_salary</th>
			</tr>
			<c:forEach var="employee" items="${employees}">
				<tr>
					<td>${employee.employeeId}</td>
					<td>${employee.employeeName}</td>
					<td>${employee.employeeSalary}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</div>

<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>