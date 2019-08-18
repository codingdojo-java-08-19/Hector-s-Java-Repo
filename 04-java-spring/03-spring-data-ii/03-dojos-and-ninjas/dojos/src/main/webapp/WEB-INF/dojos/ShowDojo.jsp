<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dojo ${dojo.id}</title>
</head>
<body>
	<h1>${dojo.name}</h1>
	<table>
	<thead>
		<tr>
			<th>first name</th>
			<th>last name</th>
			<th>age</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="ninja" items="${ninjas}">
			<tr>
				<td>${ninja.firstName}</td>
				<td>${ninja.lastName}</td>
				<td>${ninja.age}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</body>
</html>