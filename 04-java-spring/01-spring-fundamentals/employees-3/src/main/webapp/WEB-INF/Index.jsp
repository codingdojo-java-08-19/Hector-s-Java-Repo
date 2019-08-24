<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/managers">add a new manager</a>
	<a href="/employees">add a new employee</a>
	all a managers employees
	<ul>
		<c:forEach var="manager" items="${ managers }">
				<li><h4>${ manager.first_name}, ${ manager.last_name}</h4></li>
			<c:forEach var="employee" items="${ manager.employees}">
				<li>${ employee.last_name }, ${ employee.first_name}</li>
			</c:forEach>
		</c:forEach>
	</ul>
	an employee's manager
	<ul>
		<c:forEach var="employee" items="${ employees }">
				<li><h4>${ employee.first_name }, ${ employee.last_name }</h4></li>
				<li>manager: ${ employee.manager.last_name }, ${ employee.manager.first_name }</li>
		</c:forEach>
	</ul>
</body>
</html>