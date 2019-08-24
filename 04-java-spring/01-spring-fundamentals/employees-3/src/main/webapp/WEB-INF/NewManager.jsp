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
	<form:form 
		action="/managers"
		method="post"
		modelAttribute="manager"
	>
	first name:
	<form:input path="first_name"/>
	<form:errors path="first_name"/>
	last name:
	<form:input path="last_name"/>
	<form:errors path="last_name"/>
	
	<button type="submit">submit</button>
	</form:form>
</body>
</html>