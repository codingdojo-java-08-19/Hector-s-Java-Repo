<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
 		dojo:
 		<form:errors path="dojo"/>
 		<select name="sdojo">
 			<c:forEach var="dojo" items="${dojos}">
 				<option>${dojo.name}</option>
 			</c:forEach>
 		</select>
		first name:
		<form:input path="firstName"/>
		<form:errors path="firstName"/>
		last name:
		<form:input path="lastName"/>
		<form:errors path="lastName"/>
		age:
		<form:input path="age"/>
		<form:errors path="age"/>
		
		<button type="submit">submit</button>
 		
 	</form:form>
</body>
</html>