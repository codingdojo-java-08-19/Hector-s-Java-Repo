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
<h1>NEW PORDUCT</h1>
	<form:form action="/products/new" method="post" modelAttribute="product">
		name:
		<form:input path="name"/>
		<form:errors path="name"/>
		description:
		<form:input path="description"/>
		<form:errors path="description"/>
		price:
		<form:input path="price"/>
		<form:errors path="price"/>
		<button type="submit">submit</button>
	</form:form>
</body>
</html>