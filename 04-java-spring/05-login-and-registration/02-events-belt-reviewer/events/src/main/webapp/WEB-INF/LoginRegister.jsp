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
	<form:form action="/register" method="post" modelAttribute="user">
		<h3>register</h3>
		first name:
		<form:input path="first_name"/>
		<form:errors path="first_name"/>
		last name:
		<form:input path="last_name"/>
		<form:errors path="last_name"/>
		email:
		<form:input type="email" path="email"/>
		<form:errors path="email"/>
		password:
		<form:input type="password" path="password"/>
		<form:errors path="password"/>
		confirm password:
		<form:input type="password" path="confirmPWord"/>
		<form:errors path="confirmPWord"/>
		home state:
		<form:select path="homeState">
			<form:options items="${states}" itemLabel="name" itemValue="id"/>	
		</form:select>
		<button type="submit">register</button>
	</form:form>
	
	<form:form action="/login" method="post" modelAttribute="user">
		<h3>login</h3>
		email:
		<form:input type="email" path="email"/>
		<form:errors path="email"/>
		password:
		<form:input type="password" path="password"/>
		<form:errors path="password"/>
		<button type="submit">login</button>
	</form:form>
</body>
</html>