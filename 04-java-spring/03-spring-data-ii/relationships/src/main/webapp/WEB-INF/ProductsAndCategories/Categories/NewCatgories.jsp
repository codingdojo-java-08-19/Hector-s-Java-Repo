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
	<h1>NEW CATEGORY</h1>
	<form:form action="/categories/new" method="post" modelAttribute="category">
		name:
		<form:input path="name"/>
		<form:errors path="name"/>
		<button type="submit">submit</button>
	</form:form>
</body>
</html>