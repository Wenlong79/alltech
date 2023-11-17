<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <title>Delete Employee</title>
</head>
<body>

<h1>Update Employee</h1>

<form:form action="saveEmployee" cssClass="form-horizontal"
           method="post" modelAttribute="employeeInput">

    <!-- need to associate this data with user id -->
    <form:hidden path="employeeId"/>

    <label>Enter Employee Name</label>
    <form:input path="employeeName"/>
    <br><br>
    <label>Enter Salary</label>
    <form:input path="employeeSalary"/>
    <br><br>

    <form:button>Save</form:button>
</form:form>

</body>
</html>